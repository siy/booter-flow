package org.rxbooter.flow;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReactorTest {
    @Test
    public void shouldHandleSupplier() throws Exception {
        Long value = Reactor.defaultReactor().await(this::slowMethod1);

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