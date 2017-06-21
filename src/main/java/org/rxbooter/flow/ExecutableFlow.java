package org.rxbooter.flow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.rxbooter.flow.Flows.Flow;
import org.rxbooter.flow.Tuples.Tuple;

public class ExecutableFlow<O extends Tuple, I extends Tuple> {
    private final List<Step<Tuple, Tuple>> steps = new ArrayList<>();

    public ExecutableFlow(Flow<O> last) {
        last.apply((step) -> steps.add((Step<Tuple, Tuple>) step));
    }

    public Cursor<O, I> cursor(I input) {
        return new Cursor<O, I>(steps, input);
    }

    public static class Cursor<O extends Tuple, I extends Tuple> {
        private final List<Step<Tuple, Tuple>> steps;
        private final CountDownLatch latch = new CountDownLatch(1);

        private int index = 0;
        private Tuple intermediate;
        private Throwable error = null;

        protected Cursor(List<Step<Tuple, Tuple>> steps, I input) {
            this.steps = steps;
            this.intermediate = input;
        }

        public Cursor<O, ?> subCursor() {
            if (!canRun()) {
                //TODO: use other exception?
                throw new IllegalStateException("No active executable steps in cursor");
            }

            return new Cursor<>(Arrays.asList(currentStep()), intermediate);
        }

        public Tuple value() {
            return intermediate;
        }

        @SuppressWarnings("unchecked")
        public O await() {
            do {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    //Ignore it, it's irrelevant anyway
                }

                if (error != null) {
                    throw new RuntimeException("Flow processing threw an exception:", error);
                }
            } while (latch.getCount() != 1);
            return (O) value();
        }

        public boolean isBlocking() {
            if (!canRun()) {
                return false;
            }

            return currentStep().type() != StepType.SYNC;
        }

        public boolean isAsync() {
            if (!canRun()) {
                return false;
            }

            return currentStep().type() == StepType.ASYNC;
        }

        public boolean canRun() {
            return index < steps.size();
        }

        public Cursor<O, I> run() {
            if (canRun()) {
                try {
                    intermediate = currentStep().apply(intermediate);

                    if (index == (steps.size() - 1)) {
                        latch.countDown();
                    }
                } catch (Throwable t) {
                    //TODO: call step.onError when this functionality will be implemented
                    //TODO: use FlowException
                    error = t;
                    index = steps.size();
                    latch.countDown();
                }
            }
            return this;
        }

        private Step<Tuple, Tuple> currentStep() {
            return steps.get(index);
        }

        public boolean advance() {
            if (index < steps.size()) {
                index++;
            } else {
                latch.countDown();
            }
            return canRun();
        }
    }
}
