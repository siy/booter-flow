package org.rxbooter.flow;

public class Step<R1, T1> {
    private final StepType type;
    private final TF<R1, T1> function;
    private long time = Long.MAX_VALUE;

    public Step(StepType type, TF<R1, T1> function) {
        this.type = type;
        this.function = function;
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

    public R1 profile(T1 param) throws Throwable {
        long start = System.nanoTime();
        try {
            return function.apply(param);
        } finally {
            time = System.nanoTime() - start;
        }
    }

    public interface TF<R1, T1> {
        R1 apply(T1 param) throws Throwable;
    }
}
