package org.rxbooter.flow;

import org.junit.Test;
import org.rxbooter.flow.impl.FixedPoolsReactor;

public class FixedPoolsReactorTest {
    @Test
    public void shouldHandleSupplier() throws Exception {
        Long value = FixedPoolsReactor.defaultReactor().await(this::slowMethod1);

        System.out.println("Slow method returned value = " + value);
    }

    private long slowMethod1() {
        System.out.println("Starting slow operation...");
        sleep(300);
        System.out.println("Slow operation done.");
        return 42L;
    }

    private static void sleep(long delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            //Ignore
        }
    }
}