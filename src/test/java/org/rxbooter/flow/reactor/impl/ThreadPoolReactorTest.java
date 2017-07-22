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

import java.util.Optional;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

import org.junit.Test;
import org.rxbooter.flow.reactor.Promise;
import org.rxbooter.flow.reactor.Reactor;
import org.rxbooter.flow.Tuples;
import org.rxbooter.flow.Tuples.Tuple1;
import org.rxbooter.flow.Tuples.Tuple2;
import org.rxbooter.flow.Tuples.Tuple3;
import org.rxbooter.flow.Tuples.Tuple4;
import org.rxbooter.flow.Tuples.Tuple5;
import org.rxbooter.flow.Tuples.Tuple6;
import org.rxbooter.flow.Tuples.Tuple7;
import org.rxbooter.flow.Tuples.Tuple8;
import org.rxbooter.flow.Tuples.Tuple9;
import org.rxbooter.flow.reactor.ThreadPool;
import org.rxbooter.flow.reactor.impl.ThreadPoolReactor;

import static org.assertj.core.api.Assertions.assertThat;

public class ThreadPoolReactorTest {
    private Reactor reactor() {
        return ThreadPoolReactor.defaultReactor();
    }

    @Test
    public void shouldHandleSlowSupplier() throws Exception {
        Long value = reactor().await(this::slowMethod1);
        assertThat(value).isEqualTo(42L);
    }

    @Test
    public void shouldRunAsyncTask() throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        Promise<Tuple1<Void>> promise = reactor().async(latch::countDown);
        promise.await();
        assertThat(latch.getCount()).isEqualTo(0);
    }

    @Test
    public void shouldInterceptExceptionInAsyncTask() throws Exception {
        AtomicReference<Throwable> reference = new AtomicReference<>();
        Promise<Tuple1<Void>> promise = reactor().async(() -> {throw new RuntimeException();}, (t) -> {reference.set(t); return Tuples.of(null);});
        promise.safeAwait();
        assertThat(promise.isReady()).isTrue();
        assertThat(reference.get()).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void shouldWaitForAwaitTask() throws Exception {
        String result = reactor().await(() -> "abc");
        assertThat(result).isEqualTo("abc");
    }

    @Test
    public void shouldInterceptExceptionForAwaitTask() throws Exception {
        String result = reactor().await(() -> {throw new RuntimeException();}, (t) -> Tuples.of("bca"));
        assertThat(result).isEqualTo("bca");
    }

    @Test
    public void shouldWaitForAllTasks1() throws Exception {
        long start = System.currentTimeMillis();
        Tuple1<Long> result = reactor().awaitAll(this::slowMethod1);

        assertThat(result.get1()).isEqualTo(42L);
        System.out.println("Time 1: " + (System.currentTimeMillis() - start));
    }

    @Test
    public void shouldWaitForAllTasks2() throws Exception {
        long start = System.currentTimeMillis();
        Tuple2<Long, Long> result = reactor().awaitAll(this::slowMethod1, this::slowMethod2);

        assertThat(result.get1()).isEqualTo(42L);
        assertThat(result.get2()).isEqualTo(24L);
        System.out.println("Time 2: " + (System.currentTimeMillis() - start));
    }

    @Test
    public void shouldWaitForAllTasks3() throws Exception {
        long start = System.currentTimeMillis();
        Tuple3<Long, Long, Long> result = reactor().awaitAll(this::slowMethod1,
                                                             this::slowMethod2,
                                                             this::slowMethod1);

        assertThat(result.get1()).isEqualTo(42L);
        assertThat(result.get2()).isEqualTo(24L);
        assertThat(result.get3()).isEqualTo(42L);
        System.out.println("Time 3: " + (System.currentTimeMillis() - start));
    }

    @Test
    public void shouldWaitForAllTasks4() throws Exception {
        long start = System.currentTimeMillis();
        Tuple4<Long, Long, Long, Long> result = reactor().awaitAll(this::slowMethod1,
                                                                   this::slowMethod2,
                                                                   this::slowMethod1,
                                                                   this::slowMethod2);

        assertThat(result.get1()).isEqualTo(42L);
        assertThat(result.get2()).isEqualTo(24L);
        assertThat(result.get3()).isEqualTo(42L);
        assertThat(result.get4()).isEqualTo(24L);
        System.out.println("Time 4: " + (System.currentTimeMillis() - start));
    }

    @Test
    public void shouldWaitForAllTasks5() throws Exception {
        long start = System.currentTimeMillis();
        Tuple5<Long, Long, Long, Long, Long> result = reactor().awaitAll(this::slowMethod1,
                                                                         this::slowMethod2,
                                                                         this::slowMethod1,
                                                                         this::slowMethod2,
                                                                         this::slowMethod1);

        assertThat(result.get1()).isEqualTo(42L);
        assertThat(result.get2()).isEqualTo(24L);
        assertThat(result.get3()).isEqualTo(42L);
        assertThat(result.get4()).isEqualTo(24L);
        assertThat(result.get5()).isEqualTo(42L);
        System.out.println("Time 5: " + (System.currentTimeMillis() - start));
    }

    @Test
    public void shouldWaitForAllTasks6() throws Exception {
        long start = System.currentTimeMillis();
        Tuple6<Long, Long, Long, Long, Long, Long> result = reactor().awaitAll(this::slowMethod1,
                                                                               this::slowMethod2,
                                                                               this::slowMethod1,
                                                                               this::slowMethod2,
                                                                               this::slowMethod1,
                                                                               this::slowMethod2);

        assertThat(result.get1()).isEqualTo(42L);
        assertThat(result.get2()).isEqualTo(24L);
        assertThat(result.get3()).isEqualTo(42L);
        assertThat(result.get4()).isEqualTo(24L);
        assertThat(result.get5()).isEqualTo(42L);
        assertThat(result.get6()).isEqualTo(24L);
        System.out.println("Time 6: " + (System.currentTimeMillis() - start));
    }

    @Test
    public void shouldWaitForAllTasks7() throws Exception {
        long start = System.currentTimeMillis();
        Tuple7<Long, Long, Long, Long, Long, Long, Long> result = reactor().awaitAll(this::slowMethod1,
                                                                                     this::slowMethod2,
                                                                                     this::slowMethod1,
                                                                                     this::slowMethod2,
                                                                                     this::slowMethod1,
                                                                                     this::slowMethod2,
                                                                                     this::slowMethod1);

        assertThat(result.get1()).isEqualTo(42L);
        assertThat(result.get2()).isEqualTo(24L);
        assertThat(result.get3()).isEqualTo(42L);
        assertThat(result.get4()).isEqualTo(24L);
        assertThat(result.get5()).isEqualTo(42L);
        assertThat(result.get6()).isEqualTo(24L);
        assertThat(result.get7()).isEqualTo(42L);
        System.out.println("Time 7: " + (System.currentTimeMillis() - start));
    }

    @Test
    public void shouldWaitForAllTasks8() throws Exception {
        long start = System.currentTimeMillis();
        Tuple8<Long, Long, Long, Long, Long, Long, Long, Long> result = reactor().awaitAll(this::slowMethod1,
                                                                                           this::slowMethod2,
                                                                                           this::slowMethod1,
                                                                                           this::slowMethod2,
                                                                                           this::slowMethod1,
                                                                                           this::slowMethod2,
                                                                                           this::slowMethod1,
                                                                                           this::slowMethod2);

        assertThat(result.get1()).isEqualTo(42L);
        assertThat(result.get2()).isEqualTo(24L);
        assertThat(result.get3()).isEqualTo(42L);
        assertThat(result.get4()).isEqualTo(24L);
        assertThat(result.get5()).isEqualTo(42L);
        assertThat(result.get6()).isEqualTo(24L);
        assertThat(result.get7()).isEqualTo(42L);
        assertThat(result.get8()).isEqualTo(24L);
        System.out.println("Time 8: " + (System.currentTimeMillis() - start));
    }

    @Test
    public void shouldWaitForAllTasks9() throws Exception {
        long start = System.currentTimeMillis();
        Tuple9<Long, Long, Long, Long, Long, Long, Long, Long, Long> result = reactor().awaitAll(this::slowMethod1,
                                                                                                 this::slowMethod2,
                                                                                                 this::slowMethod1,
                                                                                                 this::slowMethod2,
                                                                                                 this::slowMethod1,
                                                                                                 this::slowMethod2,
                                                                                                 this::slowMethod1,
                                                                                                 this::slowMethod2,
                                                                                                 this::slowMethod1);

        assertThat(result.get1()).isEqualTo(42L);
        assertThat(result.get2()).isEqualTo(24L);
        assertThat(result.get3()).isEqualTo(42L);
        assertThat(result.get4()).isEqualTo(24L);
        assertThat(result.get5()).isEqualTo(42L);
        assertThat(result.get6()).isEqualTo(24L);
        assertThat(result.get7()).isEqualTo(42L);
        assertThat(result.get8()).isEqualTo(24L);
        assertThat(result.get9()).isEqualTo(42L);
        System.out.println("Time 9: " + (System.currentTimeMillis() - start));
    }

    @Test
    public void shouldWaitForAnyTask() throws Exception {
        // slowMethod2 has shorter delay
        Optional<Long> result = reactor().awaitAny(this::slowMethod1, this::slowMethod2);

        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(24L);
    }

    @Test
    public void shouldStartAndShutdownNewReactor() throws Exception {
        Reactor reactor = Reactor.pooled(ThreadPool.fixedComputing(2), ThreadPool.fixedIo(5));

        String result = reactor.await(() -> "12345");
        assertThat(result).isEqualTo("12345");
        reactor.shutdown();
    }

    @Test(expected = IllegalStateException.class)
    public void shouldNotAcceptNewTasksAfterShutdown() throws Exception {
        Reactor reactor = Reactor.pooled(ThreadPool.fixedComputing(2), ThreadPool.fixedIo(5));
        reactor.shutdown();
        reactor.await(() -> "12345");
    }

    private long slowMethod1() {
        sleep(30);
        return 42L;
    }

    private long slowMethod2() {
        sleep(15);
        return 24L;
    }

    private static void sleep(long delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            //Ignore
        }
    }
}