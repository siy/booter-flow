package org.rxbooter.flow.flux;

public class FlowException extends RuntimeException {
    private static final long serialVersionUID = -4685894495982223864L;

    public FlowException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
