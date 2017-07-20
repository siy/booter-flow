package org.rxbooter.flow;

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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;
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
    private final List<Consumer<T>> listeners = new ArrayList<>();

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
    public Promise<T> notify(T value) {
        if(this.value.compareAndSet(null, value, false, true)) {
            // successful completion will stop waiting
            while(latch.getCount() > 0) {
                latch.countDown();
            }

            listeners.forEach((c) -> notifyListener(c, value));
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
        this.errValue.compareAndSet(null, value, false, true);
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
     * Retrieve notified value if any. No waiting for notification is performed so if value is
     * missing then empty {@link Optional} will be returned.
     *
     * @return optional notification value.
     */
    public Optional<T> get() {
        return Optional.ofNullable(value.getReference());
    }

    public Optional<? extends Throwable> getError() {
        return Optional.ofNullable(errValue.getReference());
    }

    public T await() {
        doWait();

        if (value.isMarked()) {
            return value.getReference();
        }

        throw wrapUnwrapAsNecessary(errValue.getReference());
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
     * @param consumer
     *          The notification listener.
     * @return {@code this} for call chaining (fluent syntax)
     */
    public Promise<T> then(Consumer<T> consumer) {
        if (consumer != null) {
            listeners.add(consumer);
        }
        return this;
    }

    public Optional<T> safeAwait() {
        doWait();

        return Optional.ofNullable(value.getReference());
    }

    private void notifyListener(Consumer<T> consumer, T value) {
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
        } while (latch.getCount() != 0 && !isReady());
    }
}
