package org.rxbooter.flow.impl;

import java.util.function.Consumer;
import java.util.function.Supplier;

import org.rxbooter.flow.Flow;
import org.rxbooter.flow.Pipeline;
import org.rxbooter.flow.Reactor;

import static org.rxbooter.flow.Tuples.*;

public class PipelineBuilder<O extends Tuple, I extends Tuple>  {
    private final Flow<O, I> flow;
    private final Supplier<I> input;
    private final Consumer<O> output;

    public PipelineBuilder(Flow<O, I> flow, Supplier<I> input, Consumer<O> output) {
        this.flow = flow;
        this.input = input;
        this.output = output;
    }

    public Pipeline<O, I> on(Reactor reactor) {
        return new Pipeline<>(flow, input, output, reactor);
    }
}
