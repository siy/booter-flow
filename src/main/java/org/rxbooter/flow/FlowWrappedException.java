package org.rxbooter.flow;

public class FlowWrappedException extends RuntimeException {
    private static final long serialVersionUID = -4685894495982223864L;

    public FlowWrappedException(Throwable throwable) {
        super("Wrapped exception", throwable);
    }
}
