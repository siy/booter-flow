package org.rxbooter.flow.impl;

import org.rxbooter.flow.Flow;
import org.rxbooter.flow.Reactor;
import org.rxbooter.flow.Step;
import org.rxbooter.flow.Step.EH;
import org.rxbooter.flow.Task;
import org.rxbooter.flow.Tuples;
import org.rxbooter.flow.Tuples.Tuple;
import org.rxbooter.flow.Tuples.Tuple1;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * Base class for @{@link Reactor} implementations. In expresses most of the convenience methods via remaining ones
 * and therefore reduces number of methods which need to be implemented.
 */
public abstract class AbstractReactor implements Reactor {
    @Override
    public final <O extends Tuple, I extends Tuple> O await(FlowExecutor<O, I> flowExecutor) {
        return submit(flowExecutor).await();
    }

    @Override
    public final <T> T await(Supplier<T> supplier) {
        return await(Flow.await(Step.from(supplier)).applyTo(null)).get();
    }

    @Override
    public final <T> T await(Supplier<T> supplier, EH<Tuple1<T>> handler) {
        return await(Flow.await(Step.from(supplier), handler).applyTo(null)).get();
    }

    @Override
    public final <O extends Tuple, I extends Tuple> void async(FlowExecutor<O, I> flowExecutor) {
        submit(flowExecutor);
    }

    @Override
    public final void async(Runnable runnable) {
        submit(Flow.async(Step.from(runnable)).applyTo(null));
    }

    @Override
    public final void async(Runnable runnable, EH<Tuple1<Void>> handler) {
        submit(Flow.async(Step.from(runnable), handler).applyTo(null));
    }

    @Override
    public final <T> Optional<T> awaitAny(Supplier<T>... suppliers) {
        Promise<Tuple1<T>> promise = Promise.waifFor(suppliers.length);

        Arrays.stream(suppliers)
              .map(s -> Flow.await(Step.from(s)))
              .map(f -> f.applyTo(null, promise))
              .forEach(f -> submit(f));

        return promise.awaitSafe().map(t -> t.get());
    }

    protected void runAllAsync(FlowExecutor<?, ?> flowExecutor) {
        while (flowExecutor.isAsync()) {
            submit(flowExecutor.forCurrent());
            flowExecutor.advance();
        }
    }
}
