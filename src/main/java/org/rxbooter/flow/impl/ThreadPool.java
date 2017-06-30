package org.rxbooter.flow.impl;

import java.util.concurrent.ThreadFactory;

public interface ThreadPool {
    public static final int DEFAULT_COMPUTING_POOL_SIZE = FixedThreadPool.DEFAULT_COMPUTING_POOL_SIZE;
    public static final int DEFAULT_IO_POOL_SIZE = FixedThreadPool.DEFAULT_IO_POOL_SIZE;

    public static final ThreadFactory DEFAULT_COMPUTING_THREAD_FACTORY = new DaemonThreadFactory("FixedPoolsReactor-computing-");
    public static final ThreadFactory DEFAULT_IO_THREAD_FACTORY = new DaemonThreadFactory("FixedPoolsReactor-io-");

    ThreadPool start();

    static ThreadPool defaultIo(Runnable runnable) {
        return new FixedThreadPool(DEFAULT_IO_POOL_SIZE, DEFAULT_IO_THREAD_FACTORY, runnable);
    }

    static ThreadPool defaultComputing(Runnable runnable) {
        return new FixedThreadPool(DEFAULT_COMPUTING_POOL_SIZE, DEFAULT_COMPUTING_THREAD_FACTORY, runnable);
    }

    static ThreadPool fixedIo(int size, Runnable runnable) {
        return new FixedThreadPool(size, DEFAULT_IO_THREAD_FACTORY, runnable);
    }

    static ThreadPool fixedComputing(int size, Runnable runnable) {
        return new FixedThreadPool(size, DEFAULT_COMPUTING_THREAD_FACTORY, runnable);
    }
}
