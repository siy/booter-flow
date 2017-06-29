package org.rxbooter.flow.impl;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Supplier;

import org.rxbooter.flow.Reactor;
import org.rxbooter.flow.Tuples.Tuple;

public class FixedPoolsReactor implements Reactor {
    private static final int DEFAULT_MIN_COMPUTING_POOL_SIZE = 8;
    private static final int DEFAULT_COMPUTING_POOL_SIZE = calculateDefaultPoolSize();
    private static final int DEFAULT_IO_POOL_SIZE = 1000;
    private static final ThreadFactory DEFAULT_COMPUTING_THREAD_FACTORY = new DefaultThreadFactory("FixedPoolsReactor-computing-");
    private static final ThreadFactory DEFAULT_IO_THREAD_FACTORY = new DefaultThreadFactory("FixedPoolsReactor-io-");
    private static final long POLL_INTERVAL = 100;

    private final BlockingQueue<ExecutableFlow<?, ?>> computingInput = new LinkedBlockingQueue<>();
    private final BlockingQueue<ExecutableFlow<?, ?>> blockingInput = new LinkedBlockingQueue<>();
    private final AtomicBoolean shutdown = new AtomicBoolean();
    private final FixedThreadPool computingPool;
    private final FixedThreadPool ioPool;

    public FixedPoolsReactor() {
        this(DEFAULT_COMPUTING_POOL_SIZE, DEFAULT_COMPUTING_THREAD_FACTORY,
            DEFAULT_IO_POOL_SIZE, DEFAULT_IO_THREAD_FACTORY);
    }

    public FixedPoolsReactor(int computingPoolSize, int ioPoolSize) {
        this(computingPoolSize, DEFAULT_COMPUTING_THREAD_FACTORY,
             ioPoolSize, DEFAULT_IO_THREAD_FACTORY);
    }

    public FixedPoolsReactor(int computingPoolSize, ThreadFactory computingFactory, int ioPoolSize, ThreadFactory ioFactory) {
        computingPool = new FixedThreadPool(computingPoolSize, computingFactory, this::computingHandler);
        ioPool = new FixedThreadPool(ioPoolSize, ioFactory, this::ioHandler);
        computingPool.start();
        ioPool.start();
    }

    public static FixedPoolsReactor defaultReactor() {
        return DefaultReactorHolder.INSTANCE.reactor();
    }

    public void shutdown() {
        shutdown.compareAndSet(false, true);
    }

    public static <O extends Tuple, I extends Tuple> O waitFor(ExecutableFlow<O, I> executableFlow) {
        return defaultReactor().await(executableFlow);
    }

    public <O extends Tuple, I extends Tuple> O await(ExecutableFlow<O, I> executableFlow) {
        putTask(executableFlow);
        return executableFlow.await();
    }

    //TODO: fix it
    @SuppressWarnings("unchecked")
    public <T> T await(Supplier<T> function) {
        //return (T) await(Flow.singleWaiting((t) -> Tuples.of(function.get())).bind(null)).get(0);
        return null;
    }

    private void ioHandler() {
        while (!shutdown.get()) {
            ExecutableFlow<?, ?> executableFlow = pollQueue(computingInput);

            if (executableFlow == null) {
                continue;
            }

            runStep(executableFlow);
            putTask(executableFlow);
        }
    }

    private void computingHandler() {
        while (!shutdown.get()) {
            ExecutableFlow<?, ?> executableFlow = pollQueue(blockingInput);

            if (executableFlow == null) {
                continue;
            }

            if (executableFlow.isAsync()) {
                ExecutableFlow<?, ?> subtask = executableFlow.forCurrent();
                putTask(subtask);
                executableFlow.advance();

                if (executableFlow.canRun()) {
                    putTask(executableFlow);
                }
                continue;
            }

            //TODO: execute groups of steps
            runStep(executableFlow);
            putTask(executableFlow);
        }
    }

    private void runStep(ExecutableFlow<?, ?> executableFlow) {
        try {
            executableFlow.step().advance();
        } catch (Throwable t) {
            //TODO: how take report exception?
        }
    }

    private ExecutableFlow<?, ?> pollQueue(BlockingQueue<ExecutableFlow<?, ?>> queue) {
        try {
            return queue.poll(POLL_INTERVAL, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            // Ignore it and return null. if shutdown is requested, then we'll handle it upon exit
            return null;
        }
    }

    private void putTask(ExecutableFlow<?, ?> executableFlow) {
        if (!executableFlow.canRun()) {
            //TODO: signal end of processing somehow
            return;
        }

        try {
            (executableFlow.isBlocking() ? blockingInput : computingInput).put(executableFlow);
        } catch (InterruptedException e) {
            //TODO: how take handle it correctly? can we just ignore it?
        }
    }

    private static int calculateDefaultPoolSize() {
        int numCores = Runtime.getRuntime().availableProcessors();
        return Math.max(numCores * 2, DEFAULT_MIN_COMPUTING_POOL_SIZE);
    }

    private enum DefaultReactorHolder {
        INSTANCE;

        private final FixedPoolsReactor reactor;

        DefaultReactorHolder() {
            reactor = new FixedPoolsReactor();
        }

        public FixedPoolsReactor reactor() {
            return reactor;
        }
    }
}
