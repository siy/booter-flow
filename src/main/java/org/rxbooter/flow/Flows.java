package org.rxbooter.flow;

import static org.rxbooter.flow.Functions.*;
import static org.rxbooter.flow.Tuples.*;

public final class Flows {
    private Flows() {}

    public static<T1> Flow1<Tuple1<T1>, T1> with(Class<T1> param1) {
        return new Flow1<>(null);
    }

    public static<T1, T2> Flow2<Tuple2<T1, T2>, T1, T2> with(Class<T1> param1, Class<T2> param2) {
        return new Flow2<>(null);
    }

    public static<T1, T2, T3> Flow3<Tuple3<T1, T2, T3>, T1, T2, T3> with(Class<T1> param1, Class<T2> param2, Class<T3> param3) {
        return new Flow3<>(null);
    }

    public static<T1, T2, T3, T4> Flow4<Tuple4<T1, T2, T3, T4>, T1, T2, T3, T4> with(Class<T1> param1, Class<T2> param2, Class<T3> param3, Class<T4> param4) {
        return new Flow4<>(null);
    }

    public static<T1, T2, T3, T4, T5> Flow5<Tuple5<T1, T2, T3, T4, T5>, T1, T2, T3, T4, T5> with(Class<T1> param1, Class<T2> param2, Class<T3> param3, Class<T4> param4, Class<T5> param5) {
        return new Flow5<>(null);
    }

    public static<T1, T2, T3, T4, T5, T6> Flow6<Tuple6<T1, T2, T3, T4, T5, T6>, T1, T2, T3, T4, T5, T6> with(Class<T1> param1, Class<T2> param2, Class<T3> param3, Class<T4> param4, Class<T5> param5, Class<T6> param6) {
        return new Flow6<>(null);
    }

    public static<T1, T2, T3, T4, T5, T6, T7> Flow7<Tuple7<T1, T2, T3, T4, T5, T6, T7>, T1, T2, T3, T4, T5, T6, T7> with(Class<T1> param1, Class<T2> param2, Class<T3> param3, Class<T4> param4, Class<T5> param5, Class<T6> param6, Class<T7> param7) {
        return new Flow7<>(null);
    }

    protected static class Flow<O1> {
        private final Flow<O1> prev;
        protected Step<?, ?> step;

        protected Flow(Flow<O1> prev) {
            this.prev = prev;
        }

        public <R1, T1> Step<R1, T1> step() {
            return (Step<R1, T1>) step;
        }

        public Flow<O1> prev() {
            return prev;
        }
    }

    public static class Flow1<O1, T1> extends Flow<O1> {
        public Flow1(Flow<O1> prev) {
            super(prev);
        }

        public ExecutableFlow<O1, Tuple1<T1>> build() {
            return new ExecutableFlow<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> then1(FN11<R1, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> async1(FN11<R1, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> await1(FN11<R1, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> then2(FN21<R1, R2, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> async2(FN21<R1, R2, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> await2(FN21<R1, R2, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> then3(FN31<R1, R2, R3, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> async3(FN31<R1, R2, R3, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> await3(FN31<R1, R2, R3, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> then4(FN41<R1, R2, R3, R4, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> async4(FN41<R1, R2, R3, R4, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> await4(FN41<R1, R2, R3, R4, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> then5(FN51<R1, R2, R3, R4, R5, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> async5(FN51<R1, R2, R3, R4, R5, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> await5(FN51<R1, R2, R3, R4, R5, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> then6(FN61<R1, R2, R3, R4, R5, R6, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> async6(FN61<R1, R2, R3, R4, R5, R6, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> await6(FN61<R1, R2, R3, R4, R5, R6, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> then7(FN71<R1, R2, R3, R4, R5, R6, R7, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> async7(FN71<R1, R2, R3, R4, R5, R6, R7, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> await7(FN71<R1, R2, R3, R4, R5, R6, R7, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow7<>(this);
        }
    }

    public static class Flow2<O1, T1, T2> extends Flow<O1> {
        public Flow2(Flow<O1> prev) {
            super(prev);
        }

        public ExecutableFlow<O1, Tuple2<T1, T2>> build() {
            return new ExecutableFlow<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> then1(FN11<R1, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> async1(FN11<R1, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> await1(FN11<R1, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> then1(FN12<R1, T1, T2> function) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> async1(FN12<R1, T1, T2> function) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> await1(FN12<R1, T1, T2> function) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> then2(FN21<R1, R2, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> async2(FN21<R1, R2, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> await2(FN21<R1, R2, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> then2(FN22<R1, R2, T1, T2> function) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> async2(FN22<R1, R2, T1, T2> function) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> await2(FN22<R1, R2, T1, T2> function) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> then3(FN31<R1, R2, R3, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> async3(FN31<R1, R2, R3, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> await3(FN31<R1, R2, R3, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> then3(FN32<R1, R2, R3, T1, T2> function) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> async3(FN32<R1, R2, R3, T1, T2> function) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> await3(FN32<R1, R2, R3, T1, T2> function) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> then4(FN41<R1, R2, R3, R4, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> async4(FN41<R1, R2, R3, R4, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> await4(FN41<R1, R2, R3, R4, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> then4(FN42<R1, R2, R3, R4, T1, T2> function) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> async4(FN42<R1, R2, R3, R4, T1, T2> function) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> await4(FN42<R1, R2, R3, R4, T1, T2> function) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> then5(FN51<R1, R2, R3, R4, R5, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> async5(FN51<R1, R2, R3, R4, R5, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> await5(FN51<R1, R2, R3, R4, R5, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> then5(FN52<R1, R2, R3, R4, R5, T1, T2> function) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> async5(FN52<R1, R2, R3, R4, R5, T1, T2> function) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> await5(FN52<R1, R2, R3, R4, R5, T1, T2> function) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> then6(FN61<R1, R2, R3, R4, R5, R6, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> async6(FN61<R1, R2, R3, R4, R5, R6, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> await6(FN61<R1, R2, R3, R4, R5, R6, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> then6(FN62<R1, R2, R3, R4, R5, R6, T1, T2> function) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> async6(FN62<R1, R2, R3, R4, R5, R6, T1, T2> function) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> await6(FN62<R1, R2, R3, R4, R5, R6, T1, T2> function) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> then7(FN71<R1, R2, R3, R4, R5, R6, R7, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> async7(FN71<R1, R2, R3, R4, R5, R6, R7, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> await7(FN71<R1, R2, R3, R4, R5, R6, R7, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> then7(FN72<R1, R2, R3, R4, R5, R6, R7, T1, T2> function) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> async7(FN72<R1, R2, R3, R4, R5, R6, R7, T1, T2> function) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> await7(FN72<R1, R2, R3, R4, R5, R6, R7, T1, T2> function) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow7<>(this);
        }
    }

    public static class Flow3<O1, T1, T2, T3> extends Flow<O1> {
        public Flow3(Flow<O1> prev) {
            super(prev);
        }

        public ExecutableFlow<O1, Tuple3<T1, T2, T3>> build() {
            return new ExecutableFlow<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> then1(FN11<R1, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> async1(FN11<R1, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> await1(FN11<R1, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> then1(FN12<R1, T1, T2> function) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> async1(FN12<R1, T1, T2> function) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> await1(FN12<R1, T1, T2> function) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> then1(FN13<R1, T1, T2, T3> function) {
            step = new Step<>(StepType.SYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> async1(FN13<R1, T1, T2, T3> function) {
            step = new Step<>(StepType.ASYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> await1(FN13<R1, T1, T2, T3> function) {
            step = new Step<>(StepType.AWAIT, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> then2(FN21<R1, R2, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> async2(FN21<R1, R2, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> await2(FN21<R1, R2, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> then2(FN22<R1, R2, T1, T2> function) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> async2(FN22<R1, R2, T1, T2> function) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> await2(FN22<R1, R2, T1, T2> function) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> then2(FN23<R1, R2, T1, T2, T3> function) {
            step = new Step<>(StepType.SYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> async2(FN23<R1, R2, T1, T2, T3> function) {
            step = new Step<>(StepType.ASYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> await2(FN23<R1, R2, T1, T2, T3> function) {
            step = new Step<>(StepType.AWAIT, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> then3(FN31<R1, R2, R3, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> async3(FN31<R1, R2, R3, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> await3(FN31<R1, R2, R3, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> then3(FN32<R1, R2, R3, T1, T2> function) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> async3(FN32<R1, R2, R3, T1, T2> function) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> await3(FN32<R1, R2, R3, T1, T2> function) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> then3(FN33<R1, R2, R3, T1, T2, T3> function) {
            step = new Step<>(StepType.SYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> async3(FN33<R1, R2, R3, T1, T2, T3> function) {
            step = new Step<>(StepType.ASYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> await3(FN33<R1, R2, R3, T1, T2, T3> function) {
            step = new Step<>(StepType.AWAIT, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> then4(FN41<R1, R2, R3, R4, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> async4(FN41<R1, R2, R3, R4, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> await4(FN41<R1, R2, R3, R4, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> then4(FN42<R1, R2, R3, R4, T1, T2> function) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> async4(FN42<R1, R2, R3, R4, T1, T2> function) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> await4(FN42<R1, R2, R3, R4, T1, T2> function) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> then4(FN43<R1, R2, R3, R4, T1, T2, T3> function) {
            step = new Step<>(StepType.SYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> async4(FN43<R1, R2, R3, R4, T1, T2, T3> function) {
            step = new Step<>(StepType.ASYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> await4(FN43<R1, R2, R3, R4, T1, T2, T3> function) {
            step = new Step<>(StepType.AWAIT, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> then5(FN51<R1, R2, R3, R4, R5, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> async5(FN51<R1, R2, R3, R4, R5, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> await5(FN51<R1, R2, R3, R4, R5, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> then5(FN52<R1, R2, R3, R4, R5, T1, T2> function) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> async5(FN52<R1, R2, R3, R4, R5, T1, T2> function) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> await5(FN52<R1, R2, R3, R4, R5, T1, T2> function) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> then5(FN53<R1, R2, R3, R4, R5, T1, T2, T3> function) {
            step = new Step<>(StepType.SYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> async5(FN53<R1, R2, R3, R4, R5, T1, T2, T3> function) {
            step = new Step<>(StepType.ASYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> await5(FN53<R1, R2, R3, R4, R5, T1, T2, T3> function) {
            step = new Step<>(StepType.AWAIT, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> then6(FN61<R1, R2, R3, R4, R5, R6, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> async6(FN61<R1, R2, R3, R4, R5, R6, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> await6(FN61<R1, R2, R3, R4, R5, R6, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> then6(FN62<R1, R2, R3, R4, R5, R6, T1, T2> function) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> async6(FN62<R1, R2, R3, R4, R5, R6, T1, T2> function) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> await6(FN62<R1, R2, R3, R4, R5, R6, T1, T2> function) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> then6(FN63<R1, R2, R3, R4, R5, R6, T1, T2, T3> function) {
            step = new Step<>(StepType.SYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> async6(FN63<R1, R2, R3, R4, R5, R6, T1, T2, T3> function) {
            step = new Step<>(StepType.ASYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> await6(FN63<R1, R2, R3, R4, R5, R6, T1, T2, T3> function) {
            step = new Step<>(StepType.AWAIT, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> then7(FN71<R1, R2, R3, R4, R5, R6, R7, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> async7(FN71<R1, R2, R3, R4, R5, R6, R7, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> await7(FN71<R1, R2, R3, R4, R5, R6, R7, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> then7(FN72<R1, R2, R3, R4, R5, R6, R7, T1, T2> function) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> async7(FN72<R1, R2, R3, R4, R5, R6, R7, T1, T2> function) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> await7(FN72<R1, R2, R3, R4, R5, R6, R7, T1, T2> function) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> then7(FN73<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3> function) {
            step = new Step<>(StepType.SYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> async7(FN73<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3> function) {
            step = new Step<>(StepType.ASYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> await7(FN73<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3> function) {
            step = new Step<>(StepType.AWAIT, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow7<>(this);
        }
    }

    public static class Flow4<O1, T1, T2, T3, T4> extends Flow<O1> {
        public Flow4(Flow<O1> prev) {
            super(prev);
        }

        public ExecutableFlow<O1, Tuple4<T1, T2, T3, T4>> build() {
            return new ExecutableFlow<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> then1(FN11<R1, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> async1(FN11<R1, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> await1(FN11<R1, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> then1(FN12<R1, T1, T2> function) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> async1(FN12<R1, T1, T2> function) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> await1(FN12<R1, T1, T2> function) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> then1(FN13<R1, T1, T2, T3> function) {
            step = new Step<>(StepType.SYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> async1(FN13<R1, T1, T2, T3> function) {
            step = new Step<>(StepType.ASYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> await1(FN13<R1, T1, T2, T3> function) {
            step = new Step<>(StepType.AWAIT, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> then1(FN14<R1, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.SYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> async1(FN14<R1, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.ASYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> await1(FN14<R1, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.AWAIT, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> then2(FN21<R1, R2, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> async2(FN21<R1, R2, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> await2(FN21<R1, R2, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> then2(FN22<R1, R2, T1, T2> function) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> async2(FN22<R1, R2, T1, T2> function) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> await2(FN22<R1, R2, T1, T2> function) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> then2(FN23<R1, R2, T1, T2, T3> function) {
            step = new Step<>(StepType.SYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> async2(FN23<R1, R2, T1, T2, T3> function) {
            step = new Step<>(StepType.ASYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> await2(FN23<R1, R2, T1, T2, T3> function) {
            step = new Step<>(StepType.AWAIT, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> then2(FN24<R1, R2, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.SYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> async2(FN24<R1, R2, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.ASYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> await2(FN24<R1, R2, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.AWAIT, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> then3(FN31<R1, R2, R3, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> async3(FN31<R1, R2, R3, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> await3(FN31<R1, R2, R3, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> then3(FN32<R1, R2, R3, T1, T2> function) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> async3(FN32<R1, R2, R3, T1, T2> function) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> await3(FN32<R1, R2, R3, T1, T2> function) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> then3(FN33<R1, R2, R3, T1, T2, T3> function) {
            step = new Step<>(StepType.SYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> async3(FN33<R1, R2, R3, T1, T2, T3> function) {
            step = new Step<>(StepType.ASYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> await3(FN33<R1, R2, R3, T1, T2, T3> function) {
            step = new Step<>(StepType.AWAIT, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> then3(FN34<R1, R2, R3, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.SYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> async3(FN34<R1, R2, R3, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.ASYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> await3(FN34<R1, R2, R3, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.AWAIT, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> then4(FN41<R1, R2, R3, R4, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> async4(FN41<R1, R2, R3, R4, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> await4(FN41<R1, R2, R3, R4, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> then4(FN42<R1, R2, R3, R4, T1, T2> function) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> async4(FN42<R1, R2, R3, R4, T1, T2> function) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> await4(FN42<R1, R2, R3, R4, T1, T2> function) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> then4(FN43<R1, R2, R3, R4, T1, T2, T3> function) {
            step = new Step<>(StepType.SYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> async4(FN43<R1, R2, R3, R4, T1, T2, T3> function) {
            step = new Step<>(StepType.ASYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> await4(FN43<R1, R2, R3, R4, T1, T2, T3> function) {
            step = new Step<>(StepType.AWAIT, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> then4(FN44<R1, R2, R3, R4, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.SYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> async4(FN44<R1, R2, R3, R4, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.ASYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> await4(FN44<R1, R2, R3, R4, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.AWAIT, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> then5(FN51<R1, R2, R3, R4, R5, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> async5(FN51<R1, R2, R3, R4, R5, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> await5(FN51<R1, R2, R3, R4, R5, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> then5(FN52<R1, R2, R3, R4, R5, T1, T2> function) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> async5(FN52<R1, R2, R3, R4, R5, T1, T2> function) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> await5(FN52<R1, R2, R3, R4, R5, T1, T2> function) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> then5(FN53<R1, R2, R3, R4, R5, T1, T2, T3> function) {
            step = new Step<>(StepType.SYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> async5(FN53<R1, R2, R3, R4, R5, T1, T2, T3> function) {
            step = new Step<>(StepType.ASYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> await5(FN53<R1, R2, R3, R4, R5, T1, T2, T3> function) {
            step = new Step<>(StepType.AWAIT, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> then5(FN54<R1, R2, R3, R4, R5, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.SYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> async5(FN54<R1, R2, R3, R4, R5, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.ASYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> await5(FN54<R1, R2, R3, R4, R5, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.AWAIT, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> then6(FN61<R1, R2, R3, R4, R5, R6, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> async6(FN61<R1, R2, R3, R4, R5, R6, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> await6(FN61<R1, R2, R3, R4, R5, R6, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> then6(FN62<R1, R2, R3, R4, R5, R6, T1, T2> function) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> async6(FN62<R1, R2, R3, R4, R5, R6, T1, T2> function) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> await6(FN62<R1, R2, R3, R4, R5, R6, T1, T2> function) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> then6(FN63<R1, R2, R3, R4, R5, R6, T1, T2, T3> function) {
            step = new Step<>(StepType.SYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> async6(FN63<R1, R2, R3, R4, R5, R6, T1, T2, T3> function) {
            step = new Step<>(StepType.ASYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> await6(FN63<R1, R2, R3, R4, R5, R6, T1, T2, T3> function) {
            step = new Step<>(StepType.AWAIT, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> then6(FN64<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.SYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> async6(FN64<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.ASYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> await6(FN64<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.AWAIT, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> then7(FN71<R1, R2, R3, R4, R5, R6, R7, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> async7(FN71<R1, R2, R3, R4, R5, R6, R7, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> await7(FN71<R1, R2, R3, R4, R5, R6, R7, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> then7(FN72<R1, R2, R3, R4, R5, R6, R7, T1, T2> function) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> async7(FN72<R1, R2, R3, R4, R5, R6, R7, T1, T2> function) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> await7(FN72<R1, R2, R3, R4, R5, R6, R7, T1, T2> function) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> then7(FN73<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3> function) {
            step = new Step<>(StepType.SYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> async7(FN73<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3> function) {
            step = new Step<>(StepType.ASYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> await7(FN73<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3> function) {
            step = new Step<>(StepType.AWAIT, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> then7(FN74<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.SYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> async7(FN74<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.ASYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> await7(FN74<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.AWAIT, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow7<>(this);
        }
    }

    public static class Flow5<O1, T1, T2, T3, T4, T5> extends Flow<O1> {
        public Flow5(Flow<O1> prev) {
            super(prev);
        }

        public ExecutableFlow<O1, Tuple5<T1, T2, T3, T4, T5>> build() {
            return new ExecutableFlow<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> then1(FN11<R1, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> async1(FN11<R1, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> await1(FN11<R1, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> then1(FN12<R1, T1, T2> function) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> async1(FN12<R1, T1, T2> function) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> await1(FN12<R1, T1, T2> function) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> then1(FN13<R1, T1, T2, T3> function) {
            step = new Step<>(StepType.SYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> async1(FN13<R1, T1, T2, T3> function) {
            step = new Step<>(StepType.ASYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> await1(FN13<R1, T1, T2, T3> function) {
            step = new Step<>(StepType.AWAIT, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> then1(FN14<R1, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.SYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> async1(FN14<R1, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.ASYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> await1(FN14<R1, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.AWAIT, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> then1(FN15<R1, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.SYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> async1(FN15<R1, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.ASYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> await1(FN15<R1, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.AWAIT, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> then2(FN21<R1, R2, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> async2(FN21<R1, R2, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> await2(FN21<R1, R2, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> then2(FN22<R1, R2, T1, T2> function) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> async2(FN22<R1, R2, T1, T2> function) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> await2(FN22<R1, R2, T1, T2> function) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> then2(FN23<R1, R2, T1, T2, T3> function) {
            step = new Step<>(StepType.SYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> async2(FN23<R1, R2, T1, T2, T3> function) {
            step = new Step<>(StepType.ASYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> await2(FN23<R1, R2, T1, T2, T3> function) {
            step = new Step<>(StepType.AWAIT, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> then2(FN24<R1, R2, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.SYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> async2(FN24<R1, R2, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.ASYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> await2(FN24<R1, R2, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.AWAIT, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> then2(FN25<R1, R2, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.SYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> async2(FN25<R1, R2, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.ASYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> await2(FN25<R1, R2, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.AWAIT, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> then3(FN31<R1, R2, R3, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> async3(FN31<R1, R2, R3, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> await3(FN31<R1, R2, R3, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> then3(FN32<R1, R2, R3, T1, T2> function) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> async3(FN32<R1, R2, R3, T1, T2> function) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> await3(FN32<R1, R2, R3, T1, T2> function) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> then3(FN33<R1, R2, R3, T1, T2, T3> function) {
            step = new Step<>(StepType.SYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> async3(FN33<R1, R2, R3, T1, T2, T3> function) {
            step = new Step<>(StepType.ASYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> await3(FN33<R1, R2, R3, T1, T2, T3> function) {
            step = new Step<>(StepType.AWAIT, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> then3(FN34<R1, R2, R3, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.SYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> async3(FN34<R1, R2, R3, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.ASYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> await3(FN34<R1, R2, R3, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.AWAIT, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> then3(FN35<R1, R2, R3, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.SYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> async3(FN35<R1, R2, R3, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.ASYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> await3(FN35<R1, R2, R3, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.AWAIT, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> then4(FN41<R1, R2, R3, R4, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> async4(FN41<R1, R2, R3, R4, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> await4(FN41<R1, R2, R3, R4, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> then4(FN42<R1, R2, R3, R4, T1, T2> function) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> async4(FN42<R1, R2, R3, R4, T1, T2> function) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> await4(FN42<R1, R2, R3, R4, T1, T2> function) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> then4(FN43<R1, R2, R3, R4, T1, T2, T3> function) {
            step = new Step<>(StepType.SYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> async4(FN43<R1, R2, R3, R4, T1, T2, T3> function) {
            step = new Step<>(StepType.ASYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> await4(FN43<R1, R2, R3, R4, T1, T2, T3> function) {
            step = new Step<>(StepType.AWAIT, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> then4(FN44<R1, R2, R3, R4, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.SYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> async4(FN44<R1, R2, R3, R4, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.ASYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> await4(FN44<R1, R2, R3, R4, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.AWAIT, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> then4(FN45<R1, R2, R3, R4, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.SYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> async4(FN45<R1, R2, R3, R4, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.ASYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> await4(FN45<R1, R2, R3, R4, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.AWAIT, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> then5(FN51<R1, R2, R3, R4, R5, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> async5(FN51<R1, R2, R3, R4, R5, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> await5(FN51<R1, R2, R3, R4, R5, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> then5(FN52<R1, R2, R3, R4, R5, T1, T2> function) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> async5(FN52<R1, R2, R3, R4, R5, T1, T2> function) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> await5(FN52<R1, R2, R3, R4, R5, T1, T2> function) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> then5(FN53<R1, R2, R3, R4, R5, T1, T2, T3> function) {
            step = new Step<>(StepType.SYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> async5(FN53<R1, R2, R3, R4, R5, T1, T2, T3> function) {
            step = new Step<>(StepType.ASYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> await5(FN53<R1, R2, R3, R4, R5, T1, T2, T3> function) {
            step = new Step<>(StepType.AWAIT, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> then5(FN54<R1, R2, R3, R4, R5, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.SYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> async5(FN54<R1, R2, R3, R4, R5, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.ASYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> await5(FN54<R1, R2, R3, R4, R5, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.AWAIT, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> then5(FN55<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.SYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> async5(FN55<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.ASYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> await5(FN55<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.AWAIT, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> then6(FN61<R1, R2, R3, R4, R5, R6, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> async6(FN61<R1, R2, R3, R4, R5, R6, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> await6(FN61<R1, R2, R3, R4, R5, R6, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> then6(FN62<R1, R2, R3, R4, R5, R6, T1, T2> function) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> async6(FN62<R1, R2, R3, R4, R5, R6, T1, T2> function) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> await6(FN62<R1, R2, R3, R4, R5, R6, T1, T2> function) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> then6(FN63<R1, R2, R3, R4, R5, R6, T1, T2, T3> function) {
            step = new Step<>(StepType.SYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> async6(FN63<R1, R2, R3, R4, R5, R6, T1, T2, T3> function) {
            step = new Step<>(StepType.ASYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> await6(FN63<R1, R2, R3, R4, R5, R6, T1, T2, T3> function) {
            step = new Step<>(StepType.AWAIT, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> then6(FN64<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.SYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> async6(FN64<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.ASYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> await6(FN64<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.AWAIT, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> then6(FN65<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.SYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> async6(FN65<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.ASYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> await6(FN65<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.AWAIT, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> then7(FN71<R1, R2, R3, R4, R5, R6, R7, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> async7(FN71<R1, R2, R3, R4, R5, R6, R7, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> await7(FN71<R1, R2, R3, R4, R5, R6, R7, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> then7(FN72<R1, R2, R3, R4, R5, R6, R7, T1, T2> function) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> async7(FN72<R1, R2, R3, R4, R5, R6, R7, T1, T2> function) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> await7(FN72<R1, R2, R3, R4, R5, R6, R7, T1, T2> function) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> then7(FN73<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3> function) {
            step = new Step<>(StepType.SYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> async7(FN73<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3> function) {
            step = new Step<>(StepType.ASYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> await7(FN73<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3> function) {
            step = new Step<>(StepType.AWAIT, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> then7(FN74<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.SYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> async7(FN74<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.ASYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> await7(FN74<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.AWAIT, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> then7(FN75<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.SYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> async7(FN75<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.ASYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> await7(FN75<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.AWAIT, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow7<>(this);
        }
    }

    public static class Flow6<O1, T1, T2, T3, T4, T5, T6> extends Flow<O1> {
        public Flow6(Flow<O1> prev) {
            super(prev);
        }

        public ExecutableFlow<O1, Tuple6<T1, T2, T3, T4, T5, T6>> build() {
            return new ExecutableFlow<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> then1(FN11<R1, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> async1(FN11<R1, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> await1(FN11<R1, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> then1(FN12<R1, T1, T2> function) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> async1(FN12<R1, T1, T2> function) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> await1(FN12<R1, T1, T2> function) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> then1(FN13<R1, T1, T2, T3> function) {
            step = new Step<>(StepType.SYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> async1(FN13<R1, T1, T2, T3> function) {
            step = new Step<>(StepType.ASYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> await1(FN13<R1, T1, T2, T3> function) {
            step = new Step<>(StepType.AWAIT, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> then1(FN14<R1, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.SYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> async1(FN14<R1, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.ASYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> await1(FN14<R1, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.AWAIT, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> then1(FN15<R1, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.SYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> async1(FN15<R1, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.ASYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> await1(FN15<R1, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.AWAIT, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> then1(FN16<R1, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.SYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> async1(FN16<R1, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.ASYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> await1(FN16<R1, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.AWAIT, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> then2(FN21<R1, R2, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> async2(FN21<R1, R2, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> await2(FN21<R1, R2, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> then2(FN22<R1, R2, T1, T2> function) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> async2(FN22<R1, R2, T1, T2> function) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> await2(FN22<R1, R2, T1, T2> function) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> then2(FN23<R1, R2, T1, T2, T3> function) {
            step = new Step<>(StepType.SYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> async2(FN23<R1, R2, T1, T2, T3> function) {
            step = new Step<>(StepType.ASYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> await2(FN23<R1, R2, T1, T2, T3> function) {
            step = new Step<>(StepType.AWAIT, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> then2(FN24<R1, R2, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.SYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> async2(FN24<R1, R2, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.ASYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> await2(FN24<R1, R2, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.AWAIT, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> then2(FN25<R1, R2, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.SYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> async2(FN25<R1, R2, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.ASYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> await2(FN25<R1, R2, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.AWAIT, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> then2(FN26<R1, R2, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.SYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> async2(FN26<R1, R2, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.ASYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> await2(FN26<R1, R2, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.AWAIT, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> then3(FN31<R1, R2, R3, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> async3(FN31<R1, R2, R3, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> await3(FN31<R1, R2, R3, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> then3(FN32<R1, R2, R3, T1, T2> function) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> async3(FN32<R1, R2, R3, T1, T2> function) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> await3(FN32<R1, R2, R3, T1, T2> function) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> then3(FN33<R1, R2, R3, T1, T2, T3> function) {
            step = new Step<>(StepType.SYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> async3(FN33<R1, R2, R3, T1, T2, T3> function) {
            step = new Step<>(StepType.ASYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> await3(FN33<R1, R2, R3, T1, T2, T3> function) {
            step = new Step<>(StepType.AWAIT, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> then3(FN34<R1, R2, R3, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.SYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> async3(FN34<R1, R2, R3, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.ASYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> await3(FN34<R1, R2, R3, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.AWAIT, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> then3(FN35<R1, R2, R3, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.SYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> async3(FN35<R1, R2, R3, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.ASYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> await3(FN35<R1, R2, R3, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.AWAIT, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> then3(FN36<R1, R2, R3, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.SYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> async3(FN36<R1, R2, R3, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.ASYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> await3(FN36<R1, R2, R3, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.AWAIT, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> then4(FN41<R1, R2, R3, R4, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> async4(FN41<R1, R2, R3, R4, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> await4(FN41<R1, R2, R3, R4, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> then4(FN42<R1, R2, R3, R4, T1, T2> function) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> async4(FN42<R1, R2, R3, R4, T1, T2> function) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> await4(FN42<R1, R2, R3, R4, T1, T2> function) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> then4(FN43<R1, R2, R3, R4, T1, T2, T3> function) {
            step = new Step<>(StepType.SYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> async4(FN43<R1, R2, R3, R4, T1, T2, T3> function) {
            step = new Step<>(StepType.ASYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> await4(FN43<R1, R2, R3, R4, T1, T2, T3> function) {
            step = new Step<>(StepType.AWAIT, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> then4(FN44<R1, R2, R3, R4, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.SYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> async4(FN44<R1, R2, R3, R4, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.ASYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> await4(FN44<R1, R2, R3, R4, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.AWAIT, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> then4(FN45<R1, R2, R3, R4, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.SYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> async4(FN45<R1, R2, R3, R4, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.ASYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> await4(FN45<R1, R2, R3, R4, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.AWAIT, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> then4(FN46<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.SYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> async4(FN46<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.ASYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> await4(FN46<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.AWAIT, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> then5(FN51<R1, R2, R3, R4, R5, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> async5(FN51<R1, R2, R3, R4, R5, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> await5(FN51<R1, R2, R3, R4, R5, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> then5(FN52<R1, R2, R3, R4, R5, T1, T2> function) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> async5(FN52<R1, R2, R3, R4, R5, T1, T2> function) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> await5(FN52<R1, R2, R3, R4, R5, T1, T2> function) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> then5(FN53<R1, R2, R3, R4, R5, T1, T2, T3> function) {
            step = new Step<>(StepType.SYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> async5(FN53<R1, R2, R3, R4, R5, T1, T2, T3> function) {
            step = new Step<>(StepType.ASYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> await5(FN53<R1, R2, R3, R4, R5, T1, T2, T3> function) {
            step = new Step<>(StepType.AWAIT, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> then5(FN54<R1, R2, R3, R4, R5, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.SYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> async5(FN54<R1, R2, R3, R4, R5, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.ASYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> await5(FN54<R1, R2, R3, R4, R5, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.AWAIT, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> then5(FN55<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.SYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> async5(FN55<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.ASYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> await5(FN55<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.AWAIT, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> then5(FN56<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.SYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> async5(FN56<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.ASYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> await5(FN56<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.AWAIT, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> then6(FN61<R1, R2, R3, R4, R5, R6, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> async6(FN61<R1, R2, R3, R4, R5, R6, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> await6(FN61<R1, R2, R3, R4, R5, R6, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> then6(FN62<R1, R2, R3, R4, R5, R6, T1, T2> function) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> async6(FN62<R1, R2, R3, R4, R5, R6, T1, T2> function) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> await6(FN62<R1, R2, R3, R4, R5, R6, T1, T2> function) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> then6(FN63<R1, R2, R3, R4, R5, R6, T1, T2, T3> function) {
            step = new Step<>(StepType.SYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> async6(FN63<R1, R2, R3, R4, R5, R6, T1, T2, T3> function) {
            step = new Step<>(StepType.ASYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> await6(FN63<R1, R2, R3, R4, R5, R6, T1, T2, T3> function) {
            step = new Step<>(StepType.AWAIT, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> then6(FN64<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.SYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> async6(FN64<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.ASYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> await6(FN64<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.AWAIT, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> then6(FN65<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.SYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> async6(FN65<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.ASYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> await6(FN65<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.AWAIT, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> then6(FN66<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.SYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> async6(FN66<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.ASYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> await6(FN66<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.AWAIT, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> then7(FN71<R1, R2, R3, R4, R5, R6, R7, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> async7(FN71<R1, R2, R3, R4, R5, R6, R7, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> await7(FN71<R1, R2, R3, R4, R5, R6, R7, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> then7(FN72<R1, R2, R3, R4, R5, R6, R7, T1, T2> function) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> async7(FN72<R1, R2, R3, R4, R5, R6, R7, T1, T2> function) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> await7(FN72<R1, R2, R3, R4, R5, R6, R7, T1, T2> function) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> then7(FN73<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3> function) {
            step = new Step<>(StepType.SYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> async7(FN73<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3> function) {
            step = new Step<>(StepType.ASYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> await7(FN73<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3> function) {
            step = new Step<>(StepType.AWAIT, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> then7(FN74<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.SYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> async7(FN74<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.ASYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> await7(FN74<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.AWAIT, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> then7(FN75<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.SYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> async7(FN75<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.ASYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> await7(FN75<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.AWAIT, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> then7(FN76<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.SYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> async7(FN76<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.ASYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> await7(FN76<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.AWAIT, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new Flow7<>(this);
        }
    }

    public static class Flow7<O1, T1, T2, T3, T4, T5, T6, T7> extends Flow<O1> {
        public Flow7(Flow<O1> prev) {
            super(prev);
        }

        public ExecutableFlow<O1, Tuple7<T1, T2, T3, T4, T5, T6, T7>> build() {
            return new ExecutableFlow<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> then1(FN11<R1, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> async1(FN11<R1, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> await1(FN11<R1, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> then1(FN12<R1, T1, T2> function) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> async1(FN12<R1, T1, T2> function) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> await1(FN12<R1, T1, T2> function) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> then1(FN13<R1, T1, T2, T3> function) {
            step = new Step<>(StepType.SYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> async1(FN13<R1, T1, T2, T3> function) {
            step = new Step<>(StepType.ASYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> await1(FN13<R1, T1, T2, T3> function) {
            step = new Step<>(StepType.AWAIT, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> then1(FN14<R1, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.SYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> async1(FN14<R1, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.ASYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> await1(FN14<R1, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.AWAIT, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> then1(FN15<R1, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.SYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> async1(FN15<R1, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.ASYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> await1(FN15<R1, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.AWAIT, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> then1(FN16<R1, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.SYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> async1(FN16<R1, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.ASYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> await1(FN16<R1, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.AWAIT, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> then1(FN17<R1, T1, T2, T3, T4, T5, T6, T7> function) {
            step = new Step<>(StepType.SYNC, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> async1(FN17<R1, T1, T2, T3, T4, T5, T6, T7> function) {
            step = new Step<>(StepType.ASYNC, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> Flow1<O1, R1> await1(FN17<R1, T1, T2, T3, T4, T5, T6, T7> function) {
            step = new Step<>(StepType.AWAIT, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)));
            return new Flow1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> then2(FN21<R1, R2, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> async2(FN21<R1, R2, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> await2(FN21<R1, R2, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> then2(FN22<R1, R2, T1, T2> function) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> async2(FN22<R1, R2, T1, T2> function) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> await2(FN22<R1, R2, T1, T2> function) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> then2(FN23<R1, R2, T1, T2, T3> function) {
            step = new Step<>(StepType.SYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> async2(FN23<R1, R2, T1, T2, T3> function) {
            step = new Step<>(StepType.ASYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> await2(FN23<R1, R2, T1, T2, T3> function) {
            step = new Step<>(StepType.AWAIT, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> then2(FN24<R1, R2, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.SYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> async2(FN24<R1, R2, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.ASYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> await2(FN24<R1, R2, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.AWAIT, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> then2(FN25<R1, R2, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.SYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> async2(FN25<R1, R2, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.ASYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> await2(FN25<R1, R2, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.AWAIT, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> then2(FN26<R1, R2, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.SYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> async2(FN26<R1, R2, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.ASYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> await2(FN26<R1, R2, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.AWAIT, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> then2(FN27<R1, R2, T1, T2, T3, T4, T5, T6, T7> function) {
            step = new Step<>(StepType.SYNC, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> async2(FN27<R1, R2, T1, T2, T3, T4, T5, T6, T7> function) {
            step = new Step<>(StepType.ASYNC, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> Flow2<O1, R1, R2> await2(FN27<R1, R2, T1, T2, T3, T4, T5, T6, T7> function) {
            step = new Step<>(StepType.AWAIT, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)));
            return new Flow2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> then3(FN31<R1, R2, R3, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> async3(FN31<R1, R2, R3, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> await3(FN31<R1, R2, R3, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> then3(FN32<R1, R2, R3, T1, T2> function) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> async3(FN32<R1, R2, R3, T1, T2> function) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> await3(FN32<R1, R2, R3, T1, T2> function) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> then3(FN33<R1, R2, R3, T1, T2, T3> function) {
            step = new Step<>(StepType.SYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> async3(FN33<R1, R2, R3, T1, T2, T3> function) {
            step = new Step<>(StepType.ASYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> await3(FN33<R1, R2, R3, T1, T2, T3> function) {
            step = new Step<>(StepType.AWAIT, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> then3(FN34<R1, R2, R3, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.SYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> async3(FN34<R1, R2, R3, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.ASYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> await3(FN34<R1, R2, R3, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.AWAIT, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> then3(FN35<R1, R2, R3, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.SYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> async3(FN35<R1, R2, R3, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.ASYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> await3(FN35<R1, R2, R3, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.AWAIT, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> then3(FN36<R1, R2, R3, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.SYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> async3(FN36<R1, R2, R3, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.ASYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> await3(FN36<R1, R2, R3, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.AWAIT, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> then3(FN37<R1, R2, R3, T1, T2, T3, T4, T5, T6, T7> function) {
            step = new Step<>(StepType.SYNC, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> async3(FN37<R1, R2, R3, T1, T2, T3, T4, T5, T6, T7> function) {
            step = new Step<>(StepType.ASYNC, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> Flow3<O1, R1, R2, R3> await3(FN37<R1, R2, R3, T1, T2, T3, T4, T5, T6, T7> function) {
            step = new Step<>(StepType.AWAIT, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)));
            return new Flow3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> then4(FN41<R1, R2, R3, R4, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> async4(FN41<R1, R2, R3, R4, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> await4(FN41<R1, R2, R3, R4, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> then4(FN42<R1, R2, R3, R4, T1, T2> function) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> async4(FN42<R1, R2, R3, R4, T1, T2> function) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> await4(FN42<R1, R2, R3, R4, T1, T2> function) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> then4(FN43<R1, R2, R3, R4, T1, T2, T3> function) {
            step = new Step<>(StepType.SYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> async4(FN43<R1, R2, R3, R4, T1, T2, T3> function) {
            step = new Step<>(StepType.ASYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> await4(FN43<R1, R2, R3, R4, T1, T2, T3> function) {
            step = new Step<>(StepType.AWAIT, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> then4(FN44<R1, R2, R3, R4, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.SYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> async4(FN44<R1, R2, R3, R4, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.ASYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> await4(FN44<R1, R2, R3, R4, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.AWAIT, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> then4(FN45<R1, R2, R3, R4, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.SYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> async4(FN45<R1, R2, R3, R4, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.ASYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> await4(FN45<R1, R2, R3, R4, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.AWAIT, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> then4(FN46<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.SYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> async4(FN46<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.ASYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> await4(FN46<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.AWAIT, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> then4(FN47<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6, T7> function) {
            step = new Step<>(StepType.SYNC, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> async4(FN47<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6, T7> function) {
            step = new Step<>(StepType.ASYNC, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> Flow4<O1, R1, R2, R3, R4> await4(FN47<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6, T7> function) {
            step = new Step<>(StepType.AWAIT, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)));
            return new Flow4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> then5(FN51<R1, R2, R3, R4, R5, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> async5(FN51<R1, R2, R3, R4, R5, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> await5(FN51<R1, R2, R3, R4, R5, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> then5(FN52<R1, R2, R3, R4, R5, T1, T2> function) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> async5(FN52<R1, R2, R3, R4, R5, T1, T2> function) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> await5(FN52<R1, R2, R3, R4, R5, T1, T2> function) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> then5(FN53<R1, R2, R3, R4, R5, T1, T2, T3> function) {
            step = new Step<>(StepType.SYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> async5(FN53<R1, R2, R3, R4, R5, T1, T2, T3> function) {
            step = new Step<>(StepType.ASYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> await5(FN53<R1, R2, R3, R4, R5, T1, T2, T3> function) {
            step = new Step<>(StepType.AWAIT, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> then5(FN54<R1, R2, R3, R4, R5, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.SYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> async5(FN54<R1, R2, R3, R4, R5, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.ASYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> await5(FN54<R1, R2, R3, R4, R5, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.AWAIT, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> then5(FN55<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.SYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> async5(FN55<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.ASYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> await5(FN55<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.AWAIT, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> then5(FN56<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.SYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> async5(FN56<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.ASYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> await5(FN56<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.AWAIT, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> then5(FN57<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6, T7> function) {
            step = new Step<>(StepType.SYNC, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> async5(FN57<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6, T7> function) {
            step = new Step<>(StepType.ASYNC, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> Flow5<O1, R1, R2, R3, R4, R5> await5(FN57<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6, T7> function) {
            step = new Step<>(StepType.AWAIT, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)));
            return new Flow5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> then6(FN61<R1, R2, R3, R4, R5, R6, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> async6(FN61<R1, R2, R3, R4, R5, R6, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> await6(FN61<R1, R2, R3, R4, R5, R6, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> then6(FN62<R1, R2, R3, R4, R5, R6, T1, T2> function) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> async6(FN62<R1, R2, R3, R4, R5, R6, T1, T2> function) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> await6(FN62<R1, R2, R3, R4, R5, R6, T1, T2> function) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> then6(FN63<R1, R2, R3, R4, R5, R6, T1, T2, T3> function) {
            step = new Step<>(StepType.SYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> async6(FN63<R1, R2, R3, R4, R5, R6, T1, T2, T3> function) {
            step = new Step<>(StepType.ASYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> await6(FN63<R1, R2, R3, R4, R5, R6, T1, T2, T3> function) {
            step = new Step<>(StepType.AWAIT, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> then6(FN64<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.SYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> async6(FN64<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.ASYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> await6(FN64<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.AWAIT, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> then6(FN65<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.SYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> async6(FN65<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.ASYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> await6(FN65<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.AWAIT, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> then6(FN66<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.SYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> async6(FN66<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.ASYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> await6(FN66<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.AWAIT, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> then6(FN67<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6, T7> function) {
            step = new Step<>(StepType.SYNC, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> async6(FN67<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6, T7> function) {
            step = new Step<>(StepType.ASYNC, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> Flow6<O1, R1, R2, R3, R4, R5, R6> await6(FN67<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6, T7> function) {
            step = new Step<>(StepType.AWAIT, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)));
            return new Flow6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> then7(FN71<R1, R2, R3, R4, R5, R6, R7, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> async7(FN71<R1, R2, R3, R4, R5, R6, R7, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> await7(FN71<R1, R2, R3, R4, R5, R6, R7, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> then7(FN72<R1, R2, R3, R4, R5, R6, R7, T1, T2> function) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> async7(FN72<R1, R2, R3, R4, R5, R6, R7, T1, T2> function) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> await7(FN72<R1, R2, R3, R4, R5, R6, R7, T1, T2> function) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> then7(FN73<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3> function) {
            step = new Step<>(StepType.SYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> async7(FN73<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3> function) {
            step = new Step<>(StepType.ASYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> await7(FN73<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3> function) {
            step = new Step<>(StepType.AWAIT, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> then7(FN74<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.SYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> async7(FN74<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.ASYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> await7(FN74<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.AWAIT, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> then7(FN75<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.SYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> async7(FN75<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.ASYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> await7(FN75<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.AWAIT, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> then7(FN76<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.SYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> async7(FN76<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.ASYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> await7(FN76<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.AWAIT, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> then7(FN77<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6, T7> function) {
            step = new Step<>(StepType.SYNC, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> async7(FN77<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6, T7> function) {
            step = new Step<>(StepType.ASYNC, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)));
            return new Flow7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> Flow7<O1, R1, R2, R3, R4, R5, R6, R7> await7(FN77<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6, T7> function) {
            step = new Step<>(StepType.AWAIT, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)));
            return new Flow7<>(this);
        }
    }
}
