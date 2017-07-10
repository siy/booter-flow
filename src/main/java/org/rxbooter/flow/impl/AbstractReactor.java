package org.rxbooter.flow.impl;

import org.rxbooter.flow.Flow;
import org.rxbooter.flow.Reactor;
import org.rxbooter.flow.Step;
import org.rxbooter.flow.Step.TF;
import org.rxbooter.flow.Tuples.Tuple1;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * Base class for @{@link Reactor} implementations.
 */
public abstract class AbstractReactor implements Reactor {
    @SuppressWarnings("unchecked")
    @Override
    public final <T> Optional<T> awaitAny(Supplier<T>... suppliers) {
        Promise<Tuple1<T>> promise = Promise.waifFor(suppliers.length);

        Arrays.stream(suppliers)
              .map(s -> Flow.of(Step.await(TF.from(s))))
              .map(f -> f.applyTo(null, promise))
              .forEach(this::submit);

        return promise.safeAwait().map(Tuple1::get1);
    }

    protected void runAllAsync(FlowExecutor<?, ?> flowExecutor) {
        while (flowExecutor.isAsync()) {
            submit(flowExecutor.forCurrent());
        }
    }
}
