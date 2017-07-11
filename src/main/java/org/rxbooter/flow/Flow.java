package org.rxbooter.flow;

import org.rxbooter.flow.Tuples.*;
import org.rxbooter.flow.impl.FlowBuilders.*;
import org.rxbooter.flow.impl.FlowExecutor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Flow<O extends Tuple, I extends Tuple> {
    private final List<Step<?, ?>> steps;

    private Flow(List<Step<?, ?>> steps) {
        this.steps = steps;
    }

    public FlowExecutor<O, I> applyTo(I input) {
        return new FlowExecutor<>(steps, input, Promise.empty());
    }

    public FlowExecutor<O, I> applyTo(I input, Promise<O> promise) {
        return new FlowExecutor<>(steps, input, promise);
    }

    public static <O1 extends Tuple, I1 extends Tuple> Flow<O1, I1> of(FlowBuilder0<I1> builder) {
        List<Step<?, ?>> steps = new ArrayList<>();
        builder.apply(steps::add);

        return new Flow<>(steps);
    }

    public static <O1 extends Tuple, I1 extends Tuple> Flow<O1, I1> of(Step<O1, I1> step) {
        return new Flow<>(Collections.singletonList(step));
    }

    public static <O extends Tuple, M extends Tuple, I extends Tuple> Flow<O, I> compose(Flow<M, I> flow1, Flow<O, M> flow2) {
        List<Step<?, ?>> steps = new ArrayList<>(flow1.steps);
        steps.addAll(flow2.steps);
        return new Flow<>(steps);
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
