package org.rxbooter.flow;

import java.util.concurrent.ThreadFactory;

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
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
        return this;
    }
}
