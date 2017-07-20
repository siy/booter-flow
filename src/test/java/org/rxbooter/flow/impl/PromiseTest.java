package org.rxbooter.flow.impl;

import org.junit.Test;
import org.rxbooter.flow.FlowException;
import org.rxbooter.flow.FlowWrappedException;
import org.rxbooter.flow.Promise;

import static org.assertj.core.api.Assertions.assertThat;

public class PromiseTest {
    @Test
    public void shouldWaitForValueToBeSet() throws Exception {
        Promise<Integer> promise = Promise.empty();

        newThread(() -> {sleep(); promise.notify(42);}).start();

        assertThat(promise.get().isPresent()).isFalse();
        assertThat(promise.await()).isEqualTo(42);
        assertThat(promise.isReady()).isTrue();
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
        assertThat(promise.get().isPresent()).isFalse();
        promise.await();
    }

    private void sleep() {
        sleep(20);
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