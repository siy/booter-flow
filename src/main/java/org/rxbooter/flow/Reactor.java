package org.rxbooter.flow;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Supplier;

import org.rxbooter.flow.Tuples.Tuple;
import org.rxbooter.flow.Tuples.Tuple1;

public class Reactor {
    private static final int DEFAULT_MIN_COMPUTING_POOL_SIZE = 4;
    private static final int DEFAULT_COMPUTING_POOL_SIZE = calculateDefaultPoolSize();
    private static final int DEFAULT_IO_POOL_SIZE = 100;
    private static final ThreadFactory DEFAULT_COMPUTING_THREAD_FACTORY = new DefaultThreadFactory("Reactor-computing-");
    private static final ThreadFactory DEFAULT_IO_THREAD_FACTORY = new DefaultThreadFactory("Reactor-io-");
    private static final long POLL_INTERVAL = 100;

    private final BlockingQueue<Cursor<?, ?>> computingInput = new LinkedBlockingQueue<>();
    private final BlockingQueue<Cursor<?, ?>> blockingInput = new LinkedBlockingQueue<>();
    private final AtomicBoolean shutdown = new AtomicBoolean();
    private final FixedThreadPool computingPool;
    private final FixedThreadPool ioPool;

    public Reactor() {
        this(DEFAULT_COMPUTING_POOL_SIZE, DEFAULT_COMPUTING_THREAD_FACTORY,
            DEFAULT_IO_POOL_SIZE, DEFAULT_IO_THREAD_FACTORY);
    }

    public Reactor(int computingPoolSize, int ioPoolSize) {
        this(computingPoolSize, DEFAULT_COMPUTING_THREAD_FACTORY,
             ioPoolSize, DEFAULT_IO_THREAD_FACTORY);
    }

    public Reactor(int computingPoolSize, ThreadFactory computingFactory, int ioPoolSize, ThreadFactory ioFactory) {
        computingPool = new FixedThreadPool(computingPoolSize, computingFactory, this::computingHandler);
        ioPool = new FixedThreadPool(ioPoolSize, ioFactory, this::ioHandler);
        computingPool.start();
        ioPool.start();
    }

    public static Reactor defaultReactor() {
        return ReactorHolder.INSTANCE.reactor();
    }

    public void shutdown() {
        shutdown.compareAndSet(false, true);
    }

    public static <O extends Tuple, I extends Tuple> O waitFor(Cursor<O, I> cursor) {
        return defaultReactor().await(cursor);
    }

    public <O extends Tuple, I extends Tuple> O await(Cursor<O, I> cursor) {
        putTask(cursor);
        return cursor.await();
    }

    @SuppressWarnings("unchecked")
    public <T> T await(Supplier<T> function) {
        return (T) await(Cursor.single(Step.waiting(function))).get(0);
    }

    private void ioHandler() {
        while (!shutdown.get()) {
            Cursor<?, ?> cursor = pollQueue(computingInput);

            if (cursor == null) {
                continue;
            }

            runStep(cursor);
            putTask(cursor);
        }
    }

    private void computingHandler() {
        while (!shutdown.get()) {
            Cursor<?, ?> cursor = pollQueue(blockingInput);

            if (cursor == null) {
                continue;
            }

            if (cursor.isAsync()) {
                Cursor<?, ?> subtask = cursor.subCursor();
                putTask(subtask);
                cursor.advance();

                if (cursor.canRun()) {
                    putTask(cursor);
                }
                continue;
            }

            //TODO: execute groups of steps
            runStep(cursor);
            putTask(cursor);
        }
    }

    private void runStep(Cursor<?, ?> cursor) {
        try {
            cursor.run().advance();
        } catch (Throwable t) {
            //TODO: how to report exception?
        }
    }

    private Cursor<?, ?> pollQueue(BlockingQueue<Cursor<?, ?>> queue) {
        try {
            return queue.poll(POLL_INTERVAL, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            // Ignore it and return null. if shutdown is requested, then we'll handle it upon exit
            return null;
        }
    }

    private void putTask(Cursor<?, ?> cursor) {
        if (!cursor.canRun()) {
            //TODO: signal end of processing somehow
            return;
        }

        try {
            (cursor.isBlocking() ? blockingInput : computingInput).put(cursor);
        } catch (InterruptedException e) {
            //TODO: how to handle it correctly? can we just ignore it?
        }
    }

    private static int calculateDefaultPoolSize() {
        int numCores = Runtime.getRuntime().availableProcessors();
        return Math.max(numCores, DEFAULT_MIN_COMPUTING_POOL_SIZE);
    }

    private static enum ReactorHolder {
        INSTANCE;

        private final Reactor reactor;
        private ReactorHolder() {
            reactor = new Reactor();
        }

        public Reactor reactor() {
            return reactor;
        }
    }
}
