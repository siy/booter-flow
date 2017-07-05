package org.rxbooter.flow.impl;

import org.rxbooter.flow.Flow;
import org.rxbooter.flow.Reactor;
import org.rxbooter.flow.Step;
import org.rxbooter.flow.Tuples.Tuple1;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * Base class for @{@link Reactor} implementations.
 */
public abstract class AbstractReactor implements Reactor {
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
