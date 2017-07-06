package org.rxbooter.flow.impl;

import java.util.concurrent.ThreadFactory;

public interface ThreadPool {
    static final int DEFAULT_COMPUTING_POOL_SIZE = FixedThreadPool.DEFAULT_COMPUTING_POOL_SIZE;
    static final int DEFAULT_IO_POOL_SIZE = FixedThreadPool.DEFAULT_IO_POOL_SIZE;

    static final ThreadFactory DEFAULT_COMPUTING_THREAD_FACTORY = new DaemonThreadFactory("ThreadPoolReactor-computing-");
    static final ThreadFactory DEFAULT_IO_THREAD_FACTORY = new DaemonThreadFactory("ThreadPoolReactor-io-");

    ThreadPool start(Runnable target);
    void shutdown();

    static ThreadPool defaultIo() {
        return new FixedThreadPool(DEFAULT_IO_POOL_SIZE, DEFAULT_IO_THREAD_FACTORY);
    }

    static ThreadPool defaultComputing() {
        return new FixedThreadPool(DEFAULT_COMPUTING_POOL_SIZE, DEFAULT_COMPUTING_THREAD_FACTORY);
    }

    static ThreadPool fixedIo(int size) {
        return new FixedThreadPool(size, DEFAULT_IO_THREAD_FACTORY);
    }

    static ThreadPool fixedComputing(int size) {
        return new FixedThreadPool(size, DEFAULT_COMPUTING_THREAD_FACTORY);
    }
}
