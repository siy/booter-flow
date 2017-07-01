package org.rxbooter.flow.impl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FixedThreadPool implements ThreadPool {
    public static final int DEFAULT_COMPUTING_POOL_SIZE;
    public static final int DEFAULT_IO_POOL_SIZE = 1000;
    public static final int DEFAULT_MIN_COMPUTING_POOL_SIZE = 8;

    static {
        DEFAULT_COMPUTING_POOL_SIZE = Math.max(Runtime.getRuntime().availableProcessors() * 2,
                                               DEFAULT_MIN_COMPUTING_POOL_SIZE);
    }

    private final AtomicBoolean started = new AtomicBoolean(false);
    private final ExecutorService service;
    private final int poolSize;

    public FixedThreadPool(int poolSize, ThreadFactory factory) {
        this.poolSize = poolSize;
        this.service = Executors.newFixedThreadPool(poolSize, factory);
    }

    @Override
    public FixedThreadPool start(Runnable target) {
        if (!started.compareAndSet(false, true)) {
            throw new IllegalStateException("Thread pool is already started.");
        }

        IntStream.range(0, poolSize).mapToObj(i -> service.submit(target)).collect(Collectors.toList());

        return this;
    }

    @Override
    public void shutdown() {
        service.shutdown();
    }
}
