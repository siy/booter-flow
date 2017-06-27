package org.rxbooter.flow.flux;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static org.rxbooter.flow.flux.Functions.*;
import static org.rxbooter.flow.flux.Tuples.*;

public final class FlowBuilders {
    private FlowBuilders() {}

    protected static class FlowBuilder0<O1 extends Tuple> {
        private final FlowBuilder0<O1> prev;
        protected Step<?, ?> step;

        protected FlowBuilder0(FlowBuilder0<O1> prev) {
            this.prev = prev;
        }

        @SuppressWarnings("unchecked")
        public <R1, T1> Step<R1, T1> step() {
            return (Step<R1, T1>) step;
        }

        public FlowBuilder<O1> prev() {
            return prev;
        }

        public void apply(Consumer<Step<?, ?>> consumer) {
            if (prev != null) {
                prev.apply(consumer);
            }

            if (step != null) {
                consumer.accept(step);
            }
        }
    }

    public static class FlowBuilder1<O1 extends Tuple, T1> extends FlowBuilder0<O1> {
        public FlowBuilder1(FlowBuilder0<O1> prev) {
            super(prev);
        }

        @SuppressWarnings("unchecked")
        public Flow<O1, Tuple1<T1>> build() {
            return Flow.of(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<O1, R1> apply1(FN11<R1, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new FlowBuilder1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<O1, R1> apply1(FN11<R1, T1> function, FN11<R1, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)), handler::apply);
            return new FlowBuilder1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<O1, R1> asyncApply1(FN11<R1, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new FlowBuilder1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<O1, R1> asyncApply1(FN11<R1, T1> function, FN11<R1, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)), handler::apply);
            return new FlowBuilder1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<O1, R1> awaitApply1(FN11<R1, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new FlowBuilder1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<O1, R1> awaitApply1(FN11<R1, T1> function, FN11<R1, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)), handler::apply);
            return new FlowBuilder1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<O1, R1, R2> apply2(FN21<R1, R2, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new FlowBuilder2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<O1, R1, R2> apply2(FN21<R1, R2, T1> function, FN21<R1, R2, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)), handler::apply);
            return new FlowBuilder2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<O1, R1, R2> asyncApply2(FN21<R1, R2, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new FlowBuilder2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<O1, R1, R2> asyncApply2(FN21<R1, R2, T1> function, FN21<R1, R2, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)), handler::apply);
            return new FlowBuilder2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<O1, R1, R2> awaitApply2(FN21<R1, R2, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new FlowBuilder2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<O1, R1, R2> awaitApply2(FN21<R1, R2, T1> function, FN21<R1, R2, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)), handler::apply);
            return new FlowBuilder2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<O1, R1, R2, R3> apply3(FN31<R1, R2, R3, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new FlowBuilder3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<O1, R1, R2, R3> apply3(FN31<R1, R2, R3, T1> function, FN31<R1, R2, R3, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)), handler::apply);
            return new FlowBuilder3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<O1, R1, R2, R3> asyncApply3(FN31<R1, R2, R3, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new FlowBuilder3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<O1, R1, R2, R3> asyncApply3(FN31<R1, R2, R3, T1> function, FN31<R1, R2, R3, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)), handler::apply);
            return new FlowBuilder3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<O1, R1, R2, R3> awaitApply3(FN31<R1, R2, R3, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new FlowBuilder3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<O1, R1, R2, R3> awaitApply3(FN31<R1, R2, R3, T1> function, FN31<R1, R2, R3, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)), handler::apply);
            return new FlowBuilder3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<O1, R1, R2, R3, R4> apply4(FN41<R1, R2, R3, R4, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new FlowBuilder4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<O1, R1, R2, R3, R4> apply4(FN41<R1, R2, R3, R4, T1> function, FN41<R1, R2, R3, R4, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)), handler::apply);
            return new FlowBuilder4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<O1, R1, R2, R3, R4> asyncApply4(FN41<R1, R2, R3, R4, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new FlowBuilder4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<O1, R1, R2, R3, R4> asyncApply4(FN41<R1, R2, R3, R4, T1> function, FN41<R1, R2, R3, R4, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)), handler::apply);
            return new FlowBuilder4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<O1, R1, R2, R3, R4> awaitApply4(FN41<R1, R2, R3, R4, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new FlowBuilder4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<O1, R1, R2, R3, R4> awaitApply4(FN41<R1, R2, R3, R4, T1> function, FN41<R1, R2, R3, R4, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)), handler::apply);
            return new FlowBuilder4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<O1, R1, R2, R3, R4, R5> apply5(FN51<R1, R2, R3, R4, R5, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new FlowBuilder5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<O1, R1, R2, R3, R4, R5> apply5(FN51<R1, R2, R3, R4, R5, T1> function, FN51<R1, R2, R3, R4, R5, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)), handler::apply);
            return new FlowBuilder5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<O1, R1, R2, R3, R4, R5> asyncApply5(FN51<R1, R2, R3, R4, R5, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new FlowBuilder5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<O1, R1, R2, R3, R4, R5> asyncApply5(FN51<R1, R2, R3, R4, R5, T1> function, FN51<R1, R2, R3, R4, R5, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)), handler::apply);
            return new FlowBuilder5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<O1, R1, R2, R3, R4, R5> awaitApply5(FN51<R1, R2, R3, R4, R5, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new FlowBuilder5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<O1, R1, R2, R3, R4, R5> awaitApply5(FN51<R1, R2, R3, R4, R5, T1> function, FN51<R1, R2, R3, R4, R5, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)), handler::apply);
            return new FlowBuilder5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<O1, R1, R2, R3, R4, R5, R6> apply6(FN61<R1, R2, R3, R4, R5, R6, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new FlowBuilder6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<O1, R1, R2, R3, R4, R5, R6> apply6(FN61<R1, R2, R3, R4, R5, R6, T1> function, FN61<R1, R2, R3, R4, R5, R6, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)), handler::apply);
            return new FlowBuilder6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<O1, R1, R2, R3, R4, R5, R6> asyncApply6(FN61<R1, R2, R3, R4, R5, R6, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new FlowBuilder6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<O1, R1, R2, R3, R4, R5, R6> asyncApply6(FN61<R1, R2, R3, R4, R5, R6, T1> function, FN61<R1, R2, R3, R4, R5, R6, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)), handler::apply);
            return new FlowBuilder6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<O1, R1, R2, R3, R4, R5, R6> awaitApply6(FN61<R1, R2, R3, R4, R5, R6, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new FlowBuilder6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<O1, R1, R2, R3, R4, R5, R6> awaitApply6(FN61<R1, R2, R3, R4, R5, R6, T1> function, FN61<R1, R2, R3, R4, R5, R6, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)), handler::apply);
            return new FlowBuilder6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<O1, R1, R2, R3, R4, R5, R6, R7> apply7(FN71<R1, R2, R3, R4, R5, R6, R7, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new FlowBuilder7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<O1, R1, R2, R3, R4, R5, R6, R7> apply7(FN71<R1, R2, R3, R4, R5, R6, R7, T1> function, FN71<R1, R2, R3, R4, R5, R6, R7, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)), handler::apply);
            return new FlowBuilder7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<O1, R1, R2, R3, R4, R5, R6, R7> asyncApply7(FN71<R1, R2, R3, R4, R5, R6, R7, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new FlowBuilder7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<O1, R1, R2, R3, R4, R5, R6, R7> asyncApply7(FN71<R1, R2, R3, R4, R5, R6, R7, T1> function, FN71<R1, R2, R3, R4, R5, R6, R7, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)), handler::apply);
            return new FlowBuilder7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<O1, R1, R2, R3, R4, R5, R6, R7> awaitApply7(FN71<R1, R2, R3, R4, R5, R6, R7, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new FlowBuilder7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<O1, R1, R2, R3, R4, R5, R6, R7> awaitApply7(FN71<R1, R2, R3, R4, R5, R6, R7, T1> function, FN71<R1, R2, R3, R4, R5, R6, R7, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)), handler::apply);
            return new FlowBuilder7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<O1, R1, R2, R3, R4, R5, R6, R7, R8> apply8(FN81<R1, R2, R3, R4, R5, R6, R7, R8, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new FlowBuilder8<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<O1, R1, R2, R3, R4, R5, R6, R7, R8> apply8(FN81<R1, R2, R3, R4, R5, R6, R7, R8, T1> function, FN81<R1, R2, R3, R4, R5, R6, R7, R8, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)), handler::apply);
            return new FlowBuilder8<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<O1, R1, R2, R3, R4, R5, R6, R7, R8> asyncApply8(FN81<R1, R2, R3, R4, R5, R6, R7, R8, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new FlowBuilder8<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<O1, R1, R2, R3, R4, R5, R6, R7, R8> asyncApply8(FN81<R1, R2, R3, R4, R5, R6, R7, R8, T1> function, FN81<R1, R2, R3, R4, R5, R6, R7, R8, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)), handler::apply);
            return new FlowBuilder8<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<O1, R1, R2, R3, R4, R5, R6, R7, R8> awaitApply8(FN81<R1, R2, R3, R4, R5, R6, R7, R8, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new FlowBuilder8<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<O1, R1, R2, R3, R4, R5, R6, R7, R8> awaitApply8(FN81<R1, R2, R3, R4, R5, R6, R7, R8, T1> function, FN81<R1, R2, R3, R4, R5, R6, R7, R8, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)), handler::apply);
            return new FlowBuilder8<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<O1, R1, R2, R3, R4, R5, R6, R7, R8, R9> apply9(FN91<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1> function) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new FlowBuilder9<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<O1, R1, R2, R3, R4, R5, R6, R7, R8, R9> apply9(FN91<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1> function, FN91<R1, R2, R3, R4, R5, R6, R7, R8, R9, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)), handler::apply);
            return new FlowBuilder9<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<O1, R1, R2, R3, R4, R5, R6, R7, R8, R9> asyncApply9(FN91<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1> function) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new FlowBuilder9<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<O1, R1, R2, R3, R4, R5, R6, R7, R8, R9> asyncApply9(FN91<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1> function, FN91<R1, R2, R3, R4, R5, R6, R7, R8, R9, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple1<T1> param) -> function.apply((T1) param.get(0)), handler::apply);
            return new FlowBuilder9<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<O1, R1, R2, R3, R4, R5, R6, R7, R8, R9> awaitApply9(FN91<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1> function) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)));
            return new FlowBuilder9<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<O1, R1, R2, R3, R4, R5, R6, R7, R8, R9> awaitApply9(FN91<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1> function, FN91<R1, R2, R3, R4, R5, R6, R7, R8, R9, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple1<T1> param) -> function.apply((T1) param.get(0)), handler::apply);
            return new FlowBuilder9<>(this);
        }
    }

    public static class FlowBuilder2<O1 extends Tuple, T1, T2> extends FlowBuilder1<O1, T1> {
        public FlowBuilder2(FlowBuilder0<O1> prev) {
            super(prev);
        }

        @SuppressWarnings("unchecked")
        public Flow<O1, Tuple2<T1, T2>> build() {
            return Flow.of(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<O1, R1> apply1(FN12<R1, T1, T2> function) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new FlowBuilder1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<O1, R1> apply1(FN12<R1, T1, T2> function, FN11<R1, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)), handler::apply);
            return new FlowBuilder1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<O1, R1> asyncApply1(FN12<R1, T1, T2> function) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new FlowBuilder1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<O1, R1> asyncApply1(FN12<R1, T1, T2> function, FN11<R1, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)), handler::apply);
            return new FlowBuilder1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<O1, R1> awaitApply1(FN12<R1, T1, T2> function) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new FlowBuilder1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<O1, R1> awaitApply1(FN12<R1, T1, T2> function, FN11<R1, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)), handler::apply);
            return new FlowBuilder1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<O1, R1, R2> apply2(FN22<R1, R2, T1, T2> function) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new FlowBuilder2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<O1, R1, R2> apply2(FN22<R1, R2, T1, T2> function, FN21<R1, R2, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)), handler::apply);
            return new FlowBuilder2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<O1, R1, R2> asyncApply2(FN22<R1, R2, T1, T2> function) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new FlowBuilder2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<O1, R1, R2> asyncApply2(FN22<R1, R2, T1, T2> function, FN21<R1, R2, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)), handler::apply);
            return new FlowBuilder2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<O1, R1, R2> awaitApply2(FN22<R1, R2, T1, T2> function) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new FlowBuilder2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<O1, R1, R2> awaitApply2(FN22<R1, R2, T1, T2> function, FN21<R1, R2, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)), handler::apply);
            return new FlowBuilder2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<O1, R1, R2, R3> apply3(FN32<R1, R2, R3, T1, T2> function) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new FlowBuilder3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<O1, R1, R2, R3> apply3(FN32<R1, R2, R3, T1, T2> function, FN31<R1, R2, R3, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)), handler::apply);
            return new FlowBuilder3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<O1, R1, R2, R3> asyncApply3(FN32<R1, R2, R3, T1, T2> function) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new FlowBuilder3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<O1, R1, R2, R3> asyncApply3(FN32<R1, R2, R3, T1, T2> function, FN31<R1, R2, R3, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)), handler::apply);
            return new FlowBuilder3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<O1, R1, R2, R3> awaitApply3(FN32<R1, R2, R3, T1, T2> function) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new FlowBuilder3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<O1, R1, R2, R3> awaitApply3(FN32<R1, R2, R3, T1, T2> function, FN31<R1, R2, R3, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)), handler::apply);
            return new FlowBuilder3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<O1, R1, R2, R3, R4> apply4(FN42<R1, R2, R3, R4, T1, T2> function) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new FlowBuilder4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<O1, R1, R2, R3, R4> apply4(FN42<R1, R2, R3, R4, T1, T2> function, FN41<R1, R2, R3, R4, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)), handler::apply);
            return new FlowBuilder4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<O1, R1, R2, R3, R4> asyncApply4(FN42<R1, R2, R3, R4, T1, T2> function) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new FlowBuilder4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<O1, R1, R2, R3, R4> asyncApply4(FN42<R1, R2, R3, R4, T1, T2> function, FN41<R1, R2, R3, R4, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)), handler::apply);
            return new FlowBuilder4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<O1, R1, R2, R3, R4> awaitApply4(FN42<R1, R2, R3, R4, T1, T2> function) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new FlowBuilder4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<O1, R1, R2, R3, R4> awaitApply4(FN42<R1, R2, R3, R4, T1, T2> function, FN41<R1, R2, R3, R4, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)), handler::apply);
            return new FlowBuilder4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<O1, R1, R2, R3, R4, R5> apply5(FN52<R1, R2, R3, R4, R5, T1, T2> function) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new FlowBuilder5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<O1, R1, R2, R3, R4, R5> apply5(FN52<R1, R2, R3, R4, R5, T1, T2> function, FN51<R1, R2, R3, R4, R5, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)), handler::apply);
            return new FlowBuilder5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<O1, R1, R2, R3, R4, R5> asyncApply5(FN52<R1, R2, R3, R4, R5, T1, T2> function) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new FlowBuilder5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<O1, R1, R2, R3, R4, R5> asyncApply5(FN52<R1, R2, R3, R4, R5, T1, T2> function, FN51<R1, R2, R3, R4, R5, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)), handler::apply);
            return new FlowBuilder5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<O1, R1, R2, R3, R4, R5> awaitApply5(FN52<R1, R2, R3, R4, R5, T1, T2> function) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new FlowBuilder5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<O1, R1, R2, R3, R4, R5> awaitApply5(FN52<R1, R2, R3, R4, R5, T1, T2> function, FN51<R1, R2, R3, R4, R5, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)), handler::apply);
            return new FlowBuilder5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<O1, R1, R2, R3, R4, R5, R6> apply6(FN62<R1, R2, R3, R4, R5, R6, T1, T2> function) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new FlowBuilder6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<O1, R1, R2, R3, R4, R5, R6> apply6(FN62<R1, R2, R3, R4, R5, R6, T1, T2> function, FN61<R1, R2, R3, R4, R5, R6, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)), handler::apply);
            return new FlowBuilder6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<O1, R1, R2, R3, R4, R5, R6> asyncApply6(FN62<R1, R2, R3, R4, R5, R6, T1, T2> function) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new FlowBuilder6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<O1, R1, R2, R3, R4, R5, R6> asyncApply6(FN62<R1, R2, R3, R4, R5, R6, T1, T2> function, FN61<R1, R2, R3, R4, R5, R6, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)), handler::apply);
            return new FlowBuilder6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<O1, R1, R2, R3, R4, R5, R6> awaitApply6(FN62<R1, R2, R3, R4, R5, R6, T1, T2> function) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new FlowBuilder6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<O1, R1, R2, R3, R4, R5, R6> awaitApply6(FN62<R1, R2, R3, R4, R5, R6, T1, T2> function, FN61<R1, R2, R3, R4, R5, R6, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)), handler::apply);
            return new FlowBuilder6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<O1, R1, R2, R3, R4, R5, R6, R7> apply7(FN72<R1, R2, R3, R4, R5, R6, R7, T1, T2> function) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new FlowBuilder7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<O1, R1, R2, R3, R4, R5, R6, R7> apply7(FN72<R1, R2, R3, R4, R5, R6, R7, T1, T2> function, FN71<R1, R2, R3, R4, R5, R6, R7, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)), handler::apply);
            return new FlowBuilder7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<O1, R1, R2, R3, R4, R5, R6, R7> asyncApply7(FN72<R1, R2, R3, R4, R5, R6, R7, T1, T2> function) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new FlowBuilder7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<O1, R1, R2, R3, R4, R5, R6, R7> asyncApply7(FN72<R1, R2, R3, R4, R5, R6, R7, T1, T2> function, FN71<R1, R2, R3, R4, R5, R6, R7, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)), handler::apply);
            return new FlowBuilder7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<O1, R1, R2, R3, R4, R5, R6, R7> awaitApply7(FN72<R1, R2, R3, R4, R5, R6, R7, T1, T2> function) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new FlowBuilder7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<O1, R1, R2, R3, R4, R5, R6, R7> awaitApply7(FN72<R1, R2, R3, R4, R5, R6, R7, T1, T2> function, FN71<R1, R2, R3, R4, R5, R6, R7, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)), handler::apply);
            return new FlowBuilder7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<O1, R1, R2, R3, R4, R5, R6, R7, R8> apply8(FN82<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2> function) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new FlowBuilder8<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<O1, R1, R2, R3, R4, R5, R6, R7, R8> apply8(FN82<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2> function, FN81<R1, R2, R3, R4, R5, R6, R7, R8, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)), handler::apply);
            return new FlowBuilder8<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<O1, R1, R2, R3, R4, R5, R6, R7, R8> asyncApply8(FN82<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2> function) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new FlowBuilder8<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<O1, R1, R2, R3, R4, R5, R6, R7, R8> asyncApply8(FN82<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2> function, FN81<R1, R2, R3, R4, R5, R6, R7, R8, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)), handler::apply);
            return new FlowBuilder8<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<O1, R1, R2, R3, R4, R5, R6, R7, R8> awaitApply8(FN82<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2> function) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new FlowBuilder8<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<O1, R1, R2, R3, R4, R5, R6, R7, R8> awaitApply8(FN82<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2> function, FN81<R1, R2, R3, R4, R5, R6, R7, R8, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)), handler::apply);
            return new FlowBuilder8<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<O1, R1, R2, R3, R4, R5, R6, R7, R8, R9> apply9(FN92<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2> function) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new FlowBuilder9<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<O1, R1, R2, R3, R4, R5, R6, R7, R8, R9> apply9(FN92<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2> function, FN91<R1, R2, R3, R4, R5, R6, R7, R8, R9, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)), handler::apply);
            return new FlowBuilder9<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<O1, R1, R2, R3, R4, R5, R6, R7, R8, R9> asyncApply9(FN92<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2> function) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new FlowBuilder9<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<O1, R1, R2, R3, R4, R5, R6, R7, R8, R9> asyncApply9(FN92<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2> function, FN91<R1, R2, R3, R4, R5, R6, R7, R8, R9, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)), handler::apply);
            return new FlowBuilder9<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<O1, R1, R2, R3, R4, R5, R6, R7, R8, R9> awaitApply9(FN92<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2> function) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)));
            return new FlowBuilder9<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<O1, R1, R2, R3, R4, R5, R6, R7, R8, R9> awaitApply9(FN92<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2> function, FN91<R1, R2, R3, R4, R5, R6, R7, R8, R9, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple2<T1, T2> param) -> function.apply((T1) param.get(0), (T2) param.get(1)), handler::apply);
            return new FlowBuilder9<>(this);
        }
    }

    public static class FlowBuilder3<O1 extends Tuple, T1, T2, T3> extends FlowBuilder2<O1, T1, T2> {
        public FlowBuilder3(FlowBuilder0<O1> prev) {
            super(prev);
        }

        @SuppressWarnings("unchecked")
        public Flow<O1, Tuple3<T1, T2, T3>> build() {
            return Flow.of(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<O1, R1> apply1(FN13<R1, T1, T2, T3> function) {
            step = new Step<>(StepType.SYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new FlowBuilder1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<O1, R1> apply1(FN13<R1, T1, T2, T3> function, FN11<R1, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)), handler::apply);
            return new FlowBuilder1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<O1, R1> asyncApply1(FN13<R1, T1, T2, T3> function) {
            step = new Step<>(StepType.ASYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new FlowBuilder1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<O1, R1> asyncApply1(FN13<R1, T1, T2, T3> function, FN11<R1, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)), handler::apply);
            return new FlowBuilder1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<O1, R1> awaitApply1(FN13<R1, T1, T2, T3> function) {
            step = new Step<>(StepType.AWAIT, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new FlowBuilder1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<O1, R1> awaitApply1(FN13<R1, T1, T2, T3> function, FN11<R1, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)), handler::apply);
            return new FlowBuilder1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<O1, R1, R2> apply2(FN23<R1, R2, T1, T2, T3> function) {
            step = new Step<>(StepType.SYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new FlowBuilder2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<O1, R1, R2> apply2(FN23<R1, R2, T1, T2, T3> function, FN21<R1, R2, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)), handler::apply);
            return new FlowBuilder2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<O1, R1, R2> asyncApply2(FN23<R1, R2, T1, T2, T3> function) {
            step = new Step<>(StepType.ASYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new FlowBuilder2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<O1, R1, R2> asyncApply2(FN23<R1, R2, T1, T2, T3> function, FN21<R1, R2, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)), handler::apply);
            return new FlowBuilder2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<O1, R1, R2> awaitApply2(FN23<R1, R2, T1, T2, T3> function) {
            step = new Step<>(StepType.AWAIT, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new FlowBuilder2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<O1, R1, R2> awaitApply2(FN23<R1, R2, T1, T2, T3> function, FN21<R1, R2, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)), handler::apply);
            return new FlowBuilder2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<O1, R1, R2, R3> apply3(FN33<R1, R2, R3, T1, T2, T3> function) {
            step = new Step<>(StepType.SYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new FlowBuilder3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<O1, R1, R2, R3> apply3(FN33<R1, R2, R3, T1, T2, T3> function, FN31<R1, R2, R3, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)), handler::apply);
            return new FlowBuilder3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<O1, R1, R2, R3> asyncApply3(FN33<R1, R2, R3, T1, T2, T3> function) {
            step = new Step<>(StepType.ASYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new FlowBuilder3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<O1, R1, R2, R3> asyncApply3(FN33<R1, R2, R3, T1, T2, T3> function, FN31<R1, R2, R3, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)), handler::apply);
            return new FlowBuilder3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<O1, R1, R2, R3> awaitApply3(FN33<R1, R2, R3, T1, T2, T3> function) {
            step = new Step<>(StepType.AWAIT, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new FlowBuilder3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<O1, R1, R2, R3> awaitApply3(FN33<R1, R2, R3, T1, T2, T3> function, FN31<R1, R2, R3, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)), handler::apply);
            return new FlowBuilder3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<O1, R1, R2, R3, R4> apply4(FN43<R1, R2, R3, R4, T1, T2, T3> function) {
            step = new Step<>(StepType.SYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new FlowBuilder4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<O1, R1, R2, R3, R4> apply4(FN43<R1, R2, R3, R4, T1, T2, T3> function, FN41<R1, R2, R3, R4, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)), handler::apply);
            return new FlowBuilder4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<O1, R1, R2, R3, R4> asyncApply4(FN43<R1, R2, R3, R4, T1, T2, T3> function) {
            step = new Step<>(StepType.ASYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new FlowBuilder4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<O1, R1, R2, R3, R4> asyncApply4(FN43<R1, R2, R3, R4, T1, T2, T3> function, FN41<R1, R2, R3, R4, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)), handler::apply);
            return new FlowBuilder4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<O1, R1, R2, R3, R4> awaitApply4(FN43<R1, R2, R3, R4, T1, T2, T3> function) {
            step = new Step<>(StepType.AWAIT, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new FlowBuilder4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<O1, R1, R2, R3, R4> awaitApply4(FN43<R1, R2, R3, R4, T1, T2, T3> function, FN41<R1, R2, R3, R4, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)), handler::apply);
            return new FlowBuilder4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<O1, R1, R2, R3, R4, R5> apply5(FN53<R1, R2, R3, R4, R5, T1, T2, T3> function) {
            step = new Step<>(StepType.SYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new FlowBuilder5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<O1, R1, R2, R3, R4, R5> apply5(FN53<R1, R2, R3, R4, R5, T1, T2, T3> function, FN51<R1, R2, R3, R4, R5, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)), handler::apply);
            return new FlowBuilder5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<O1, R1, R2, R3, R4, R5> asyncApply5(FN53<R1, R2, R3, R4, R5, T1, T2, T3> function) {
            step = new Step<>(StepType.ASYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new FlowBuilder5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<O1, R1, R2, R3, R4, R5> asyncApply5(FN53<R1, R2, R3, R4, R5, T1, T2, T3> function, FN51<R1, R2, R3, R4, R5, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)), handler::apply);
            return new FlowBuilder5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<O1, R1, R2, R3, R4, R5> awaitApply5(FN53<R1, R2, R3, R4, R5, T1, T2, T3> function) {
            step = new Step<>(StepType.AWAIT, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new FlowBuilder5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<O1, R1, R2, R3, R4, R5> awaitApply5(FN53<R1, R2, R3, R4, R5, T1, T2, T3> function, FN51<R1, R2, R3, R4, R5, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)), handler::apply);
            return new FlowBuilder5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<O1, R1, R2, R3, R4, R5, R6> apply6(FN63<R1, R2, R3, R4, R5, R6, T1, T2, T3> function) {
            step = new Step<>(StepType.SYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new FlowBuilder6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<O1, R1, R2, R3, R4, R5, R6> apply6(FN63<R1, R2, R3, R4, R5, R6, T1, T2, T3> function, FN61<R1, R2, R3, R4, R5, R6, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)), handler::apply);
            return new FlowBuilder6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<O1, R1, R2, R3, R4, R5, R6> asyncApply6(FN63<R1, R2, R3, R4, R5, R6, T1, T2, T3> function) {
            step = new Step<>(StepType.ASYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new FlowBuilder6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<O1, R1, R2, R3, R4, R5, R6> asyncApply6(FN63<R1, R2, R3, R4, R5, R6, T1, T2, T3> function, FN61<R1, R2, R3, R4, R5, R6, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)), handler::apply);
            return new FlowBuilder6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<O1, R1, R2, R3, R4, R5, R6> awaitApply6(FN63<R1, R2, R3, R4, R5, R6, T1, T2, T3> function) {
            step = new Step<>(StepType.AWAIT, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new FlowBuilder6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<O1, R1, R2, R3, R4, R5, R6> awaitApply6(FN63<R1, R2, R3, R4, R5, R6, T1, T2, T3> function, FN61<R1, R2, R3, R4, R5, R6, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)), handler::apply);
            return new FlowBuilder6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<O1, R1, R2, R3, R4, R5, R6, R7> apply7(FN73<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3> function) {
            step = new Step<>(StepType.SYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new FlowBuilder7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<O1, R1, R2, R3, R4, R5, R6, R7> apply7(FN73<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3> function, FN71<R1, R2, R3, R4, R5, R6, R7, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)), handler::apply);
            return new FlowBuilder7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<O1, R1, R2, R3, R4, R5, R6, R7> asyncApply7(FN73<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3> function) {
            step = new Step<>(StepType.ASYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new FlowBuilder7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<O1, R1, R2, R3, R4, R5, R6, R7> asyncApply7(FN73<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3> function, FN71<R1, R2, R3, R4, R5, R6, R7, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)), handler::apply);
            return new FlowBuilder7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<O1, R1, R2, R3, R4, R5, R6, R7> awaitApply7(FN73<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3> function) {
            step = new Step<>(StepType.AWAIT, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new FlowBuilder7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<O1, R1, R2, R3, R4, R5, R6, R7> awaitApply7(FN73<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3> function, FN71<R1, R2, R3, R4, R5, R6, R7, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)), handler::apply);
            return new FlowBuilder7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<O1, R1, R2, R3, R4, R5, R6, R7, R8> apply8(FN83<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3> function) {
            step = new Step<>(StepType.SYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new FlowBuilder8<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<O1, R1, R2, R3, R4, R5, R6, R7, R8> apply8(FN83<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3> function, FN81<R1, R2, R3, R4, R5, R6, R7, R8, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)), handler::apply);
            return new FlowBuilder8<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<O1, R1, R2, R3, R4, R5, R6, R7, R8> asyncApply8(FN83<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3> function) {
            step = new Step<>(StepType.ASYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new FlowBuilder8<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<O1, R1, R2, R3, R4, R5, R6, R7, R8> asyncApply8(FN83<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3> function, FN81<R1, R2, R3, R4, R5, R6, R7, R8, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)), handler::apply);
            return new FlowBuilder8<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<O1, R1, R2, R3, R4, R5, R6, R7, R8> awaitApply8(FN83<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3> function) {
            step = new Step<>(StepType.AWAIT, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new FlowBuilder8<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<O1, R1, R2, R3, R4, R5, R6, R7, R8> awaitApply8(FN83<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3> function, FN81<R1, R2, R3, R4, R5, R6, R7, R8, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)), handler::apply);
            return new FlowBuilder8<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<O1, R1, R2, R3, R4, R5, R6, R7, R8, R9> apply9(FN93<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3> function) {
            step = new Step<>(StepType.SYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new FlowBuilder9<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<O1, R1, R2, R3, R4, R5, R6, R7, R8, R9> apply9(FN93<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3> function, FN91<R1, R2, R3, R4, R5, R6, R7, R8, R9, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)), handler::apply);
            return new FlowBuilder9<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<O1, R1, R2, R3, R4, R5, R6, R7, R8, R9> asyncApply9(FN93<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3> function) {
            step = new Step<>(StepType.ASYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new FlowBuilder9<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<O1, R1, R2, R3, R4, R5, R6, R7, R8, R9> asyncApply9(FN93<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3> function, FN91<R1, R2, R3, R4, R5, R6, R7, R8, R9, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)), handler::apply);
            return new FlowBuilder9<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<O1, R1, R2, R3, R4, R5, R6, R7, R8, R9> awaitApply9(FN93<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3> function) {
            step = new Step<>(StepType.AWAIT, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)));
            return new FlowBuilder9<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<O1, R1, R2, R3, R4, R5, R6, R7, R8, R9> awaitApply9(FN93<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3> function, FN91<R1, R2, R3, R4, R5, R6, R7, R8, R9, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple3<T1, T2, T3> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2)), handler::apply);
            return new FlowBuilder9<>(this);
        }
    }

    public static class FlowBuilder4<O1 extends Tuple, T1, T2, T3, T4> extends FlowBuilder3<O1, T1, T2, T3> {
        public FlowBuilder4(FlowBuilder0<O1> prev) {
            super(prev);
        }

        @SuppressWarnings("unchecked")
        public Flow<O1, Tuple4<T1, T2, T3, T4>> build() {
            return Flow.of(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<O1, R1> apply1(FN14<R1, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.SYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new FlowBuilder1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<O1, R1> apply1(FN14<R1, T1, T2, T3, T4> function, FN11<R1, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)), handler::apply);
            return new FlowBuilder1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<O1, R1> asyncApply1(FN14<R1, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.ASYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new FlowBuilder1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<O1, R1> asyncApply1(FN14<R1, T1, T2, T3, T4> function, FN11<R1, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)), handler::apply);
            return new FlowBuilder1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<O1, R1> awaitApply1(FN14<R1, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.AWAIT, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new FlowBuilder1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<O1, R1> awaitApply1(FN14<R1, T1, T2, T3, T4> function, FN11<R1, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)), handler::apply);
            return new FlowBuilder1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<O1, R1, R2> apply2(FN24<R1, R2, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.SYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new FlowBuilder2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<O1, R1, R2> apply2(FN24<R1, R2, T1, T2, T3, T4> function, FN21<R1, R2, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)), handler::apply);
            return new FlowBuilder2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<O1, R1, R2> asyncApply2(FN24<R1, R2, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.ASYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new FlowBuilder2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<O1, R1, R2> asyncApply2(FN24<R1, R2, T1, T2, T3, T4> function, FN21<R1, R2, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)), handler::apply);
            return new FlowBuilder2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<O1, R1, R2> awaitApply2(FN24<R1, R2, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.AWAIT, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new FlowBuilder2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<O1, R1, R2> awaitApply2(FN24<R1, R2, T1, T2, T3, T4> function, FN21<R1, R2, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)), handler::apply);
            return new FlowBuilder2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<O1, R1, R2, R3> apply3(FN34<R1, R2, R3, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.SYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new FlowBuilder3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<O1, R1, R2, R3> apply3(FN34<R1, R2, R3, T1, T2, T3, T4> function, FN31<R1, R2, R3, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)), handler::apply);
            return new FlowBuilder3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<O1, R1, R2, R3> asyncApply3(FN34<R1, R2, R3, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.ASYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new FlowBuilder3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<O1, R1, R2, R3> asyncApply3(FN34<R1, R2, R3, T1, T2, T3, T4> function, FN31<R1, R2, R3, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)), handler::apply);
            return new FlowBuilder3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<O1, R1, R2, R3> awaitApply3(FN34<R1, R2, R3, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.AWAIT, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new FlowBuilder3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<O1, R1, R2, R3> awaitApply3(FN34<R1, R2, R3, T1, T2, T3, T4> function, FN31<R1, R2, R3, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)), handler::apply);
            return new FlowBuilder3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<O1, R1, R2, R3, R4> apply4(FN44<R1, R2, R3, R4, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.SYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new FlowBuilder4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<O1, R1, R2, R3, R4> apply4(FN44<R1, R2, R3, R4, T1, T2, T3, T4> function, FN41<R1, R2, R3, R4, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)), handler::apply);
            return new FlowBuilder4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<O1, R1, R2, R3, R4> asyncApply4(FN44<R1, R2, R3, R4, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.ASYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new FlowBuilder4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<O1, R1, R2, R3, R4> asyncApply4(FN44<R1, R2, R3, R4, T1, T2, T3, T4> function, FN41<R1, R2, R3, R4, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)), handler::apply);
            return new FlowBuilder4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<O1, R1, R2, R3, R4> awaitApply4(FN44<R1, R2, R3, R4, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.AWAIT, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new FlowBuilder4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<O1, R1, R2, R3, R4> awaitApply4(FN44<R1, R2, R3, R4, T1, T2, T3, T4> function, FN41<R1, R2, R3, R4, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)), handler::apply);
            return new FlowBuilder4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<O1, R1, R2, R3, R4, R5> apply5(FN54<R1, R2, R3, R4, R5, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.SYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new FlowBuilder5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<O1, R1, R2, R3, R4, R5> apply5(FN54<R1, R2, R3, R4, R5, T1, T2, T3, T4> function, FN51<R1, R2, R3, R4, R5, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)), handler::apply);
            return new FlowBuilder5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<O1, R1, R2, R3, R4, R5> asyncApply5(FN54<R1, R2, R3, R4, R5, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.ASYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new FlowBuilder5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<O1, R1, R2, R3, R4, R5> asyncApply5(FN54<R1, R2, R3, R4, R5, T1, T2, T3, T4> function, FN51<R1, R2, R3, R4, R5, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)), handler::apply);
            return new FlowBuilder5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<O1, R1, R2, R3, R4, R5> awaitApply5(FN54<R1, R2, R3, R4, R5, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.AWAIT, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new FlowBuilder5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<O1, R1, R2, R3, R4, R5> awaitApply5(FN54<R1, R2, R3, R4, R5, T1, T2, T3, T4> function, FN51<R1, R2, R3, R4, R5, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)), handler::apply);
            return new FlowBuilder5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<O1, R1, R2, R3, R4, R5, R6> apply6(FN64<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.SYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new FlowBuilder6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<O1, R1, R2, R3, R4, R5, R6> apply6(FN64<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4> function, FN61<R1, R2, R3, R4, R5, R6, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)), handler::apply);
            return new FlowBuilder6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<O1, R1, R2, R3, R4, R5, R6> asyncApply6(FN64<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.ASYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new FlowBuilder6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<O1, R1, R2, R3, R4, R5, R6> asyncApply6(FN64<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4> function, FN61<R1, R2, R3, R4, R5, R6, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)), handler::apply);
            return new FlowBuilder6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<O1, R1, R2, R3, R4, R5, R6> awaitApply6(FN64<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.AWAIT, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new FlowBuilder6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<O1, R1, R2, R3, R4, R5, R6> awaitApply6(FN64<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4> function, FN61<R1, R2, R3, R4, R5, R6, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)), handler::apply);
            return new FlowBuilder6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<O1, R1, R2, R3, R4, R5, R6, R7> apply7(FN74<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.SYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new FlowBuilder7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<O1, R1, R2, R3, R4, R5, R6, R7> apply7(FN74<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4> function, FN71<R1, R2, R3, R4, R5, R6, R7, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)), handler::apply);
            return new FlowBuilder7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<O1, R1, R2, R3, R4, R5, R6, R7> asyncApply7(FN74<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.ASYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new FlowBuilder7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<O1, R1, R2, R3, R4, R5, R6, R7> asyncApply7(FN74<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4> function, FN71<R1, R2, R3, R4, R5, R6, R7, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)), handler::apply);
            return new FlowBuilder7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<O1, R1, R2, R3, R4, R5, R6, R7> awaitApply7(FN74<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.AWAIT, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new FlowBuilder7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<O1, R1, R2, R3, R4, R5, R6, R7> awaitApply7(FN74<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4> function, FN71<R1, R2, R3, R4, R5, R6, R7, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)), handler::apply);
            return new FlowBuilder7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<O1, R1, R2, R3, R4, R5, R6, R7, R8> apply8(FN84<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.SYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new FlowBuilder8<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<O1, R1, R2, R3, R4, R5, R6, R7, R8> apply8(FN84<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4> function, FN81<R1, R2, R3, R4, R5, R6, R7, R8, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)), handler::apply);
            return new FlowBuilder8<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<O1, R1, R2, R3, R4, R5, R6, R7, R8> asyncApply8(FN84<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.ASYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new FlowBuilder8<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<O1, R1, R2, R3, R4, R5, R6, R7, R8> asyncApply8(FN84<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4> function, FN81<R1, R2, R3, R4, R5, R6, R7, R8, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)), handler::apply);
            return new FlowBuilder8<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<O1, R1, R2, R3, R4, R5, R6, R7, R8> awaitApply8(FN84<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.AWAIT, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new FlowBuilder8<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<O1, R1, R2, R3, R4, R5, R6, R7, R8> awaitApply8(FN84<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4> function, FN81<R1, R2, R3, R4, R5, R6, R7, R8, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)), handler::apply);
            return new FlowBuilder8<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<O1, R1, R2, R3, R4, R5, R6, R7, R8, R9> apply9(FN94<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.SYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new FlowBuilder9<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<O1, R1, R2, R3, R4, R5, R6, R7, R8, R9> apply9(FN94<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4> function, FN91<R1, R2, R3, R4, R5, R6, R7, R8, R9, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)), handler::apply);
            return new FlowBuilder9<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<O1, R1, R2, R3, R4, R5, R6, R7, R8, R9> asyncApply9(FN94<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.ASYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new FlowBuilder9<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<O1, R1, R2, R3, R4, R5, R6, R7, R8, R9> asyncApply9(FN94<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4> function, FN91<R1, R2, R3, R4, R5, R6, R7, R8, R9, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)), handler::apply);
            return new FlowBuilder9<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<O1, R1, R2, R3, R4, R5, R6, R7, R8, R9> awaitApply9(FN94<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4> function) {
            step = new Step<>(StepType.AWAIT, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)));
            return new FlowBuilder9<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<O1, R1, R2, R3, R4, R5, R6, R7, R8, R9> awaitApply9(FN94<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4> function, FN91<R1, R2, R3, R4, R5, R6, R7, R8, R9, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple4<T1, T2, T3, T4> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3)), handler::apply);
            return new FlowBuilder9<>(this);
        }
    }

    public static class FlowBuilder5<O1 extends Tuple, T1, T2, T3, T4, T5> extends FlowBuilder4<O1, T1, T2, T3, T4> {
        public FlowBuilder5(FlowBuilder0<O1> prev) {
            super(prev);
        }

        @SuppressWarnings("unchecked")
        public Flow<O1, Tuple5<T1, T2, T3, T4, T5>> build() {
            return Flow.of(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<O1, R1> apply1(FN15<R1, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.SYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new FlowBuilder1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<O1, R1> apply1(FN15<R1, T1, T2, T3, T4, T5> function, FN11<R1, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)), handler::apply);
            return new FlowBuilder1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<O1, R1> asyncApply1(FN15<R1, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.ASYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new FlowBuilder1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<O1, R1> asyncApply1(FN15<R1, T1, T2, T3, T4, T5> function, FN11<R1, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)), handler::apply);
            return new FlowBuilder1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<O1, R1> awaitApply1(FN15<R1, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.AWAIT, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new FlowBuilder1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<O1, R1> awaitApply1(FN15<R1, T1, T2, T3, T4, T5> function, FN11<R1, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)), handler::apply);
            return new FlowBuilder1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<O1, R1, R2> apply2(FN25<R1, R2, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.SYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new FlowBuilder2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<O1, R1, R2> apply2(FN25<R1, R2, T1, T2, T3, T4, T5> function, FN21<R1, R2, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)), handler::apply);
            return new FlowBuilder2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<O1, R1, R2> asyncApply2(FN25<R1, R2, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.ASYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new FlowBuilder2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<O1, R1, R2> asyncApply2(FN25<R1, R2, T1, T2, T3, T4, T5> function, FN21<R1, R2, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)), handler::apply);
            return new FlowBuilder2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<O1, R1, R2> awaitApply2(FN25<R1, R2, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.AWAIT, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new FlowBuilder2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<O1, R1, R2> awaitApply2(FN25<R1, R2, T1, T2, T3, T4, T5> function, FN21<R1, R2, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)), handler::apply);
            return new FlowBuilder2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<O1, R1, R2, R3> apply3(FN35<R1, R2, R3, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.SYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new FlowBuilder3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<O1, R1, R2, R3> apply3(FN35<R1, R2, R3, T1, T2, T3, T4, T5> function, FN31<R1, R2, R3, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)), handler::apply);
            return new FlowBuilder3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<O1, R1, R2, R3> asyncApply3(FN35<R1, R2, R3, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.ASYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new FlowBuilder3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<O1, R1, R2, R3> asyncApply3(FN35<R1, R2, R3, T1, T2, T3, T4, T5> function, FN31<R1, R2, R3, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)), handler::apply);
            return new FlowBuilder3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<O1, R1, R2, R3> awaitApply3(FN35<R1, R2, R3, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.AWAIT, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new FlowBuilder3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<O1, R1, R2, R3> awaitApply3(FN35<R1, R2, R3, T1, T2, T3, T4, T5> function, FN31<R1, R2, R3, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)), handler::apply);
            return new FlowBuilder3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<O1, R1, R2, R3, R4> apply4(FN45<R1, R2, R3, R4, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.SYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new FlowBuilder4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<O1, R1, R2, R3, R4> apply4(FN45<R1, R2, R3, R4, T1, T2, T3, T4, T5> function, FN41<R1, R2, R3, R4, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)), handler::apply);
            return new FlowBuilder4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<O1, R1, R2, R3, R4> asyncApply4(FN45<R1, R2, R3, R4, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.ASYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new FlowBuilder4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<O1, R1, R2, R3, R4> asyncApply4(FN45<R1, R2, R3, R4, T1, T2, T3, T4, T5> function, FN41<R1, R2, R3, R4, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)), handler::apply);
            return new FlowBuilder4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<O1, R1, R2, R3, R4> awaitApply4(FN45<R1, R2, R3, R4, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.AWAIT, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new FlowBuilder4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<O1, R1, R2, R3, R4> awaitApply4(FN45<R1, R2, R3, R4, T1, T2, T3, T4, T5> function, FN41<R1, R2, R3, R4, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)), handler::apply);
            return new FlowBuilder4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<O1, R1, R2, R3, R4, R5> apply5(FN55<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.SYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new FlowBuilder5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<O1, R1, R2, R3, R4, R5> apply5(FN55<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5> function, FN51<R1, R2, R3, R4, R5, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)), handler::apply);
            return new FlowBuilder5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<O1, R1, R2, R3, R4, R5> asyncApply5(FN55<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.ASYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new FlowBuilder5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<O1, R1, R2, R3, R4, R5> asyncApply5(FN55<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5> function, FN51<R1, R2, R3, R4, R5, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)), handler::apply);
            return new FlowBuilder5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<O1, R1, R2, R3, R4, R5> awaitApply5(FN55<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.AWAIT, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new FlowBuilder5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<O1, R1, R2, R3, R4, R5> awaitApply5(FN55<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5> function, FN51<R1, R2, R3, R4, R5, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)), handler::apply);
            return new FlowBuilder5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<O1, R1, R2, R3, R4, R5, R6> apply6(FN65<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.SYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new FlowBuilder6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<O1, R1, R2, R3, R4, R5, R6> apply6(FN65<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5> function, FN61<R1, R2, R3, R4, R5, R6, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)), handler::apply);
            return new FlowBuilder6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<O1, R1, R2, R3, R4, R5, R6> asyncApply6(FN65<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.ASYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new FlowBuilder6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<O1, R1, R2, R3, R4, R5, R6> asyncApply6(FN65<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5> function, FN61<R1, R2, R3, R4, R5, R6, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)), handler::apply);
            return new FlowBuilder6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<O1, R1, R2, R3, R4, R5, R6> awaitApply6(FN65<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.AWAIT, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new FlowBuilder6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<O1, R1, R2, R3, R4, R5, R6> awaitApply6(FN65<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5> function, FN61<R1, R2, R3, R4, R5, R6, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)), handler::apply);
            return new FlowBuilder6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<O1, R1, R2, R3, R4, R5, R6, R7> apply7(FN75<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.SYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new FlowBuilder7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<O1, R1, R2, R3, R4, R5, R6, R7> apply7(FN75<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5> function, FN71<R1, R2, R3, R4, R5, R6, R7, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)), handler::apply);
            return new FlowBuilder7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<O1, R1, R2, R3, R4, R5, R6, R7> asyncApply7(FN75<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.ASYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new FlowBuilder7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<O1, R1, R2, R3, R4, R5, R6, R7> asyncApply7(FN75<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5> function, FN71<R1, R2, R3, R4, R5, R6, R7, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)), handler::apply);
            return new FlowBuilder7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<O1, R1, R2, R3, R4, R5, R6, R7> awaitApply7(FN75<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.AWAIT, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new FlowBuilder7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<O1, R1, R2, R3, R4, R5, R6, R7> awaitApply7(FN75<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5> function, FN71<R1, R2, R3, R4, R5, R6, R7, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)), handler::apply);
            return new FlowBuilder7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<O1, R1, R2, R3, R4, R5, R6, R7, R8> apply8(FN85<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.SYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new FlowBuilder8<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<O1, R1, R2, R3, R4, R5, R6, R7, R8> apply8(FN85<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5> function, FN81<R1, R2, R3, R4, R5, R6, R7, R8, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)), handler::apply);
            return new FlowBuilder8<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<O1, R1, R2, R3, R4, R5, R6, R7, R8> asyncApply8(FN85<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.ASYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new FlowBuilder8<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<O1, R1, R2, R3, R4, R5, R6, R7, R8> asyncApply8(FN85<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5> function, FN81<R1, R2, R3, R4, R5, R6, R7, R8, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)), handler::apply);
            return new FlowBuilder8<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<O1, R1, R2, R3, R4, R5, R6, R7, R8> awaitApply8(FN85<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.AWAIT, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new FlowBuilder8<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<O1, R1, R2, R3, R4, R5, R6, R7, R8> awaitApply8(FN85<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5> function, FN81<R1, R2, R3, R4, R5, R6, R7, R8, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)), handler::apply);
            return new FlowBuilder8<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<O1, R1, R2, R3, R4, R5, R6, R7, R8, R9> apply9(FN95<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.SYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new FlowBuilder9<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<O1, R1, R2, R3, R4, R5, R6, R7, R8, R9> apply9(FN95<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5> function, FN91<R1, R2, R3, R4, R5, R6, R7, R8, R9, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)), handler::apply);
            return new FlowBuilder9<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<O1, R1, R2, R3, R4, R5, R6, R7, R8, R9> asyncApply9(FN95<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.ASYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new FlowBuilder9<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<O1, R1, R2, R3, R4, R5, R6, R7, R8, R9> asyncApply9(FN95<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5> function, FN91<R1, R2, R3, R4, R5, R6, R7, R8, R9, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)), handler::apply);
            return new FlowBuilder9<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<O1, R1, R2, R3, R4, R5, R6, R7, R8, R9> awaitApply9(FN95<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5> function) {
            step = new Step<>(StepType.AWAIT, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)));
            return new FlowBuilder9<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<O1, R1, R2, R3, R4, R5, R6, R7, R8, R9> awaitApply9(FN95<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5> function, FN91<R1, R2, R3, R4, R5, R6, R7, R8, R9, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple5<T1, T2, T3, T4, T5> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4)), handler::apply);
            return new FlowBuilder9<>(this);
        }
    }

    public static class FlowBuilder6<O1 extends Tuple, T1, T2, T3, T4, T5, T6> extends FlowBuilder5<O1, T1, T2, T3, T4, T5> {
        public FlowBuilder6(FlowBuilder0<O1> prev) {
            super(prev);
        }

        @SuppressWarnings("unchecked")
        public Flow<O1, Tuple6<T1, T2, T3, T4, T5, T6>> build() {
            return Flow.of(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<O1, R1> apply1(FN16<R1, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.SYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new FlowBuilder1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<O1, R1> apply1(FN16<R1, T1, T2, T3, T4, T5, T6> function, FN11<R1, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)), handler::apply);
            return new FlowBuilder1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<O1, R1> asyncApply1(FN16<R1, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.ASYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new FlowBuilder1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<O1, R1> asyncApply1(FN16<R1, T1, T2, T3, T4, T5, T6> function, FN11<R1, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)), handler::apply);
            return new FlowBuilder1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<O1, R1> awaitApply1(FN16<R1, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.AWAIT, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new FlowBuilder1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<O1, R1> awaitApply1(FN16<R1, T1, T2, T3, T4, T5, T6> function, FN11<R1, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)), handler::apply);
            return new FlowBuilder1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<O1, R1, R2> apply2(FN26<R1, R2, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.SYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new FlowBuilder2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<O1, R1, R2> apply2(FN26<R1, R2, T1, T2, T3, T4, T5, T6> function, FN21<R1, R2, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)), handler::apply);
            return new FlowBuilder2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<O1, R1, R2> asyncApply2(FN26<R1, R2, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.ASYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new FlowBuilder2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<O1, R1, R2> asyncApply2(FN26<R1, R2, T1, T2, T3, T4, T5, T6> function, FN21<R1, R2, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)), handler::apply);
            return new FlowBuilder2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<O1, R1, R2> awaitApply2(FN26<R1, R2, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.AWAIT, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new FlowBuilder2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<O1, R1, R2> awaitApply2(FN26<R1, R2, T1, T2, T3, T4, T5, T6> function, FN21<R1, R2, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)), handler::apply);
            return new FlowBuilder2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<O1, R1, R2, R3> apply3(FN36<R1, R2, R3, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.SYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new FlowBuilder3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<O1, R1, R2, R3> apply3(FN36<R1, R2, R3, T1, T2, T3, T4, T5, T6> function, FN31<R1, R2, R3, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)), handler::apply);
            return new FlowBuilder3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<O1, R1, R2, R3> asyncApply3(FN36<R1, R2, R3, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.ASYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new FlowBuilder3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<O1, R1, R2, R3> asyncApply3(FN36<R1, R2, R3, T1, T2, T3, T4, T5, T6> function, FN31<R1, R2, R3, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)), handler::apply);
            return new FlowBuilder3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<O1, R1, R2, R3> awaitApply3(FN36<R1, R2, R3, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.AWAIT, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new FlowBuilder3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<O1, R1, R2, R3> awaitApply3(FN36<R1, R2, R3, T1, T2, T3, T4, T5, T6> function, FN31<R1, R2, R3, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)), handler::apply);
            return new FlowBuilder3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<O1, R1, R2, R3, R4> apply4(FN46<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.SYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new FlowBuilder4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<O1, R1, R2, R3, R4> apply4(FN46<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6> function, FN41<R1, R2, R3, R4, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)), handler::apply);
            return new FlowBuilder4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<O1, R1, R2, R3, R4> asyncApply4(FN46<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.ASYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new FlowBuilder4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<O1, R1, R2, R3, R4> asyncApply4(FN46<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6> function, FN41<R1, R2, R3, R4, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)), handler::apply);
            return new FlowBuilder4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<O1, R1, R2, R3, R4> awaitApply4(FN46<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.AWAIT, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new FlowBuilder4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<O1, R1, R2, R3, R4> awaitApply4(FN46<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6> function, FN41<R1, R2, R3, R4, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)), handler::apply);
            return new FlowBuilder4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<O1, R1, R2, R3, R4, R5> apply5(FN56<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.SYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new FlowBuilder5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<O1, R1, R2, R3, R4, R5> apply5(FN56<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6> function, FN51<R1, R2, R3, R4, R5, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)), handler::apply);
            return new FlowBuilder5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<O1, R1, R2, R3, R4, R5> asyncApply5(FN56<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.ASYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new FlowBuilder5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<O1, R1, R2, R3, R4, R5> asyncApply5(FN56<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6> function, FN51<R1, R2, R3, R4, R5, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)), handler::apply);
            return new FlowBuilder5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<O1, R1, R2, R3, R4, R5> awaitApply5(FN56<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.AWAIT, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new FlowBuilder5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<O1, R1, R2, R3, R4, R5> awaitApply5(FN56<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6> function, FN51<R1, R2, R3, R4, R5, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)), handler::apply);
            return new FlowBuilder5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<O1, R1, R2, R3, R4, R5, R6> apply6(FN66<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.SYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new FlowBuilder6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<O1, R1, R2, R3, R4, R5, R6> apply6(FN66<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6> function, FN61<R1, R2, R3, R4, R5, R6, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)), handler::apply);
            return new FlowBuilder6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<O1, R1, R2, R3, R4, R5, R6> asyncApply6(FN66<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.ASYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new FlowBuilder6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<O1, R1, R2, R3, R4, R5, R6> asyncApply6(FN66<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6> function, FN61<R1, R2, R3, R4, R5, R6, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)), handler::apply);
            return new FlowBuilder6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<O1, R1, R2, R3, R4, R5, R6> awaitApply6(FN66<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.AWAIT, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new FlowBuilder6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<O1, R1, R2, R3, R4, R5, R6> awaitApply6(FN66<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6> function, FN61<R1, R2, R3, R4, R5, R6, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)), handler::apply);
            return new FlowBuilder6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<O1, R1, R2, R3, R4, R5, R6, R7> apply7(FN76<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.SYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new FlowBuilder7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<O1, R1, R2, R3, R4, R5, R6, R7> apply7(FN76<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6> function, FN71<R1, R2, R3, R4, R5, R6, R7, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)), handler::apply);
            return new FlowBuilder7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<O1, R1, R2, R3, R4, R5, R6, R7> asyncApply7(FN76<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.ASYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new FlowBuilder7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<O1, R1, R2, R3, R4, R5, R6, R7> asyncApply7(FN76<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6> function, FN71<R1, R2, R3, R4, R5, R6, R7, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)), handler::apply);
            return new FlowBuilder7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<O1, R1, R2, R3, R4, R5, R6, R7> awaitApply7(FN76<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.AWAIT, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new FlowBuilder7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<O1, R1, R2, R3, R4, R5, R6, R7> awaitApply7(FN76<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6> function, FN71<R1, R2, R3, R4, R5, R6, R7, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)), handler::apply);
            return new FlowBuilder7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<O1, R1, R2, R3, R4, R5, R6, R7, R8> apply8(FN86<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.SYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new FlowBuilder8<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<O1, R1, R2, R3, R4, R5, R6, R7, R8> apply8(FN86<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5, T6> function, FN81<R1, R2, R3, R4, R5, R6, R7, R8, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)), handler::apply);
            return new FlowBuilder8<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<O1, R1, R2, R3, R4, R5, R6, R7, R8> asyncApply8(FN86<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.ASYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new FlowBuilder8<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<O1, R1, R2, R3, R4, R5, R6, R7, R8> asyncApply8(FN86<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5, T6> function, FN81<R1, R2, R3, R4, R5, R6, R7, R8, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)), handler::apply);
            return new FlowBuilder8<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<O1, R1, R2, R3, R4, R5, R6, R7, R8> awaitApply8(FN86<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.AWAIT, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new FlowBuilder8<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<O1, R1, R2, R3, R4, R5, R6, R7, R8> awaitApply8(FN86<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5, T6> function, FN81<R1, R2, R3, R4, R5, R6, R7, R8, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)), handler::apply);
            return new FlowBuilder8<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<O1, R1, R2, R3, R4, R5, R6, R7, R8, R9> apply9(FN96<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.SYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new FlowBuilder9<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<O1, R1, R2, R3, R4, R5, R6, R7, R8, R9> apply9(FN96<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5, T6> function, FN91<R1, R2, R3, R4, R5, R6, R7, R8, R9, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)), handler::apply);
            return new FlowBuilder9<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<O1, R1, R2, R3, R4, R5, R6, R7, R8, R9> asyncApply9(FN96<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.ASYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new FlowBuilder9<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<O1, R1, R2, R3, R4, R5, R6, R7, R8, R9> asyncApply9(FN96<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5, T6> function, FN91<R1, R2, R3, R4, R5, R6, R7, R8, R9, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)), handler::apply);
            return new FlowBuilder9<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<O1, R1, R2, R3, R4, R5, R6, R7, R8, R9> awaitApply9(FN96<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5, T6> function) {
            step = new Step<>(StepType.AWAIT, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)));
            return new FlowBuilder9<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<O1, R1, R2, R3, R4, R5, R6, R7, R8, R9> awaitApply9(FN96<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5, T6> function, FN91<R1, R2, R3, R4, R5, R6, R7, R8, R9, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple6<T1, T2, T3, T4, T5, T6> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5)), handler::apply);
            return new FlowBuilder9<>(this);
        }
    }

    public static class FlowBuilder7<O1 extends Tuple, T1, T2, T3, T4, T5, T6, T7> extends FlowBuilder6<O1, T1, T2, T3, T4, T5, T6> {
        public FlowBuilder7(FlowBuilder0<O1> prev) {
            super(prev);
        }

        @SuppressWarnings("unchecked")
        public Flow<O1, Tuple7<T1, T2, T3, T4, T5, T6, T7>> build() {
            return Flow.of(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<O1, R1> apply1(FN17<R1, T1, T2, T3, T4, T5, T6, T7> function) {
            step = new Step<>(StepType.SYNC, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)));
            return new FlowBuilder1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<O1, R1> apply1(FN17<R1, T1, T2, T3, T4, T5, T6, T7> function, FN11<R1, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)), handler::apply);
            return new FlowBuilder1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<O1, R1> asyncApply1(FN17<R1, T1, T2, T3, T4, T5, T6, T7> function) {
            step = new Step<>(StepType.ASYNC, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)));
            return new FlowBuilder1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<O1, R1> asyncApply1(FN17<R1, T1, T2, T3, T4, T5, T6, T7> function, FN11<R1, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)), handler::apply);
            return new FlowBuilder1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<O1, R1> awaitApply1(FN17<R1, T1, T2, T3, T4, T5, T6, T7> function) {
            step = new Step<>(StepType.AWAIT, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)));
            return new FlowBuilder1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<O1, R1> awaitApply1(FN17<R1, T1, T2, T3, T4, T5, T6, T7> function, FN11<R1, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)), handler::apply);
            return new FlowBuilder1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<O1, R1, R2> apply2(FN27<R1, R2, T1, T2, T3, T4, T5, T6, T7> function) {
            step = new Step<>(StepType.SYNC, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)));
            return new FlowBuilder2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<O1, R1, R2> apply2(FN27<R1, R2, T1, T2, T3, T4, T5, T6, T7> function, FN21<R1, R2, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)), handler::apply);
            return new FlowBuilder2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<O1, R1, R2> asyncApply2(FN27<R1, R2, T1, T2, T3, T4, T5, T6, T7> function) {
            step = new Step<>(StepType.ASYNC, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)));
            return new FlowBuilder2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<O1, R1, R2> asyncApply2(FN27<R1, R2, T1, T2, T3, T4, T5, T6, T7> function, FN21<R1, R2, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)), handler::apply);
            return new FlowBuilder2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<O1, R1, R2> awaitApply2(FN27<R1, R2, T1, T2, T3, T4, T5, T6, T7> function) {
            step = new Step<>(StepType.AWAIT, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)));
            return new FlowBuilder2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<O1, R1, R2> awaitApply2(FN27<R1, R2, T1, T2, T3, T4, T5, T6, T7> function, FN21<R1, R2, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)), handler::apply);
            return new FlowBuilder2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<O1, R1, R2, R3> apply3(FN37<R1, R2, R3, T1, T2, T3, T4, T5, T6, T7> function) {
            step = new Step<>(StepType.SYNC, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)));
            return new FlowBuilder3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<O1, R1, R2, R3> apply3(FN37<R1, R2, R3, T1, T2, T3, T4, T5, T6, T7> function, FN31<R1, R2, R3, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)), handler::apply);
            return new FlowBuilder3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<O1, R1, R2, R3> asyncApply3(FN37<R1, R2, R3, T1, T2, T3, T4, T5, T6, T7> function) {
            step = new Step<>(StepType.ASYNC, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)));
            return new FlowBuilder3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<O1, R1, R2, R3> asyncApply3(FN37<R1, R2, R3, T1, T2, T3, T4, T5, T6, T7> function, FN31<R1, R2, R3, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)), handler::apply);
            return new FlowBuilder3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<O1, R1, R2, R3> awaitApply3(FN37<R1, R2, R3, T1, T2, T3, T4, T5, T6, T7> function) {
            step = new Step<>(StepType.AWAIT, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)));
            return new FlowBuilder3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<O1, R1, R2, R3> awaitApply3(FN37<R1, R2, R3, T1, T2, T3, T4, T5, T6, T7> function, FN31<R1, R2, R3, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)), handler::apply);
            return new FlowBuilder3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<O1, R1, R2, R3, R4> apply4(FN47<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6, T7> function) {
            step = new Step<>(StepType.SYNC, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)));
            return new FlowBuilder4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<O1, R1, R2, R3, R4> apply4(FN47<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6, T7> function, FN41<R1, R2, R3, R4, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)), handler::apply);
            return new FlowBuilder4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<O1, R1, R2, R3, R4> asyncApply4(FN47<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6, T7> function) {
            step = new Step<>(StepType.ASYNC, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)));
            return new FlowBuilder4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<O1, R1, R2, R3, R4> asyncApply4(FN47<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6, T7> function, FN41<R1, R2, R3, R4, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)), handler::apply);
            return new FlowBuilder4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<O1, R1, R2, R3, R4> awaitApply4(FN47<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6, T7> function) {
            step = new Step<>(StepType.AWAIT, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)));
            return new FlowBuilder4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<O1, R1, R2, R3, R4> awaitApply4(FN47<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6, T7> function, FN41<R1, R2, R3, R4, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)), handler::apply);
            return new FlowBuilder4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<O1, R1, R2, R3, R4, R5> apply5(FN57<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6, T7> function) {
            step = new Step<>(StepType.SYNC, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)));
            return new FlowBuilder5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<O1, R1, R2, R3, R4, R5> apply5(FN57<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6, T7> function, FN51<R1, R2, R3, R4, R5, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)), handler::apply);
            return new FlowBuilder5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<O1, R1, R2, R3, R4, R5> asyncApply5(FN57<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6, T7> function) {
            step = new Step<>(StepType.ASYNC, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)));
            return new FlowBuilder5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<O1, R1, R2, R3, R4, R5> asyncApply5(FN57<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6, T7> function, FN51<R1, R2, R3, R4, R5, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)), handler::apply);
            return new FlowBuilder5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<O1, R1, R2, R3, R4, R5> awaitApply5(FN57<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6, T7> function) {
            step = new Step<>(StepType.AWAIT, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)));
            return new FlowBuilder5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<O1, R1, R2, R3, R4, R5> awaitApply5(FN57<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6, T7> function, FN51<R1, R2, R3, R4, R5, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)), handler::apply);
            return new FlowBuilder5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<O1, R1, R2, R3, R4, R5, R6> apply6(FN67<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6, T7> function) {
            step = new Step<>(StepType.SYNC, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)));
            return new FlowBuilder6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<O1, R1, R2, R3, R4, R5, R6> apply6(FN67<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6, T7> function, FN61<R1, R2, R3, R4, R5, R6, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)), handler::apply);
            return new FlowBuilder6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<O1, R1, R2, R3, R4, R5, R6> asyncApply6(FN67<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6, T7> function) {
            step = new Step<>(StepType.ASYNC, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)));
            return new FlowBuilder6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<O1, R1, R2, R3, R4, R5, R6> asyncApply6(FN67<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6, T7> function, FN61<R1, R2, R3, R4, R5, R6, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)), handler::apply);
            return new FlowBuilder6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<O1, R1, R2, R3, R4, R5, R6> awaitApply6(FN67<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6, T7> function) {
            step = new Step<>(StepType.AWAIT, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)));
            return new FlowBuilder6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<O1, R1, R2, R3, R4, R5, R6> awaitApply6(FN67<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6, T7> function, FN61<R1, R2, R3, R4, R5, R6, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)), handler::apply);
            return new FlowBuilder6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<O1, R1, R2, R3, R4, R5, R6, R7> apply7(FN77<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6, T7> function) {
            step = new Step<>(StepType.SYNC, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)));
            return new FlowBuilder7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<O1, R1, R2, R3, R4, R5, R6, R7> apply7(FN77<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6, T7> function, FN71<R1, R2, R3, R4, R5, R6, R7, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)), handler::apply);
            return new FlowBuilder7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<O1, R1, R2, R3, R4, R5, R6, R7> asyncApply7(FN77<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6, T7> function) {
            step = new Step<>(StepType.ASYNC, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)));
            return new FlowBuilder7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<O1, R1, R2, R3, R4, R5, R6, R7> asyncApply7(FN77<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6, T7> function, FN71<R1, R2, R3, R4, R5, R6, R7, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)), handler::apply);
            return new FlowBuilder7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<O1, R1, R2, R3, R4, R5, R6, R7> awaitApply7(FN77<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6, T7> function) {
            step = new Step<>(StepType.AWAIT, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)));
            return new FlowBuilder7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<O1, R1, R2, R3, R4, R5, R6, R7> awaitApply7(FN77<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6, T7> function, FN71<R1, R2, R3, R4, R5, R6, R7, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)), handler::apply);
            return new FlowBuilder7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<O1, R1, R2, R3, R4, R5, R6, R7, R8> apply8(FN87<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5, T6, T7> function) {
            step = new Step<>(StepType.SYNC, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)));
            return new FlowBuilder8<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<O1, R1, R2, R3, R4, R5, R6, R7, R8> apply8(FN87<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5, T6, T7> function, FN81<R1, R2, R3, R4, R5, R6, R7, R8, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)), handler::apply);
            return new FlowBuilder8<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<O1, R1, R2, R3, R4, R5, R6, R7, R8> asyncApply8(FN87<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5, T6, T7> function) {
            step = new Step<>(StepType.ASYNC, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)));
            return new FlowBuilder8<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<O1, R1, R2, R3, R4, R5, R6, R7, R8> asyncApply8(FN87<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5, T6, T7> function, FN81<R1, R2, R3, R4, R5, R6, R7, R8, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)), handler::apply);
            return new FlowBuilder8<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<O1, R1, R2, R3, R4, R5, R6, R7, R8> awaitApply8(FN87<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5, T6, T7> function) {
            step = new Step<>(StepType.AWAIT, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)));
            return new FlowBuilder8<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<O1, R1, R2, R3, R4, R5, R6, R7, R8> awaitApply8(FN87<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5, T6, T7> function, FN81<R1, R2, R3, R4, R5, R6, R7, R8, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)), handler::apply);
            return new FlowBuilder8<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<O1, R1, R2, R3, R4, R5, R6, R7, R8, R9> apply9(FN97<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5, T6, T7> function) {
            step = new Step<>(StepType.SYNC, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)));
            return new FlowBuilder9<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<O1, R1, R2, R3, R4, R5, R6, R7, R8, R9> apply9(FN97<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5, T6, T7> function, FN91<R1, R2, R3, R4, R5, R6, R7, R8, R9, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)), handler::apply);
            return new FlowBuilder9<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<O1, R1, R2, R3, R4, R5, R6, R7, R8, R9> asyncApply9(FN97<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5, T6, T7> function) {
            step = new Step<>(StepType.ASYNC, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)));
            return new FlowBuilder9<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<O1, R1, R2, R3, R4, R5, R6, R7, R8, R9> asyncApply9(FN97<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5, T6, T7> function, FN91<R1, R2, R3, R4, R5, R6, R7, R8, R9, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)), handler::apply);
            return new FlowBuilder9<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<O1, R1, R2, R3, R4, R5, R6, R7, R8, R9> awaitApply9(FN97<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5, T6, T7> function) {
            step = new Step<>(StepType.AWAIT, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)));
            return new FlowBuilder9<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<O1, R1, R2, R3, R4, R5, R6, R7, R8, R9> awaitApply9(FN97<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5, T6, T7> function, FN91<R1, R2, R3, R4, R5, R6, R7, R8, R9, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6)), handler::apply);
            return new FlowBuilder9<>(this);
        }
    }

    public static class FlowBuilder8<O1 extends Tuple, T1, T2, T3, T4, T5, T6, T7, T8> extends FlowBuilder7<O1, T1, T2, T3, T4, T5, T6, T7> {
        public FlowBuilder8(FlowBuilder0<O1> prev) {
            super(prev);
        }

        @SuppressWarnings("unchecked")
        public Flow<O1, Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>> build() {
            return Flow.of(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<O1, R1> apply1(FN18<R1, T1, T2, T3, T4, T5, T6, T7, T8> function) {
            step = new Step<>(StepType.SYNC, (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7)));
            return new FlowBuilder1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<O1, R1> apply1(FN18<R1, T1, T2, T3, T4, T5, T6, T7, T8> function, FN11<R1, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7)), handler::apply);
            return new FlowBuilder1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<O1, R1> asyncApply1(FN18<R1, T1, T2, T3, T4, T5, T6, T7, T8> function) {
            step = new Step<>(StepType.ASYNC, (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7)));
            return new FlowBuilder1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<O1, R1> asyncApply1(FN18<R1, T1, T2, T3, T4, T5, T6, T7, T8> function, FN11<R1, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7)), handler::apply);
            return new FlowBuilder1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<O1, R1> awaitApply1(FN18<R1, T1, T2, T3, T4, T5, T6, T7, T8> function) {
            step = new Step<>(StepType.AWAIT, (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7)));
            return new FlowBuilder1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<O1, R1> awaitApply1(FN18<R1, T1, T2, T3, T4, T5, T6, T7, T8> function, FN11<R1, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7)), handler::apply);
            return new FlowBuilder1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<O1, R1, R2> apply2(FN28<R1, R2, T1, T2, T3, T4, T5, T6, T7, T8> function) {
            step = new Step<>(StepType.SYNC, (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7)));
            return new FlowBuilder2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<O1, R1, R2> apply2(FN28<R1, R2, T1, T2, T3, T4, T5, T6, T7, T8> function, FN21<R1, R2, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7)), handler::apply);
            return new FlowBuilder2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<O1, R1, R2> asyncApply2(FN28<R1, R2, T1, T2, T3, T4, T5, T6, T7, T8> function) {
            step = new Step<>(StepType.ASYNC, (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7)));
            return new FlowBuilder2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<O1, R1, R2> asyncApply2(FN28<R1, R2, T1, T2, T3, T4, T5, T6, T7, T8> function, FN21<R1, R2, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7)), handler::apply);
            return new FlowBuilder2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<O1, R1, R2> awaitApply2(FN28<R1, R2, T1, T2, T3, T4, T5, T6, T7, T8> function) {
            step = new Step<>(StepType.AWAIT, (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7)));
            return new FlowBuilder2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<O1, R1, R2> awaitApply2(FN28<R1, R2, T1, T2, T3, T4, T5, T6, T7, T8> function, FN21<R1, R2, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7)), handler::apply);
            return new FlowBuilder2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<O1, R1, R2, R3> apply3(FN38<R1, R2, R3, T1, T2, T3, T4, T5, T6, T7, T8> function) {
            step = new Step<>(StepType.SYNC, (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7)));
            return new FlowBuilder3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<O1, R1, R2, R3> apply3(FN38<R1, R2, R3, T1, T2, T3, T4, T5, T6, T7, T8> function, FN31<R1, R2, R3, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7)), handler::apply);
            return new FlowBuilder3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<O1, R1, R2, R3> asyncApply3(FN38<R1, R2, R3, T1, T2, T3, T4, T5, T6, T7, T8> function) {
            step = new Step<>(StepType.ASYNC, (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7)));
            return new FlowBuilder3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<O1, R1, R2, R3> asyncApply3(FN38<R1, R2, R3, T1, T2, T3, T4, T5, T6, T7, T8> function, FN31<R1, R2, R3, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7)), handler::apply);
            return new FlowBuilder3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<O1, R1, R2, R3> awaitApply3(FN38<R1, R2, R3, T1, T2, T3, T4, T5, T6, T7, T8> function) {
            step = new Step<>(StepType.AWAIT, (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7)));
            return new FlowBuilder3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<O1, R1, R2, R3> awaitApply3(FN38<R1, R2, R3, T1, T2, T3, T4, T5, T6, T7, T8> function, FN31<R1, R2, R3, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7)), handler::apply);
            return new FlowBuilder3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<O1, R1, R2, R3, R4> apply4(FN48<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6, T7, T8> function) {
            step = new Step<>(StepType.SYNC, (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7)));
            return new FlowBuilder4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<O1, R1, R2, R3, R4> apply4(FN48<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6, T7, T8> function, FN41<R1, R2, R3, R4, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7)), handler::apply);
            return new FlowBuilder4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<O1, R1, R2, R3, R4> asyncApply4(FN48<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6, T7, T8> function) {
            step = new Step<>(StepType.ASYNC, (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7)));
            return new FlowBuilder4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<O1, R1, R2, R3, R4> asyncApply4(FN48<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6, T7, T8> function, FN41<R1, R2, R3, R4, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7)), handler::apply);
            return new FlowBuilder4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<O1, R1, R2, R3, R4> awaitApply4(FN48<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6, T7, T8> function) {
            step = new Step<>(StepType.AWAIT, (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7)));
            return new FlowBuilder4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<O1, R1, R2, R3, R4> awaitApply4(FN48<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6, T7, T8> function, FN41<R1, R2, R3, R4, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7)), handler::apply);
            return new FlowBuilder4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<O1, R1, R2, R3, R4, R5> apply5(FN58<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6, T7, T8> function) {
            step = new Step<>(StepType.SYNC, (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7)));
            return new FlowBuilder5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<O1, R1, R2, R3, R4, R5> apply5(FN58<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6, T7, T8> function, FN51<R1, R2, R3, R4, R5, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7)), handler::apply);
            return new FlowBuilder5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<O1, R1, R2, R3, R4, R5> asyncApply5(FN58<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6, T7, T8> function) {
            step = new Step<>(StepType.ASYNC, (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7)));
            return new FlowBuilder5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<O1, R1, R2, R3, R4, R5> asyncApply5(FN58<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6, T7, T8> function, FN51<R1, R2, R3, R4, R5, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7)), handler::apply);
            return new FlowBuilder5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<O1, R1, R2, R3, R4, R5> awaitApply5(FN58<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6, T7, T8> function) {
            step = new Step<>(StepType.AWAIT, (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7)));
            return new FlowBuilder5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<O1, R1, R2, R3, R4, R5> awaitApply5(FN58<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6, T7, T8> function, FN51<R1, R2, R3, R4, R5, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7)), handler::apply);
            return new FlowBuilder5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<O1, R1, R2, R3, R4, R5, R6> apply6(FN68<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6, T7, T8> function) {
            step = new Step<>(StepType.SYNC, (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7)));
            return new FlowBuilder6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<O1, R1, R2, R3, R4, R5, R6> apply6(FN68<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6, T7, T8> function, FN61<R1, R2, R3, R4, R5, R6, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7)), handler::apply);
            return new FlowBuilder6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<O1, R1, R2, R3, R4, R5, R6> asyncApply6(FN68<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6, T7, T8> function) {
            step = new Step<>(StepType.ASYNC, (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7)));
            return new FlowBuilder6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<O1, R1, R2, R3, R4, R5, R6> asyncApply6(FN68<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6, T7, T8> function, FN61<R1, R2, R3, R4, R5, R6, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7)), handler::apply);
            return new FlowBuilder6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<O1, R1, R2, R3, R4, R5, R6> awaitApply6(FN68<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6, T7, T8> function) {
            step = new Step<>(StepType.AWAIT, (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7)));
            return new FlowBuilder6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<O1, R1, R2, R3, R4, R5, R6> awaitApply6(FN68<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6, T7, T8> function, FN61<R1, R2, R3, R4, R5, R6, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7)), handler::apply);
            return new FlowBuilder6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<O1, R1, R2, R3, R4, R5, R6, R7> apply7(FN78<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6, T7, T8> function) {
            step = new Step<>(StepType.SYNC, (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7)));
            return new FlowBuilder7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<O1, R1, R2, R3, R4, R5, R6, R7> apply7(FN78<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6, T7, T8> function, FN71<R1, R2, R3, R4, R5, R6, R7, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7)), handler::apply);
            return new FlowBuilder7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<O1, R1, R2, R3, R4, R5, R6, R7> asyncApply7(FN78<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6, T7, T8> function) {
            step = new Step<>(StepType.ASYNC, (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7)));
            return new FlowBuilder7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<O1, R1, R2, R3, R4, R5, R6, R7> asyncApply7(FN78<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6, T7, T8> function, FN71<R1, R2, R3, R4, R5, R6, R7, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7)), handler::apply);
            return new FlowBuilder7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<O1, R1, R2, R3, R4, R5, R6, R7> awaitApply7(FN78<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6, T7, T8> function) {
            step = new Step<>(StepType.AWAIT, (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7)));
            return new FlowBuilder7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<O1, R1, R2, R3, R4, R5, R6, R7> awaitApply7(FN78<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6, T7, T8> function, FN71<R1, R2, R3, R4, R5, R6, R7, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7)), handler::apply);
            return new FlowBuilder7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<O1, R1, R2, R3, R4, R5, R6, R7, R8> apply8(FN88<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5, T6, T7, T8> function) {
            step = new Step<>(StepType.SYNC, (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7)));
            return new FlowBuilder8<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<O1, R1, R2, R3, R4, R5, R6, R7, R8> apply8(FN88<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5, T6, T7, T8> function, FN81<R1, R2, R3, R4, R5, R6, R7, R8, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7)), handler::apply);
            return new FlowBuilder8<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<O1, R1, R2, R3, R4, R5, R6, R7, R8> asyncApply8(FN88<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5, T6, T7, T8> function) {
            step = new Step<>(StepType.ASYNC, (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7)));
            return new FlowBuilder8<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<O1, R1, R2, R3, R4, R5, R6, R7, R8> asyncApply8(FN88<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5, T6, T7, T8> function, FN81<R1, R2, R3, R4, R5, R6, R7, R8, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7)), handler::apply);
            return new FlowBuilder8<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<O1, R1, R2, R3, R4, R5, R6, R7, R8> awaitApply8(FN88<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5, T6, T7, T8> function) {
            step = new Step<>(StepType.AWAIT, (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7)));
            return new FlowBuilder8<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<O1, R1, R2, R3, R4, R5, R6, R7, R8> awaitApply8(FN88<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5, T6, T7, T8> function, FN81<R1, R2, R3, R4, R5, R6, R7, R8, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7)), handler::apply);
            return new FlowBuilder8<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<O1, R1, R2, R3, R4, R5, R6, R7, R8, R9> apply9(FN98<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5, T6, T7, T8> function) {
            step = new Step<>(StepType.SYNC, (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7)));
            return new FlowBuilder9<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<O1, R1, R2, R3, R4, R5, R6, R7, R8, R9> apply9(FN98<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5, T6, T7, T8> function, FN91<R1, R2, R3, R4, R5, R6, R7, R8, R9, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7)), handler::apply);
            return new FlowBuilder9<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<O1, R1, R2, R3, R4, R5, R6, R7, R8, R9> asyncApply9(FN98<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5, T6, T7, T8> function) {
            step = new Step<>(StepType.ASYNC, (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7)));
            return new FlowBuilder9<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<O1, R1, R2, R3, R4, R5, R6, R7, R8, R9> asyncApply9(FN98<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5, T6, T7, T8> function, FN91<R1, R2, R3, R4, R5, R6, R7, R8, R9, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7)), handler::apply);
            return new FlowBuilder9<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<O1, R1, R2, R3, R4, R5, R6, R7, R8, R9> awaitApply9(FN98<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5, T6, T7, T8> function) {
            step = new Step<>(StepType.AWAIT, (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7)));
            return new FlowBuilder9<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<O1, R1, R2, R3, R4, R5, R6, R7, R8, R9> awaitApply9(FN98<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5, T6, T7, T8> function, FN91<R1, R2, R3, R4, R5, R6, R7, R8, R9, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7)), handler::apply);
            return new FlowBuilder9<>(this);
        }
    }

    public static class FlowBuilder9<O1 extends Tuple, T1, T2, T3, T4, T5, T6, T7, T8, T9> extends FlowBuilder8<O1, T1, T2, T3, T4, T5, T6, T7, T8> {
        public FlowBuilder9(FlowBuilder0<O1> prev) {
            super(prev);
        }

        @SuppressWarnings("unchecked")
        public Flow<O1, Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>> build() {
            return Flow.of(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<O1, R1> apply1(FN19<R1, T1, T2, T3, T4, T5, T6, T7, T8, T9> function) {
            step = new Step<>(StepType.SYNC, (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8)));
            return new FlowBuilder1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<O1, R1> apply1(FN19<R1, T1, T2, T3, T4, T5, T6, T7, T8, T9> function, FN11<R1, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8)), handler::apply);
            return new FlowBuilder1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<O1, R1> asyncApply1(FN19<R1, T1, T2, T3, T4, T5, T6, T7, T8, T9> function) {
            step = new Step<>(StepType.ASYNC, (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8)));
            return new FlowBuilder1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<O1, R1> asyncApply1(FN19<R1, T1, T2, T3, T4, T5, T6, T7, T8, T9> function, FN11<R1, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8)), handler::apply);
            return new FlowBuilder1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<O1, R1> awaitApply1(FN19<R1, T1, T2, T3, T4, T5, T6, T7, T8, T9> function) {
            step = new Step<>(StepType.AWAIT, (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8)));
            return new FlowBuilder1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<O1, R1> awaitApply1(FN19<R1, T1, T2, T3, T4, T5, T6, T7, T8, T9> function, FN11<R1, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8)), handler::apply);
            return new FlowBuilder1<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<O1, R1, R2> apply2(FN29<R1, R2, T1, T2, T3, T4, T5, T6, T7, T8, T9> function) {
            step = new Step<>(StepType.SYNC, (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8)));
            return new FlowBuilder2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<O1, R1, R2> apply2(FN29<R1, R2, T1, T2, T3, T4, T5, T6, T7, T8, T9> function, FN21<R1, R2, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8)), handler::apply);
            return new FlowBuilder2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<O1, R1, R2> asyncApply2(FN29<R1, R2, T1, T2, T3, T4, T5, T6, T7, T8, T9> function) {
            step = new Step<>(StepType.ASYNC, (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8)));
            return new FlowBuilder2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<O1, R1, R2> asyncApply2(FN29<R1, R2, T1, T2, T3, T4, T5, T6, T7, T8, T9> function, FN21<R1, R2, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8)), handler::apply);
            return new FlowBuilder2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<O1, R1, R2> awaitApply2(FN29<R1, R2, T1, T2, T3, T4, T5, T6, T7, T8, T9> function) {
            step = new Step<>(StepType.AWAIT, (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8)));
            return new FlowBuilder2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<O1, R1, R2> awaitApply2(FN29<R1, R2, T1, T2, T3, T4, T5, T6, T7, T8, T9> function, FN21<R1, R2, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8)), handler::apply);
            return new FlowBuilder2<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<O1, R1, R2, R3> apply3(FN39<R1, R2, R3, T1, T2, T3, T4, T5, T6, T7, T8, T9> function) {
            step = new Step<>(StepType.SYNC, (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8)));
            return new FlowBuilder3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<O1, R1, R2, R3> apply3(FN39<R1, R2, R3, T1, T2, T3, T4, T5, T6, T7, T8, T9> function, FN31<R1, R2, R3, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8)), handler::apply);
            return new FlowBuilder3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<O1, R1, R2, R3> asyncApply3(FN39<R1, R2, R3, T1, T2, T3, T4, T5, T6, T7, T8, T9> function) {
            step = new Step<>(StepType.ASYNC, (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8)));
            return new FlowBuilder3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<O1, R1, R2, R3> asyncApply3(FN39<R1, R2, R3, T1, T2, T3, T4, T5, T6, T7, T8, T9> function, FN31<R1, R2, R3, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8)), handler::apply);
            return new FlowBuilder3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<O1, R1, R2, R3> awaitApply3(FN39<R1, R2, R3, T1, T2, T3, T4, T5, T6, T7, T8, T9> function) {
            step = new Step<>(StepType.AWAIT, (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8)));
            return new FlowBuilder3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<O1, R1, R2, R3> awaitApply3(FN39<R1, R2, R3, T1, T2, T3, T4, T5, T6, T7, T8, T9> function, FN31<R1, R2, R3, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8)), handler::apply);
            return new FlowBuilder3<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<O1, R1, R2, R3, R4> apply4(FN49<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6, T7, T8, T9> function) {
            step = new Step<>(StepType.SYNC, (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8)));
            return new FlowBuilder4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<O1, R1, R2, R3, R4> apply4(FN49<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6, T7, T8, T9> function, FN41<R1, R2, R3, R4, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8)), handler::apply);
            return new FlowBuilder4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<O1, R1, R2, R3, R4> asyncApply4(FN49<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6, T7, T8, T9> function) {
            step = new Step<>(StepType.ASYNC, (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8)));
            return new FlowBuilder4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<O1, R1, R2, R3, R4> asyncApply4(FN49<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6, T7, T8, T9> function, FN41<R1, R2, R3, R4, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8)), handler::apply);
            return new FlowBuilder4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<O1, R1, R2, R3, R4> awaitApply4(FN49<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6, T7, T8, T9> function) {
            step = new Step<>(StepType.AWAIT, (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8)));
            return new FlowBuilder4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<O1, R1, R2, R3, R4> awaitApply4(FN49<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6, T7, T8, T9> function, FN41<R1, R2, R3, R4, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8)), handler::apply);
            return new FlowBuilder4<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<O1, R1, R2, R3, R4, R5> apply5(FN59<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6, T7, T8, T9> function) {
            step = new Step<>(StepType.SYNC, (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8)));
            return new FlowBuilder5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<O1, R1, R2, R3, R4, R5> apply5(FN59<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6, T7, T8, T9> function, FN51<R1, R2, R3, R4, R5, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8)), handler::apply);
            return new FlowBuilder5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<O1, R1, R2, R3, R4, R5> asyncApply5(FN59<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6, T7, T8, T9> function) {
            step = new Step<>(StepType.ASYNC, (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8)));
            return new FlowBuilder5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<O1, R1, R2, R3, R4, R5> asyncApply5(FN59<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6, T7, T8, T9> function, FN51<R1, R2, R3, R4, R5, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8)), handler::apply);
            return new FlowBuilder5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<O1, R1, R2, R3, R4, R5> awaitApply5(FN59<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6, T7, T8, T9> function) {
            step = new Step<>(StepType.AWAIT, (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8)));
            return new FlowBuilder5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<O1, R1, R2, R3, R4, R5> awaitApply5(FN59<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6, T7, T8, T9> function, FN51<R1, R2, R3, R4, R5, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8)), handler::apply);
            return new FlowBuilder5<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<O1, R1, R2, R3, R4, R5, R6> apply6(FN69<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6, T7, T8, T9> function) {
            step = new Step<>(StepType.SYNC, (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8)));
            return new FlowBuilder6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<O1, R1, R2, R3, R4, R5, R6> apply6(FN69<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6, T7, T8, T9> function, FN61<R1, R2, R3, R4, R5, R6, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8)), handler::apply);
            return new FlowBuilder6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<O1, R1, R2, R3, R4, R5, R6> asyncApply6(FN69<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6, T7, T8, T9> function) {
            step = new Step<>(StepType.ASYNC, (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8)));
            return new FlowBuilder6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<O1, R1, R2, R3, R4, R5, R6> asyncApply6(FN69<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6, T7, T8, T9> function, FN61<R1, R2, R3, R4, R5, R6, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8)), handler::apply);
            return new FlowBuilder6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<O1, R1, R2, R3, R4, R5, R6> awaitApply6(FN69<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6, T7, T8, T9> function) {
            step = new Step<>(StepType.AWAIT, (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8)));
            return new FlowBuilder6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<O1, R1, R2, R3, R4, R5, R6> awaitApply6(FN69<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6, T7, T8, T9> function, FN61<R1, R2, R3, R4, R5, R6, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8)), handler::apply);
            return new FlowBuilder6<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<O1, R1, R2, R3, R4, R5, R6, R7> apply7(FN79<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6, T7, T8, T9> function) {
            step = new Step<>(StepType.SYNC, (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8)));
            return new FlowBuilder7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<O1, R1, R2, R3, R4, R5, R6, R7> apply7(FN79<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6, T7, T8, T9> function, FN71<R1, R2, R3, R4, R5, R6, R7, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8)), handler::apply);
            return new FlowBuilder7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<O1, R1, R2, R3, R4, R5, R6, R7> asyncApply7(FN79<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6, T7, T8, T9> function) {
            step = new Step<>(StepType.ASYNC, (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8)));
            return new FlowBuilder7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<O1, R1, R2, R3, R4, R5, R6, R7> asyncApply7(FN79<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6, T7, T8, T9> function, FN71<R1, R2, R3, R4, R5, R6, R7, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8)), handler::apply);
            return new FlowBuilder7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<O1, R1, R2, R3, R4, R5, R6, R7> awaitApply7(FN79<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6, T7, T8, T9> function) {
            step = new Step<>(StepType.AWAIT, (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8)));
            return new FlowBuilder7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<O1, R1, R2, R3, R4, R5, R6, R7> awaitApply7(FN79<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6, T7, T8, T9> function, FN71<R1, R2, R3, R4, R5, R6, R7, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8)), handler::apply);
            return new FlowBuilder7<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<O1, R1, R2, R3, R4, R5, R6, R7, R8> apply8(FN89<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5, T6, T7, T8, T9> function) {
            step = new Step<>(StepType.SYNC, (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8)));
            return new FlowBuilder8<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<O1, R1, R2, R3, R4, R5, R6, R7, R8> apply8(FN89<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5, T6, T7, T8, T9> function, FN81<R1, R2, R3, R4, R5, R6, R7, R8, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8)), handler::apply);
            return new FlowBuilder8<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<O1, R1, R2, R3, R4, R5, R6, R7, R8> asyncApply8(FN89<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5, T6, T7, T8, T9> function) {
            step = new Step<>(StepType.ASYNC, (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8)));
            return new FlowBuilder8<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<O1, R1, R2, R3, R4, R5, R6, R7, R8> asyncApply8(FN89<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5, T6, T7, T8, T9> function, FN81<R1, R2, R3, R4, R5, R6, R7, R8, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8)), handler::apply);
            return new FlowBuilder8<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<O1, R1, R2, R3, R4, R5, R6, R7, R8> awaitApply8(FN89<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5, T6, T7, T8, T9> function) {
            step = new Step<>(StepType.AWAIT, (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8)));
            return new FlowBuilder8<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<O1, R1, R2, R3, R4, R5, R6, R7, R8> awaitApply8(FN89<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5, T6, T7, T8, T9> function, FN81<R1, R2, R3, R4, R5, R6, R7, R8, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8)), handler::apply);
            return new FlowBuilder8<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<O1, R1, R2, R3, R4, R5, R6, R7, R8, R9> apply9(FN99<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5, T6, T7, T8, T9> function) {
            step = new Step<>(StepType.SYNC, (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8)));
            return new FlowBuilder9<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<O1, R1, R2, R3, R4, R5, R6, R7, R8, R9> apply9(FN99<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5, T6, T7, T8, T9> function, FN91<R1, R2, R3, R4, R5, R6, R7, R8, R9, Throwable> handler) {
            step = new Step<>(StepType.SYNC, (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8)), handler::apply);
            return new FlowBuilder9<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<O1, R1, R2, R3, R4, R5, R6, R7, R8, R9> asyncApply9(FN99<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5, T6, T7, T8, T9> function) {
            step = new Step<>(StepType.ASYNC, (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8)));
            return new FlowBuilder9<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<O1, R1, R2, R3, R4, R5, R6, R7, R8, R9> asyncApply9(FN99<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5, T6, T7, T8, T9> function, FN91<R1, R2, R3, R4, R5, R6, R7, R8, R9, Throwable> handler) {
            step = new Step<>(StepType.ASYNC, (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8)), handler::apply);
            return new FlowBuilder9<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<O1, R1, R2, R3, R4, R5, R6, R7, R8, R9> awaitApply9(FN99<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5, T6, T7, T8, T9> function) {
            step = new Step<>(StepType.AWAIT, (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8)));
            return new FlowBuilder9<>(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<O1, R1, R2, R3, R4, R5, R6, R7, R8, R9> awaitApply9(FN99<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5, T6, T7, T8, T9> function, FN91<R1, R2, R3, R4, R5, R6, R7, R8, R9, Throwable> handler) {
            step = new Step<>(StepType.AWAIT, (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> function.apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8)), handler::apply);
            return new FlowBuilder9<>(this);
        }
    }
}
