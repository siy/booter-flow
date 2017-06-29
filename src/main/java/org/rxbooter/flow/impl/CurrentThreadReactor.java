package org.rxbooter.flow.impl;

import java.util.function.Supplier;

import org.rxbooter.flow.Reactor;
import org.rxbooter.flow.Step;
import org.rxbooter.flow.Tuples.Tuple;
import org.rxbooter.flow.Tuples.Tuple1;

//TODO: finish it
public class CurrentThreadReactor implements Reactor {
    public static Reactor instance() {
        return DefaultReactorHolder.INSTANCE.reactor();
    }

    @Override
    public void shutdown() {
    }

    @Override
    public <O extends Tuple, I extends Tuple> O await(FlowExecutor<O, I> flowExecutor) {
        return null;
    }

    @Override
    public <T> T await(Supplier<T> supplier) {
        return null;
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
