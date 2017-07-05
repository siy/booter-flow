package org.rxbooter.flow.impl;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

//TODO: finish it
public class FixedThreadPoolTest {
    @Test
    public void shouldStartPool() throws Exception {
        FixedThreadPool pool = new FixedThreadPool(3, new DaemonThreadFactory("test-"));
        CountDownLatch latch = new CountDownLatch(1);
        AtomicInteger counter = new AtomicInteger(0);

        pool.start(() -> {safe(latch::await); counter.incrementAndGet();});

        latch.countDown();

        safe(() -> Thread.sleep(100));
        assertThat(counter.get()).isEqualTo(3);
        pool.shutdown();
    }

    @Test(expected = IllegalStateException.class)
    public void shouldStartPoolOnce() throws Exception {
        FixedThreadPool pool = new FixedThreadPool(3, new DaemonThreadFactory("test-"));

        pool.start(() -> {});
        pool.start(() -> {});
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowNullTarged() throws Exception {
        FixedThreadPool pool = new FixedThreadPool(3, new DaemonThreadFactory("test-"));

        pool.start(null);
    }

    public interface ThrowingRunnable {
        void run() throws Exception;
    }

    public static void safe(ThrowingRunnable runnable) {
        try {
            runnable.run();
        } catch (Exception e) {
            fail("Failed with exception", e);
        }
    }
}