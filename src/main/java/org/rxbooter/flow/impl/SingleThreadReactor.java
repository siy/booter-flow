package org.rxbooter.flow.impl;

import java.util.function.Supplier;

import org.rxbooter.flow.Reactor;
import org.rxbooter.flow.Step;
import org.rxbooter.flow.Tuples;

//TODO: finish it
public class SingleThreadReactor implements Reactor {

    @Override
    public void shutdown() {

    }

    @Override
    public <O extends Tuples.Tuple, I extends Tuples.Tuple> O await(FlowExecutor<O, I> flowExecutor) {
        return null;
    }

    @Override
    public <O extends Tuples.Tuple, I extends Tuples.Tuple> void async(FlowExecutor<O, I> flowExecutor) {

    }

    @Override
    public void async(Runnable runnable) {

    }

    @Override
    public <T> T await(Supplier<T> supplier) {
        return null;
    }

    @Override
    public void async(Runnable runnable, Step.EH<Tuples.Tuple1<Void>> handler) {

    }

    @Override
    public <T> T await(Supplier<T> function, Step.EH<Tuples.Tuple1<T>> handler) {
        return null;
    }

    @Override
    public <T> T awaitAny(Supplier<T>... suppliers) {
        return null;
    }
}
