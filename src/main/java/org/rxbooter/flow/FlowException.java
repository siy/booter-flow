package org.rxbooter.flow;

public class FlowException extends RuntimeException {
    private static final long serialVersionUID = -4685894495982223864L;

    public FlowException(String message) {
        super(message);
    }

    public FlowException(Throwable throwable) {
        super(throwable);
    }

    public FlowException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
