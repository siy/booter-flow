package org.rxbooter.flow;

import org.rxbooter.flow.Tuples.Tuple;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Cursor<O extends Tuple, I extends Tuple> {
    private final List<Step<? extends Tuple, ? extends Tuple>> steps;
    private final CountDownLatch latch = new CountDownLatch(1);

    private int index = 0;
    private Tuple intermediate;
    private Throwable error = null;

    public Cursor(List<Step<? extends Tuple, ? extends Tuple>> steps, I input) {
        this.steps = steps;
        this.intermediate = input;
    }

    public static <O extends Tuple, I extends Tuple> Cursor<O, I> single(Step<O, I> step, I input) {
        return new Cursor<>(Collections.singletonList(step), input);
    }

    public static <O extends Tuple> Cursor<O, Tuple> single(Step<O, Tuple> step) {
        return new Cursor<>(Collections.singletonList(step), Tuples.of(null));
    }

    public Cursor<O, ?> subCursor() {
        if (!canRun()) {
            //TODO: use other exception?
            throw new IllegalStateException("No active executable steps in cursor");
        }

        return new Cursor<>(Collections.singletonList(currentStep()), intermediate);
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
                //TODO: use FlowException
                throw new RuntimeException("Flow processing threw an unhandled exception:", error);
            }
        } while (latch.getCount() != 0);
        return (O) value();
    }

    public boolean isBlocking() {
        return canRun() ? currentStep().type() != StepType.SYNC : true;
    }

    public boolean isAsync() {
        return canRun() ? currentStep().type() == StepType.ASYNC : false;
    }

    public int group() {
        return canRun() ? currentStep().group() : -1;
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
                Tuple res = currentStep().handle(t);

                if (res != null) {
                    //Assume error is handled
                    intermediate = res;
                } else {
                    error = t;
                    index = steps.size();
                    latch.countDown();
                }
            }
        }

        return this;
    }

    @SuppressWarnings("unchecked")
    private Step<Tuple, Tuple> currentStep() {
        return (Step<Tuple, Tuple>) steps.get(index);
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
