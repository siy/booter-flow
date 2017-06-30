package org.rxbooter.flow.impl;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Extremely simple thread poos. It has no thread restart capabilities, so users of this thread pool
 * should make sure that passed @{@link Runnable} does not leak any exceptions during execution.
 * Also, this thread pool has no way to stop running threads, so it is up to application how (and if)
 * to stop threads. Basically exiting from passed runnable should be enough for graceful shutdown of
 * thread.
 */
public class FixedThreadPool implements ThreadPool {
    public static final int DEFAULT_COMPUTING_POOL_SIZE;
    public static final int DEFAULT_IO_POOL_SIZE = 1000;
    public static final int DEFAULT_MIN_COMPUTING_POOL_SIZE = 8;

    static {
        DEFAULT_COMPUTING_POOL_SIZE = Math.max(Runtime.getRuntime().availableProcessors() * 2,
                                               DEFAULT_MIN_COMPUTING_POOL_SIZE);
    }

    private final Thread[] threads;
    private final ThreadFactory factory;
    private final AtomicBoolean started = new AtomicBoolean(false);

    public FixedThreadPool(int poolSize, ThreadFactory factory) {
        if (poolSize < 1) {
            throw new IllegalArgumentException("Number of threads must be greater than 0");
        }

        this.factory = factory;
        threads = new Thread[poolSize];
    }

    @Override
    public FixedThreadPool start(Runnable target) {
        if (!started.compareAndSet(false, true)) {
            throw new IllegalStateException("Thread pool is already started.");
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i] = factory.newThread(target);
        }

        for (Thread thread : threads) {
            thread.start();
        }
        return this;
    }
}
