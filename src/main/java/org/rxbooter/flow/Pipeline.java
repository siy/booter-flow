package org.rxbooter.flow;

import java.util.ArrayList;
import java.util.List;

import org.rxbooter.flow.Flow.FlowBuilder;
import org.rxbooter.flow.Tuples.Tuple;

public class Pipeline<O extends Tuple, I extends Tuple> {
    private final List<Step<? extends Tuple, ? extends Tuple>> steps = new ArrayList<>();

    @SuppressWarnings("unchecked")
    public Pipeline(FlowBuilder<O> last) {
        //TODO: add grouping steps in batches
        last.apply((step) -> steps.add((Step<Tuple, Tuple>) step));
    }

    public Pipeline(Step<O, I> step) {
        steps.add(step);
    }

    public Cursor<O, I> cursor(I input) {
        return new Cursor<>(steps, input);
    }
}
