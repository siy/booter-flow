package org.rxbooter.flow;

import org.rxbooter.flow.impl.FlowExecutor;

public abstract class Task implements Runnable {
    private static final Step.EH<Tuples.Tuple1<Void>> DEFAULT_HANDLER = (t) -> null;

    private final ExecutionType type;

    private Task(ExecutionType type) {
        this.type = type;
    }

    public static Task sync(Runnable runnable) {
        return sync(runnable, DEFAULT_HANDLER);
    }

    public static Task sync(Runnable runnable, Step.EH<Tuples.Tuple1<Void>> handler) {
        return new Task(ExecutionType.SYNC) {
            @Override
            public void run() {
                try {
                    runnable.run();
                } catch (Throwable t) {
                    handler.handle(t);
                }
            }
        };
    }

    public static Task async(Runnable runnable) {
        return async(runnable, DEFAULT_HANDLER);
    }

    public static Task async(Runnable runnable, Step.EH<Tuples.Tuple1<Void>> handler) {
        return new Task(ExecutionType.ASYNC) {
            @Override
            public void run() {
                try {
                    runnable.run();
                } catch (Throwable t) {
                    handler.handle(t);
                }
            }
        };
    }

    public static Task await(Runnable runnable) {
        return await(runnable, DEFAULT_HANDLER);
    }

    public static Task await(Runnable runnable, Step.EH<Tuples.Tuple1<Void>> handler) {
        return new Task(ExecutionType.AWAIT) {
            @Override
            public void run() {
                try {
                    runnable.run();
                } catch (Throwable t) {
                    handler.handle(t);
                }
            }
        };
    }
}
