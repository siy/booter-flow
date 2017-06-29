package org.rxbooter.flow.impl;

import org.rxbooter.flow.Step;
import org.rxbooter.flow.StepType;
import org.rxbooter.flow.Tuples.Tuple;

import java.util.Collections;
import java.util.List;

//TODO: rework it!!!
public class ExecutableFlow<O extends Tuple, I extends Tuple> {
    private final List<Step<? extends Tuple, ? extends Tuple>> steps;
    private final Promise<O> promise;

    private int index = 0;
    private Tuple intermediate;
    private Throwable error = null;

    private ExecutableFlow(List<Step<? extends Tuple, ? extends Tuple>> steps, I input, Promise<O> promise) {
        this.steps = steps;
        this.intermediate = input;
        this.promise = promise;
    }

    public static <O extends Tuple, I extends Tuple> ExecutableFlow<O, I> with(List<Step<? extends Tuple, ? extends Tuple>> steps, I input) {
        return new ExecutableFlow<>(steps, input, Promise.with());
    }

    public static <O extends Tuple, I extends Tuple> ExecutableFlow<O, I> with(List<Step<? extends Tuple, ? extends Tuple>> steps, I input, Promise<O> promise) {
        return new ExecutableFlow<>(steps, input, promise);
    }

    public ExecutableFlow<O, ?> forCurrent() {
        if (!canRun()) {
            //TODO: use other exception?
            throw new IllegalStateException("No active executable steps in cursor");
        }

        return ExecutableFlow.with(Collections.singletonList(currentStep()), intermediate);
    }

    public Tuple value() {
        return intermediate;
    }

    @SuppressWarnings("unchecked")
    public O await() {
        return promise.await();
    }

    private boolean isReady() {
        return promise.isReady();
    }

    public boolean isBlocking() {
        return !canRun() || currentStep().type() != StepType.SYNC;
    }

    public boolean isAsync() {
        return canRun() && currentStep().type() == StepType.ASYNC;
    }

    public int group() {
        return canRun() ? currentStep().group() : -1;
    }

    public boolean canRun() {
        return !isReady() && index < steps.size();
    }

    @SuppressWarnings("unchecked")
    public ExecutableFlow<O, I> step() {
        if (canRun()) {
            try {
                intermediate = currentStep().apply(intermediate);

                if (isLastStep()) {
                    promise.notify((O) intermediate);
                }
            } catch (Throwable t) {
//                    Tuple res = currentStep().handle(t);
//
//                    if (res != null) {
//                        //Assume error is handled
//                        if (isLastStep()) {
//                            promise.notify((O) intermediate);
//                        }
//                    } else {
//                        promise.notifyError(t);
//                    }
            }
        }

        return this;
    }

    private boolean isLastStep() {
        return index == (steps.size() - 1);
    }

    @SuppressWarnings("unchecked")
    private Step<Tuple, Tuple> currentStep() {
        return (Step<Tuple, Tuple>) steps.get(index);
    }

    public boolean advance() {
        if (index < steps.size()) {
            index++;
        }
        return canRun();
    }
}
