package org.rxbooter.flow.impl;

import java.util.function.Supplier;

import org.rxbooter.flow.Flow;
import org.rxbooter.flow.Reactor;
import org.rxbooter.flow.Step;
import org.rxbooter.flow.Tuples;
import org.rxbooter.flow.Tuples.Tuple;
import org.rxbooter.flow.Tuples.Tuple1;

public class CurrentThreadReactor implements Reactor {
    public static Reactor instance() {
        return DefaultReactorHolder.INSTANCE.reactor();
    }

    @Override
    public void shutdown() {
    }

    @Override
    @SuppressWarnings("unchecked")
    public <O extends Tuple, I extends Tuple> O await(FlowExecutor<O, I> flowExecutor) {
        runToEnd(flowExecutor);
        return flowExecutor.isReady() ? (O) flowExecutor.value() : null;
    }

    private void runToEnd(FlowExecutor<?, ?> flowExecutor) {
        do {
            //Intentionally left empty
        } while (flowExecutor.stepAndAdvance());
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T await(Supplier<T> function) {
        FlowExecutor<Tuple1<T>, Tuple> flowExecutor = Flow.singleWaiting((t) -> Tuples.of(function.get())).applyTo(null);
        runToEnd(flowExecutor);
        return flowExecutor.isReady() ? ((Tuple1<T>) flowExecutor.value()).get() : null;
    }

    @Override
    public <O extends Tuple, I extends Tuple> Promise<O> submit(FlowExecutor<O, I> flowExecutor) {
        runToEnd(flowExecutor);
        return flowExecutor.promise();
    }

    @Override
    public <O extends Tuple, I extends Tuple> void async(FlowExecutor<O, I> flowExecutor) {
        throw new UnsupportedOperationException("CurrentThreadReactor does not support asynchronous execution");
    }

    @Override
    public void async(Runnable runnable) {
        throw new UnsupportedOperationException("CurrentThreadReactor does not support asynchronous execution");
    }

    @Override
    public void async(Runnable runnable, Step.EH<Tuple1<Void>> handler) {
        throw new UnsupportedOperationException("CurrentThreadReactor does not support asynchronous execution");
    }

    @Override
    public <T> T await(Supplier<T> function, Step.EH<Tuple1<T>> handler) {
        throw new UnsupportedOperationException("CurrentThreadReactor does not support asynchronous execution");
    }

    @Override
    public <T> T awaitAny(Supplier<T>... suppliers) {
        throw new UnsupportedOperationException("CurrentThreadReactor does not support asynchronous execution");
    }

    private enum DefaultReactorHolder {
        INSTANCE;

        private final CurrentThreadReactor reactor;

        DefaultReactorHolder() {
            reactor = new CurrentThreadReactor();
        }

        public CurrentThreadReactor reactor() {
            return reactor;
        }
    }
}
