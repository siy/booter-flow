package org.rxbooter.flow;

import org.rxbooter.flow.impl.FlowBuilders.FlowBuilder0;

import java.util.ArrayList;
import java.util.List;

import static org.rxbooter.flow.Tuples.*;

public class Flow<O extends Tuple, I extends Tuple> {
    private final List<Step<?, ?>> steps;

    private Flow(List<Step<?, ?>> steps) {
        this.steps = steps;
    }

    public static <O1 extends Tuple, I1 extends Tuple> Flow<O1, I1> of(FlowBuilder0<O1> builder) {
        List<Step<?, ?>> steps = new ArrayList<>();
        builder.apply(steps::add);

        return new Flow<>(steps);
    }
}
