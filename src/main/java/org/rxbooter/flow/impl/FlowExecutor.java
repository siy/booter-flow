package org.rxbooter.flow.impl;

import org.rxbooter.flow.*;
import org.rxbooter.flow.Tuples.Tuple;

import java.util.Collections;
import java.util.List;

/**
 * Representation of the @{@link org.rxbooter.flow.Flow} in active state, i.e. when flow is bound to input
 * and can be executed.
 */
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

    /**
     * Creates new {@link FlowExecutor} from current {@link Step} in the flow. Created flow consists of only one step
     * and shares the same intermediate calculated value as original flow at the moment when all previous steps in the
     * flow are executed.
     *
     * @return new {@link org.rxbooter.flow.Flow} consisting of single current step.
     */
    public FlowExecutor<O, ?> forCurrent() {
        if (!canRun()) {
            throw new FlowException("No active executable steps in cursor");
        }

        //TODO: add call to advance()
        return new FlowExecutor<>(Collections.singletonList(currentStep()), intermediate, Promise.empty());
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
    public boolean run() {
        if (!canRun()) {
            return false;
        }

        try {
            intermediate = currentStep().apply(intermediate);

            if (isLastStep()) {
                promise.notify((O) intermediate);
            }
        } catch (Throwable t) {
            promise.notifyError(t);
        }

        //TODO: add call to advance()
        return advance();
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

    public Promise<O> in(Reactor reactor) {
        return reactor.submit(this);
    }
}
