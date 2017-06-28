package org.rxbooter.flow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

//import static org.rxbooter.flow.FlowBuilders.*;
import static org.rxbooter.flow.Tuples.*;

public class Flow<O extends Tuple, I extends Tuple> {
    private final List<Step<? extends Tuple, ? extends Tuple>> steps = new ArrayList<>();

    private Flow(Step<O, I> step) {
        steps.add(step);
    }

    private Flow(List<Step<? extends Tuple, ? extends Tuple>> steps) {
        this.steps.addAll(steps);
    }

    private <N extends Tuple> Flow(Flow<N, I> flow1, Flow<O, N> flow2) {
        steps.addAll(flow1.steps);
        steps.addAll(flow2.steps);
    }

    /**
     * Applies specified {@link Consumer} to all steps.
     *
     * @param action
     *          Consumer to apply
     *
     * @return <code>this</code> for convenient fluent syntax calls
     */
    public Flow<O, I> apply(Consumer<Step<? extends Tuple, ? extends Tuple>> action) {
        steps.forEach(action);
        return this;
    }

    public ExecutableFlow<O, I> bind(I value) {
        return ExecutableFlow.with(steps, value);
    }

    public ExecutableFlow<O, I> bind(I value, NotificationHolder<O> notificationHolder) {
        return ExecutableFlow.with(steps, value, notificationHolder);
    }

    public static <O extends Tuple, I extends Tuple> Flow <O, I> single(Step<O, I> step) {
        return new Flow<>(step);
    }

    public static <O, I> Flow <Tuple1<O>, Tuple1<I>> single(Function<I, O> function) {
        return new Flow<>(Step.single(function));
    }

    public static <O> Flow <Tuple1<O>, Tuple> single(Supplier<O> function) {
        return new Flow<>(Step.single(function));
    }

    public static <O, I> Flow <Tuple1<O>, Tuple1<I>> async(Function<I, O> function) {
        return new Flow<>(Step.async(function));
    }

    public static <O> Flow <Tuple1<O>, Tuple> async(Supplier<O> function) {
        return new Flow<>(Step.async(function));
    }

    public static <O, I> Flow <Tuple1<O>, Tuple1<I>> waiting(Function<I, O> function) {
        return new Flow<>(Step.waiting(function));
    }

    public static <O> Flow <Tuple1<O>, Tuple> waiting(Supplier<O> function) {
        return new Flow<>(Step.waiting(function));
    }

    public static <O extends Tuple, I extends Tuple, N extends Tuple> Flow <O, I> compose(Flow<N, I> flow1, Flow<O, N> flow2) {
        return new Flow<>(flow1, flow2);
    }

//    @SuppressWarnings("unchecked")
//    public static <O extends Tuple, I extends Tuple> Flow <O, I> of(FlowBuilder<O> builder) {
//        List<Step<? extends Tuple, ? extends Tuple>> steps = new ArrayList<>();
//        builder.apply((step) -> steps.add((Step<? extends Tuple, ? extends Tuple>) step));
//        return new Flow<>(steps);
//    }
//
//    public static<T1> FlowBuilder1<Tuple1<T1>, T1> take(Class<T1> param1) {
//        return new FlowBuilder1<>(null);
//    }
//
//    public static<T1, T2> FlowBuilder2<Tuple2<T1, T2>, T1, T2> take(Class<T1> param1, Class<T2> param2) {
//        return new FlowBuilder2<>(null);
//    }
//
//    public static<T1, T2, T3> FlowBuilder3<Tuple3<T1, T2, T3>, T1, T2, T3> take(Class<T1> param1, Class<T2> param2, Class<T3> param3) {
//        return new FlowBuilder3<>(null);
//    }
//
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

    public static class ExecutableFlow<O extends Tuple, I extends Tuple> {
        private final List<Step<? extends Tuple, ? extends Tuple>> steps;
        private final NotificationHolder<O> notificationHolder;

        private int index = 0;
        private Tuple intermediate;
        private Throwable error = null;

        private ExecutableFlow(List<Step<? extends Tuple, ? extends Tuple>> steps, I input, NotificationHolder<O> notificationHolder) {
            this.steps = steps;
            this.intermediate = input;
            this.notificationHolder = notificationHolder;
        }

        public static <O extends Tuple, I extends Tuple> ExecutableFlow<O, I> with(List<Step<? extends Tuple, ? extends Tuple>> steps, I input) {
            return new ExecutableFlow<>(steps, input, NotificationHolder.with());
        }

        public static <O extends Tuple, I extends Tuple> ExecutableFlow<O, I> with(List<Step<? extends Tuple, ? extends Tuple>> steps, I input, NotificationHolder<O> notificationHolder) {
            return new ExecutableFlow<>(steps, input, notificationHolder);
        }

        public ExecutableFlow<O, ?> forCurrent() {
            if (!canRun()) {
                //TODO: use other exception?
                throw new IllegalStateException("No active executable steps in cursor");
            }

            return ExecutableFlow.with(Collections.singletonList(currentStep()), intermediate);
        }

        public Tuple value() {
            return intermediate;
        }

        @SuppressWarnings("unchecked")
        public O await() {
            return notificationHolder.await();
        }

        private boolean isReady() {
            return notificationHolder.isReady();
        }

        public boolean isBlocking() {
            return !canRun() || currentStep().type() != StepType.SYNC;
        }

        public boolean isAsync() {
            return canRun() && currentStep().type() == StepType.ASYNC;
        }

        public int group() {
            return canRun() ? currentStep().group() : -1;
        }

        public boolean canRun() {
            return !isReady() && index < steps.size();
        }

        @SuppressWarnings("unchecked")
        public ExecutableFlow<O, I> step() {
            if (canRun()) {
                try {
                    intermediate = currentStep().apply(intermediate);

                    if (isLastStep()) {
                        notificationHolder.notify((O) intermediate);
                    }
                } catch (Throwable t) {
                    Tuple res = currentStep().handle(t);

                    if (res != null) {
                        //Assume error is handled
                        if (isLastStep()) {
                            notificationHolder.notify((O) intermediate);
                        }
                    } else {
                        notificationHolder.notifyError(t);
                    }
                }
            }

            return this;
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
    }
}
