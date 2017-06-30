package org.rxbooter.flow.impl;

import org.rxbooter.flow.FlowException;
import org.rxbooter.flow.Reactor;
import org.rxbooter.flow.Step;
import org.rxbooter.flow.ExecutionType;
import org.rxbooter.flow.Tuples;
import org.rxbooter.flow.Tuples.Tuple;

import java.util.Collections;
import java.util.List;

public class FlowExecutor<O extends Tuple, I extends Tuple> {
    private final List<Step<?, ?>> steps;
    private final Promise<O> promise;

    private int index = 0;
    private Tuple intermediate;
    private Throwable error = null;

    public FlowExecutor(List<Step<?, ?>> steps, I input, Promise<O> promise) {
        this.steps = steps;
        this.intermediate = input == null ? Tuples.empty() : input;
        this.promise = promise;
    }

    public FlowExecutor<O, ?> forCurrent() {
        if (!canRun()) {
            throw new FlowException("No active executable steps in cursor");
        }

        return new FlowExecutor<>(Collections.singletonList(currentStep()), intermediate, Promise.empty());
    }

    public Tuple value() {
        return intermediate;
    }

    public Promise<O> promise() {
        return promise;
    }

    public boolean isReady() {
        return promise.isReady();
    }

    public ExecutionType type() {
        return (index < steps.size()) ? currentStep().type() : null;
    }

    public boolean isBlocking() {
        return !canRun() || currentStep().type() != ExecutionType.SYNC;
    }

    public boolean isAsync() {
        return canRun() && currentStep().type() == ExecutionType.ASYNC;
    }

    public boolean canRun() {
        return !isReady() && index < steps.size();
    }

    @SuppressWarnings("unchecked")
    public FlowExecutor<O, I> run() {
        if (!canRun()) {
            return this;
        }

        try {
            intermediate = currentStep().apply(intermediate);

            if (isLastStep()) {
                promise.notify((O) intermediate);
            }
        } catch (Throwable t) {
            promise.notifyError(t);
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

    public boolean stepAndAdvance() {
        try {
            intermediate = currentStep().apply(intermediate);

            if (isLastStep()) {
                promise.notify((O) intermediate);
            } else {
                return advance();
            }
        } catch (Throwable t) {
            promise.notifyError(t);
        }

        return canRun();
    }

    public Promise<O> in(Reactor reactor) {
        return reactor.submit(this);
    }
}
