package org.rxbooter.flow;

import org.junit.Test;
import org.rxbooter.flow.impl.ThreadPoolReactor;

import static org.assertj.core.api.Assertions.assertThat;

//TODO: finish it
public class ThreadPoolReactorTest {
    @Test
    public void shouldHandleSlowSupplier() throws Exception {
        Long value = ThreadPoolReactor.defaultReactor().await(this::slowMethod1);

        assertThat(value).isEqualTo(42L);
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