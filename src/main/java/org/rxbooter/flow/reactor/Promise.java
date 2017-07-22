package org.rxbooter.flow.reactor;

/*
 * Copyright (c) 2017 Sergiy Yevtushenko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 */

import org.rxbooter.flow.exception.FlowException;
import org.rxbooter.flow.exception.FlowWrappedException;

import java.util.Optional;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.function.Consumer;

/**
 * Representation of the future result of asynchronous operation.
 * The result of operation will be accepted only once, when {@link #notify(Object)} method is called
 * first time. Subsequent notifications will not change the result, but they can be taken into account
 * to decide when waiting for result can be finished.
 */
public class Promise<T> {
    private final AtomicMarkableReference<T> value = new AtomicMarkableReference<>(null, false);
    private final AtomicMarkableReference<Throwable> errValue = new AtomicMarkableReference<>(null, false);
    private final CountDownLatch latch;
    private final BlockingQueue<Consumer<T>> listeners = new LinkedBlockingQueue<>();
    private final BlockingQueue<Consumer<Throwable>> errorListeners = new LinkedBlockingQueue<>();

    private Promise() {
        this(1);
    }

    private Promise(int count) {
        latch = new CountDownLatch(count);
    }

    /**
     * Create {@link Promise} instance which will wait for specified number of notifications.
     *
     * @param count
     *          Number of calls to {@link #notify(Object)} after which {@link #await()} call will
     *          return result.
     * @return created {@link Promise} instance.
     */
    public static <T> Promise<T> waifFor(int count) {
        return new Promise<>(count);
    }

    /**
     * Create an empty (not yet notified) instance of promise expects single notification.
     *
     * @return created {@link Promise} instance.
     */
    public static <T> Promise<T> empty() {
        return new Promise<>();
    }

    /**
     * Create an notified instance with specified value.
     *
     * @param value
     *          Value to store in {@link Promise}.
     * @return created {@link Promise} instance.
     */
    public static <T> Promise<T> ready(T value) {
        return new Promise<T>().notify(value);
    }

    /**
     * Create an notified instance with specified error value.
     *
     * @param value
     *          The error value to store in {@link Promise}.
     * @return created {@link Promise} instance.
     */
    public static <T> Promise<T> error(Throwable value) {
        return new Promise<T>().notifyError(value);
    }

    /**
     * Notify {@link Promise} instance about value assigned to it. If there were any threads waiting
     * in {@link #await()} method, they will be immediately released as any successful notification
     * resets number of required notifications to zero.
     *
     * @param value
     *          Value to store in {@link Promise} instance.
     * @return {@code this} for call chaining (fluent syntax).
     */
    //TODO: decide what to do with null values.
    // Should we just discard them as useless? perhaps just handle them as if value was already set?
    public Promise<T> notify(T value) {
        if(this.value.compareAndSet(null, value, false, true)) {
            if (listeners.size() > 0) {
                listeners.forEach((c) -> notifyListener(c, value));
            }

            while(latch.getCount() > 0) {
                latch.countDown();
            }

        } else {
            latch.countDown();
        }

        return this;
    }

    /**
     * Notify {@link Promise} about error condition. Only the very first notification is recorded,
     * subsequent notifications only decrease number of required notifications.
     *
     * @param value
     *          Error cause
     * @return {@code this} for call chaining (fluent syntax).
     */
    public Promise<T> notifyError(Throwable value) {
        if(this.errValue.compareAndSet(null, value, false, true)) {
            errorListeners.forEach(c -> notifyListener(c, value));
        }
        latch.countDown();

        return this;
    }

    /**
     * Check if {@link Promise} instance received any notifications.
     * @return {@code true} if either value or error were notified at least once.
     */
    public boolean isReady() {
        return value.isMarked() || errValue.isMarked();
    }

    /**
     * Check if {@link Promise} holds error notification.
     *
     * @return {@code true} if {@link Promise} holds error.
     */
    public boolean isError() {
        return errValue.isMarked();
    }

    /**
     * Retrieve notified value if any. No waiting for notification is performed so if
     * value is missing then empty {@link Optional} is returned.
     *
     * @return optional notification value.
     */
    public Optional<T> get() {
        return Optional.ofNullable(value.getReference());
    }

    /**
     * Retrieve error notification if any. No waiting for notification is performed so if
     * value is missing then empty {@link Optional} is returned.
     * @return
     */
    public Optional<? extends Throwable> getError() {
        return Optional.ofNullable(errValue.getReference());
    }

    /**
     * Wait for notification and return value. If error is notified then notified exception
     * is rethrown.
     *
     * @return  value
     */
    public T await() {
        doWait();

        if (value.isMarked()) {
            return value.getReference();
        }

        throw wrapUnwrapAsNecessary(errValue.getReference());
    }

    /**
     * Wait for notification and then return value. If error is notified and return value is missing then
     * empty {@link Optional} is returned.
     *
     * @return instance of {@link Optional} with result.
     */
    public Optional<T> safeAwait() {
        doWait();

        return Optional.ofNullable(value.getReference());
    }

    /**
     * Install notification listener which will be invoked upon value notification.
     * More than one notification listeners can be installed. Note that listener must perform
     * it's operations fast, because it's invoked in the context of the notifying thread
     * which might be part of time-critical processing. Also, listener must not throw
     * any exceptions. Although exceptions in listener will be intercepted and will not
     * affect notifying of other listeners, intercepted exceptions are silently discarded
     * and information about the cause is lost.
     *
     * @param listener
     *          The notification listener.
     * @return {@code this} for call chaining (fluent syntax)
     */
    public Promise<T> then(Consumer<T> listener) {
        return addListener(listener, listeners, value);
    }

    /**
     * Install notification listener which will be invoked upon error notification.
     * More than one error notification listeners can be installed. Note that listener must perform
     * it's operations fast, because it's invoked in the context of the notifying thread
     * which might be part of time-critical processing. Also, listener must not throw
     * any exceptions. Although exceptions in listener will be intercepted and will not
     * affect notifying of other listeners, intercepted exceptions are silently discarded
     * and information about the cause is lost.
     *
     * @param listener
     *          The notification listener.
     * @return {@code this} for call chaining (fluent syntax)
     */
    public Promise<T> onError(Consumer<Throwable> listener) {
        return addListener(listener, errorListeners, errValue);
    }

    private <V> Promise<T> addListener(Consumer<V> consumer, BlockingQueue<Consumer<V>> queue, AtomicMarkableReference<V> value) {
        if (consumer == null) {
            return this;
        }

        if (value.isMarked()) {
            notifyListener(consumer, value.getReference());
        } else {
            queue.offer(consumer);
        }
        return this;
    }

    private static <T> void notifyListener(Consumer<T> consumer, T value) {
        try {
            consumer.accept(value);
        } catch (Throwable t) {
            //TODO: how to report errors here?
        }
    }

    private RuntimeException wrapUnwrapAsNecessary(Throwable reference) {
        if(reference instanceof FlowException) {
            if (reference.getCause() instanceof RuntimeException) {
                return (RuntimeException) reference.getCause();
            }

            return new FlowWrappedException(reference.getMessage(), reference.getCause());
        }

        if (reference instanceof RuntimeException) {
            return (RuntimeException) reference;
        }

        return new FlowWrappedException(reference);
    }

    private void doWait() {
        do {
            try {
                latch.await();
            } catch (InterruptedException e) {
                // Ignore exceptions here
            }
        } while (latch.getCount() != 0);
    }
}
