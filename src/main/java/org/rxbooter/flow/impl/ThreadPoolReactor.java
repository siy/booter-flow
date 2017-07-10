package org.rxbooter.flow.impl;

import org.rxbooter.flow.ExecutionType;
import org.rxbooter.flow.Tuples.Tuple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class ThreadPoolReactor extends AbstractReactor {
    private static final long POLL_INTERVAL = 100;

    private final BlockingQueue<FlowExecutor<?, ?>> computingInput = new LinkedBlockingQueue<>();
    private final BlockingQueue<FlowExecutor<?, ?>> blockingInput = new LinkedBlockingQueue<>();
    private final AtomicBoolean shutdown = new AtomicBoolean();
    private final ThreadPool computingPool;
    private final ThreadPool ioPool;

    private ThreadPoolReactor(ThreadPool computingPool, ThreadPool ioPool) {
        this.computingPool = computingPool;
        this.ioPool = ioPool;

        this.computingPool.start(this::computingHandler);
        this.ioPool.start(this::ioHandler);
    }

    public static ThreadPoolReactor defaultReactor() {
        return DefaultReactorHolder.INSTANCE.reactor();
    }

    public static ThreadPoolReactor with(ThreadPool computingPool, ThreadPool ioPool) {
        return new ThreadPoolReactor(computingPool, ioPool);
    }

    @Override
    public void shutdown() {
        shutdown.compareAndSet(false, true);
        computingPool.shutdown();
        ioPool.shutdown();
    }

    @Override
    public <O extends Tuple, I extends Tuple> Promise<O> submit(FlowExecutor<O, I> flowExecutor) {
        if (shutdown.get()) {
            throw new IllegalStateException("Reactor is shutdown()");
        }

        if(flowExecutor.isReady()) {
            return flowExecutor.promise();
        }

        if(!flowExecutor.canRun()) {
            return flowExecutor.promise();
        }

        (flowExecutor.isBlocking() ? blockingInput : computingInput).offer(flowExecutor);

        return flowExecutor.promise();
    }

    private void ioHandler() {
        while (!shutdown.get()) {
            FlowExecutor<?, ?> flowExecutor = pollQueueForSingle(blockingInput);

            if (flowExecutor == null) {
                continue;
            }

            flowExecutor.run();
            submit(flowExecutor);
        }
    }

    private void computingHandler() {
        while (!shutdown.get()) {
            List<FlowExecutor<?, ?>> flowExecutors = pollQueue(computingInput);

            if (flowExecutors.isEmpty()) {
                continue;
            }

            flowExecutors.forEach(this::executeSingle);
        }
    }

    private void executeSingle(FlowExecutor<?, ?> flowExecutor) {
        runAllAsync(flowExecutor);

        while (ExecutionType.SYNC == flowExecutor.type()) {
            flowExecutor.run();
        }

        submit(flowExecutor);
    }

    private List<FlowExecutor<?, ?>> pollQueue(BlockingQueue<FlowExecutor<?, ?>> queue) {
        try {
            FlowExecutor<?, ?> element = queue.poll(POLL_INTERVAL, TimeUnit.MILLISECONDS);
            if (element == null) {
                return Collections.emptyList();
            }
            List<FlowExecutor<?, ?>> result = new ArrayList<>();
            result.add(element);
            queue.drainTo(result);
            return result;

        } catch (InterruptedException e) {
            // Ignore it and return empty collection
            return Collections.emptyList();
        }
    }

    private FlowExecutor<?, ?> pollQueueForSingle(BlockingQueue<FlowExecutor<?, ?>> queue) {
        try {
            return queue.poll(POLL_INTERVAL, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            // Ignore it and return null
            return null;
        }
    }

    private enum DefaultReactorHolder {
        INSTANCE;

        private final ThreadPoolReactor reactor;

        DefaultReactorHolder() {
            reactor = new ThreadPoolReactor(ThreadPool.defaultComputing(), ThreadPool.defaultIo());
        }

        public ThreadPoolReactor reactor() {
            return reactor;
        }
    }
}
