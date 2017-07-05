package org.rxbooter.flow;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.assertj.core.api.Assertions.assertThat;

public class StepTest {
    // Sync
    @Test
    public void shouldExecuteFunctionForSyncType() throws Exception {
        Step<Object, String> step = Step.sync((String a) -> "<a: " + a + ">");
        assertThat(step.apply("value")).isEqualTo("<a: value>");
        assertThat(step.type()).isEqualTo(ExecutionType.SYNC);
    }

    @Test
    public void shouldNotifyOnExceptionForSyncType() throws Exception {
        AtomicReference<Throwable> value = new AtomicReference<>();
        Step<Object, String> step = Step.sync((String a) -> {
            throw new RuntimeException();
        }, (t) -> {
            value.set(t);
            return "some other value";
        });


        assertThat(step.apply("some value")).isEqualTo("some other value");
        assertThat(value.get()).isInstanceOf(RuntimeException.class);
    }

    @Test(expected = FlowException.class)
    public void shouldThrowFlowExceptionWhenSourceExceptionIsNotHandledForSyncType() throws Exception {
        Step.sync((String a) -> { throw new RuntimeException();}, (t) -> null).apply("abc");
    }

    @Test(expected = FlowException.class)
    public void shouldThrowFlowExceptionWhenExceptionHandlerIsNotProvidedForSyncType() throws Exception {
        Step.sync((String a) -> { throw new RuntimeException();}).apply("abc");
    }

    //Async
    @Test
    public void shouldExecuteFunctionForAsyncType() throws Exception {
        Step<Object, String> step = Step.async((String a) -> "<a: " + a + ">");
        assertThat(step.apply("value")).isEqualTo("<a: value>");
        assertThat(step.type()).isEqualTo(ExecutionType.ASYNC);
    }

    @Test
    public void shouldNotifyOnExceptionForAsyncType() throws Exception {
        AtomicReference<Throwable> value = new AtomicReference<>();
        Step<Object, String> step = Step.async((String a) -> {
            throw new RuntimeException();
        }, (t) -> {
            value.set(t);
            return "some other value";
        });


        assertThat(step.apply("some value")).isEqualTo("some other value");
        assertThat(value.get()).isInstanceOf(RuntimeException.class);
    }

    @Test(expected = FlowException.class)
    public void shouldThrowFlowExceptionWhenSourceExceptionIsNotHandledForAsyncType() throws Exception {
        Step.async((String a) -> { throw new RuntimeException();}, (t) -> null).apply("abc");
    }

    @Test(expected = FlowException.class)
    public void shouldThrowFlowExceptionWhenExceptionHandlerIsNotProvidedForAsyncType() throws Exception {
        Step.async((String a) -> { throw new RuntimeException();}).apply("abc");
    }

    //Await
    @Test
    public void shouldExecuteFunctionForAwaitType() throws Exception {
        Step<Object, String> step = Step.await((String a) -> "<a: " + a + ">");
        assertThat(step.apply("value")).isEqualTo("<a: value>");
        assertThat(step.type()).isEqualTo(ExecutionType.AWAIT);
    }

    @Test
    public void shouldNotifyOnExceptionForAwaitType() throws Exception {
        AtomicReference<Throwable> value = new AtomicReference<>();
        Step<Object, String> step = Step.await((String a) -> {
            throw new RuntimeException();
        }, (t) -> {
            value.set(t);
            return "some other value";
        });


        assertThat(step.apply("some value")).isEqualTo("some other value");
        assertThat(value.get()).isInstanceOf(RuntimeException.class);
    }

    @Test(expected = FlowException.class)
    public void shouldThrowFlowExceptionWhenSourceExceptionIsNotHandledForAwaitType() throws Exception {
        Step.await((String a) -> { throw new RuntimeException();}, (t) -> null).apply("abc");
    }

    @Test(expected = FlowException.class)
    public void shouldThrowFlowExceptionWhenExceptionHandlerIsNotProvidedForAwaitType() throws Exception {
        Step.await((String a) -> { throw new RuntimeException();}).apply("abc");
    }
}