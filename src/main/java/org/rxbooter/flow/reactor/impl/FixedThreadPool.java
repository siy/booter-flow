package org.rxbooter.flow.reactor.impl;

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

import org.rxbooter.flow.reactor.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.IntStream;

/**
 * Implementation of {@link ThreadPool} with fixed number of threads.
 */
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
        if (target == null) {
            throw new IllegalArgumentException("Passed runnable should not be null.");
        }

        if (!started.compareAndSet(false, true)) {
            throw new IllegalStateException("Thread pool is already started.");
        }

        IntStream.range(0, poolSize).forEach(i -> service.submit(target));

        return this;
    }

    @Override
    public void shutdown() {
        service.shutdown();
    }
}
