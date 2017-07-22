package org.rxbooter.flow.impl;

/*
 * Copyright (c) 2017 Sergiy Yevtushenko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 */

import org.rxbooter.flow.Flow;
import org.rxbooter.flow.Tuples.Tuple;
import org.rxbooter.flow.exception.FlowException;
import org.rxbooter.flow.reactor.ExecutionType;
import org.rxbooter.flow.reactor.Promise;
import org.rxbooter.flow.reactor.Reactor;
import org.rxbooter.flow.reactor.Step;

import java.util.Collections;
import java.util.List;

/**
 * Representation of the @{@link org.rxbooter.flow.Flow} in active state, i.e. when flow
 * is bound to input and can be executed.
 */
public class FlowExecutor<O extends Tuple, I extends Tuple> {
    private final List<Step<?, ?>> steps;
    private final Promise<O> promise;

    private int index = 0;
    private Tuple intermediate;

    public FlowExecutor(List<Step<?, ?>> steps, I input, Promise<O> promise) {
        this.steps = steps;
        this.intermediate = input;
        this.promise = promise;
    }

    /**
     * Creates new {@link FlowExecutor} from current {@link Step} in the flow. Created flow consists of only one step
     * and shares the same intermediate calculated value as original flow at the moment when all previous steps in the
     * flow are executed.
     *
     * @return new {@link Flow} consisting of single current step.
     */
    public FlowExecutor<O, ?> forCurrent() {
        if (!canRun()) {
            throw new FlowException("No active executable steps in cursor");
        }

        FlowExecutor<O, Tuple> result = new FlowExecutor<>(Collections.singletonList(currentStep()), intermediate, Promise.empty());
        advance();
        return result;
    }

    /**
     * Access instance of {@link Promise} associated with this {@link FlowExecutor}.
     *
     * @return reference to {@link Promise} instance.
     */
    public Promise<O> promise() {
        return promise;
    }

    /**
     * Check if execution changed state of associated {@link Promise} so result of execution
     * is already calculated and can be returned.
     *
     * @return {@code true} is associated {@link Promise} instance holds value or error.
     */
    public boolean isReady() {
        return promise.isReady();
    }

    /**
     * Return type of current (not yet executed) step.
     *
     * @return execution type.
     */
    public ExecutionType type() {
        return (index < steps.size()) ? currentStep().type() : null;
    }

    /**
     * Check if current (not yet executed) step is blocking. All step types except
     * {@link ExecutionType#SYNC} are considered blocking.
     *
     * @return {@code true} if current step can be executed and is blocking.
     */
    public boolean isBlocking() {
        return !canRun() || currentStep().type() != ExecutionType.SYNC;
    }

    /**
     * Check if current (not yet executed) step is asynchronous execution step.
     *
     * @return {@code true} if current step can be executed and is asynchronous.
     */
    public boolean isAsync() {
        return canRun() && currentStep().type() == ExecutionType.ASYNC;
    }

    /**
     * Check if flow can execute current step.
     *
     * @return {@code true} if step can be executed.
     */
    public boolean canRun() {
        return !isReady() && index < steps.size();
    }

    /**
     * Execute single flow step. If executed step is the last one then associated promise is notified.
     *
     * @return {@code true} if next step can be executed.
     */
    @SuppressWarnings("unchecked")
    public boolean invoke() {
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

        return advance();
    }

    private boolean isLastStep() {
        return index == (steps.size() - 1);
    }

    @SuppressWarnings("unchecked")
    private Step<Tuple, Tuple> currentStep() {
        return (Step<Tuple, Tuple>) steps.get(index);
    }

    /**
     * Go to next step.
     *
     * @return {@code true} if switching to next step is possible and went successfully.
     */
    public boolean advance() {
        if (index < steps.size()) {
            index++;
        }
        return canRun();
    }

    /**
     * Start execution of the flow in the specified {@link Reactor}.
     *
     * @param reactor
     *          Instance of {@link Reactor} where flow will be executed.
     * @return instance of {@link Promise} associated with this flow.
     */
    public Promise<O> in(Reactor reactor) {
        return reactor.submit(this);
    }
}
