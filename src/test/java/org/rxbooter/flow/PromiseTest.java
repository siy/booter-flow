package org.rxbooter.flow;

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
import org.rxbooter.flow.FlowException;
import org.rxbooter.flow.FlowWrappedException;
import org.rxbooter.flow.Promise;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import static org.assertj.core.api.Assertions.assertThat;

public class PromiseTest {
    @Test
    public void shouldWaitForValueToBeSet() throws Exception {
        Promise<Integer> promise = Promise.empty();

        newThread(() -> {sleep(); promise.notify(42);}).start();

        assertThat(promise.get()).isNotPresent();
        assertThat(promise.await()).isEqualTo(42);
        assertThat(promise.isReady()).isTrue();
    }

    @Test
    public void shouldWaitForValueToBeSetWithoutExceptions() throws Exception {
        Promise<Integer> promise = Promise.empty();

        newThread(() -> {sleep(); promise.notify(42);}).start();

        assertThat(promise.get()).isNotPresent();
        assertThat(promise.safeAwait()).isEqualTo(Optional.of(42));
        assertThat(promise.isReady()).isTrue();
    }

    @Test
    public void shouldInvokeListenersInstalledBeforePromiseIsReady() throws Exception {
        AtomicInteger result = new AtomicInteger();
        Promise<Integer> promise = Promise.<Integer>empty().then(v -> result.set(v));

        newThread(() -> {sleep(); promise.notify(42);}).start();

        assertThat(promise.get()).isNotPresent();
        assertThat(promise.safeAwait()).isEqualTo(Optional.of(42));
        assertThat(promise.isReady()).isTrue();

        assertThat(result.get()).isEqualTo(42);
    }

    @Test
    public void shouldInvokeErrorListenersInstalledBeforePromiseIsReady() throws Exception {
        AtomicReference<Throwable> result = new AtomicReference<>();
        Promise<Integer> promise = Promise.<Integer>empty().onError(v -> result.set(v));

        newThread(() -> {sleep(); promise.notifyError(new RuntimeException());}).start();

        assertThat(promise.getError()).isNotPresent();
        assertThat(promise.safeAwait()).isEmpty();
        assertThat(promise.isReady()).isTrue();

        assertThat(result.get()).isNotNull();
    }

    @Test
    public void shouldInvokeListenersInstalledAfterPromiseIsReady() throws Exception {
        List<Integer> results = new ArrayList<>();
        Promise<Integer> promise = Promise.empty();

        newThread(() -> {sleep(); promise.notify(42);}).start();

        assertThat(promise.get()).isNotPresent();
        assertThat(promise.safeAwait()).isEqualTo(Optional.of(42));
        assertThat(promise.isReady()).isTrue();

        promise.then(v -> results.add(v));

        assertThat(results.size()).isEqualTo(1);
        assertThat(results.get(0)).isEqualTo(42);
    }

    @Test
    public void shouldInvokeErrorListenersInstalledAfterPromiseIsReady() throws Exception {
        Promise<Integer> promise = Promise.error(new RuntimeException());
        AtomicReference<Throwable> result = new AtomicReference<>();

        promise.onError(t -> result.set(t));

        assertThat(promise.getError()).isPresent();
        assertThat(promise.isReady()).isTrue();

        assertThat(result.get()).isNotNull();
    }

    @Test
    public void shouldIgnoreExceptionThrownByListener() throws Exception {
        List<Integer> results = new ArrayList<>();
        Promise.ready(32)
               .then(v -> { results.add(v); throw new RuntimeException("oops!"); })
               .then(v -> { results.add(v); throw new RuntimeException("oops!"); });

        assertThat(results).hasSize(2);
        assertThat(results).containsExactly(32, 32);
    }

    @Test
    public void shouldWaitForRequestedNumberOfNotifications() throws Exception {
        Promise<Integer> promise = Promise.waifFor(2);
        AtomicReference<Optional<Integer>> value = new AtomicReference<>();
        CountDownLatch latch = new CountDownLatch(1);

        newThread(() -> {value.set(promise.safeAwait()); latch.countDown();}).start();

        assertThat(value.get()).isNull();
        promise.notifyError(new RuntimeException());
        assertThat(value.get()).isNull();
        promise.notifyError(new RuntimeException());
        latch.await();
        assertThat(value.get()).isNotNull();
    }

    @Test
    public void shouldStopWaitingAfterFirstSuccessfulNotification() throws Exception {
        Promise<Integer> promise = Promise.waifFor(100);
        AtomicReference<Optional<Integer>> value = new AtomicReference<>();
        CountDownLatch latch = new CountDownLatch(1);

        newThread(() -> {value.set(promise.safeAwait()); latch.countDown();}).start();

        assertThat(value.get()).isNull();
        promise.notify(97);
        latch.await();
        assertThat(value.get()).isNotNull();
        assertThat(value.get().get()).isEqualTo(97);
    }

    @Test
    public void shouldLeaveRuntimeExceptionAsIs() throws Exception {
        Promise<Integer> promise = Promise.error(new RuntimeException());

        try {
            promise.await();
        } catch (RuntimeException e) {
            assertThat(e.getClass().isAssignableFrom(RuntimeException.class)).isTrue();
        }
    }

    @Test
    public void shouldUnwrapFlowExceptionIfItHoldsRuntimeException() throws Exception {
        Promise<Integer> promise = Promise.error(new FlowException(new RuntimeException()));

        try {
            promise.await();
        } catch (RuntimeException e) {
            assertThat(e.getClass().isAssignableFrom(RuntimeException.class)).isTrue();
        }
    }

    @Test
    public void shouldWrapCheckedExceptionIntoFlowWrappedException() throws Exception {
        Promise<Integer> promise = Promise.error(new Exception());

        try {
            promise.await();
        } catch (RuntimeException e) {
            assertThat(e.getClass().isAssignableFrom(FlowWrappedException.class)).isTrue();
            assertThat(e.getCause().getClass().isAssignableFrom(Exception.class)).isTrue();
        }
    }

    @Test
    public void shouldUnwrapFlowExceptionAndWrapCheckedExceptionIntoFlowWrappedException() throws Exception {
        Promise<Integer> promise = Promise.error(new FlowException(new Exception()));

        try {
            promise.await();
        } catch (RuntimeException e) {
            assertThat(e.getClass().isAssignableFrom(FlowWrappedException.class)).isTrue();
            assertThat(e.getCause().getClass().isAssignableFrom(Exception.class)).isTrue();
        }
    }

    @Test
    public void shouldIgnoreNullListener() throws Exception {
        Promise.ready(10).then(null);
    }

    @Test
    public void shouldSetValueOnlyOnce() throws Exception {
        Promise<Integer> promise = Promise.empty();

        newThread(() -> {promise.notify(40); promise.notify(41);}).start();
        sleep();
        assertThat(promise.await()).isEqualTo(40);
        assertThat(promise.isReady()).isTrue();
    }

    @Test
    public void shouldRethrowNotifiedError() throws Exception {
        Promise<Integer> promise = Promise.empty();

        newThread(() -> {sleep(); promise.notifyError(new FlowException("oops!"));}).start();

        try {
            promise.await();
        } catch (Throwable e) {
            assertThat(e).isInstanceOf(FlowWrappedException.class);
            assertThat(e.getMessage()).endsWith("oops!");
        }
        assertThat(promise.isReady()).isTrue();
    }

    @Test
    public void shouldReturnNotifiedError() throws Exception {
        Promise<Integer> promise = Promise.empty();

        newThread(() -> {sleep(); promise.notifyError(new FlowException("oops!"));}).start();
        Optional<Integer> result = promise.safeAwait();
        assertThat(result).isEmpty();
        assertThat(promise.isReady()).isTrue();
        assertThat(promise.isError()).isTrue();
        assertThat(promise.getError()).isNotEmpty();
        assertThat(promise.getError().get()).isInstanceOf(FlowException.class);
    }

    @Test
    public void shouldSetErrorOnlyOnce() throws Exception {
        Promise<Integer> promise = Promise.empty();

        newThread(() -> {promise.notifyError(new FlowException("oops!")); promise.notifyError(new RuntimeException("oops!"));}).start();
        sleep(20);

        try {
            promise.await();
        } catch (Throwable e) {
            assertThat(e).isInstanceOf(FlowWrappedException.class);
            assertThat(e.getMessage()).endsWith("oops!");
        }
        assertThat(promise.isReady()).isTrue();
    }

    @Test
    public void shouldHaveValueSetIfReady() throws Exception {
        Promise<Integer> promise = Promise.ready(42);
        assertThat(promise.isReady()).isTrue();
        assertThat(promise.get().get()).isEqualTo(42);
        assertThat(promise.await()).isEqualTo(42);
    }

    @Test(expected = FlowWrappedException.class)
    public void shouldHaveErrorSetIfReady() throws Exception {
        Promise<Integer> promise = Promise.error(new FlowException("oops!"));
        assertThat(promise.isReady()).isTrue();
        assertThat(promise.get()).isNotPresent();
        promise.await();
    }

    private void sleep() {
        sleep(25);
    }

    private void sleep(long delay) {
        long start = System.currentTimeMillis();

        do {
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                //Ignore
            }
        } while((System.currentTimeMillis() - start) < delay);
    }

    private Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        return thread;
    }
}