package org.rxbooter.flow;

import java.util.ArrayList;
import java.util.List;

import org.rxbooter.flow.Flows.Flow;
import org.rxbooter.flow.Tuples.Tuple;

public class ExecutableFlow<O, I> {
    private final List<Step<Tuple, Tuple>> steps = new ArrayList<>();

    public ExecutableFlow(Flow<O> last) {
        last.apply((step) -> steps.add((Step<Tuple, Tuple>) step));
    }

    public Cursor<O, I> cursor(I input) {
        return new Cursor<O, I>(steps, input);
    }

    public static class Cursor<O, I> {
        private final List<Step<Tuple, Tuple>> steps;
        private final I input;

        private int index = 0;
        private Tuple intermediate;
        private Throwable error = null;

        protected Cursor(List<Step<Tuple, Tuple>> steps, I input) {
            this.steps = steps;
            this.input = input;
            this.intermediate = (input instanceof Tuple) ? (Tuple) input : Tuples.of(input);
        }

        public Tuple value() {
            return intermediate;
        }

        public I input() {
            return input;
        }

        public boolean canRun() {
            return index < steps.size();
        }

        public Cursor<O, I> run() {
            if (canRun()) {
                Step<Tuple, Tuple> step = steps.get(index);

                try {
                    intermediate = step.apply(intermediate);
                } catch (Throwable t) {
                    //TODO: call step.onError when this functiinality will be implemented
                    //TODO: use FlowException
                    throw new RuntimeException(t);
                }
            }
            return this;
        }

        private boolean advance() {
            if (index < steps.size()) {
                index++;
            }
            return canRun();
        }
    }
}
