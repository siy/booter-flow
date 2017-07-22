package org.rxbooter.flow.impl;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

import org.junit.Test;
import org.rxbooter.flow.*;
import org.rxbooter.flow.exception.FlowException;
import org.rxbooter.flow.reactor.Promise;
import org.rxbooter.flow.reactor.Reactor;

import static  org.rxbooter.flow.Tuples.*;
import static  org.rxbooter.flow.Functions.*;

import static org.assertj.core.api.Assertions.assertThat;

public class FlowBuildersTest {
    @SuppressWarnings("SpellCheckingInspection")
    @Test
    public void shouldBuildSimpleFlow() throws Exception {
        Flow<Tuple1<String>, Tuple1<String>> flow = Flow.take(String.class)
                                                        .mapTo2((s) -> Tuples.of(s, s.length()))
                                                        .map((s, l) -> Tuples.of(s.toLowerCase(), l * 2))
                                                        .mapTo1((s, l) -> Tuples.of(s + " - " + l))
                                                        .done();
        String result = flow.applyTo(Tuples.of("AbCdEf")).in(Reactor.pooled()).await().get1();
        assertThat(result).isEqualTo("abcdef - 12");
    }

    @Test
    public void shouldBuildFlowWithOneInput() throws Exception {
        assertOutput(Flow.take(String.class)
                         .mapTo2((s) -> Tuples.of(s, s + "2"))
                         .mapTo3((s1, s2) -> Tuples.of(s1, s2, s1 + "3"))
                         .mapTo4((s1, s2, s3) -> Tuples.of(s1, s2, s3, s1 + "4"))
                         .mapTo5((s1, s2, s3, s4) -> Tuples.of(s1, s2, s3, s4, s1 + "5"))
                         .mapTo6((s1, s2, s3, s4, s5) -> Tuples.of(s1, s2, s3, s4, s5, s1 + "6"))
                         .mapTo7((s1, s2, s3, s4, s5, s6) -> Tuples.of(s1, s2, s3, s4, s5, s6, s1 + "7"))
                         .mapTo8((s1, s2, s3, s4, s5, s6, s7) -> Tuples.of(s1, s2, s3, s4, s5, s6, s7, s1 + "8"))
                         .mapTo9((s1, s2, s3, s4, s5, s6, s7, s8) -> Tuples.of(s1 + "1", s2, s3, s4, s5, s6, s7, s8,s1 + "9"))
                         .done()
                         .applyTo(Tuples.of("input"))
                         .in(Reactor.pooled())
                         .await());
    }

    @Test
    public void shouldBuildFlowWithOneInputExtendingBy2() throws Exception {
        assertOutput(Flow.take(String.class)
                         .mapTo3((s) -> Tuples.of(s, s + "2", s + "3"))
                         .mapTo5((s1, s2, s3) -> Tuples.of(s1, s2, s3, s1 + "4", s1 + "5"))
                         .mapTo7((s1, s2, s3, s4, s5) -> Tuples.of(s1, s2, s3, s4, s5, s1 + "6", s1 + "7"))
                         .mapTo9((s1, s2, s3, s4, s5, s6, s7) -> Tuples.of(s1 + "1", s2, s3, s4, s5, s6, s7, s1 + "8",s1 + "9"))
                         .done()
                         .applyTo(Tuples.of("input"))
                         .in(Reactor.pooled())
                         .await());
    }

    @Test
    public void shouldBuildFlowWithOneInputExtendingBy3() throws Exception {
        assertOutput(Flow.take(String.class)
                         .mapTo4((s1) -> Tuples.of(s1, s1 + "2", s1 + "3", s1 + "4"))
                         .mapTo7((s1, s2, s3, s4) -> Tuples.of(s1 + "1", s2, s3, s4, s1 + "5", s1 + "6", s1 + "7"))
                         .done()
                         .applyTo(Tuples.of("input"))
                         .in(Reactor.pooled())
                         .await());
    }

    @Test
    public void shouldBuildFlowWithOneInputExtendingBy4() throws Exception {
        assertOutput(Flow.take(String.class)
                         .mapTo5((s1) -> Tuples.of(s1, s1 + "2", s1 + "3", s1 + "4", s1 + "5"))
                         .mapTo9((s1, s2, s3, s4, s5) -> Tuples.of(s1 + "1", s2, s3, s4, s5, s1 + "6", s1 + "7", s1 + "8",s1 + "9"))
                         .done()
                         .applyTo(Tuples.of("input"))
                         .in(Reactor.pooled())
                         .await());
    }

    @Test
    public void shouldBuildFlowWithOneInputExtendingBy5() throws Exception {
        assertOutput(Flow.take(String.class)
                         .mapTo6((s1) -> Tuples.of(s1 + "1", s1 + "2", s1 + "3", s1 + "4", s1 + "5", s1 + "6"))
                         .done()
                         .applyTo(Tuples.of("input"))
                         .in(Reactor.pooled())
                         .await());
    }

    @Test
    public void shouldBuildFlowWithOneInputExtendingBy6() throws Exception {
        assertOutput(Flow.take(String.class)
                         .mapTo7((s1) -> Tuples.of(s1 + "1", s1 + "2", s1 + "3", s1 + "4", s1 + "5", s1 + "6", s1 + "7"))
                         .done()
                         .applyTo(Tuples.of("input"))
                         .in(Reactor.pooled())
                         .await());
    }

    @Test
    public void shouldBuildFlowWithTwoInputs() throws Exception {
        assertOutput(Flow.take(String.class, String.class)
                         .mapTo3((s1, s2) -> Tuples.of(s1, s2, s1 + "3"))
                         .mapTo4((s1, s2, s3) -> Tuples.of(s1, s2, s3, s1 + "4"))
                         .mapTo5((s1, s2, s3, s4) -> Tuples.of(s1, s2, s3, s4, s1 + "5"))
                         .mapTo6((s1, s2, s3, s4, s5) -> Tuples.of(s1, s2, s3, s4, s5, s1 + "6"))
                         .mapTo7((s1, s2, s3, s4, s5, s6) -> Tuples.of(s1, s2, s3, s4, s5, s6, s1 + "7"))
                         .mapTo8((s1, s2, s3, s4, s5, s6, s7) -> Tuples.of(s1, s2, s3, s4, s5, s6, s7, s1 + "8"))
                         .mapTo9((s1, s2, s3, s4, s5, s6, s7, s8) -> Tuples.of(s1 + "1", s2, s3, s4, s5, s6, s7, s8,s1 + "9"))
                         .done()
                         .applyTo(Tuples.of("input", "input2"))
                         .in(Reactor.pooled())
                         .await());
    }

    @Test
    public void shouldBuildFlowWithTwoInputsExtendingBy2() throws Exception {
        assertOutput(Flow.take(String.class, String.class)
                         .mapTo4((s1, s2) -> Tuples.of(s1, s2, s1 + "3", s1 + "4"))
                         .mapTo6((s1, s2, s3, s4) -> Tuples.of(s1, s2, s3, s4, s1 + "5", s1 + "6"))
                         .mapTo8((s1, s2, s3, s4, s5, s6) -> Tuples.of(s1 + "1", s2, s3, s4, s5, s6, s1 + "7", s1 + "8"))
                         .done()
                         .applyTo(Tuples.of("input", "input2"))
                         .in(Reactor.pooled())
                         .await());
    }

    @Test
    public void shouldBuildFlowWithThreeInputs() throws Exception {
        assertOutput(Flow.take(String.class, String.class, String.class)
                         .mapTo4((s1, s2, s3) -> Tuples.of(s1, s2, s3, s1 + "4"))
                         .mapTo5((s1, s2, s3, s4) -> Tuples.of(s1, s2, s3, s4, s1 + "5"))
                         .mapTo6((s1, s2, s3, s4, s5) -> Tuples.of(s1, s2, s3, s4, s5, s1 + "6"))
                         .mapTo7((s1, s2, s3, s4, s5, s6) -> Tuples.of(s1, s2, s3, s4, s5, s6, s1 + "7"))
                         .mapTo8((s1, s2, s3, s4, s5, s6, s7) -> Tuples.of(s1, s2, s3, s4, s5, s6, s7, s1 + "8"))
                         .mapTo9((s1, s2, s3, s4, s5, s6, s7, s8) -> Tuples.of(s1 + "1", s2, s3, s4, s5, s6, s7, s8,s1 + "9"))
                         .done()
                         .applyTo(Tuples.of("input", "input2", "input3"))
                         .in(Reactor.pooled())
                         .await());
    }

    @Test
    public void shouldBuildFlowWithFourInputs() throws Exception {
        assertOutput(Flow.take(String.class, String.class, String.class, String.class)
                         .mapTo5((s1, s2, s3, s4) -> Tuples.of(s1, s2, s3, s4, s1 + "5"))
                         .mapTo6((s1, s2, s3, s4, s5) -> Tuples.of(s1, s2, s3, s4, s5, s1 + "6"))
                         .mapTo7((s1, s2, s3, s4, s5, s6) -> Tuples.of(s1, s2, s3, s4, s5, s6, s1 + "7"))
                         .mapTo8((s1, s2, s3, s4, s5, s6, s7) -> Tuples.of(s1, s2, s3, s4, s5, s6, s7, s1 + "8"))
                         .mapTo9((s1, s2, s3, s4, s5, s6, s7, s8) -> Tuples.of(s1 + "1", s2, s3, s4, s5, s6, s7, s8,s1 + "9"))
                         .done()
                         .applyTo(Tuples.of("input", "input2", "input3", "input4"))
                         .in(Reactor.pooled())
                         .await());
    }

    @Test
    public void shouldBuildFlowWithFiveInputs() throws Exception {
        assertOutput(Flow.take(String.class, String.class, String.class, String.class, String.class)
                         .mapTo6((s1, s2, s3, s4, s5) -> Tuples.of(s1, s2, s3, s4, s5, s1 + "6"))
                         .mapTo7((s1, s2, s3, s4, s5, s6) -> Tuples.of(s1, s2, s3, s4, s5, s6, s1 + "7"))
                         .mapTo8((s1, s2, s3, s4, s5, s6, s7) -> Tuples.of(s1, s2, s3, s4, s5, s6, s7, s1 + "8"))
                         .mapTo9((s1, s2, s3, s4, s5, s6, s7, s8) -> Tuples.of(s1 + "1", s2, s3, s4, s5, s6, s7, s8,s1 + "9"))
                         .done()
                         .applyTo(Tuples.of("input", "input2", "input3", "input4", "input5"))
                         .in(Reactor.pooled())
                         .await());
    }

    @Test
    public void shouldBuildFlowWithSixInputs() throws Exception {
        assertOutput(Flow.take(String.class, String.class, String.class, String.class, String.class, String.class)
                         .mapTo7((s1, s2, s3, s4, s5, s6) -> Tuples.of(s1, s2, s3, s4, s5, s6, s1 + "7"))
                         .mapTo8((s1, s2, s3, s4, s5, s6, s7) -> Tuples.of(s1, s2, s3, s4, s5, s6, s7, s1 + "8"))
                         .mapTo9((s1, s2, s3, s4, s5, s6, s7, s8) -> Tuples.of(s1 + "1", s2, s3, s4, s5, s6, s7, s8,s1 + "9"))
                         .done()
                         .applyTo(Tuples.of("input", "input2", "input3", "input4", "input5", "input6"))
                         .in(Reactor.pooled())
                         .await());
    }

    @Test
    public void shouldBuildFlowWithSevenInputs() throws Exception {
        assertOutput(Flow.take(String.class, String.class, String.class, String.class, String.class, String.class, String.class)
                         .mapTo8((s1, s2, s3, s4, s5, s6, s7) -> Tuples.of(s1, s2, s3, s4, s5, s6, s7, s1 + "8"))
                         .mapTo9((s1, s2, s3, s4, s5, s6, s7, s8) -> Tuples.of(s1 + "1", s2, s3, s4, s5, s6, s7, s8,s1 + "9"))
                         .done()
                         .applyTo(Tuples.of("input", "input2", "input3", "input4", "input5", "input6", "input7"))
                         .in(Reactor.pooled())
                         .await());
    }

    @Test
    public void shouldBuildFlowWithEightInputs() throws Exception {
        assertOutput(Flow.take(String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class)
                         .mapTo9((s1, s2, s3, s4, s5, s6, s7, s8) -> Tuples.of(s1 + "1", s2, s3, s4, s5, s6, s7, s8,s1 + "9"))
                         .done()
                         .applyTo(Tuples.of("input", "input2", "input3", "input4", "input5", "input6", "input7", "input8"))
                         .in(Reactor.pooled())
                         .await());
    }

    @Test
    public void shouldBuildFlowWithNineInputs() throws Exception {
        assertOutput(Flow.take(String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class)
                         .map((s1, s2, s3, s4, s5, s6, s7, s8, s9) -> Tuples.of(s1 + "1", s2, s3, s4, s5, s6, s7, s8,s1 + "9"))
                         .done()
                         .applyTo(Tuples.of("input", "input2", "input3", "input4", "input5", "input6", "input7", "input8", ""))
                         .in(Reactor.pooled())
                         .await());
    }

    @Test
    public void shouldBuildFlowWithNineInputsAndOneOutput() throws Exception {
        assertOutput(Flow.take(String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class)
                         .map((s1, s2, s3, s4, s5, s6, s7, s8, s9) -> Tuples.of(s1 + "1", s2, s3, s4, s5, s6, s7, s8,s1 + "9"))
                         .mapTo8((s1, s2, s3, s4, s5, s6, s7, s8, s9) -> Tuples.of(s1, s2, s3, s4, s5, s6, s7, s8))
                         .mapTo7((s1, s2, s3, s4, s5, s6, s7, s8) -> Tuples.of(s1, s2, s3, s4, s5, s6, s7))
                         .mapTo6((s1, s2, s3, s4, s5, s6, s7) -> Tuples.of(s1, s2, s3, s4, s5, s6))
                         .mapTo5((s1, s2, s3, s4, s5, s6) -> Tuples.of(s1, s2, s3, s4, s5))
                         .mapTo4((s1, s2, s3, s4, s5) -> Tuples.of(s1, s2, s3, s4))
                         .mapTo3((s1, s2, s3, s4) -> Tuples.of(s1, s2, s3))
                         .mapTo2((s1, s2, s3) -> Tuples.of(s1, s2))
                         .mapTo1((s1, s2) -> Tuples.of(s1))
                         .done()
                         .applyTo(Tuples.of("input", "input2", "input3", "input4", "input5", "input6", "input7", "input8", ""))
                         .in(Reactor.pooled())
                         .await());
    }

    @Test
    public void shouldBuildFlowWithOneInputAndOneOutput() throws Exception {
        assertOutput(Flow.take(new Type<String>(){})
                         .map((s1) -> Tuples.of(s1 + "1"))
                         .done()
                         .applyTo(Tuples.of("input"))
                         .in(Reactor.pooled())
                         .await());
    }

    @Test
    public void shouldBuildFlowWithTwoInputsAndTwoOutputs() throws Exception {
        assertOutput(Flow.take(new Type<String>(){}, new Type<String>(){})
                         .map((s1, s2) -> Tuples.of(s1 + "1", s2 + "2"))
                         .done()
                         .applyTo(Tuples.of("input", "input"))
                         .in(Reactor.pooled())
                         .await());
    }

    @Test
    public void shouldBuildFlowWithThreeInputsAndThreeOutputs() throws Exception {
        assertOutput(Flow.take(new Type<String>(){}, new Type<String>(){}, new Type<String>(){})
                         .map((s1, s2, s3) -> Tuples.of(s1 + "1", s2 + "2", s3 + "3"))
                         .done()
                         .applyTo(Tuples.of("input", "input", "input"))
                         .in(Reactor.pooled())
                         .await());
    }

    @Test
    public void shouldBuildFlowWithFourInputsAndFourOutputs() throws Exception {
        assertOutput(Flow.take(new Type<String>(){}, new Type<String>(){}, new Type<String>(){}, new Type<String>(){})
                         .map((s1, s2, s3, s4) -> Tuples.of(s1 + "1", s2 + "2", s3 + "3", s4 + "4"))
                         .done()
                         .applyTo(Tuples.of("input", "input", "input", "input"))
                         .in(Reactor.pooled())
                         .await());
    }

    @Test
    public void shouldBuildFlowWithFiveInputsAndFiveOutputs() throws Exception {
        assertOutput(Flow.take(new Type<String>(){}, new Type<String>(){}, new Type<String>(){}, new Type<String>(){}, new Type<String>(){})
                         .map((s1, s2, s3, s4, s5) -> Tuples.of(s1 + "1", s2 + "2", s3 + "3", s4 + "4", s5 + "5"))
                         .done()
                         .applyTo(Tuples.of("input", "input", "input", "input", "input"))
                         .in(Reactor.pooled())
                         .await());
    }

    @Test
    public void shouldBuildFlowWithSixInputsAndSixOutputs() throws Exception {
        assertOutput(Flow.take(new Type<String>(){}, new Type<String>(){}, new Type<String>(){}, new Type<String>(){}, new Type<String>(){}, new Type<String>(){})
                         .map((s1, s2, s3, s4, s5, s6) -> Tuples.of(s1 + "1", s2 + "2", s3 + "3", s4 + "4", s5 + "5", s6 + "6"))
                         .done()
                         .applyTo(Tuples.of("input", "input", "input", "input", "input", "input"))
                         .in(Reactor.pooled())
                         .await());
    }

    @Test
    public void shouldBuildFlowWithSevenInputsAndSevenOutputs() throws Exception {
        assertOutput(Flow.take(new Type<String>(){}, new Type<String>(){}, new Type<String>(){}, new Type<String>(){}, new Type<String>(){}, new Type<String>(){}, new Type<String>(){})
                         .map((s1, s2, s3, s4, s5, s6, s7) -> Tuples.of(s1 + "1", s2 + "2", s3 + "3", s4 + "4", s5 + "5", s6 + "6", s7 + "7"))
                         .done()
                         .applyTo(Tuples.of("input", "input", "input", "input", "input", "input", "input"))
                         .in(Reactor.pooled())
                         .await());
    }

    @Test
    public void shouldBuildFlowWithEightInputsAndEightOutputs() throws Exception {
        assertOutput(Flow.take(new Type<String>(){}, new Type<String>(){}, new Type<String>(){}, new Type<String>(){}, new Type<String>(){}, new Type<String>(){}, new Type<String>(){}, new Type<String>(){})
                         .map((s1, s2, s3, s4, s5, s6, s7, s8) -> Tuples.of(s1 + "1", s2 + "2", s3 + "3", s4 + "4", s5 + "5", s6 + "6", s7 + "7", s8 + "8"))
                         .done()
                         .applyTo(Tuples.of("input", "input", "input", "input", "input", "input", "input", "input"))
                         .in(Reactor.pooled())
                         .await());
    }

    @Test
    public void shouldBuildFlowWithNineInputsAndNineOutputs() throws Exception {
        assertOutput(Flow.take(new Type<String>(){}, new Type<String>(){}, new Type<String>(){}, new Type<String>(){}, new Type<String>(){}, new Type<String>(){}, new Type<String>(){}, new Type<String>(){}, new Type<String>(){})
                         .map((s1, s2, s3, s4, s5, s6, s7, s8, s9) -> Tuples.of(s1 + "1", s2 + "2", s3 + "3", s4 + "4", s5 + "5", s6 + "6", s7 + "7", s8 + "8", s9 + "9"))
                         .done()
                         .applyTo(Tuples.of("input", "input", "input", "input", "input", "input", "input", "input", "input"))
                         .in(Reactor.pooled())
                         .await());
    }

    @Test
    public void shouldBuildAsyncFlowWithOneInput() throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        AtomicReference<Tuple1<String>> ref = new AtomicReference<>();

        Flow.take(String.class)
            .async()
            .accept((s1) -> { ref.set(Tuples.of(s1 + "1")); latch.countDown();})
            .done()
            .applyTo(Tuples.of("input"))
            .in(Reactor.pooled());
        latch.await();
        assertOutput(ref.get());
    }

    @Test
    public void shouldBuildAsyncFlowWithTwoInputs() throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        AtomicReference<Tuple2<String, String>> ref = new AtomicReference<>();

        Flow.take(String.class, String.class)
            .async()
            .accept((s1, s2) -> { ref.set(Tuples.of(s1 + "1", s2 + "2")); latch.countDown();})
            .done()
            .applyTo(Tuples.of("input", "input"))
            .in(Reactor.pooled());
        latch.await();
        assertOutput(ref.get());
    }

    @Test
    public void shouldBuildAsyncFlowWithThreeInputs() throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        AtomicReference<Tuple3<String, String, String>> ref = new AtomicReference<>();

        Flow.take(String.class, String.class, String.class)
            .async()
            .accept((s1, s2, s3) -> { ref.set(Tuples.of(s1 + "1", s2 + "2", s3 + "3")); latch.countDown();})
            .done()
            .applyTo(Tuples.of("input", "input", "input"))
            .in(Reactor.pooled());
        latch.await();
        assertOutput(ref.get());
    }

    @Test
    public void shouldBuildAsyncFlowWithFourInputs() throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        AtomicReference<Tuple4<String, String, String, String>> ref = new AtomicReference<>();

        Flow.take(String.class, String.class, String.class, String.class)
            .async()
            .accept((s1, s2, s3, s4) -> { ref.set(Tuples.of(s1 + "1", s2 + "2", s3 + "3", s4 + "4")); latch.countDown();})
            .done()
            .applyTo(Tuples.of("input", "input", "input", "input"))
            .in(Reactor.pooled());
        latch.await();
        assertOutput(ref.get());
    }

    @Test
    public void shouldBuildAsyncFlowWithFiveInputs() throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        AtomicReference<Tuple5<String, String, String, String, String>> ref = new AtomicReference<>();

        Flow.take(String.class, String.class, String.class, String.class, String.class)
            .async()
            .accept((s1, s2, s3, s4, s5) -> { ref.set(Tuples.of(s1 + "1", s2 + "2", s3 + "3", s4 + "4", s5 + "5")); latch.countDown();})
            .done()
            .applyTo(Tuples.of("input", "input", "input", "input", "input"))
            .in(Reactor.pooled());
        latch.await();
        assertOutput(ref.get());
    }

    @Test
    public void shouldBuildAsyncFlowWithSixInputs() throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        AtomicReference<Tuple6<String, String, String, String, String, String>> ref = new AtomicReference<>();

        Flow.take(String.class, String.class, String.class, String.class, String.class, String.class)
            .async()
            .accept((s1, s2, s3, s4, s5, s6) -> { ref.set(Tuples.of(s1 + "1", s2 + "2", s3 + "3", s4 + "4", s5 + "5", s6 + "6")); latch.countDown();})
            .done()
            .applyTo(Tuples.of("input", "input", "input", "input", "input", "input"))
            .in(Reactor.pooled());
        latch.await();
        assertOutput(ref.get());
    }

    @Test
    public void shouldBuildAsyncFlowWithSevenInputs() throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        AtomicReference<Tuple7<String, String, String, String, String, String, String>> ref = new AtomicReference<>();

        Flow.take(String.class, String.class, String.class, String.class, String.class, String.class, String.class)
            .async()
            .accept((s1, s2, s3, s4, s5, s6, s7) -> { ref.set(Tuples.of(s1 + "1", s2 + "2", s3 + "3", s4 + "4", s5 + "5", s6 + "6", s7 + "7")); latch.countDown();})
            .done()
            .applyTo(Tuples.of("input", "input", "input", "input", "input", "input", "input"))
            .in(Reactor.pooled());
        latch.await();
        assertOutput(ref.get());
    }

    @Test
    public void shouldBuildAsyncFlowWithEightInputs() throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        AtomicReference<Tuple8<String, String, String, String, String, String, String, String>> ref = new AtomicReference<>();

        Flow.take(String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class)
            .async()
            .accept((s1, s2, s3, s4, s5, s6, s7, s8) -> { ref.set(Tuples.of(s1 + "1", s2 + "2", s3 + "3", s4 + "4", s5 + "5", s6 + "6", s7 + "7", s8 + "8")); latch.countDown();})
            .done()
            .applyTo(Tuples.of("input", "input", "input", "input", "input", "input", "input", "input"))
            .in(Reactor.pooled());
        latch.await();
        assertOutput(ref.get());
    }

    @Test
    public void shouldBuildAsyncFlowWithNineInputs() throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        AtomicReference<Tuple9<String, String, String, String, String, String, String, String, String>> ref = new AtomicReference<>();

        Flow.take(String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class)
            .async()
            .accept((s1, s2, s3, s4, s5, s6, s7, s8, s9) -> { ref.set(Tuples.of(s1 + "1", s2 + "2", s3 + "3", s4 + "4", s5 + "5", s6 + "6", s7 + "7", s8 + "8", s9 + "9")); latch.countDown();})
            .done()
            .applyTo(Tuples.of("input", "input", "input", "input", "input", "input", "input", "input", "input"))
            .in(Reactor.pooled());
        latch.await();
        assertOutput(ref.get());
    }

    @Test
    public void shouldBuildAwaitFlowWithOneInput() throws Exception {
        assertOutput(Flow.take(String.class)
                         .await()
                         .map((s1) -> Tuples.of(s1 + "1"))
                         .done()
                         .applyTo(Tuples.of("input"))
                         .in(Reactor.pooled()).await());
    }

    @Test
    public void shouldBuildAwaitFlowWithTwoInputs() throws Exception {
        assertOutput(Flow.take(String.class, String.class)
                         .await()
                         .map((s1, s2) -> Tuples.of(s1 + "1", s2 + "2"))
                         .done()
                         .applyTo(Tuples.of("input", "input"))
                         .in(Reactor.pooled()).await());
    }

    @Test
    public void shouldBuildAwaitFlowWithThreeInputs() throws Exception {
        assertOutput(Flow.take(String.class, String.class, String.class)
                         .await()
                         .map((s1, s2, s3) -> Tuples.of(s1 + "1", s2 + "2", s3 + "3"))
                         .done()
                         .applyTo(Tuples.of("input", "input", "input"))
                         .in(Reactor.pooled()).await());
    }

    @Test
    public void shouldBuildAwaitFlowWithFourInputs() throws Exception {
        assertOutput(Flow.take(String.class, String.class, String.class, String.class)
                         .await()
                         .map((s1, s2, s3, s4) -> Tuples.of(s1 + "1", s2 + "2", s3 + "3", s4 + "4"))
                         .done()
                         .applyTo(Tuples.of("input", "input", "input", "input"))
                         .in(Reactor.pooled()).await());
    }

    @Test
    public void shouldBuildAwaitFlowWithFiveInputs() throws Exception {
        assertOutput(Flow.take(String.class, String.class, String.class, String.class, String.class)
                         .await()
                         .map((s1, s2, s3, s4, s5) -> Tuples.of(s1 + "1", s2 + "2", s3 + "3", s4 + "4", s5 + "5"))
                         .done()
                         .applyTo(Tuples.of("input", "input", "input", "input", "input"))
                         .in(Reactor.pooled()).await());
    }

    @Test
    public void shouldBuildAwaitFlowWithSixInputs() throws Exception {
        assertOutput(Flow.take(String.class, String.class, String.class, String.class, String.class, String.class)
                         .await()
                         .map((s1, s2, s3, s4, s5, s6) -> Tuples.of(s1 + "1", s2 + "2", s3 + "3", s4 + "4", s5 + "5", s6 + "6"))
                         .done()
                         .applyTo(Tuples.of("input", "input", "input", "input", "input", "input"))
                         .in(Reactor.pooled()).await());
    }

    @Test
    public void shouldBuildAwaitFlowWithSevenInputs() throws Exception {
        assertOutput(Flow.take(String.class, String.class, String.class, String.class, String.class, String.class, String.class)
                         .await()
                         .map((s1, s2, s3, s4, s5, s6, s7) -> Tuples.of(s1 + "1", s2 + "2", s3 + "3", s4 + "4", s5 + "5", s6 + "6", s7 + "7"))
                         .done()
                         .applyTo(Tuples.of("input", "input", "input", "input", "input", "input", "input"))
                         .in(Reactor.pooled()).await());
    }

    @Test
    public void shouldBuildAwaitFlowWithEightInputs() throws Exception {
        assertOutput(Flow.take(String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class)
                         .await()
                         .map((s1, s2, s3, s4, s5, s6, s7, s8) -> Tuples.of(s1 + "1", s2 + "2", s3 + "3", s4 + "4", s5 + "5", s6 + "6", s7 + "7", s8 + "8"))
                         .done()
                         .applyTo(Tuples.of("input", "input", "input", "input", "input", "input", "input", "input"))
                         .in(Reactor.pooled()).await());
    }

    @Test
    public void shouldBuildAwaitFlowWithNineInputs() throws Exception {
        assertOutput(Flow.take(String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class)
                         .await()
                         .map((s1, s2, s3, s4, s5, s6, s7, s8, s9) -> Tuples.of(s1 + "1", s2 + "2", s3 + "3", s4 + "4", s5 + "5", s6 + "6", s7 + "7", s8 + "8", s9 + "9"))
                         .done()
                         .applyTo(Tuples.of("input", "input", "input", "input", "input", "input", "input", "input", "input"))
                         .in(Reactor.pooled()).await());
    }

    @Test
    public void shouldBuildFlowWithOnErrorHandlerAndOneInput() throws Exception {
        assertOutput(Flow.take(String.class)
                         .map((s1) -> {throw new FlowException("fatal");})
                         .onError((t) -> Tuples.of("input1"))
                         .done()
                         .applyTo(Tuples.empty1())
                         .in(Reactor.pooled()).await());
    }

    @Test
    public void shouldBuildFlowWithOnErrorHandlerAndTwoInputs() throws Exception {
        assertOutput(Flow.take(String.class, String.class)
                         .map((s1, s2) -> {throw new FlowException("fatal");})
                         .onError((t) -> Tuples.of("input1", "input2"))
                         .done()
                         .applyTo(Tuples.empty2())
                         .in(Reactor.pooled()).await());
    }

    @Test
    public void shouldBuildFlowWithOnErrorHandlerAndThreeInputs() throws Exception {
        assertOutput(Flow.take(String.class, String.class, String.class)
                         .map((s1, s2, s3) -> {throw new FlowException("fatal");})
                         .onError((t) -> Tuples.of("input1", "input2", "input3"))
                         .done()
                         .applyTo(Tuples.empty3())
                         .in(Reactor.pooled()).await());
    }

    @Test
    public void shouldBuildFlowWithOnErrorHandlerAndFourInputs() throws Exception {
        assertOutput(Flow.take(String.class, String.class, String.class, String.class)
                         .map((s1, s2, s3, s4) -> {throw new FlowException("fatal");})
                         .onError((t) -> Tuples.of("input1", "input2", "input3", "input4"))
                         .done()
                         .applyTo(Tuples.empty4())
                         .in(Reactor.pooled()).await());
    }

    @Test
    public void shouldBuildFlowWithOnErrorHandlerAndFiveInputs() throws Exception {
        assertOutput(Flow.take(String.class, String.class, String.class, String.class, String.class)
                         .map((s1, s2, s3, s4, s5) -> {throw new FlowException("fatal");})
                         .onError((t) -> Tuples.of("input1", "input2", "input3", "input4", "input5"))
                         .done()
                         .applyTo(Tuples.empty5())
                         .in(Reactor.pooled()).await());
    }

    @Test
    public void shouldBuildFlowWithOnErrorHandlerAndSixInputs() throws Exception {
        assertOutput(Flow.take(String.class, String.class, String.class, String.class, String.class, String.class)
                         .map((s1, s2, s3, s4, s5, s6) -> {throw new FlowException("fatal");})
                         .onError((t) -> Tuples.of("input1", "input2", "input3", "input4", "input5", "input6"))
                         .done()
                         .applyTo(Tuples.empty6())
                         .in(Reactor.pooled()).await());
    }

    @Test
    public void shouldBuildFlowWithOnErrorHandlerAndSevenInputs() throws Exception {
        assertOutput(Flow.take(String.class, String.class, String.class, String.class, String.class, String.class, String.class)
                         .map((s1, s2, s3, s4, s5, s6, s7) -> {throw new FlowException("fatal");})
                         .onError((t) -> Tuples.of("input1", "input2", "input3", "input4", "input5", "input6", "input7"))
                         .done()
                         .applyTo(Tuples.empty7())
                         .in(Reactor.pooled()).await());
    }

    @Test
    public void shouldBuildFlowWithOnErrorHandlerAndEightInputs() throws Exception {
        assertOutput(Flow.take(String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class)
                         .map((s1, s2, s3, s4, s5, s6, s7, s8) -> {throw new FlowException("fatal");})
                         .onError((t) -> Tuples.of("input1", "input2", "input3", "input4", "input5", "input6", "input7", "input8"))
                         .done()
                         .applyTo(Tuples.empty8())
                         .in(Reactor.pooled()).await());
    }

    @Test
    public void shouldBuildFlowWithOnErrorHandlerAndNineInputs() throws Exception {
        assertOutput(Flow.take(String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class)
                         .map((s1, s2, s3, s4, s5, s6, s7, s8, s9) -> {throw new FlowException("fatal");})
                         .onError((t) -> Tuples.of("input1", "input2", "input3", "input4", "input5", "input6", "input7", "input8", "input9"))
                         .done()
                         .applyTo(Tuples.empty9())
                         .in(Reactor.pooled()).await());
    }

    @Test
    public void shouldBuildFlowWithConditionAndOneInput() throws Exception {
        assertOutput(Flow.take(String.class)
                         .when((s1) -> true)
                         .map((s1) -> Tuples.of(s1 + "1"))
                         .done()
                         .applyTo(Tuples.of("input"))
                         .in(Reactor.pooled()).await());
    }

    @Test
    public void shouldBuildFlowWithConditionAndTwoInputs() throws Exception {
        assertOutput(Flow.take(String.class, String.class)
                         .when((s1, s2) -> true)
                         .map((s1, s2) -> Tuples.of(s1 + "1", s2 + "2"))
                         .done()
                         .applyTo(Tuples.of("input", "input"))
                         .in(Reactor.pooled()).await());
    }

    @Test
    public void shouldBuildFlowWithConditionAndThreeInputs() throws Exception {
        assertOutput(Flow.take(String.class, String.class, String.class)
                         .when((s1, s2, s3) -> true)
                         .map((s1, s2, s3) -> Tuples.of(s1 + "1", s2 + "2", s3 + "3"))
                         .done()
                         .applyTo(Tuples.of("input", "input", "input"))
                         .in(Reactor.pooled()).await());
    }

    @Test
    public void shouldBuildFlowWithConditionAndFourInputs() throws Exception {
        assertOutput(Flow.take(String.class, String.class, String.class, String.class)
                         .when((s1, s2, s3, s4) -> true)
                         .map((s1, s2, s3, s4) -> Tuples.of(s1 + "1", s2 + "2", s3 + "3", s4 + "4"))
                         .done()
                         .applyTo(Tuples.of("input", "input", "input", "input"))
                         .in(Reactor.pooled()).await());
    }

    @Test
    public void shouldBuildFlowWithConditionAndFiveInputs() throws Exception {
        assertOutput(Flow.take(String.class, String.class, String.class, String.class, String.class)
                         .when((s1, s2, s3, s4, s5) -> true)
                         .map((s1, s2, s3, s4, s5) -> Tuples.of(s1 + "1", s2 + "2", s3 + "3", s4 + "4", s5 + "5"))
                         .done()
                         .applyTo(Tuples.of("input", "input", "input", "input", "input"))
                         .in(Reactor.pooled()).await());
    }

    @Test
    public void shouldBuildFlowWithConditionAndSixInputs() throws Exception {
        assertOutput(Flow.take(String.class, String.class, String.class, String.class, String.class, String.class)
                         .when((s1, s2, s3, s4, s5, s6) -> true)
                         .map((s1, s2, s3, s4, s5, s6) -> Tuples.of(s1 + "1", s2 + "2", s3 + "3", s4 + "4", s5 + "5", s6 + "6"))
                         .done()
                         .applyTo(Tuples.of("input", "input", "input", "input", "input", "input"))
                         .in(Reactor.pooled()).await());
    }

    @Test
    public void shouldBuildFlowWithConditionAndSevenInputs() throws Exception {
        assertOutput(Flow.take(String.class, String.class, String.class, String.class, String.class, String.class, String.class)
                         .when((s1, s2, s3, s4, s5, s6, s7) -> true)
                         .map((s1, s2, s3, s4, s5, s6, s7) -> Tuples.of(s1 + "1", s2 + "2", s3 + "3", s4 + "4", s5 + "5", s6 + "6", s7 + "7"))
                         .done()
                         .applyTo(Tuples.of("input", "input", "input", "input", "input", "input", "input"))
                         .in(Reactor.pooled()).await());
    }

    @Test
    public void shouldBuildFlowWithConditionAndEightInputs() throws Exception {
        assertOutput(Flow.take(String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class)
                         .when((s1, s2, s3, s4, s5, s6, s7, s8) -> true)
                         .map((s1, s2, s3, s4, s5, s6, s7, s8) -> Tuples.of(s1 + "1", s2 + "2", s3 + "3", s4 + "4", s5 + "5", s6 + "6", s7 + "7", s8 + "8"))
                         .done()
                         .applyTo(Tuples.of("input", "input", "input", "input", "input", "input", "input", "input"))
                         .in(Reactor.pooled()).await());
    }

    @Test
    public void shouldBuildFlowWithConditionAndNineInputs() throws Exception {
        assertOutput(Flow.take(String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class)
                         .when((s1, s2, s3, s4, s5, s6, s7, s8, s9) -> true)
                         .map((s1, s2, s3, s4, s5, s6, s7, s8, s9) -> Tuples.of(s1 + "1", s2 + "2", s3 + "3", s4 + "4", s5 + "5", s6 + "6", s7 + "7", s8 + "8", s9 + "9"))
                         .done()
                         .applyTo(Tuples.of("input", "input", "input", "input", "input", "input", "input", "input", "input"))
                         .in(Reactor.pooled()).await());
    }

    @Test
    public void shouldBuildFunctionForOneInput() throws Exception {
        F<Promise<Tuple1<String>>, Tuple1<String>> fn = Flow.take(String.class).map((s) -> Tuples.of(s + "1")).asFunctionIn(Reactor.pooled());

        assertOutput(fn.apply(Tuples.of("input")).await());
    }

    @Test
    public void shouldBuildFunctionForTwoInputs() throws Exception {
        F<Promise<Tuple2<String, String>>, Tuple2<String, String>> fn = Flow.take(String.class, String.class)
                                                                            .map((s1, s2) -> Tuples.of(s1 + "1", s2 + "2"))
                                                                            .asFunctionIn(Reactor.pooled());

        assertOutput(fn.apply(Tuples.of("input", "input")).await());
    }

    @Test
    public void shouldBuildFunctionForThreeInputs() throws Exception {
        F<Promise<Tuple3<String, String, String>>,
            Tuple3<String, String, String>> fn = Flow.take(String.class, String.class, String.class)
                                                             .map((s1, s2, s3) -> Tuples.of(s1 + "1", s2 + "2", s3 + "3"))
                                                             .asFunctionIn(Reactor.pooled());

        assertOutput(fn.apply(Tuples.of("input", "input", "input")).await());
    }

    @Test
    public void shouldBuildFunctionForFourInputs() throws Exception {
        F<Promise<Tuple4<String, String, String, String>>,
            Tuple4<String, String, String, String>> fn = Flow.take(String.class, String.class, String.class, String.class)
                                                             .map((s1, s2, s3, s4) -> Tuples.of(s1 + "1", s2 + "2", s3 + "3", s4 + "4"))
                                                             .asFunctionIn(Reactor.pooled());

        assertOutput(fn.apply(Tuples.of("input", "input", "input", "input")).await());
    }

    @Test
    public void shouldBuildFunctionForFiveInputs() throws Exception {
        F<Promise<Tuple5<String, String, String, String, String>>,
            Tuple5<String, String, String, String, String>> fn = Flow.take(String.class, String.class, String.class, String.class, String.class)
                                                                     .map((s1, s2, s3, s4, s5) -> Tuples.of(s1 + "1", s2 + "2", s3 + "3", s4 + "4", s5 + "5"))
                                                                     .asFunctionIn(Reactor.pooled());

        assertOutput(fn.apply(Tuples.of("input", "input", "input", "input", "input")).await());
    }

    @Test
    public void shouldBuildFunctionForSixInputs() throws Exception {
        F<Promise<Tuple6<String, String, String, String, String, String>>,
            Tuple6<String, String, String, String, String, String>> fn = Flow.take(String.class, String.class, String.class, String.class, String.class, String.class)
                                                                                     .map((s1, s2, s3, s4, s5, s6) -> Tuples.of(s1 + "1", s2 + "2", s3 + "3", s4 + "4", s5 + "5", s6 + "6"))
                                                                                     .asFunctionIn(Reactor.pooled());

        assertOutput(fn.apply(Tuples.of("input", "input", "input", "input", "input", "input")).await());
    }

    @Test
    public void shouldBuildFunctionForSevenInputs() throws Exception {
        F<Promise<Tuple7<String, String, String, String, String, String, String>>,
            Tuple7<String, String, String, String, String, String, String>> fn = Flow.take(String.class, String.class, String.class, String.class, String.class, String.class, String.class)
                                                                                     .map((s1, s2, s3, s4, s5, s6, s7) -> Tuples.of(s1 + "1", s2 + "2", s3 + "3", s4 + "4", s5 + "5", s6 + "6", s7 + "7"))
                                                                                     .asFunctionIn(Reactor.pooled());

        assertOutput(fn.apply(Tuples.of("input", "input", "input", "input", "input", "input", "input")).await());
    }

    @Test
    public void shouldBuildFunctionForEightInputs() throws Exception {
        F<Promise<Tuple8<String, String, String, String, String, String, String, String>>,
            Tuple8<String, String, String, String, String, String, String, String>> fn = Flow.take(String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class)
                                                                                             .map((s1, s2, s3, s4, s5, s6, s7, s8) -> Tuples.of(s1 + "1", s2 + "2", s3 + "3", s4 + "4", s5 + "5", s6 + "6", s7 + "7", s8 + "8"))
                                                                                             .asFunctionIn(Reactor.pooled());

        assertOutput(fn.apply(Tuples.of("input", "input", "input", "input", "input", "input", "input", "input")).await());
    }

    @Test
    public void shouldBuildFunctionForNineInputs() throws Exception {
        F<Promise<Tuple9<String, String, String, String, String, String, String, String, String>>,
            Tuple9<String, String, String, String, String, String, String, String, String>> fn = Flow.take(String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class)
                                                                                                     .map((s1, s2, s3, s4, s5, s6, s7, s8, s9) -> Tuples.of(s1 + "1", s2 + "2", s3 + "3", s4 + "4", s5 + "5", s6 + "6", s7 + "7", s8 + "8", s9 + "9"))
                                                                                                     .asFunctionIn(Reactor.pooled());

        assertOutput(fn.apply(Tuples.of("input", "input", "input", "input", "input", "input", "input", "input", "input")).await());
    }

    private void assertOutput(Tuple1<?> result) {
        assertThat(result.get1()).isEqualTo("input1");
    }

    private void assertOutput(Tuple2<?, ?> result) {
        assertThat(result.get1()).isEqualTo("input1");
        assertThat(result.get2()).isEqualTo("input2");
    }

    private void assertOutput(Tuple3<?, ?, ?> result) {
        assertThat(result.get1()).isEqualTo("input1");
        assertThat(result.get2()).isEqualTo("input2");
        assertThat(result.get3()).isEqualTo("input3");
    }

    private void assertOutput(Tuple4<?, ?, ?, ?> result) {
        assertThat(result.get1()).isEqualTo("input1");
        assertThat(result.get2()).isEqualTo("input2");
        assertThat(result.get3()).isEqualTo("input3");
        assertThat(result.get4()).isEqualTo("input4");
    }

    private void assertOutput(Tuple5<?, ?, ?, ?, ?> result) {
        assertThat(result.get1()).isEqualTo("input1");
        assertThat(result.get2()).isEqualTo("input2");
        assertThat(result.get3()).isEqualTo("input3");
        assertThat(result.get4()).isEqualTo("input4");
        assertThat(result.get5()).isEqualTo("input5");
    }

    private void assertOutput(Tuple6<?, ?, ?, ?, ?, ?> result) {
        assertThat(result.get1()).isEqualTo("input1");
        assertThat(result.get2()).isEqualTo("input2");
        assertThat(result.get3()).isEqualTo("input3");
        assertThat(result.get4()).isEqualTo("input4");
        assertThat(result.get5()).isEqualTo("input5");
        assertThat(result.get6()).isEqualTo("input6");
    }

    private void assertOutput(Tuple7<?, ?, ?, ?, ?, ?, ?> result) {
        assertThat(result.get1()).isEqualTo("input1");
        assertThat(result.get2()).isEqualTo("input2");
        assertThat(result.get3()).isEqualTo("input3");
        assertThat(result.get4()).isEqualTo("input4");
        assertThat(result.get5()).isEqualTo("input5");
        assertThat(result.get6()).isEqualTo("input6");
        assertThat(result.get7()).isEqualTo("input7");
    }

    private void assertOutput(Tuple8<?, ?, ?, ?, ?, ?, ?, ?> result) {
        assertThat(result.get1()).isEqualTo("input1");
        assertThat(result.get2()).isEqualTo("input2");
        assertThat(result.get3()).isEqualTo("input3");
        assertThat(result.get4()).isEqualTo("input4");
        assertThat(result.get5()).isEqualTo("input5");
        assertThat(result.get6()).isEqualTo("input6");
        assertThat(result.get7()).isEqualTo("input7");
        assertThat(result.get8()).isEqualTo("input8");
    }

    private void assertOutput(Tuple9<?, ?, ?, ?, ?, ?, ?, ?, ?> result) {
        assertThat(result.get1()).isEqualTo("input1");
        assertThat(result.get2()).isEqualTo("input2");
        assertThat(result.get3()).isEqualTo("input3");
        assertThat(result.get4()).isEqualTo("input4");
        assertThat(result.get5()).isEqualTo("input5");
        assertThat(result.get6()).isEqualTo("input6");
        assertThat(result.get7()).isEqualTo("input7");
        assertThat(result.get8()).isEqualTo("input8");
        assertThat(result.get9()).isEqualTo("input9");
    }
}