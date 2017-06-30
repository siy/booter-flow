package org.rxbooter.flow.impl;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Supplier;

import org.rxbooter.flow.Flow;
import org.rxbooter.flow.Reactor;
import org.rxbooter.flow.Step.EH;
import org.rxbooter.flow.Tuples;
import org.rxbooter.flow.Tuples.Tuple;
import org.rxbooter.flow.Tuples.Tuple1;

public class SingleThreadReactor implements Reactor {
    private static final long POLL_INTERVAL = 100;

    private static final AtomicLong counter = new AtomicLong(0);

    private final Thread executor;
    private final BlockingQueue<FlowExecutor<?, ?>> input = new LinkedBlockingQueue<>();
    private final AtomicBoolean shutdown = new AtomicBoolean();

    public SingleThreadReactor() {
        executor = new Thread(this::stepper, "SingleThreadReactor-" + counter.incrementAndGet());
        executor.setDaemon(true);
        executor.start();
    }

    @Override
    public void shutdown() {
        shutdown.compareAndSet(false, true);
    }

    @Override
    public <O extends Tuple, I extends Tuple> O await(FlowExecutor<O, I> flowExecutor) {
        putTask(flowExecutor);
        return flowExecutor.promise().await();
    }

    @Override
    public <O extends Tuple, I extends Tuple> void async(FlowExecutor<O, I> flowExecutor) {
        putTask(flowExecutor);
    }

    @Override
    public void async(Runnable runnable) {
        putTask(Flow.async((a) -> {runnable.run(); return Tuples.empty();}).applyTo(null));
    }

    @Override
    public <T> T await(Supplier<T> function) {
        return await(Flow.await((t) -> Tuples.of(function.get())).applyTo(null)).get();
    }

    @Override
    public void async(Runnable runnable, EH<Tuple1<Void>> handler) {
        putTask(Flow.async((a) -> {runnable.run(); return Tuples.of(null);}, handler).applyTo(null));
    }

    @Override
    public <T> T await(Supplier<T> function, EH<Tuple1<T>> handler) {
        return await(Flow.await((t) -> Tuples.of(function.get()), handler).applyTo(null)).get();
    }

    @Override
    public <T> T awaitAny(Supplier<T>... suppliers) {
        Promise<Tuple1<T>> promise = Promise.empty();

        for (Supplier<T> supplier : suppliers) {
            putTask(Flow.await((t) -> Tuples.of(supplier.get())).applyTo(null, promise));
        }

        return promise.await().get();
    }

    @Override
    public <O extends Tuple, I extends Tuple> Promise<O> submit(FlowExecutor<O, I> flowExecutor) {
        putTask(flowExecutor);
        return flowExecutor.promise();
    }

    private void putTask(FlowExecutor<?, ?> flowExecutor) {
        input.add(flowExecutor);
    }

    private void stepper() {
        while (!shutdown.get()) {
            try {
                FlowExecutor<?, ?> flowExecutor = pollQueue(input);

                if (flowExecutor == null) {
                    continue;
                }

                do {
                    //Intentionally left empty
                } while(flowExecutor.stepAndAdvance());
            } catch (Throwable t) {
                //TODO: log issue somehow? flows should not leak exceptions, but this need to be verified
            }
        }
    }

    private FlowExecutor<?, ?> pollQueue(BlockingQueue<FlowExecutor<?, ?>> queue) {
        try {
            return queue.poll(POLL_INTERVAL, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            // Ignore it and return null. if shutdown is requested, then we'll handle it upon exit
            return null;
        }
    }
}
