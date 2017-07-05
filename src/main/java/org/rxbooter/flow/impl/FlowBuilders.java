package org.rxbooter.flow.impl;

// WARNING: Generated file, do not edit, all changes will be lost.

import org.rxbooter.flow.ExecutionType;
import org.rxbooter.flow.Flow;
import org.rxbooter.flow.Step;

import java.util.function.Consumer;

import static org.rxbooter.flow.Functions.*;
import static org.rxbooter.flow.Step.EH;
import static org.rxbooter.flow.Step.TF;
import static org.rxbooter.flow.Tuples.*;

public final class FlowBuilders {
    private FlowBuilders() {}

    /** I1 - holds original input tuple. */
    public static class FlowBuilder0<I1 extends Tuple> {
        private final FlowBuilder0<I1> prev;
        Step<?, ?> step;

        FlowBuilder0(FlowBuilder0<I1> prev) {
            this.prev = prev;
        }

        public void apply(Consumer<Step<?, ?>> consumer) {
            if (prev != null) {
                prev.apply(consumer);
            }

            if (step != null) {
                consumer.accept(step);
            }
        }

        public<R, T> FlowBuilder0<I1> step(ExecutionType type, TF<R, T> function, EH<R> handler) {
            this.step = Step.of(type, function, handler);
            return this;
        }
    }

    public static class FlowBuilder1<I1 extends Tuple, T1> extends FlowBuilder0<I1> {
        private ExecutionType type = ExecutionType.SYNC;

        public FlowBuilder1(FlowBuilder0<I1> prev) {
            super(prev);
        }

        public FlowBuilder1<I1, T1> async() {
            type = ExecutionType.ASYNC;
            return this;
        }

        public FlowBuilder1<I1, T1> await() {
            type = ExecutionType.AWAIT;
            return this;
        }

        @SuppressWarnings("unchecked")
        public Flow<Tuple1<T1>, I1> done() {
            return Flow.of(this);
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<I1, R1> map(FN11<R1, T1> function) {
            return new FlowBuilder1<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<I1, R1> map(FN11<R1, T1> function, EH<Tuple1<R1>> handler) {
            return new FlowBuilder1<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<I1, R1, R2> mapTo2(FN12<R1, R2, T1> function) {
            return new FlowBuilder2<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<I1, R1, R2> mapTo2(FN12<R1, R2, T1> function, EH<Tuple2<R1, R2>> handler) {
            return new FlowBuilder2<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<I1, R1, R2, R3> mapTo3(FN13<R1, R2, R3, T1> function) {
            return new FlowBuilder3<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<I1, R1, R2, R3> mapTo3(FN13<R1, R2, R3, T1> function, EH<Tuple3<R1, R2, R3>> handler) {
            return new FlowBuilder3<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<I1, R1, R2, R3, R4> mapTo4(FN14<R1, R2, R3, R4, T1> function) {
            return new FlowBuilder4<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<I1, R1, R2, R3, R4> mapTo4(FN14<R1, R2, R3, R4, T1> function, EH<Tuple4<R1, R2, R3, R4>> handler) {
            return new FlowBuilder4<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<I1, R1, R2, R3, R4, R5> mapTo5(FN15<R1, R2, R3, R4, R5, T1> function) {
            return new FlowBuilder5<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<I1, R1, R2, R3, R4, R5> mapTo5(FN15<R1, R2, R3, R4, R5, T1> function, EH<Tuple5<R1, R2, R3, R4, R5>> handler) {
            return new FlowBuilder5<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<I1, R1, R2, R3, R4, R5, R6> mapTo6(FN16<R1, R2, R3, R4, R5, R6, T1> function) {
            return new FlowBuilder6<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<I1, R1, R2, R3, R4, R5, R6> mapTo6(FN16<R1, R2, R3, R4, R5, R6, T1> function, EH<Tuple6<R1, R2, R3, R4, R5, R6>> handler) {
            return new FlowBuilder6<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<I1, R1, R2, R3, R4, R5, R6, R7> mapTo7(FN17<R1, R2, R3, R4, R5, R6, R7, T1> function) {
            return new FlowBuilder7<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<I1, R1, R2, R3, R4, R5, R6, R7> mapTo7(FN17<R1, R2, R3, R4, R5, R6, R7, T1> function, EH<Tuple7<R1, R2, R3, R4, R5, R6, R7>> handler) {
            return new FlowBuilder7<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<I1, R1, R2, R3, R4, R5, R6, R7, R8> mapTo8(FN18<R1, R2, R3, R4, R5, R6, R7, R8, T1> function) {
            return new FlowBuilder8<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<I1, R1, R2, R3, R4, R5, R6, R7, R8> mapTo8(FN18<R1, R2, R3, R4, R5, R6, R7, R8, T1> function, EH<Tuple8<R1, R2, R3, R4, R5, R6, R7, R8>> handler) {
            return new FlowBuilder8<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<I1, R1, R2, R3, R4, R5, R6, R7, R8, R9> mapTo9(FN19<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1> function) {
            return new FlowBuilder9<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<I1, R1, R2, R3, R4, R5, R6, R7, R8, R9> mapTo9(FN19<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1> function, EH<Tuple9<R1, R2, R3, R4, R5, R6, R7, R8, R9>> handler) {
            return new FlowBuilder9<>(step(type, function.asStepFunction(), handler));
        }
    }

    public static class FlowBuilder2<I1 extends Tuple, T1, T2> extends FlowBuilder0<I1> {
        private ExecutionType type = ExecutionType.SYNC;

        public FlowBuilder2(FlowBuilder0<I1> prev) {
            super(prev);
        }

        public FlowBuilder2<I1, T1, T2> async() {
            type = ExecutionType.ASYNC;
            return this;
        }

        public FlowBuilder2<I1, T1, T2> await() {
            type = ExecutionType.AWAIT;
            return this;
        }

        @SuppressWarnings("unchecked")
        public Flow<Tuple2<T1, T2>, I1> done() {
            return Flow.of(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<I1, R1, R2> map(FN22<R1, R2, T1, T2> function) {
            return new FlowBuilder2<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<I1, R1, R2> map(FN22<R1, R2, T1, T2> function, EH<Tuple2<R1, R2>> handler) {
            return new FlowBuilder2<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<I1, R1> mapTo1(FN21<R1, T1, T2> function) {
            return new FlowBuilder1<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<I1, R1> mapTo1(FN21<R1, T1, T2> function, EH<Tuple1<R1>> handler) {
            return new FlowBuilder1<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<I1, R1, R2, R3> mapTo3(FN23<R1, R2, R3, T1, T2> function) {
            return new FlowBuilder3<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<I1, R1, R2, R3> mapTo3(FN23<R1, R2, R3, T1, T2> function, EH<Tuple3<R1, R2, R3>> handler) {
            return new FlowBuilder3<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<I1, R1, R2, R3, R4> mapTo4(FN24<R1, R2, R3, R4, T1, T2> function) {
            return new FlowBuilder4<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<I1, R1, R2, R3, R4> mapTo4(FN24<R1, R2, R3, R4, T1, T2> function, EH<Tuple4<R1, R2, R3, R4>> handler) {
            return new FlowBuilder4<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<I1, R1, R2, R3, R4, R5> mapTo5(FN25<R1, R2, R3, R4, R5, T1, T2> function) {
            return new FlowBuilder5<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<I1, R1, R2, R3, R4, R5> mapTo5(FN25<R1, R2, R3, R4, R5, T1, T2> function, EH<Tuple5<R1, R2, R3, R4, R5>> handler) {
            return new FlowBuilder5<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<I1, R1, R2, R3, R4, R5, R6> mapTo6(FN26<R1, R2, R3, R4, R5, R6, T1, T2> function) {
            return new FlowBuilder6<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<I1, R1, R2, R3, R4, R5, R6> mapTo6(FN26<R1, R2, R3, R4, R5, R6, T1, T2> function, EH<Tuple6<R1, R2, R3, R4, R5, R6>> handler) {
            return new FlowBuilder6<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<I1, R1, R2, R3, R4, R5, R6, R7> mapTo7(FN27<R1, R2, R3, R4, R5, R6, R7, T1, T2> function) {
            return new FlowBuilder7<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<I1, R1, R2, R3, R4, R5, R6, R7> mapTo7(FN27<R1, R2, R3, R4, R5, R6, R7, T1, T2> function, EH<Tuple7<R1, R2, R3, R4, R5, R6, R7>> handler) {
            return new FlowBuilder7<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<I1, R1, R2, R3, R4, R5, R6, R7, R8> mapTo8(FN28<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2> function) {
            return new FlowBuilder8<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<I1, R1, R2, R3, R4, R5, R6, R7, R8> mapTo8(FN28<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2> function, EH<Tuple8<R1, R2, R3, R4, R5, R6, R7, R8>> handler) {
            return new FlowBuilder8<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<I1, R1, R2, R3, R4, R5, R6, R7, R8, R9> mapTo9(FN29<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2> function) {
            return new FlowBuilder9<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<I1, R1, R2, R3, R4, R5, R6, R7, R8, R9> mapTo9(FN29<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2> function, EH<Tuple9<R1, R2, R3, R4, R5, R6, R7, R8, R9>> handler) {
            return new FlowBuilder9<>(step(type, function.asStepFunction(), handler));
        }
    }

    public static class FlowBuilder3<I1 extends Tuple, T1, T2, T3> extends FlowBuilder0<I1> {
        private ExecutionType type = ExecutionType.SYNC;

        public FlowBuilder3(FlowBuilder0<I1> prev) {
            super(prev);
        }

        public FlowBuilder3<I1, T1, T2, T3> async() {
            type = ExecutionType.ASYNC;
            return this;
        }

        public FlowBuilder3<I1, T1, T2, T3> await() {
            type = ExecutionType.AWAIT;
            return this;
        }

        @SuppressWarnings("unchecked")
        public Flow<Tuple3<T1, T2, T3>, I1> done() {
            return Flow.of(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<I1, R1, R2, R3> map(FN33<R1, R2, R3, T1, T2, T3> function) {
            return new FlowBuilder3<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<I1, R1, R2, R3> map(FN33<R1, R2, R3, T1, T2, T3> function, EH<Tuple3<R1, R2, R3>> handler) {
            return new FlowBuilder3<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<I1, R1> mapTo1(FN31<R1, T1, T2, T3> function) {
            return new FlowBuilder1<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<I1, R1> mapTo1(FN31<R1, T1, T2, T3> function, EH<Tuple1<R1>> handler) {
            return new FlowBuilder1<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<I1, R1, R2> mapTo2(FN32<R1, R2, T1, T2, T3> function) {
            return new FlowBuilder2<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<I1, R1, R2> mapTo2(FN32<R1, R2, T1, T2, T3> function, EH<Tuple2<R1, R2>> handler) {
            return new FlowBuilder2<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<I1, R1, R2, R3, R4> mapTo4(FN34<R1, R2, R3, R4, T1, T2, T3> function) {
            return new FlowBuilder4<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<I1, R1, R2, R3, R4> mapTo4(FN34<R1, R2, R3, R4, T1, T2, T3> function, EH<Tuple4<R1, R2, R3, R4>> handler) {
            return new FlowBuilder4<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<I1, R1, R2, R3, R4, R5> mapTo5(FN35<R1, R2, R3, R4, R5, T1, T2, T3> function) {
            return new FlowBuilder5<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<I1, R1, R2, R3, R4, R5> mapTo5(FN35<R1, R2, R3, R4, R5, T1, T2, T3> function, EH<Tuple5<R1, R2, R3, R4, R5>> handler) {
            return new FlowBuilder5<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<I1, R1, R2, R3, R4, R5, R6> mapTo6(FN36<R1, R2, R3, R4, R5, R6, T1, T2, T3> function) {
            return new FlowBuilder6<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<I1, R1, R2, R3, R4, R5, R6> mapTo6(FN36<R1, R2, R3, R4, R5, R6, T1, T2, T3> function, EH<Tuple6<R1, R2, R3, R4, R5, R6>> handler) {
            return new FlowBuilder6<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<I1, R1, R2, R3, R4, R5, R6, R7> mapTo7(FN37<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3> function) {
            return new FlowBuilder7<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<I1, R1, R2, R3, R4, R5, R6, R7> mapTo7(FN37<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3> function, EH<Tuple7<R1, R2, R3, R4, R5, R6, R7>> handler) {
            return new FlowBuilder7<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<I1, R1, R2, R3, R4, R5, R6, R7, R8> mapTo8(FN38<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3> function) {
            return new FlowBuilder8<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<I1, R1, R2, R3, R4, R5, R6, R7, R8> mapTo8(FN38<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3> function, EH<Tuple8<R1, R2, R3, R4, R5, R6, R7, R8>> handler) {
            return new FlowBuilder8<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<I1, R1, R2, R3, R4, R5, R6, R7, R8, R9> mapTo9(FN39<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3> function) {
            return new FlowBuilder9<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<I1, R1, R2, R3, R4, R5, R6, R7, R8, R9> mapTo9(FN39<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3> function, EH<Tuple9<R1, R2, R3, R4, R5, R6, R7, R8, R9>> handler) {
            return new FlowBuilder9<>(step(type, function.asStepFunction(), handler));
        }
    }

    public static class FlowBuilder4<I1 extends Tuple, T1, T2, T3, T4> extends FlowBuilder0<I1> {
        private ExecutionType type = ExecutionType.SYNC;

        public FlowBuilder4(FlowBuilder0<I1> prev) {
            super(prev);
        }

        public FlowBuilder4<I1, T1, T2, T3, T4> async() {
            type = ExecutionType.ASYNC;
            return this;
        }

        public FlowBuilder4<I1, T1, T2, T3, T4> await() {
            type = ExecutionType.AWAIT;
            return this;
        }

        @SuppressWarnings("unchecked")
        public Flow<Tuple4<T1, T2, T3, T4>, I1> done() {
            return Flow.of(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<I1, R1, R2, R3, R4> map(FN44<R1, R2, R3, R4, T1, T2, T3, T4> function) {
            return new FlowBuilder4<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<I1, R1, R2, R3, R4> map(FN44<R1, R2, R3, R4, T1, T2, T3, T4> function, EH<Tuple4<R1, R2, R3, R4>> handler) {
            return new FlowBuilder4<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<I1, R1> mapTo1(FN41<R1, T1, T2, T3, T4> function) {
            return new FlowBuilder1<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<I1, R1> mapTo1(FN41<R1, T1, T2, T3, T4> function, EH<Tuple1<R1>> handler) {
            return new FlowBuilder1<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<I1, R1, R2> mapTo2(FN42<R1, R2, T1, T2, T3, T4> function) {
            return new FlowBuilder2<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<I1, R1, R2> mapTo2(FN42<R1, R2, T1, T2, T3, T4> function, EH<Tuple2<R1, R2>> handler) {
            return new FlowBuilder2<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<I1, R1, R2, R3> mapTo3(FN43<R1, R2, R3, T1, T2, T3, T4> function) {
            return new FlowBuilder3<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<I1, R1, R2, R3> mapTo3(FN43<R1, R2, R3, T1, T2, T3, T4> function, EH<Tuple3<R1, R2, R3>> handler) {
            return new FlowBuilder3<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<I1, R1, R2, R3, R4, R5> mapTo5(FN45<R1, R2, R3, R4, R5, T1, T2, T3, T4> function) {
            return new FlowBuilder5<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<I1, R1, R2, R3, R4, R5> mapTo5(FN45<R1, R2, R3, R4, R5, T1, T2, T3, T4> function, EH<Tuple5<R1, R2, R3, R4, R5>> handler) {
            return new FlowBuilder5<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<I1, R1, R2, R3, R4, R5, R6> mapTo6(FN46<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4> function) {
            return new FlowBuilder6<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<I1, R1, R2, R3, R4, R5, R6> mapTo6(FN46<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4> function, EH<Tuple6<R1, R2, R3, R4, R5, R6>> handler) {
            return new FlowBuilder6<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<I1, R1, R2, R3, R4, R5, R6, R7> mapTo7(FN47<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4> function) {
            return new FlowBuilder7<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<I1, R1, R2, R3, R4, R5, R6, R7> mapTo7(FN47<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4> function, EH<Tuple7<R1, R2, R3, R4, R5, R6, R7>> handler) {
            return new FlowBuilder7<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<I1, R1, R2, R3, R4, R5, R6, R7, R8> mapTo8(FN48<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4> function) {
            return new FlowBuilder8<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<I1, R1, R2, R3, R4, R5, R6, R7, R8> mapTo8(FN48<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4> function, EH<Tuple8<R1, R2, R3, R4, R5, R6, R7, R8>> handler) {
            return new FlowBuilder8<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<I1, R1, R2, R3, R4, R5, R6, R7, R8, R9> mapTo9(FN49<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4> function) {
            return new FlowBuilder9<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<I1, R1, R2, R3, R4, R5, R6, R7, R8, R9> mapTo9(FN49<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4> function, EH<Tuple9<R1, R2, R3, R4, R5, R6, R7, R8, R9>> handler) {
            return new FlowBuilder9<>(step(type, function.asStepFunction(), handler));
        }
    }

    public static class FlowBuilder5<I1 extends Tuple, T1, T2, T3, T4, T5> extends FlowBuilder0<I1> {
        private ExecutionType type = ExecutionType.SYNC;

        public FlowBuilder5(FlowBuilder0<I1> prev) {
            super(prev);
        }

        public FlowBuilder5<I1, T1, T2, T3, T4, T5> async() {
            type = ExecutionType.ASYNC;
            return this;
        }

        public FlowBuilder5<I1, T1, T2, T3, T4, T5> await() {
            type = ExecutionType.AWAIT;
            return this;
        }

        @SuppressWarnings("unchecked")
        public Flow<Tuple5<T1, T2, T3, T4, T5>, I1> done() {
            return Flow.of(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<I1, R1, R2, R3, R4, R5> map(FN55<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5> function) {
            return new FlowBuilder5<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<I1, R1, R2, R3, R4, R5> map(FN55<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5> function, EH<Tuple5<R1, R2, R3, R4, R5>> handler) {
            return new FlowBuilder5<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<I1, R1> mapTo1(FN51<R1, T1, T2, T3, T4, T5> function) {
            return new FlowBuilder1<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<I1, R1> mapTo1(FN51<R1, T1, T2, T3, T4, T5> function, EH<Tuple1<R1>> handler) {
            return new FlowBuilder1<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<I1, R1, R2> mapTo2(FN52<R1, R2, T1, T2, T3, T4, T5> function) {
            return new FlowBuilder2<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<I1, R1, R2> mapTo2(FN52<R1, R2, T1, T2, T3, T4, T5> function, EH<Tuple2<R1, R2>> handler) {
            return new FlowBuilder2<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<I1, R1, R2, R3> mapTo3(FN53<R1, R2, R3, T1, T2, T3, T4, T5> function) {
            return new FlowBuilder3<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<I1, R1, R2, R3> mapTo3(FN53<R1, R2, R3, T1, T2, T3, T4, T5> function, EH<Tuple3<R1, R2, R3>> handler) {
            return new FlowBuilder3<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<I1, R1, R2, R3, R4> mapTo4(FN54<R1, R2, R3, R4, T1, T2, T3, T4, T5> function) {
            return new FlowBuilder4<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<I1, R1, R2, R3, R4> mapTo4(FN54<R1, R2, R3, R4, T1, T2, T3, T4, T5> function, EH<Tuple4<R1, R2, R3, R4>> handler) {
            return new FlowBuilder4<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<I1, R1, R2, R3, R4, R5, R6> mapTo6(FN56<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5> function) {
            return new FlowBuilder6<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<I1, R1, R2, R3, R4, R5, R6> mapTo6(FN56<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5> function, EH<Tuple6<R1, R2, R3, R4, R5, R6>> handler) {
            return new FlowBuilder6<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<I1, R1, R2, R3, R4, R5, R6, R7> mapTo7(FN57<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5> function) {
            return new FlowBuilder7<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<I1, R1, R2, R3, R4, R5, R6, R7> mapTo7(FN57<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5> function, EH<Tuple7<R1, R2, R3, R4, R5, R6, R7>> handler) {
            return new FlowBuilder7<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<I1, R1, R2, R3, R4, R5, R6, R7, R8> mapTo8(FN58<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5> function) {
            return new FlowBuilder8<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<I1, R1, R2, R3, R4, R5, R6, R7, R8> mapTo8(FN58<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5> function, EH<Tuple8<R1, R2, R3, R4, R5, R6, R7, R8>> handler) {
            return new FlowBuilder8<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<I1, R1, R2, R3, R4, R5, R6, R7, R8, R9> mapTo9(FN59<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5> function) {
            return new FlowBuilder9<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<I1, R1, R2, R3, R4, R5, R6, R7, R8, R9> mapTo9(FN59<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5> function, EH<Tuple9<R1, R2, R3, R4, R5, R6, R7, R8, R9>> handler) {
            return new FlowBuilder9<>(step(type, function.asStepFunction(), handler));
        }
    }

    public static class FlowBuilder6<I1 extends Tuple, T1, T2, T3, T4, T5, T6> extends FlowBuilder0<I1> {
        private ExecutionType type = ExecutionType.SYNC;

        public FlowBuilder6(FlowBuilder0<I1> prev) {
            super(prev);
        }

        public FlowBuilder6<I1, T1, T2, T3, T4, T5, T6> async() {
            type = ExecutionType.ASYNC;
            return this;
        }

        public FlowBuilder6<I1, T1, T2, T3, T4, T5, T6> await() {
            type = ExecutionType.AWAIT;
            return this;
        }

        @SuppressWarnings("unchecked")
        public Flow<Tuple6<T1, T2, T3, T4, T5, T6>, I1> done() {
            return Flow.of(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<I1, R1, R2, R3, R4, R5, R6> map(FN66<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6> function) {
            return new FlowBuilder6<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<I1, R1, R2, R3, R4, R5, R6> map(FN66<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6> function, EH<Tuple6<R1, R2, R3, R4, R5, R6>> handler) {
            return new FlowBuilder6<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<I1, R1> mapTo1(FN61<R1, T1, T2, T3, T4, T5, T6> function) {
            return new FlowBuilder1<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<I1, R1> mapTo1(FN61<R1, T1, T2, T3, T4, T5, T6> function, EH<Tuple1<R1>> handler) {
            return new FlowBuilder1<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<I1, R1, R2> mapTo2(FN62<R1, R2, T1, T2, T3, T4, T5, T6> function) {
            return new FlowBuilder2<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<I1, R1, R2> mapTo2(FN62<R1, R2, T1, T2, T3, T4, T5, T6> function, EH<Tuple2<R1, R2>> handler) {
            return new FlowBuilder2<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<I1, R1, R2, R3> mapTo3(FN63<R1, R2, R3, T1, T2, T3, T4, T5, T6> function) {
            return new FlowBuilder3<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<I1, R1, R2, R3> mapTo3(FN63<R1, R2, R3, T1, T2, T3, T4, T5, T6> function, EH<Tuple3<R1, R2, R3>> handler) {
            return new FlowBuilder3<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<I1, R1, R2, R3, R4> mapTo4(FN64<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6> function) {
            return new FlowBuilder4<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<I1, R1, R2, R3, R4> mapTo4(FN64<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6> function, EH<Tuple4<R1, R2, R3, R4>> handler) {
            return new FlowBuilder4<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<I1, R1, R2, R3, R4, R5> mapTo5(FN65<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6> function) {
            return new FlowBuilder5<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<I1, R1, R2, R3, R4, R5> mapTo5(FN65<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6> function, EH<Tuple5<R1, R2, R3, R4, R5>> handler) {
            return new FlowBuilder5<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<I1, R1, R2, R3, R4, R5, R6, R7> mapTo7(FN67<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6> function) {
            return new FlowBuilder7<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<I1, R1, R2, R3, R4, R5, R6, R7> mapTo7(FN67<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6> function, EH<Tuple7<R1, R2, R3, R4, R5, R6, R7>> handler) {
            return new FlowBuilder7<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<I1, R1, R2, R3, R4, R5, R6, R7, R8> mapTo8(FN68<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5, T6> function) {
            return new FlowBuilder8<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<I1, R1, R2, R3, R4, R5, R6, R7, R8> mapTo8(FN68<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5, T6> function, EH<Tuple8<R1, R2, R3, R4, R5, R6, R7, R8>> handler) {
            return new FlowBuilder8<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<I1, R1, R2, R3, R4, R5, R6, R7, R8, R9> mapTo9(FN69<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5, T6> function) {
            return new FlowBuilder9<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<I1, R1, R2, R3, R4, R5, R6, R7, R8, R9> mapTo9(FN69<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5, T6> function, EH<Tuple9<R1, R2, R3, R4, R5, R6, R7, R8, R9>> handler) {
            return new FlowBuilder9<>(step(type, function.asStepFunction(), handler));
        }
    }

    public static class FlowBuilder7<I1 extends Tuple, T1, T2, T3, T4, T5, T6, T7> extends FlowBuilder0<I1> {
        private ExecutionType type = ExecutionType.SYNC;

        public FlowBuilder7(FlowBuilder0<I1> prev) {
            super(prev);
        }

        public FlowBuilder7<I1, T1, T2, T3, T4, T5, T6, T7> async() {
            type = ExecutionType.ASYNC;
            return this;
        }

        public FlowBuilder7<I1, T1, T2, T3, T4, T5, T6, T7> await() {
            type = ExecutionType.AWAIT;
            return this;
        }

        @SuppressWarnings("unchecked")
        public Flow<Tuple7<T1, T2, T3, T4, T5, T6, T7>, I1> done() {
            return Flow.of(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<I1, R1, R2, R3, R4, R5, R6, R7> map(FN77<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6, T7> function) {
            return new FlowBuilder7<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<I1, R1, R2, R3, R4, R5, R6, R7> map(FN77<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6, T7> function, EH<Tuple7<R1, R2, R3, R4, R5, R6, R7>> handler) {
            return new FlowBuilder7<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<I1, R1> mapTo1(FN71<R1, T1, T2, T3, T4, T5, T6, T7> function) {
            return new FlowBuilder1<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<I1, R1> mapTo1(FN71<R1, T1, T2, T3, T4, T5, T6, T7> function, EH<Tuple1<R1>> handler) {
            return new FlowBuilder1<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<I1, R1, R2> mapTo2(FN72<R1, R2, T1, T2, T3, T4, T5, T6, T7> function) {
            return new FlowBuilder2<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<I1, R1, R2> mapTo2(FN72<R1, R2, T1, T2, T3, T4, T5, T6, T7> function, EH<Tuple2<R1, R2>> handler) {
            return new FlowBuilder2<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<I1, R1, R2, R3> mapTo3(FN73<R1, R2, R3, T1, T2, T3, T4, T5, T6, T7> function) {
            return new FlowBuilder3<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<I1, R1, R2, R3> mapTo3(FN73<R1, R2, R3, T1, T2, T3, T4, T5, T6, T7> function, EH<Tuple3<R1, R2, R3>> handler) {
            return new FlowBuilder3<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<I1, R1, R2, R3, R4> mapTo4(FN74<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6, T7> function) {
            return new FlowBuilder4<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<I1, R1, R2, R3, R4> mapTo4(FN74<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6, T7> function, EH<Tuple4<R1, R2, R3, R4>> handler) {
            return new FlowBuilder4<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<I1, R1, R2, R3, R4, R5> mapTo5(FN75<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6, T7> function) {
            return new FlowBuilder5<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<I1, R1, R2, R3, R4, R5> mapTo5(FN75<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6, T7> function, EH<Tuple5<R1, R2, R3, R4, R5>> handler) {
            return new FlowBuilder5<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<I1, R1, R2, R3, R4, R5, R6> mapTo6(FN76<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6, T7> function) {
            return new FlowBuilder6<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<I1, R1, R2, R3, R4, R5, R6> mapTo6(FN76<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6, T7> function, EH<Tuple6<R1, R2, R3, R4, R5, R6>> handler) {
            return new FlowBuilder6<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<I1, R1, R2, R3, R4, R5, R6, R7, R8> mapTo8(FN78<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5, T6, T7> function) {
            return new FlowBuilder8<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<I1, R1, R2, R3, R4, R5, R6, R7, R8> mapTo8(FN78<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5, T6, T7> function, EH<Tuple8<R1, R2, R3, R4, R5, R6, R7, R8>> handler) {
            return new FlowBuilder8<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<I1, R1, R2, R3, R4, R5, R6, R7, R8, R9> mapTo9(FN79<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5, T6, T7> function) {
            return new FlowBuilder9<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<I1, R1, R2, R3, R4, R5, R6, R7, R8, R9> mapTo9(FN79<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5, T6, T7> function, EH<Tuple9<R1, R2, R3, R4, R5, R6, R7, R8, R9>> handler) {
            return new FlowBuilder9<>(step(type, function.asStepFunction(), handler));
        }
    }

    public static class FlowBuilder8<I1 extends Tuple, T1, T2, T3, T4, T5, T6, T7, T8> extends FlowBuilder0<I1> {
        private ExecutionType type = ExecutionType.SYNC;

        public FlowBuilder8(FlowBuilder0<I1> prev) {
            super(prev);
        }

        public FlowBuilder8<I1, T1, T2, T3, T4, T5, T6, T7, T8> async() {
            type = ExecutionType.ASYNC;
            return this;
        }

        public FlowBuilder8<I1, T1, T2, T3, T4, T5, T6, T7, T8> await() {
            type = ExecutionType.AWAIT;
            return this;
        }

        @SuppressWarnings("unchecked")
        public Flow<Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>, I1> done() {
            return Flow.of(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<I1, R1, R2, R3, R4, R5, R6, R7, R8> map(FN88<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5, T6, T7, T8> function) {
            return new FlowBuilder8<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<I1, R1, R2, R3, R4, R5, R6, R7, R8> map(FN88<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5, T6, T7, T8> function, EH<Tuple8<R1, R2, R3, R4, R5, R6, R7, R8>> handler) {
            return new FlowBuilder8<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<I1, R1> mapTo1(FN81<R1, T1, T2, T3, T4, T5, T6, T7, T8> function) {
            return new FlowBuilder1<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<I1, R1> mapTo1(FN81<R1, T1, T2, T3, T4, T5, T6, T7, T8> function, EH<Tuple1<R1>> handler) {
            return new FlowBuilder1<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<I1, R1, R2> mapTo2(FN82<R1, R2, T1, T2, T3, T4, T5, T6, T7, T8> function) {
            return new FlowBuilder2<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<I1, R1, R2> mapTo2(FN82<R1, R2, T1, T2, T3, T4, T5, T6, T7, T8> function, EH<Tuple2<R1, R2>> handler) {
            return new FlowBuilder2<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<I1, R1, R2, R3> mapTo3(FN83<R1, R2, R3, T1, T2, T3, T4, T5, T6, T7, T8> function) {
            return new FlowBuilder3<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<I1, R1, R2, R3> mapTo3(FN83<R1, R2, R3, T1, T2, T3, T4, T5, T6, T7, T8> function, EH<Tuple3<R1, R2, R3>> handler) {
            return new FlowBuilder3<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<I1, R1, R2, R3, R4> mapTo4(FN84<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6, T7, T8> function) {
            return new FlowBuilder4<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<I1, R1, R2, R3, R4> mapTo4(FN84<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6, T7, T8> function, EH<Tuple4<R1, R2, R3, R4>> handler) {
            return new FlowBuilder4<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<I1, R1, R2, R3, R4, R5> mapTo5(FN85<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6, T7, T8> function) {
            return new FlowBuilder5<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<I1, R1, R2, R3, R4, R5> mapTo5(FN85<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6, T7, T8> function, EH<Tuple5<R1, R2, R3, R4, R5>> handler) {
            return new FlowBuilder5<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<I1, R1, R2, R3, R4, R5, R6> mapTo6(FN86<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6, T7, T8> function) {
            return new FlowBuilder6<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<I1, R1, R2, R3, R4, R5, R6> mapTo6(FN86<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6, T7, T8> function, EH<Tuple6<R1, R2, R3, R4, R5, R6>> handler) {
            return new FlowBuilder6<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<I1, R1, R2, R3, R4, R5, R6, R7> mapTo7(FN87<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6, T7, T8> function) {
            return new FlowBuilder7<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<I1, R1, R2, R3, R4, R5, R6, R7> mapTo7(FN87<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6, T7, T8> function, EH<Tuple7<R1, R2, R3, R4, R5, R6, R7>> handler) {
            return new FlowBuilder7<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<I1, R1, R2, R3, R4, R5, R6, R7, R8, R9> mapTo9(FN89<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5, T6, T7, T8> function) {
            return new FlowBuilder9<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<I1, R1, R2, R3, R4, R5, R6, R7, R8, R9> mapTo9(FN89<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5, T6, T7, T8> function, EH<Tuple9<R1, R2, R3, R4, R5, R6, R7, R8, R9>> handler) {
            return new FlowBuilder9<>(step(type, function.asStepFunction(), handler));
        }
    }

    public static class FlowBuilder9<I1 extends Tuple, T1, T2, T3, T4, T5, T6, T7, T8, T9> extends FlowBuilder0<I1> {
        private ExecutionType type = ExecutionType.SYNC;

        public FlowBuilder9(FlowBuilder0<I1> prev) {
            super(prev);
        }

        public FlowBuilder9<I1, T1, T2, T3, T4, T5, T6, T7, T8, T9> async() {
            type = ExecutionType.ASYNC;
            return this;
        }

        public FlowBuilder9<I1, T1, T2, T3, T4, T5, T6, T7, T8, T9> await() {
            type = ExecutionType.AWAIT;
            return this;
        }

        @SuppressWarnings("unchecked")
        public Flow<Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>, I1> done() {
            return Flow.of(this);
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<I1, R1, R2, R3, R4, R5, R6, R7, R8, R9> map(FN99<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5, T6, T7, T8, T9> function) {
            return new FlowBuilder9<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<I1, R1, R2, R3, R4, R5, R6, R7, R8, R9> map(FN99<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5, T6, T7, T8, T9> function, EH<Tuple9<R1, R2, R3, R4, R5, R6, R7, R8, R9>> handler) {
            return new FlowBuilder9<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<I1, R1> mapTo1(FN91<R1, T1, T2, T3, T4, T5, T6, T7, T8, T9> function) {
            return new FlowBuilder1<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1> FlowBuilder1<I1, R1> mapTo1(FN91<R1, T1, T2, T3, T4, T5, T6, T7, T8, T9> function, EH<Tuple1<R1>> handler) {
            return new FlowBuilder1<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<I1, R1, R2> mapTo2(FN92<R1, R2, T1, T2, T3, T4, T5, T6, T7, T8, T9> function) {
            return new FlowBuilder2<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2> FlowBuilder2<I1, R1, R2> mapTo2(FN92<R1, R2, T1, T2, T3, T4, T5, T6, T7, T8, T9> function, EH<Tuple2<R1, R2>> handler) {
            return new FlowBuilder2<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<I1, R1, R2, R3> mapTo3(FN93<R1, R2, R3, T1, T2, T3, T4, T5, T6, T7, T8, T9> function) {
            return new FlowBuilder3<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3> FlowBuilder3<I1, R1, R2, R3> mapTo3(FN93<R1, R2, R3, T1, T2, T3, T4, T5, T6, T7, T8, T9> function, EH<Tuple3<R1, R2, R3>> handler) {
            return new FlowBuilder3<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<I1, R1, R2, R3, R4> mapTo4(FN94<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6, T7, T8, T9> function) {
            return new FlowBuilder4<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4> FlowBuilder4<I1, R1, R2, R3, R4> mapTo4(FN94<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6, T7, T8, T9> function, EH<Tuple4<R1, R2, R3, R4>> handler) {
            return new FlowBuilder4<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<I1, R1, R2, R3, R4, R5> mapTo5(FN95<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6, T7, T8, T9> function) {
            return new FlowBuilder5<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5> FlowBuilder5<I1, R1, R2, R3, R4, R5> mapTo5(FN95<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6, T7, T8, T9> function, EH<Tuple5<R1, R2, R3, R4, R5>> handler) {
            return new FlowBuilder5<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<I1, R1, R2, R3, R4, R5, R6> mapTo6(FN96<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6, T7, T8, T9> function) {
            return new FlowBuilder6<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<I1, R1, R2, R3, R4, R5, R6> mapTo6(FN96<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6, T7, T8, T9> function, EH<Tuple6<R1, R2, R3, R4, R5, R6>> handler) {
            return new FlowBuilder6<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<I1, R1, R2, R3, R4, R5, R6, R7> mapTo7(FN97<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6, T7, T8, T9> function) {
            return new FlowBuilder7<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<I1, R1, R2, R3, R4, R5, R6, R7> mapTo7(FN97<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6, T7, T8, T9> function, EH<Tuple7<R1, R2, R3, R4, R5, R6, R7>> handler) {
            return new FlowBuilder7<>(step(type, function.asStepFunction(), handler));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<I1, R1, R2, R3, R4, R5, R6, R7, R8> mapTo8(FN98<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5, T6, T7, T8, T9> function) {
            return new FlowBuilder8<>(step(type, function.asStepFunction(), (t) -> null));
        }

        @SuppressWarnings("unchecked")
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<I1, R1, R2, R3, R4, R5, R6, R7, R8> mapTo8(FN98<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5, T6, T7, T8, T9> function, EH<Tuple8<R1, R2, R3, R4, R5, R6, R7, R8>> handler) {
            return new FlowBuilder8<>(step(type, function.asStepFunction(), handler));
        }

    }
}
