package org.rxbooter.flow.impl;

import org.rxbooter.flow.Promise;
import org.rxbooter.flow.Tuples.Tuple;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public class SingleThreadReactor extends AbstractReactor {
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

        input.offer(flowExecutor);  // unbound queue, always succeed
        return flowExecutor.promise();
    }

    private void stepper() {
        while (!shutdown.get()) {
            FlowExecutor<?, ?> flowExecutor = pollQueue(input);

            if (flowExecutor != null) {
                runSingle(flowExecutor);
            }
        }
    }

    private void runSingle(FlowExecutor<?, ?> flowExecutor) {
        do {
            runAllAsync(flowExecutor);
        } while (flowExecutor.run());
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
