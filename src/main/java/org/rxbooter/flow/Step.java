package org.rxbooter.flow;

import org.rxbooter.flow.Tuples.Tuple;
import org.rxbooter.flow.Tuples.Tuple1;

import java.util.function.Supplier;

public class Step<R1, T1> {
    private final ExecutionType type;
    private final TF<R1, T1> function;

    private EH<R1> handler = (t) -> null;

    private Step(ExecutionType type, TF<R1, T1> function, EH<R1> handler) {
        this.type = type;
        this.function = function;
        this.handler = handler == null ? this.handler : handler;
    }

    public EH<R1> handler() {
        return handler;
    }

    public Step handler(EH<R1> errorHandler) {
        this.handler = errorHandler;
        return this;
    }

    public ExecutionType type() {
        return type;
    }

    public R1 apply(T1 param) {
        try {
            return function.apply(param);
        } catch (Throwable t) {
            R1 res = handler.handle(t);

            if (res == null) {
                throw new FlowException("User code threw an unhandled exception ", t);
            }
            return res;
        }
    }

    public static<R, T> Step<R, T> of(ExecutionType type, TF<R, T> function, EH<R> errorHandler) {
        return new Step<>(type, function, errorHandler);
    }

    public static<R, T> Step<R, T> sync(TF<R, T> function) {
        return new Step<>(ExecutionType.SYNC, function, null);
    }

    public static<R, T> Step<R, T> sync(TF<R, T> function, EH<R> errorHandler) {
        return new Step<>(ExecutionType.SYNC, function, errorHandler);
    }

    public static<R, T> Step<R, T> async(TF<R, T> function) {
        return new Step<>(ExecutionType.ASYNC, function, null);
    }

    public static<R, T> Step<R, T> async(TF<R, T> function, EH<R> errorHandler) {
        return new Step<>(ExecutionType.ASYNC, function, errorHandler);
    }

    public static<R, T> Step<R, T> await(TF<R, T> function) {
        return new Step<>(ExecutionType.AWAIT, function, null);
    }

    public static<R, T> Step<R, T> await(TF<R, T> function, EH<R> errorHandler) {
        return new Step<>(ExecutionType.AWAIT, function, errorHandler);
    }

    public static TF<Tuple1<Void>, Tuple> from(Runnable runnable) {
        return (a) -> {runnable.run(); return Tuples.of(null);};
    }

    public static <T> TF<Tuple1<T>, Tuple> from(Supplier<T> supplier) {
        return (t) -> Tuples.of(supplier.get());
    }

    public interface TF<R1, T1> {
        R1 apply(T1 param) throws Throwable;
    }

    public interface EH<R1> {
        R1 handle(Throwable err);
    }
}
