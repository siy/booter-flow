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

import org.rxbooter.flow.Tuples.*;
import org.rxbooter.flow.impl.FlowBuilders.*;
import org.rxbooter.flow.impl.FlowExecutor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

/**
 * Representation of executable flow.
 * <br/>
 * Executable flow consists of set of {@link Step}'s. Each step might be one of the {@link ExecutionType}
 * type. Steps of {@link ExecutionType#SYNC} type are handled by computing thread pool of {@link Reactor}.
 * Steps of {@link ExecutionType#ASYNC} and {@link ExecutionType#AWAIT} types are handled by blocking I/O
 * thread pool of {@link Reactor}.
 * <br/>
 * Each flow has input and output values. Both of them are instances of {@link Tuple} of some size
 * (sizes from 1 to 9 are supported) qualified by some types. Flows with compatible types (i.e. type of
 * output of one flow matches type of input of other flow) can be combined in more complex flow.
 * <br/>
 * {@link Flow} is immutable container with zero flow state, so it can be freely shared across multiple
 * threads without need for synchronisation. In order to execute flow {@link #applyTo(Tuple)} is used.
 * It creates an instance of {@link FlowExecutor} which can be submitted to {@link Reactor} for execution.
 *
 * @param <O>
 *     Output type
 * @param <I>
 *     Input type
 */
public class Flow<O extends Tuple, I extends Tuple> {
    private final List<Step<?, ?>> steps;
    private final Tuple empty;

    private Flow(List<Step<?, ?>> steps, Tuple empty) {
        this.steps = steps;
        this.empty = empty;
    }

    /**
     * Create {@link FlowExecutor} for this flow. Note that this call does not trigger immediate execution.
     * Instead created instance of {@link FlowExecutor} should be submitted to {@link Reactor} for execution.
     *
     * @param input
     *          Actual input parameters for flow.
     * @return created {@link FlowExecutor}
     */
    public FlowExecutor<O, I> applyTo(I input) {
        return new FlowExecutor<>(steps, sanitizeInput(input), Promise.empty());
    }

    /**
     * Create {@link FlowExecutor} for this flow. Note that this call does not trigger immediate execution.
     * Instead created instance of {@link FlowExecutor} should be submitted to {@link Reactor} for execution.
     * <br/>
     * Along with input parameter this method requires instance of {@link Promise} which will receive
     * notification upon flow execution completion.
     *
     * @param input
     *          Actual input parameters for flow.
     * @param promise
     *          Instance of {@link Promise} which will receive notification
     * @return created {@link FlowExecutor}
     */
    public FlowExecutor<O, I> applyTo(I input, Promise<O> promise) {
        return new FlowExecutor<>(steps, sanitizeInput(input), promise);
    }

    @SuppressWarnings("unchecked")
    private I sanitizeInput(I input) {
        return input == null ? (I) empty : input;
    }

    /**
     * Factory method for assembling {@link Flow} from flow builder.
     *
     * @param builder
     *          Builder to assemble flow from.
     * @return created {@link Flow} instance
     */
    public static <O1 extends Tuple, I1 extends Tuple> Flow<O1, I1> of(FlowBuilder0<I1> builder) {
        List<Step<?, ?>> steps = new ArrayList<>();
        builder.apply(steps::add);

        return new Flow<>(steps, builder.empty());
    }

    /**
     * Create flow consisting of single step.
     *
     * @param step
     *          The step for which flow is created.
     * @param empty
     *          Tuple which represents empty input for step.
     * @return created {@link Flow} instance
     */
    public static <O1 extends Tuple, I1 extends Tuple> Flow<O1, I1> of(Step<O1, I1> step, Tuple empty) {
        return new Flow<>(Collections.singletonList(step), empty);
    }

    public static <O extends Tuple, M extends Tuple, I extends Tuple> Flow<O, I> compose(Flow<M, I> flow1, Flow<O, M> flow2) {
        List<Step<?, ?>> steps = new ArrayList<>(flow1.steps);
        steps.addAll(flow2.steps);
        return new Flow<>(steps, flow1.empty);
    }

    public static<T1> FlowBuilder1<Tuple1<Void>, T1> from(Supplier<T1> param1) {
        return new FlowBuilder1<Tuple1<Void>, T1>(null).map((t) -> Tuples.of(param1.get()));
    }

    public static<T1> FlowBuilder1<Tuple1<T1>, T1> take(Class<T1> param1) {
        return new FlowBuilder1<>(null);
    }

    public static<T1, T2> FlowBuilder2<Tuple2<T1, T2>, T1, T2> take(Class<T1> param1, Class<T2> param2) {
        return new FlowBuilder2<>(null);
    }

    public static<T1, T2, T3> FlowBuilder3<Tuple3<T1, T2, T3>, T1, T2, T3> take(Class<T1> param1, Class<T2> param2, Class<T3> param3) {
        return new FlowBuilder3<>(null);
    }

    public static<T1, T2, T3, T4> FlowBuilder4<Tuple4<T1, T2, T3, T4>, T1, T2, T3, T4> take(Class<T1> param1, Class<T2> param2, Class<T3> param3, Class<T4> param4) {
        return new FlowBuilder4<>(null);
    }

    public static<T1, T2, T3, T4, T5> FlowBuilder5<Tuple5<T1, T2, T3, T4, T5>, T1, T2, T3, T4, T5> take(Class<T1> param1, Class<T2> param2, Class<T3> param3, Class<T4> param4, Class<T5> param5) {
        return new FlowBuilder5<>(null);
    }

    public static<T1, T2, T3, T4, T5, T6> FlowBuilder6<Tuple6<T1, T2, T3, T4, T5, T6>, T1, T2, T3, T4, T5, T6> take(Class<T1> param1, Class<T2> param2, Class<T3> param3, Class<T4> param4, Class<T5> param5, Class<T6> param6) {
        return new FlowBuilder6<>(null);
    }

    public static<T1, T2, T3, T4, T5, T6, T7> FlowBuilder7<Tuple7<T1, T2, T3, T4, T5, T6, T7>, T1, T2, T3, T4, T5, T6, T7> take(Class<T1> param1, Class<T2> param2, Class<T3> param3, Class<T4> param4, Class<T5> param5, Class<T6> param6, Class<T7> param7) {
        return new FlowBuilder7<>(null);
    }

    public static<T1, T2, T3, T4, T5, T6, T7, T8> FlowBuilder8<Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>, T1, T2, T3, T4, T5, T6, T7, T8> take(Class<T1> param1, Class<T2> param2, Class<T3> param3, Class<T4> param4, Class<T5> param5, Class<T6> param6, Class<T7> param7, Class<T8> param8) {
        return new FlowBuilder8<>(null);
    }

    public static<T1, T2, T3, T4, T5, T6, T7, T8, T9> FlowBuilder9<Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>, T1, T2, T3, T4, T5, T6, T7, T8, T9> take(Class<T1> param1, Class<T2> param2, Class<T3> param3, Class<T4> param4, Class<T5> param5, Class<T6> param6, Class<T7> param7, Class<T8> param8, Class<T9> param9) {
        return new FlowBuilder9<>(null);
    }

    public static<T1> FlowBuilder1<Tuple1<T1>, T1> take(Type<T1> param1) {
        return new FlowBuilder1<>(null);
    }

    public static<T1, T2> FlowBuilder2<Tuple2<T1, T2>, T1, T2> take(Type<T1> param1, Type<T2> param2) {
        return new FlowBuilder2<>(null);
    }

    public static<T1, T2, T3> FlowBuilder3<Tuple3<T1, T2, T3>, T1, T2, T3> take(Type<T1> param1, Type<T2> param2, Type<T3> param3) {
        return new FlowBuilder3<>(null);
    }

    public static<T1, T2, T3, T4> FlowBuilder4<Tuple4<T1, T2, T3, T4>, T1, T2, T3, T4> take(Type<T1> param1, Type<T2> param2, Type<T3> param3, Type<T4> param4) {
        return new FlowBuilder4<>(null);
    }

    public static<T1, T2, T3, T4, T5> FlowBuilder5<Tuple5<T1, T2, T3, T4, T5>, T1, T2, T3, T4, T5> take(Type<T1> param1, Type<T2> param2, Type<T3> param3, Type<T4> param4, Type<T5> param5) {
        return new FlowBuilder5<>(null);
    }

    public static<T1, T2, T3, T4, T5, T6> FlowBuilder6<Tuple6<T1, T2, T3, T4, T5, T6>, T1, T2, T3, T4, T5, T6> take(Type<T1> param1, Type<T2> param2, Type<T3> param3, Type<T4> param4, Type<T5> param5, Type<T6> param6) {
        return new FlowBuilder6<>(null);
    }

    public static<T1, T2, T3, T4, T5, T6, T7> FlowBuilder7<Tuple7<T1, T2, T3, T4, T5, T6, T7>, T1, T2, T3, T4, T5, T6, T7> take(Type<T1> param1, Type<T2> param2, Type<T3> param3, Type<T4> param4, Type<T5> param5, Type<T6> param6, Type<T7> param7) {
        return new FlowBuilder7<>(null);
    }

    public static<T1, T2, T3, T4, T5, T6, T7, T8> FlowBuilder8<Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>, T1, T2, T3, T4, T5, T6, T7, T8> take(Type<T1> param1, Type<T2> param2, Type<T3> param3, Type<T4> param4, Type<T5> param5, Type<T6> param6, Type<T7> param7, Type<T8> param8) {
        return new FlowBuilder8<>(null);
    }

    public static<T1, T2, T3, T4, T5, T6, T7, T8, T9> FlowBuilder9<Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>, T1, T2, T3, T4, T5, T6, T7, T8, T9> take(Type<T1> param1, Type<T2> param2, Type<T3> param3, Type<T4> param4, Type<T5> param5, Type<T6> param6, Type<T7> param7, Type<T8> param8, Type<T9> param9) {
        return new FlowBuilder9<>(null);
    }
}
