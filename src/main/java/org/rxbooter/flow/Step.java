package org.rxbooter.flow;

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

import org.rxbooter.flow.Functions.EH;
import org.rxbooter.flow.Functions.TF;

/**
 * Contained for single flow step.
 *
 * @param <R1>  return type
 * @param <T1>  input type
 */
public class Step<R1, T1> {
    private final ExecutionType type;
    private final TF<R1, T1> function;
    private EH<R1> handler;

    private Step(ExecutionType type, TF<R1, T1> function, EH<R1> handler) {
        this.type = type;
        this.function = function;
        this.handler = handler == null ? (t) -> null : handler;
    }

    /**
     * Obtain exception handler for the step.
     *
     * @return exception handler defined for the step.
     */
    public EH<R1> handler() {
        return handler;
    }

    /**
     * Set new exception handler for step.
     *
     * @param handler
     *          New exception handler.
     * @return  reference to {@code this} for call chaining (fluent syntax)
     */
    public Step<R1, T1> handler(EH<R1> handler) {
        this.handler = handler;
        return this;
    }

    /**
     * Obtain step execution type.
     *
     * @return step execution type.
     */
    public ExecutionType type() {
        return type;
    }

    /**
     * Apply step function to provided parameters and handle result.
     *
     * @param param
     *          Input parameter
     * @return  result of applying step function to given parameter.
     */
    public R1 apply(T1 param) {
        try {
            return function.apply(param);
        } catch (Throwable t) {
            R1 res = handler.handle(t);

            if (res == null) {
                throw new FlowException("User code threw an unhandled exception ", t);
            }
            return res;
        }
    }

    /**
     * Static factory method for creating steps with given type and step function.
     *
     * @param type
     *          Desired step type
     * @param function
     *          Step function
     * @return created {@link Step} instance.
     */
    public static<R, T> Step<R, T> of(ExecutionType type, TF<R, T> function) {
        return of(type, function, (t) -> null);
    }

    /**
     * Static factory method for creating steps with given type, step function and exception handler.
     *
     * @param type
     *          Desired step type
     * @param function
     *          Step function
     * @param errorHandler
     *          Exception handler
     * @return created {@link Step} instance.
     */
    public static<R, T> Step<R, T> of(ExecutionType type, TF<R, T> function, EH<R> errorHandler) {
        return new Step<>(type, function, errorHandler);
    }

    /**
     * Static factory method for creating steps of {@link ExecutionType#SYNC} type and with given
     * step function.
     *
     * @param function
     *          Step function
     * @return created {@link Step} instance.
     */
    public static<R, T> Step<R, T> sync(TF<R, T> function) {
        return of(ExecutionType.SYNC, function);
    }

    /**
     * Static factory method for creating steps of {@link ExecutionType#SYNC} type, with given
     * step function and exception handler.
     *
     * @param function
     *          Step function
     * @param errorHandler
     *          Exception handler
     * @return created {@link Step} instance.
     */
    public static<R, T> Step<R, T> sync(TF<R, T> function, EH<R> errorHandler) {
        return of(ExecutionType.SYNC, function, errorHandler);
    }

    /**
     * Static factory method for creating steps of {@link ExecutionType#ASYNC} type and with given
     * step function.
     *
     * @param function
     *          Step function
     * @return created {@link Step} instance.
     */
    public static<R, T> Step<R, T> async(TF<R, T> function) {
        return of(ExecutionType.ASYNC, function);
    }

    /**
     * Static factory method for creating steps of {@link ExecutionType#ASYNC} type, with given
     * step function and exception handler.
     *
     * @param function
     *          Step function
     * @param errorHandler
     *          Exception handler
     * @return created {@link Step} instance.
     */
    public static<R, T> Step<R, T> async(TF<R, T> function, EH<R> errorHandler) {
        return of(ExecutionType.ASYNC, function, errorHandler);
    }

    /**
     * Static factory method for creating steps of {@link ExecutionType#AWAIT} type and with given
     * step function.
     *
     * @param function
     *          Step function
     * @return created {@link Step} instance.
     */
    public static<R, T> Step<R, T> await(TF<R, T> function) {
        return of(ExecutionType.AWAIT, function);
    }

    /**
     * Static factory method for creating steps of {@link ExecutionType#AWAIT} type, with given
     * step function and exception handler.
     *
     * @param function
     *          Step function
     * @param errorHandler
     *          Exception handler
     * @return created {@link Step} instance.
     */
    public static<R, T> Step<R, T> await(TF<R, T> function, EH<R> errorHandler) {
        return of(ExecutionType.AWAIT, function, errorHandler);
    }
}
