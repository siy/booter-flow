package org.rxbooter.flow.flux;

import java.util.ArrayList;
import java.util.List;

import static org.rxbooter.flow.flux.FlowBuilders.*;
import static org.rxbooter.flow.flux.Tuples.*;

public class Flow<O extends Tuple, I extends Tuple> {
    private final List<Step<?, ?>> steps;

    public Flow(List<Step<?, ?>> steps) {
        this.steps = steps;
    }

    public static <O1 extends Tuple, I1 extends Tuple> Flow<O1, I1> of(FlowBuilder0<O1> builder) {
        List<Step<?, ?>>steps = new ArrayList<>();
        builder.apply(steps::add);

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

//    public static<T1, T2, T3, T4> FlowBuilder4<Tuple4<T1, T2, T3, T4>, T1, T2, T3, T4> take(Class<T1> param1, Class<T2> param2, Class<T3> param3, Class<T4> param4) {
//        return new FlowBuilder4<>(null);
//    }
//
//    public static<T1, T2, T3, T4, T5> FlowBuilder5<Tuple5<T1, T2, T3, T4, T5>, T1, T2, T3, T4, T5> take(Class<T1> param1, Class<T2> param2, Class<T3> param3, Class<T4> param4, Class<T5> param5) {
//        return new FlowBuilder5<>(null);
//    }
//
//    public static<T1, T2, T3, T4, T5, T6> FlowBuilder6<Tuple6<T1, T2, T3, T4, T5, T6>, T1, T2, T3, T4, T5, T6> take(Class<T1> param1, Class<T2> param2, Class<T3> param3, Class<T4> param4, Class<T5> param5, Class<T6> param6) {
//        return new FlowBuilder6<>(null);
//    }
//
//    public static<T1, T2, T3, T4, T5, T6, T7> FlowBuilder7<Tuple7<T1, T2, T3, T4, T5, T6, T7>, T1, T2, T3, T4, T5, T6, T7> take(Class<T1> param1, Class<T2> param2, Class<T3> param3, Class<T4> param4, Class<T5> param5, Class<T6> param6, Class<T7> param7) {
//        return new FlowBuilder7<>(null);
//    }
//
    //TODO: applyTo(I input).on(Reactor)
}
