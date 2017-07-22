package org.rxbooter.flow.reactor.impl;

/*
 * Copyright (c) 2017 Sergiy Yevtushenko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 */

import org.junit.Test;
import org.rxbooter.flow.reactor.impl.DaemonThreadFactory;
import org.rxbooter.flow.reactor.impl.FixedThreadPool;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class FixedThreadPoolTest {
    @Test
    public void shouldStartPool() throws Exception {
        FixedThreadPool pool = new FixedThreadPool(3, new DaemonThreadFactory("test-"));
        CountDownLatch latch = new CountDownLatch(1);
        AtomicInteger counter = new AtomicInteger(0);

        pool.start(() -> {safe(latch::await); counter.incrementAndGet();});

        latch.countDown();

        safe(() -> Thread.sleep(20));
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
    public void shouldNotAllowNullTarget() throws Exception {
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