package org.rxbooter.flow.impl;

// WARNING: Generated file, do not edit, all changes will be lost.

import org.rxbooter.flow.ExecutionType;
import org.rxbooter.flow.Flow;
import org.rxbooter.flow.Step;

import java.util.function.Consumer;

import static org.rxbooter.flow.Functions.*;
import static org.rxbooter.flow.Step.*;
import static org.rxbooter.flow.Tuples.*;

public final class FlowBuilders {
    private FlowBuilders() {}

    /** The type {@code I1} holds original input tuple. */
    public static class FlowBuilder0<I1 extends Tuple> {
        protected final FlowBuilder0<I1> prev;
        private ExecutionType type = ExecutionType.SYNC;
        protected Step<?, ?> step;
        private CF<?> condition;

        FlowBuilder0(FlowBuilder0<I1> prev) {
            this.prev = prev;
        }

        void setAsync() {
            type = ExecutionType.ASYNC;
        }

        void setAwait() {
            type = ExecutionType.AWAIT;
        }

        void setCondition(CF<?> condition) {
            this.condition = condition;
        }

        public void apply(Consumer<Step<?, ?>> consumer) {
            if (prev != null) {
                prev.apply(consumer);
            }

            if (step != null) {
                consumer.accept(step);
            }
        }

        protected<R, T> FlowBuilder0<I1> step(TF<R, T> function) {
            this.step = Step.of(type, function);
            return this;
        }

        @SuppressWarnings({"rawtypes", "unchecked"})
        protected void setOnError(EH<?> handler) {
            if (prev != null) {
                prev.step.handler((EH) handler);
            }
        }
    }

    public interface FlowBuilderBase1<I1 extends Tuple, T1> {
        <R1> FlowBuilder1<I1, R1> map(FN11<R1, T1> function);
        FlowBuilderBase1<I1, T1> when(CF1<T1> condition);
    }

    public static class FlowBuilder1<I1 extends Tuple, T1> extends FlowBuilder0<I1> implements FlowBuilderBase1<I1, T1> {

        public FlowBuilder1(FlowBuilder0<I1> prev) {
            super(prev);
        }

        public FlowBuilder1<I1, T1> async() {
            setAsync();
            return this;
        }

        public FlowBuilder1<I1, T1> await() {
            setAwait();
            return this;
        }

        @SuppressWarnings({"rawtypes", "unchecked"})
        public FlowBuilder1<I1, T1> onError(EH<Tuple1<T1>> handler) {
            setOnError(handler);
            return this;
        }

        public Flow<Tuple1<T1>, I1> done() {
            return Flow.of(this);
        }

        @Override
        public <R1> FlowBuilder1<I1, R1> map(FN11<R1, T1> function) {
            return new FlowBuilder1<>(step(function.asStepFunction()));
        }

        @Override
        public FlowBuilderBase1<I1, T1> when(CF1<T1> condition) {
            setCondition(condition.asConditionFunction());
            return this;
        }

        public <R1, R2> FlowBuilder2<I1, R1, R2> mapTo2(FN12<R1, R2, T1> function) {
            return new FlowBuilder2<>(step(function.asStepFunction()));
        }

        public <R1, R2, R3> FlowBuilder3<I1, R1, R2, R3> mapTo3(FN13<R1, R2, R3, T1> function) {
            return new FlowBuilder3<>(step(function.asStepFunction()));
        }

        public <R1, R2, R3, R4> FlowBuilder4<I1, R1, R2, R3, R4> mapTo4(FN14<R1, R2, R3, R4, T1> function) {
            return new FlowBuilder4<>(step(function.asStepFunction()));
        }

        public <R1, R2, R3, R4, R5> FlowBuilder5<I1, R1, R2, R3, R4, R5> mapTo5(FN15<R1, R2, R3, R4, R5, T1> function) {
            return new FlowBuilder5<>(step(function.asStepFunction()));
        }

        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<I1, R1, R2, R3, R4, R5, R6> mapTo6(FN16<R1, R2, R3, R4, R5, R6, T1> function) {
            return new FlowBuilder6<>(step(function.asStepFunction()));
        }

        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<I1, R1, R2, R3, R4, R5, R6, R7> mapTo7(FN17<R1, R2, R3, R4, R5, R6, R7, T1> function) {
            return new FlowBuilder7<>(step(function.asStepFunction()));
        }

        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<I1, R1, R2, R3, R4, R5, R6, R7, R8> mapTo8(FN18<R1, R2, R3, R4, R5, R6, R7, R8, T1> function) {
            return new FlowBuilder8<>(step(function.asStepFunction()));
        }

        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<I1, R1, R2, R3, R4, R5, R6, R7, R8, R9> mapTo9(FN19<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1> function) {
            return new FlowBuilder9<>(step(function.asStepFunction()));
        }
    }

    public interface FlowBuilderBase2<I1 extends Tuple, T1, T2> {
        <R1, R2> FlowBuilder2<I1, R1, R2> map(FN22<R1, R2, T1, T2> function);
        FlowBuilderBase2<I1, T1, T2> when(CF2<T1, T2> condition);
    }

    public static class FlowBuilder2<I1 extends Tuple, T1, T2> extends FlowBuilder0<I1> implements FlowBuilderBase2<I1, T1, T2> {

        public FlowBuilder2(FlowBuilder0<I1> prev) {
            super(prev);
        }

        public FlowBuilder2<I1, T1, T2> async() {
            setAsync();
            return this;
        }

        public FlowBuilder2<I1, T1, T2> await() {
            setAwait();
            return this;
        }

        @SuppressWarnings({"rawtypes", "unchecked"})
        public FlowBuilder2<I1, T1, T2> onError(EH<Tuple2<T1, T2>> handler) {
            setOnError(handler);
            return this;
        }

        public Flow<Tuple2<T1, T2>, I1> done() {
            return Flow.of(this);
        }

        @Override
        public <R1, R2> FlowBuilder2<I1, R1, R2> map(FN22<R1, R2, T1, T2> function) {
            return new FlowBuilder2<>(step(function.asStepFunction()));
        }

        @Override
        public FlowBuilderBase2<I1, T1, T2> when(CF2<T1, T2> condition) {
            setCondition(condition.asConditionFunction());
            return this;
        }

        public <R1> FlowBuilder1<I1, R1> mapTo1(FN21<R1, T1, T2> function) {
            return new FlowBuilder1<>(step(function.asStepFunction()));
        }

        public <R1, R2, R3> FlowBuilder3<I1, R1, R2, R3> mapTo3(FN23<R1, R2, R3, T1, T2> function) {
            return new FlowBuilder3<>(step(function.asStepFunction()));
        }

        public <R1, R2, R3, R4> FlowBuilder4<I1, R1, R2, R3, R4> mapTo4(FN24<R1, R2, R3, R4, T1, T2> function) {
            return new FlowBuilder4<>(step(function.asStepFunction()));
        }

        public <R1, R2, R3, R4, R5> FlowBuilder5<I1, R1, R2, R3, R4, R5> mapTo5(FN25<R1, R2, R3, R4, R5, T1, T2> function) {
            return new FlowBuilder5<>(step(function.asStepFunction()));
        }

        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<I1, R1, R2, R3, R4, R5, R6> mapTo6(FN26<R1, R2, R3, R4, R5, R6, T1, T2> function) {
            return new FlowBuilder6<>(step(function.asStepFunction()));
        }

        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<I1, R1, R2, R3, R4, R5, R6, R7> mapTo7(FN27<R1, R2, R3, R4, R5, R6, R7, T1, T2> function) {
            return new FlowBuilder7<>(step(function.asStepFunction()));
        }

        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<I1, R1, R2, R3, R4, R5, R6, R7, R8> mapTo8(FN28<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2> function) {
            return new FlowBuilder8<>(step(function.asStepFunction()));
        }

        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<I1, R1, R2, R3, R4, R5, R6, R7, R8, R9> mapTo9(FN29<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2> function) {
            return new FlowBuilder9<>(step(function.asStepFunction()));
        }
    }

    public interface FlowBuilderBase3<I1 extends Tuple, T1, T2, T3> {
        <R1, R2, R3> FlowBuilder3<I1, R1, R2, R3> map(FN33<R1, R2, R3, T1, T2, T3> function);
        FlowBuilderBase3<I1, T1, T2, T3> when(CF3<T1, T2, T3> condition);
    }

    public static class FlowBuilder3<I1 extends Tuple, T1, T2, T3> extends FlowBuilder0<I1> implements FlowBuilderBase3<I1, T1, T2, T3> {

        public FlowBuilder3(FlowBuilder0<I1> prev) {
            super(prev);
        }

        public FlowBuilder3<I1, T1, T2, T3> async() {
            setAsync();
            return this;
        }

        public FlowBuilder3<I1, T1, T2, T3> await() {
            setAwait();
            return this;
        }

        @SuppressWarnings({"rawtypes", "unchecked"})
        public FlowBuilder3<I1, T1, T2, T3> onError(EH<Tuple3<T1, T2, T3>> handler) {
            setOnError(handler);
            return this;
        }

        public Flow<Tuple3<T1, T2, T3>, I1> done() {
            return Flow.of(this);
        }

        @Override
        public <R1, R2, R3> FlowBuilder3<I1, R1, R2, R3> map(FN33<R1, R2, R3, T1, T2, T3> function) {
            return new FlowBuilder3<>(step(function.asStepFunction()));
        }

        @Override
        public FlowBuilderBase3<I1, T1, T2, T3> when(CF3<T1, T2, T3> condition) {
            setCondition(condition.asConditionFunction());
            return this;
        }

        public <R1> FlowBuilder1<I1, R1> mapTo1(FN31<R1, T1, T2, T3> function) {
            return new FlowBuilder1<>(step(function.asStepFunction()));
        }

        public <R1, R2> FlowBuilder2<I1, R1, R2> mapTo2(FN32<R1, R2, T1, T2, T3> function) {
            return new FlowBuilder2<>(step(function.asStepFunction()));
        }

        public <R1, R2, R3, R4> FlowBuilder4<I1, R1, R2, R3, R4> mapTo4(FN34<R1, R2, R3, R4, T1, T2, T3> function) {
            return new FlowBuilder4<>(step(function.asStepFunction()));
        }

        public <R1, R2, R3, R4, R5> FlowBuilder5<I1, R1, R2, R3, R4, R5> mapTo5(FN35<R1, R2, R3, R4, R5, T1, T2, T3> function) {
            return new FlowBuilder5<>(step(function.asStepFunction()));
        }

        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<I1, R1, R2, R3, R4, R5, R6> mapTo6(FN36<R1, R2, R3, R4, R5, R6, T1, T2, T3> function) {
            return new FlowBuilder6<>(step(function.asStepFunction()));
        }

        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<I1, R1, R2, R3, R4, R5, R6, R7> mapTo7(FN37<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3> function) {
            return new FlowBuilder7<>(step(function.asStepFunction()));
        }

        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<I1, R1, R2, R3, R4, R5, R6, R7, R8> mapTo8(FN38<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3> function) {
            return new FlowBuilder8<>(step(function.asStepFunction()));
        }

        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<I1, R1, R2, R3, R4, R5, R6, R7, R8, R9> mapTo9(FN39<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3> function) {
            return new FlowBuilder9<>(step(function.asStepFunction()));
        }
    }

    public interface FlowBuilderBase4<I1 extends Tuple, T1, T2, T3, T4> {
        <R1, R2, R3, R4> FlowBuilder4<I1, R1, R2, R3, R4> map(FN44<R1, R2, R3, R4, T1, T2, T3, T4> function);
        FlowBuilderBase4<I1, T1, T2, T3, T4> when(CF4<T1, T2, T3, T4> condition);
    }

    public static class FlowBuilder4<I1 extends Tuple, T1, T2, T3, T4> extends FlowBuilder0<I1> implements FlowBuilderBase4<I1, T1, T2, T3, T4> {

        public FlowBuilder4(FlowBuilder0<I1> prev) {
            super(prev);
        }

        public FlowBuilder4<I1, T1, T2, T3, T4> async() {
            setAsync();
            return this;
        }

        public FlowBuilder4<I1, T1, T2, T3, T4> await() {
            setAwait();
            return this;
        }

        @SuppressWarnings({"rawtypes", "unchecked"})
        public FlowBuilder4<I1, T1, T2, T3, T4> onError(EH<Tuple4<T1, T2, T3, T4>> handler) {
            setOnError(handler);
            return this;
        }

        public Flow<Tuple4<T1, T2, T3, T4>, I1> done() {
            return Flow.of(this);
        }

        @Override
        public <R1, R2, R3, R4> FlowBuilder4<I1, R1, R2, R3, R4> map(FN44<R1, R2, R3, R4, T1, T2, T3, T4> function) {
            return new FlowBuilder4<>(step(function.asStepFunction()));
        }

        @Override
        public FlowBuilderBase4<I1, T1, T2, T3, T4> when(CF4<T1, T2, T3, T4> condition) {
            setCondition(condition.asConditionFunction());
            return this;
        }

        public <R1> FlowBuilder1<I1, R1> mapTo1(FN41<R1, T1, T2, T3, T4> function) {
            return new FlowBuilder1<>(step(function.asStepFunction()));
        }

        public <R1, R2> FlowBuilder2<I1, R1, R2> mapTo2(FN42<R1, R2, T1, T2, T3, T4> function) {
            return new FlowBuilder2<>(step(function.asStepFunction()));
        }

        public <R1, R2, R3> FlowBuilder3<I1, R1, R2, R3> mapTo3(FN43<R1, R2, R3, T1, T2, T3, T4> function) {
            return new FlowBuilder3<>(step(function.asStepFunction()));
        }

        public <R1, R2, R3, R4, R5> FlowBuilder5<I1, R1, R2, R3, R4, R5> mapTo5(FN45<R1, R2, R3, R4, R5, T1, T2, T3, T4> function) {
            return new FlowBuilder5<>(step(function.asStepFunction()));
        }

        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<I1, R1, R2, R3, R4, R5, R6> mapTo6(FN46<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4> function) {
            return new FlowBuilder6<>(step(function.asStepFunction()));
        }

        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<I1, R1, R2, R3, R4, R5, R6, R7> mapTo7(FN47<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4> function) {
            return new FlowBuilder7<>(step(function.asStepFunction()));
        }

        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<I1, R1, R2, R3, R4, R5, R6, R7, R8> mapTo8(FN48<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4> function) {
            return new FlowBuilder8<>(step(function.asStepFunction()));
        }

        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<I1, R1, R2, R3, R4, R5, R6, R7, R8, R9> mapTo9(FN49<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4> function) {
            return new FlowBuilder9<>(step(function.asStepFunction()));
        }
    }

    public interface FlowBuilderBase5<I1 extends Tuple, T1, T2, T3, T4, T5> {
        <R1, R2, R3, R4, R5> FlowBuilder5<I1, R1, R2, R3, R4, R5> map(FN55<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5> function);
        FlowBuilderBase5<I1, T1, T2, T3, T4, T5> when(CF5<T1, T2, T3, T4, T5> condition);
    }

    public static class FlowBuilder5<I1 extends Tuple, T1, T2, T3, T4, T5> extends FlowBuilder0<I1> implements FlowBuilderBase5<I1, T1, T2, T3, T4, T5> {

        public FlowBuilder5(FlowBuilder0<I1> prev) {
            super(prev);
        }

        public FlowBuilder5<I1, T1, T2, T3, T4, T5> async() {
            setAsync();
            return this;
        }

        public FlowBuilder5<I1, T1, T2, T3, T4, T5> await() {
            setAwait();
            return this;
        }

        @SuppressWarnings({"rawtypes", "unchecked"})
        public FlowBuilder5<I1, T1, T2, T3, T4, T5> onError(EH<Tuple5<T1, T2, T3, T4, T5>> handler) {
            setOnError(handler);
            return this;
        }

        public Flow<Tuple5<T1, T2, T3, T4, T5>, I1> done() {
            return Flow.of(this);
        }

        @Override
        public <R1, R2, R3, R4, R5> FlowBuilder5<I1, R1, R2, R3, R4, R5> map(FN55<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5> function) {
            return new FlowBuilder5<>(step(function.asStepFunction()));
        }

        @Override
        public FlowBuilderBase5<I1, T1, T2, T3, T4, T5> when(CF5<T1, T2, T3, T4, T5> condition) {
            setCondition(condition.asConditionFunction());
            return this;
        }

        public <R1> FlowBuilder1<I1, R1> mapTo1(FN51<R1, T1, T2, T3, T4, T5> function) {
            return new FlowBuilder1<>(step(function.asStepFunction()));
        }

        public <R1, R2> FlowBuilder2<I1, R1, R2> mapTo2(FN52<R1, R2, T1, T2, T3, T4, T5> function) {
            return new FlowBuilder2<>(step(function.asStepFunction()));
        }

        public <R1, R2, R3> FlowBuilder3<I1, R1, R2, R3> mapTo3(FN53<R1, R2, R3, T1, T2, T3, T4, T5> function) {
            return new FlowBuilder3<>(step(function.asStepFunction()));
        }

        public <R1, R2, R3, R4> FlowBuilder4<I1, R1, R2, R3, R4> mapTo4(FN54<R1, R2, R3, R4, T1, T2, T3, T4, T5> function) {
            return new FlowBuilder4<>(step(function.asStepFunction()));
        }

        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<I1, R1, R2, R3, R4, R5, R6> mapTo6(FN56<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5> function) {
            return new FlowBuilder6<>(step(function.asStepFunction()));
        }

        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<I1, R1, R2, R3, R4, R5, R6, R7> mapTo7(FN57<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5> function) {
            return new FlowBuilder7<>(step(function.asStepFunction()));
        }

        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<I1, R1, R2, R3, R4, R5, R6, R7, R8> mapTo8(FN58<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5> function) {
            return new FlowBuilder8<>(step(function.asStepFunction()));
        }

        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<I1, R1, R2, R3, R4, R5, R6, R7, R8, R9> mapTo9(FN59<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5> function) {
            return new FlowBuilder9<>(step(function.asStepFunction()));
        }
    }

    public interface FlowBuilderBase6<I1 extends Tuple, T1, T2, T3, T4, T5, T6> {
        <R1, R2, R3, R4, R5, R6> FlowBuilder6<I1, R1, R2, R3, R4, R5, R6> map(FN66<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6> function);
        FlowBuilderBase6<I1, T1, T2, T3, T4, T5, T6> when(CF6<T1, T2, T3, T4, T5, T6> condition);
    }

    public static class FlowBuilder6<I1 extends Tuple, T1, T2, T3, T4, T5, T6> extends FlowBuilder0<I1> implements FlowBuilderBase6<I1, T1, T2, T3, T4, T5, T6> {

        public FlowBuilder6(FlowBuilder0<I1> prev) {
            super(prev);
        }

        public FlowBuilder6<I1, T1, T2, T3, T4, T5, T6> async() {
            setAsync();
            return this;
        }

        public FlowBuilder6<I1, T1, T2, T3, T4, T5, T6> await() {
            setAwait();
            return this;
        }

        @SuppressWarnings({"rawtypes", "unchecked"})
        public FlowBuilder6<I1, T1, T2, T3, T4, T5, T6> onError(EH<Tuple6<T1, T2, T3, T4, T5, T6>> handler) {
            setOnError(handler);
            return this;
        }

        public Flow<Tuple6<T1, T2, T3, T4, T5, T6>, I1> done() {
            return Flow.of(this);
        }

        @Override
        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<I1, R1, R2, R3, R4, R5, R6> map(FN66<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6> function) {
            return new FlowBuilder6<>(step(function.asStepFunction()));
        }

        @Override
        public FlowBuilderBase6<I1, T1, T2, T3, T4, T5, T6> when(CF6<T1, T2, T3, T4, T5, T6> condition) {
            setCondition(condition.asConditionFunction());
            return this;
        }

        public <R1> FlowBuilder1<I1, R1> mapTo1(FN61<R1, T1, T2, T3, T4, T5, T6> function) {
            return new FlowBuilder1<>(step(function.asStepFunction()));
        }

        public <R1, R2> FlowBuilder2<I1, R1, R2> mapTo2(FN62<R1, R2, T1, T2, T3, T4, T5, T6> function) {
            return new FlowBuilder2<>(step(function.asStepFunction()));
        }

        public <R1, R2, R3> FlowBuilder3<I1, R1, R2, R3> mapTo3(FN63<R1, R2, R3, T1, T2, T3, T4, T5, T6> function) {
            return new FlowBuilder3<>(step(function.asStepFunction()));
        }

        public <R1, R2, R3, R4> FlowBuilder4<I1, R1, R2, R3, R4> mapTo4(FN64<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6> function) {
            return new FlowBuilder4<>(step(function.asStepFunction()));
        }

        public <R1, R2, R3, R4, R5> FlowBuilder5<I1, R1, R2, R3, R4, R5> mapTo5(FN65<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6> function) {
            return new FlowBuilder5<>(step(function.asStepFunction()));
        }

        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<I1, R1, R2, R3, R4, R5, R6, R7> mapTo7(FN67<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6> function) {
            return new FlowBuilder7<>(step(function.asStepFunction()));
        }

        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<I1, R1, R2, R3, R4, R5, R6, R7, R8> mapTo8(FN68<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5, T6> function) {
            return new FlowBuilder8<>(step(function.asStepFunction()));
        }

        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<I1, R1, R2, R3, R4, R5, R6, R7, R8, R9> mapTo9(FN69<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5, T6> function) {
            return new FlowBuilder9<>(step(function.asStepFunction()));
        }
    }

    public interface FlowBuilderBase7<I1 extends Tuple, T1, T2, T3, T4, T5, T6, T7> {
        <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<I1, R1, R2, R3, R4, R5, R6, R7> map(FN77<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6, T7> function);
        FlowBuilderBase7<I1, T1, T2, T3, T4, T5, T6, T7> when(CF7<T1, T2, T3, T4, T5, T6, T7> condition);
    }

    public static class FlowBuilder7<I1 extends Tuple, T1, T2, T3, T4, T5, T6, T7> extends FlowBuilder0<I1> implements FlowBuilderBase7<I1, T1, T2, T3, T4, T5, T6, T7> {

        public FlowBuilder7(FlowBuilder0<I1> prev) {
            super(prev);
        }

        public FlowBuilder7<I1, T1, T2, T3, T4, T5, T6, T7> async() {
            setAsync();
            return this;
        }

        public FlowBuilder7<I1, T1, T2, T3, T4, T5, T6, T7> await() {
            setAwait();
            return this;
        }

        @SuppressWarnings({"rawtypes", "unchecked"})
        public FlowBuilder7<I1, T1, T2, T3, T4, T5, T6, T7> onError(EH<Tuple7<T1, T2, T3, T4, T5, T6, T7>> handler) {
            setOnError(handler);
            return this;
        }

        public Flow<Tuple7<T1, T2, T3, T4, T5, T6, T7>, I1> done() {
            return Flow.of(this);
        }

        @Override
        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<I1, R1, R2, R3, R4, R5, R6, R7> map(FN77<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6, T7> function) {
            return new FlowBuilder7<>(step(function.asStepFunction()));
        }

        @Override
        public FlowBuilderBase7<I1, T1, T2, T3, T4, T5, T6, T7> when(CF7<T1, T2, T3, T4, T5, T6, T7> condition) {
            setCondition(condition.asConditionFunction());
            return this;
        }

        public <R1> FlowBuilder1<I1, R1> mapTo1(FN71<R1, T1, T2, T3, T4, T5, T6, T7> function) {
            return new FlowBuilder1<>(step(function.asStepFunction()));
        }

        public <R1, R2> FlowBuilder2<I1, R1, R2> mapTo2(FN72<R1, R2, T1, T2, T3, T4, T5, T6, T7> function) {
            return new FlowBuilder2<>(step(function.asStepFunction()));
        }

        public <R1, R2, R3> FlowBuilder3<I1, R1, R2, R3> mapTo3(FN73<R1, R2, R3, T1, T2, T3, T4, T5, T6, T7> function) {
            return new FlowBuilder3<>(step(function.asStepFunction()));
        }

        public <R1, R2, R3, R4> FlowBuilder4<I1, R1, R2, R3, R4> mapTo4(FN74<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6, T7> function) {
            return new FlowBuilder4<>(step(function.asStepFunction()));
        }

        public <R1, R2, R3, R4, R5> FlowBuilder5<I1, R1, R2, R3, R4, R5> mapTo5(FN75<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6, T7> function) {
            return new FlowBuilder5<>(step(function.asStepFunction()));
        }

        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<I1, R1, R2, R3, R4, R5, R6> mapTo6(FN76<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6, T7> function) {
            return new FlowBuilder6<>(step(function.asStepFunction()));
        }

        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<I1, R1, R2, R3, R4, R5, R6, R7, R8> mapTo8(FN78<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5, T6, T7> function) {
            return new FlowBuilder8<>(step(function.asStepFunction()));
        }

        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<I1, R1, R2, R3, R4, R5, R6, R7, R8, R9> mapTo9(FN79<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5, T6, T7> function) {
            return new FlowBuilder9<>(step(function.asStepFunction()));
        }
    }

    public interface FlowBuilderBase8<I1 extends Tuple, T1, T2, T3, T4, T5, T6, T7, T8> {
        <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<I1, R1, R2, R3, R4, R5, R6, R7, R8> map(FN88<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5, T6, T7, T8> function);
        FlowBuilderBase8<I1, T1, T2, T3, T4, T5, T6, T7, T8> when(CF8<T1, T2, T3, T4, T5, T6, T7, T8> condition);
    }

    public static class FlowBuilder8<I1 extends Tuple, T1, T2, T3, T4, T5, T6, T7, T8> extends FlowBuilder0<I1> implements FlowBuilderBase8<I1, T1, T2, T3, T4, T5, T6, T7, T8> {

        public FlowBuilder8(FlowBuilder0<I1> prev) {
            super(prev);
        }

        public FlowBuilder8<I1, T1, T2, T3, T4, T5, T6, T7, T8> async() {
            setAsync();
            return this;
        }

        public FlowBuilder8<I1, T1, T2, T3, T4, T5, T6, T7, T8> await() {
            setAwait();
            return this;
        }

        @SuppressWarnings({"rawtypes", "unchecked"})
        public FlowBuilder8<I1, T1, T2, T3, T4, T5, T6, T7, T8> onError(EH<Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>> handler) {
            setOnError(handler);
            return this;
        }

        public Flow<Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>, I1> done() {
            return Flow.of(this);
        }

        @Override
        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<I1, R1, R2, R3, R4, R5, R6, R7, R8> map(FN88<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5, T6, T7, T8> function) {
            return new FlowBuilder8<>(step(function.asStepFunction()));
        }

        @Override
        public FlowBuilderBase8<I1, T1, T2, T3, T4, T5, T6, T7, T8> when(CF8<T1, T2, T3, T4, T5, T6, T7, T8> condition) {
            setCondition(condition.asConditionFunction());
            return this;
        }

        public <R1> FlowBuilder1<I1, R1> mapTo1(FN81<R1, T1, T2, T3, T4, T5, T6, T7, T8> function) {
            return new FlowBuilder1<>(step(function.asStepFunction()));
        }

        public <R1, R2> FlowBuilder2<I1, R1, R2> mapTo2(FN82<R1, R2, T1, T2, T3, T4, T5, T6, T7, T8> function) {
            return new FlowBuilder2<>(step(function.asStepFunction()));
        }

        public <R1, R2, R3> FlowBuilder3<I1, R1, R2, R3> mapTo3(FN83<R1, R2, R3, T1, T2, T3, T4, T5, T6, T7, T8> function) {
            return new FlowBuilder3<>(step(function.asStepFunction()));
        }

        public <R1, R2, R3, R4> FlowBuilder4<I1, R1, R2, R3, R4> mapTo4(FN84<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6, T7, T8> function) {
            return new FlowBuilder4<>(step(function.asStepFunction()));
        }

        public <R1, R2, R3, R4, R5> FlowBuilder5<I1, R1, R2, R3, R4, R5> mapTo5(FN85<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6, T7, T8> function) {
            return new FlowBuilder5<>(step(function.asStepFunction()));
        }

        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<I1, R1, R2, R3, R4, R5, R6> mapTo6(FN86<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6, T7, T8> function) {
            return new FlowBuilder6<>(step(function.asStepFunction()));
        }

        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<I1, R1, R2, R3, R4, R5, R6, R7> mapTo7(FN87<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6, T7, T8> function) {
            return new FlowBuilder7<>(step(function.asStepFunction()));
        }

        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<I1, R1, R2, R3, R4, R5, R6, R7, R8, R9> mapTo9(FN89<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5, T6, T7, T8> function) {
            return new FlowBuilder9<>(step(function.asStepFunction()));
        }
    }

    public interface FlowBuilderBase9<I1 extends Tuple, T1, T2, T3, T4, T5, T6, T7, T8, T9> {
        <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<I1, R1, R2, R3, R4, R5, R6, R7, R8, R9> map(FN99<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5, T6, T7, T8, T9> function);
        FlowBuilderBase9<I1, T1, T2, T3, T4, T5, T6, T7, T8, T9> when(CF9<T1, T2, T3, T4, T5, T6, T7, T8, T9> condition);
    }

    public static class FlowBuilder9<I1 extends Tuple, T1, T2, T3, T4, T5, T6, T7, T8, T9> extends FlowBuilder0<I1> implements FlowBuilderBase9<I1, T1, T2, T3, T4, T5, T6, T7, T8, T9> {

        public FlowBuilder9(FlowBuilder0<I1> prev) {
            super(prev);
        }

        public FlowBuilder9<I1, T1, T2, T3, T4, T5, T6, T7, T8, T9> async() {
            setAsync();
            return this;
        }

        public FlowBuilder9<I1, T1, T2, T3, T4, T5, T6, T7, T8, T9> await() {
            setAwait();
            return this;
        }

        @SuppressWarnings({"rawtypes", "unchecked"})
        public FlowBuilder9<I1, T1, T2, T3, T4, T5, T6, T7, T8, T9> onError(EH<Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>> handler) {
            setOnError(handler);
            return this;
        }

        public Flow<Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>, I1> done() {
            return Flow.of(this);
        }

        @Override
        public <R1, R2, R3, R4, R5, R6, R7, R8, R9> FlowBuilder9<I1, R1, R2, R3, R4, R5, R6, R7, R8, R9> map(FN99<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5, T6, T7, T8, T9> function) {
            return new FlowBuilder9<>(step(function.asStepFunction()));
        }

        @Override
        public FlowBuilderBase9<I1, T1, T2, T3, T4, T5, T6, T7, T8, T9> when(CF9<T1, T2, T3, T4, T5, T6, T7, T8, T9> condition) {
            setCondition(condition.asConditionFunction());
            return this;
        }

        public <R1> FlowBuilder1<I1, R1> mapTo1(FN91<R1, T1, T2, T3, T4, T5, T6, T7, T8, T9> function) {
            return new FlowBuilder1<>(step(function.asStepFunction()));
        }

        public <R1, R2> FlowBuilder2<I1, R1, R2> mapTo2(FN92<R1, R2, T1, T2, T3, T4, T5, T6, T7, T8, T9> function) {
            return new FlowBuilder2<>(step(function.asStepFunction()));
        }

        public <R1, R2, R3> FlowBuilder3<I1, R1, R2, R3> mapTo3(FN93<R1, R2, R3, T1, T2, T3, T4, T5, T6, T7, T8, T9> function) {
            return new FlowBuilder3<>(step(function.asStepFunction()));
        }

        public <R1, R2, R3, R4> FlowBuilder4<I1, R1, R2, R3, R4> mapTo4(FN94<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6, T7, T8, T9> function) {
            return new FlowBuilder4<>(step(function.asStepFunction()));
        }

        public <R1, R2, R3, R4, R5> FlowBuilder5<I1, R1, R2, R3, R4, R5> mapTo5(FN95<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6, T7, T8, T9> function) {
            return new FlowBuilder5<>(step(function.asStepFunction()));
        }

        public <R1, R2, R3, R4, R5, R6> FlowBuilder6<I1, R1, R2, R3, R4, R5, R6> mapTo6(FN96<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6, T7, T8, T9> function) {
            return new FlowBuilder6<>(step(function.asStepFunction()));
        }

        public <R1, R2, R3, R4, R5, R6, R7> FlowBuilder7<I1, R1, R2, R3, R4, R5, R6, R7> mapTo7(FN97<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6, T7, T8, T9> function) {
            return new FlowBuilder7<>(step(function.asStepFunction()));
        }

        public <R1, R2, R3, R4, R5, R6, R7, R8> FlowBuilder8<I1, R1, R2, R3, R4, R5, R6, R7, R8> mapTo8(FN98<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5, T6, T7, T8, T9> function) {
            return new FlowBuilder8<>(step(function.asStepFunction()));
        }

    }
}
