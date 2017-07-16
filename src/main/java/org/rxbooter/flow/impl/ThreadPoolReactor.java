package org.rxbooter.flow.impl;

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

import org.rxbooter.flow.*;
import org.rxbooter.flow.Tuples.Tuple;
import org.rxbooter.flow.Tuples.Tuple1;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Supplier;

/**
 * Simple yet full featured {@link Reactor} implementation.
 * <br/>
 * This implementation is built around two thread pools - one (computation) thread pool is used
 * for {@link ExecutionType#SYNC} steps and second (I/O or blocking) for remaining tasks.
 */
public class ThreadPoolReactor implements Reactor {
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

    /**
     * Obtain default instance of {@link ThreadPoolReactor}
     * @return default reactor instance.
     */
    public static ThreadPoolReactor defaultReactor() {
        return DefaultReactorHolder.INSTANCE.reactor();
    }

    /**
     * Create instance of {@link ThreadPoolReactor} with which will use specified thread pools.
     *
     * @param computingPool
     *          Computing pool which is used for fast non-blocking flow steps execution.
     * @param ioPool
     *          I/O or blocking pool which is used for all asynchronous and blocking tasks.
     * @return built instance of {@link ThreadPoolReactor}
     */
    public static ThreadPoolReactor with(ThreadPool computingPool, ThreadPool ioPool) {
        return new ThreadPoolReactor(computingPool, ioPool);
    }

    /**
     * Execute provided instances of {@link Supplier} and wait for one of them which will finish
     * successful execution first. Once first supplier is finished, result is returned event if
     * some other suppliers are still running. If all suppliers failed then empty result is returned.
     *
     * @param suppliers Suppliers to execute
     * @return optional result of execution. It holds first returned value if at least one supplier
     * provided valid instance or is empty if all suppliers failed.
     */
    @SuppressWarnings("unchecked")
    @Override
    public final <T> Optional<T> awaitAny(Supplier<T>... suppliers) {
        Promise<Tuple1<T>> promise = Promise.waifFor(suppliers.length);

        Arrays.stream(suppliers)
              .map(s -> Flow.of(Step.await(Functions.TF.from(s)), Tuples.empty1()))
              .map(f -> f.applyTo(null, promise))
              .forEach(this::submit);

        return promise.safeAwait().map(Tuple1::get1);
    }

    /**
     * Shutdown reactor.
     */
    @Override
    public void shutdown() {
        shutdown.compareAndSet(false, true);
        computingPool.shutdown();
        ioPool.shutdown();
    }

    /**
     * Submit {@link FlowExecutor} to reactor for execution. Submission is performed asynchronously
     * and result if returned immediately. Notification about execution are performed via returned
     * instance of {@link Promise} associated with the {@link FlowExecutor} instance.
     *
     * @param flowExecutor
     *          {@link FlowExecutor} instance which need to be processed.
     * @return  Instance of {@link Promise} associated with submitted {@link FlowExecutor}.
     */
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

    protected void runAllAsync(FlowExecutor<?, ?> flowExecutor) {
        while (flowExecutor.isAsync()) {
            submit(flowExecutor.forCurrent());
        }
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
