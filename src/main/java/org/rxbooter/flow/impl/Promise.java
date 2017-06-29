package org.rxbooter.flow.impl;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.function.Consumer;
import java.util.function.Function;

public class Promise<T> {
    private final AtomicMarkableReference<T> value = new AtomicMarkableReference<>(null, false);
    private final AtomicMarkableReference<Throwable> errValue = new AtomicMarkableReference<>(null, false);

    private final CountDownLatch latch = new CountDownLatch(1);
    private final Consumer<T> onReady;
    private final Function<Throwable, T> onError;

    private Promise(Consumer<T> onReady, Function<Throwable, T> onError) {
        this.onReady = onReady;
        this.onError = onError;
    }

    public static <T> Promise<T> with() {
        return new Promise<>((v) -> {}, (t) -> null);
    }

    public static <T> Promise<T> with(Consumer<T> onReady) {
        return new Promise<>(onReady, (t) -> null);
    }

    public static <T> Promise<T> with(Consumer<T> onReady, Function<Throwable, T> onError) {
        return new Promise<>(onReady, onError);
    }

    public boolean notify(T value) {
        boolean result = this.value.compareAndSet(null, value, false, true);
        if (result) {
            latch.countDown();
            onReady.accept(value);
        }
        return result;
    }

    public boolean notifyError(Throwable value) {
        boolean result = this.errValue.compareAndSet(null, value, false, true);
        return result ? notify(onError.apply(value)) : result;
    }

    public boolean isReady() {
        return value.isMarked() || errValue.isMarked();
    }

    public T await() {
        do {
            try {
                latch.await();
            } catch (InterruptedException e) {
                // Ignore
            }
        } while (latch.getCount() != 0 && !value.isMarked());

        T result = value.getReference();

        if (result == null && errValue.getReference() != null) {
            throw new RuntimeException(errValue.getReference());
        }

        return result;
    }
}
