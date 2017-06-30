package org.rxbooter.flow.impl;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.function.Consumer;
import java.util.function.Function;

import org.rxbooter.flow.FlowException;

/**
 * Tiny lightweight implementation of Promise pattern.
 */
public class Promise<T> {
    private final AtomicMarkableReference<T> value = new AtomicMarkableReference<>(null, false);
    private final AtomicMarkableReference<Throwable> errValue = new AtomicMarkableReference<>(null, false);
    private final CountDownLatch latch = new CountDownLatch(1);

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
        if (this.value.compareAndSet(null, value, false, true)) {
            latch.countDown();
        }

        return this;
    }

    public Promise<T> notifyError(Throwable value) {
        if(this.errValue.compareAndSet(null, value, false, true)) {
            latch.countDown();
        }

        return this;
    }

    public boolean isReady() {
        return value.isMarked() || errValue.isMarked();
    }

    public T get() {
        return value.getReference();
    }

    public T await() {
        do {
            try {
                latch.await();
            } catch (InterruptedException e) {
                // Ignore exceptions here
            }
        } while (latch.getCount() != 0 && isReady());

        if (value.isMarked()) {
            return value.getReference();
        }

        throw new FlowException(errValue.getReference());
    }
}
