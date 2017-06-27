package org.rxbooter.flow;

import org.rxbooter.flow.Functions.FN11;
import org.rxbooter.flow.Tuples.Tuple;
import org.rxbooter.flow.Tuples.Tuple1;

import java.util.function.Function;
import java.util.function.Supplier;

public class Step<R1, T1> {
    private final StepType type;
    private final TF<R1, T1> function;
    private final EH<R1> handler;
    private long time = Long.MAX_VALUE;
    private int group = 0;

    public Step(StepType type, TF<R1, T1> function) {
        this(type, function, (t) -> null);
    }

    public Step(StepType type, TF<R1, T1> function, EH<R1> handler) {
        this.type = type;
        this.function = function;
        this.handler = handler;
    }

    @SuppressWarnings("unchecked")
    public static <O, I> Step<Tuple1<O>, Tuple1<I>> waiting(FN11<O, I> function) {
        return new Step<>(StepType.AWAIT, (p) -> function.apply((I) p.get(0)));
    }

    @SuppressWarnings("unchecked")
    public static <O, I> Step<Tuple1<O>, Tuple1<I>> waiting(Function<I, O> function) {
        return new Step<>(StepType.AWAIT, (p) -> Tuples.of(function.apply((I) p.get(0))));
    }

    @SuppressWarnings("unchecked")
    public static <O> Step<Tuple1<O>, Tuple> waiting(Supplier<O> function) {
        return new Step<>(StepType.AWAIT, (p) -> Tuples.of(function.get()));
    }

    @SuppressWarnings("unchecked")
    public static <O, I> Step<Tuple1<O>, Tuple1<I>> async(FN11<O, I> function) {
        return new Step<>(StepType.ASYNC, (p) -> function.apply((I) p.get(0)));
    }

    @SuppressWarnings("unchecked")
    public static <O> Step<Tuple1<O>, Tuple> async(Supplier<O> function) {
        return new Step<>(StepType.ASYNC, (p) -> Tuples.of(function.get()));
    }

    @SuppressWarnings("unchecked")
    public static <O, I> Step<Tuple1<O>, Tuple1<I>> async(Function<I, O> function) {
        return new Step<>(StepType.ASYNC, (p) -> Tuples.of(function.apply((I) p.get(0))));
    }

    @SuppressWarnings("unchecked")
    public static <O, I> Step<Tuple1<O>, Tuple1<I>> single(FN11<O, I> function) {
        return new Step<>(StepType.SYNC, (p) -> function.apply((I) p.get(0)));
    }

    @SuppressWarnings("unchecked")
    public static <O> Step<Tuple1<O>, Tuple> single(Supplier<O> function) {
        return new Step<>(StepType.SYNC, (p) -> Tuples.of(function.get()));
    }

    @SuppressWarnings("unchecked")
    public static <O, I> Step<Tuple1<O>, Tuple1<I>> single(Function<I, O> function) {
        return new Step<>(StepType.SYNC, (p) -> Tuples.of(function.apply((I) p.get(0))));
    }

    public StepType type() {
        return type;
    }

    public long time() {
        return time;
    }

    public R1 apply(T1 param) throws Throwable {
        return function.apply(param);
    }

    public R1 handle(Throwable param) {
        return handler.handle(param);
    }

    public R1 profile(T1 param) throws Throwable {
        long start = System.nanoTime();
        try {
            return function.apply(param);
        } finally {
            time = System.nanoTime() - start;
        }
    }

    public int group() {
        return group;
    }

    public Step<R1, T1> group(int group) {
        this.group = group;
        return this;
    }

    public interface TF<R1, T1> {
        R1 apply(T1 param) throws Throwable;
    }

    public interface EH<R1> {
        R1 handle(Throwable err);
    }
}
