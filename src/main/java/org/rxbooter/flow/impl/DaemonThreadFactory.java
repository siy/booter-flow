package org.rxbooter.flow.impl;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Very simple thread factory which produces daemon threads.
 */
public class DaemonThreadFactory implements ThreadFactory {
    private final String prefix;
    private final AtomicLong counter = new AtomicLong(0);

    public DaemonThreadFactory(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r, prefix + counter.incrementAndGet());
        thread.setDaemon(true);
        return thread;
    }
}
