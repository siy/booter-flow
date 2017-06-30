package org.rxbooter.flow.impl;

import java.util.concurrent.ThreadFactory;

/**
 * Extremely simple thread poos. It has no thread restart capabilities, so users of this thread pool
 * should make sure that passed @{@link Runnable} does not leak any exceptions during execution.
 * Also, this thread pool has no way to stop running threads, so it is up to application how (and if)
 * to stop threads. Basically exiting from passed runnable should be enough for graceful shutdown of
 * thread.
 */
//TODO: extract interface, generalize approach and rework pool instantiation
public class FixedThreadPool {
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

    public FixedThreadPool start() {
        for (Thread thread : threads) {
            thread.start();
        }
        return this;
    }
}
