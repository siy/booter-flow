package org.rxbooter.flow.impl;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public class DefaultThreadFactory implements ThreadFactory {
    private final String prefix;
    private final AtomicLong counter = new AtomicLong(0);

    public DefaultThreadFactory(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r, newThreadName());
        thread.setDaemon(true);
        return thread;
    }

    private String newThreadName() {
        return prefix + counter.incrementAndGet();
    }
}
