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

import java.util.Optional;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicMarkableReference;

/**
 * Tiny lightweight implementation of Promise pattern.
 */
public class Promise<T> {
    private final AtomicMarkableReference<T> value = new AtomicMarkableReference<>(null, false);
    private final AtomicMarkableReference<Throwable> errValue = new AtomicMarkableReference<>(null, false);
    private final CountDownLatch latch;

    private Promise() {
        this(1);
    }

    private Promise(int count) {
        latch = new CountDownLatch(count);
    }

    public static <T> Promise<T> waifFor(int count) {
        return new Promise<>(count);
    }

    public static <T> Promise<T> empty() {
        return new Promise<>();
    }

    public static <T> Promise<T> ready(T value) {
        return new Promise<T>().notify(value);
    }

    public static <T> Promise<T> error(Throwable value) {
        return new Promise<T>().notifyError(value);
    }

    public Promise<T> notify(T value) {
        if(this.value.compareAndSet(null, value, false, true)) {
            // successful completion will stop waiting
            while(latch.getCount() > 0) {
                latch.countDown();
            }
        } else {
            latch.countDown();
        }

        return this;
    }

    public Promise<T> notifyError(Throwable value) {
        this.errValue.compareAndSet(null, value, false, true);
        latch.countDown();

        return this;
    }

    public boolean isReady() {
        return value.isMarked() || errValue.isMarked();
    }

    public boolean isError() {
        return errValue.isMarked();
    }

    public T get() {
        return value.getReference();
    }

    public Throwable getError() {
        return errValue.getReference();
    }

    public T await() {
        doWait();

        if (value.isMarked()) {
            return value.getReference();
        }

        throw wrapUnwrapAsNecessary(errValue.getReference());
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

    public Optional<T> safeAwait() {
        doWait();

        return Optional.ofNullable(value.getReference());
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
