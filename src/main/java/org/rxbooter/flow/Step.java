package org.rxbooter.flow;

public class Step<R1, T1> {
    private StepType type;
    private final TF<R1, T1> function;
    private final EH<R1> errorHandler;
    private long time = Long.MAX_VALUE;
    private int group = 0;

    private Step(StepType type, TF<R1, T1> function) {
        this(type, function, (t) -> null);
    }

    private Step(StepType type, TF<R1, T1> function, EH<R1> errorHandler) {
        this.type = type;
        this.function = function;
        this.errorHandler = errorHandler;
    }

    public static<R, T> Step<R, T> with(StepType type, TF<R, T> function) {
        return new Step<>(type, function);
    }

    public static<R, T> Step<R, T> with(StepType type, TF<R, T> function, EH<R> errorHandler) {
        return new Step<>(type, function, errorHandler);
    }

    public static<R, T> Step<R, T> sync(TF<R, T> function) {
        return with(StepType.SYNC, function);
    }

    public static<R, T> Step<R, T> sync(TF<R, T> function, EH<R> errorHandler) {
        return with(StepType.SYNC, function, errorHandler);
    }

    public static<R, T> Step<R, T> async(TF<R, T> function) {
        return with(StepType.ASYNC, function);
    }

    public static<R, T> Step<R, T> async(TF<R, T> function, EH<R> errorHandler) {
        return with(StepType.ASYNC, function, errorHandler);
    }

    public static<R, T> Step<R, T> await(TF<R, T> function) {
        return with(StepType.AWAIT, function);
    }

    public static<R, T> Step<R, T> await(TF<R, T> function, EH<R> errorHandler) {
        return with(StepType.AWAIT, function, errorHandler);
    }

    public StepType type() {
        return type;
    }

    public Step<R1, T1> type(StepType type) {
        this.type = type;
        return this;
    }

    public long time() {
        return time;
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

    public R1 profile(T1 param) {
        long start = System.nanoTime();
        try {
            return apply(param);
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
