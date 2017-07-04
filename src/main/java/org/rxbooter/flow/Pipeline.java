package org.rxbooter.flow;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Pipeline<O extends Tuples.Tuple, I extends Tuples.Tuple>  {
    private final Flow<O, I> flow;
    private final Supplier<I> input;
    private final Consumer<O> output;
    private final Reactor reactor;

    public Pipeline(Flow<O, I> flow, Supplier<I> input, Consumer<O> output, Reactor reactor) {
        this.flow = flow;
        this.input = input;
        this.output = output;
        this.reactor = reactor;
    }

    public Pipeline<O, I> start() {
        //TODO: finish it once refactoring of Reactor will be completed
        return null;
    }
}
