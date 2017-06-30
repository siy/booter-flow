package org.rxbooter.flow.impl;

import java.util.concurrent.ThreadFactory;

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

    public FixedThreadPool(int poolSize, ThreadFactory factory, Runnable handler) {
        if (poolSize < 1) {
            throw new IllegalArgumentException("Number of threads must be greater than 0");
        }

        threads = createPool(poolSize, factory, handler);
    }

    private static Thread[] createPool(int size, ThreadFactory factory, Runnable handler) {
        Thread[] result = new Thread[size];

        for (int i = 0; i < size; i++) {
            result[i] = factory.newThread(handler);
        }
        return result;
    }

    @Override
    public FixedThreadPool start() {
        for (Thread thread : threads) {
            thread.start();
        }
        return this;
    }
}
