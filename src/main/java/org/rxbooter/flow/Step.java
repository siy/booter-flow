package org.rxbooter.flow;

public class Step<R1, T1> {
    private final ExecutionType type;
    private final TF<R1, T1> function;
    private final EH<R1> errorHandler;

    private Step(ExecutionType type, TF<R1, T1> function) {
        this(type, function, (t) -> null);
    }

    private Step(ExecutionType type, TF<R1, T1> function, EH<R1> errorHandler) {
        this.type = type;
        this.function = function;
        this.errorHandler = errorHandler;
    }

    public static<R, T> Step<R, T> sync(TF<R, T> function) {
        return new Step<>(ExecutionType.SYNC, function);
    }

    public static<R, T> Step<R, T> sync(TF<R, T> function, EH<R> errorHandler) {
        return new Step<>(ExecutionType.SYNC, function, errorHandler);
    }

    public static<R, T> Step<R, T> async(TF<R, T> function) {
        return new Step<>(ExecutionType.ASYNC, function);
    }

    public static<R, T> Step<R, T> async(TF<R, T> function, EH<R> errorHandler) {
        return new Step<>(ExecutionType.ASYNC, function, errorHandler);
    }

    public static<R, T> Step<R, T> await(TF<R, T> function) {
        return new Step<>(ExecutionType.AWAIT, function);
    }

    public static<R, T> Step<R, T> await(TF<R, T> function, EH<R> errorHandler) {
        return new Step<>(ExecutionType.AWAIT, function, errorHandler);
    }

    public ExecutionType type() {
        return type;
    }

    public R1 apply(T1 param) {
        try {
            return function.apply(param);
        } catch (Throwable t) {
            R1 res = errorHandler.handle(t);

            if (res == null) {
                throw new FlowException("User code threw an unhandled exception ", t);
            }
            return res;
        }
    }

    public interface TF<R1, T1> {
        R1 apply(T1 param) throws Throwable;
    }

    public interface EH<R1> {
        R1 handle(Throwable err);
    }
}
