package org.rxbooter.flow.impl;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

import org.junit.Test;
import org.rxbooter.flow.Flow;
import org.rxbooter.flow.Reactor;
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
import org.rxbooter.flow.Type;

import static org.assertj.core.api.Assertions.assertThat;

public class FlowBuildersTest {
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

    public void assertOutput(Tuple1<String> result) {
        assertThat(result.get1()).isEqualTo("input1");
    }

    public void assertOutput(Tuple2<String, String> result) {
        assertThat(result.get1()).isEqualTo("input1");
        assertThat(result.get2()).isEqualTo("input2");
    }

    public void assertOutput(Tuple3<String, String, String> result) {
        assertThat(result.get1()).isEqualTo("input1");
        assertThat(result.get2()).isEqualTo("input2");
        assertThat(result.get3()).isEqualTo("input3");
    }

    public void assertOutput(Tuple4<String, String, String, String> result) {
        assertThat(result.get1()).isEqualTo("input1");
        assertThat(result.get2()).isEqualTo("input2");
        assertThat(result.get3()).isEqualTo("input3");
        assertThat(result.get4()).isEqualTo("input4");
    }

    public void assertOutput(Tuple5<String, String, String, String, String> result) {
        assertThat(result.get1()).isEqualTo("input1");
        assertThat(result.get2()).isEqualTo("input2");
        assertThat(result.get3()).isEqualTo("input3");
        assertThat(result.get4()).isEqualTo("input4");
        assertThat(result.get5()).isEqualTo("input5");
    }

    public void assertOutput(Tuple6<String, String, String, String, String, String> result) {
        assertThat(result.get1()).isEqualTo("input1");
        assertThat(result.get2()).isEqualTo("input2");
        assertThat(result.get3()).isEqualTo("input3");
        assertThat(result.get4()).isEqualTo("input4");
        assertThat(result.get5()).isEqualTo("input5");
        assertThat(result.get6()).isEqualTo("input6");
    }

    public void assertOutput(Tuple7<String, String, String, String, String, String, String> result) {
        assertThat(result.get1()).isEqualTo("input1");
        assertThat(result.get2()).isEqualTo("input2");
        assertThat(result.get3()).isEqualTo("input3");
        assertThat(result.get4()).isEqualTo("input4");
        assertThat(result.get5()).isEqualTo("input5");
        assertThat(result.get6()).isEqualTo("input6");
        assertThat(result.get7()).isEqualTo("input7");
    }

    public void assertOutput(Tuple8<String, String, String, String, String, String, String, String> result) {
        assertThat(result.get1()).isEqualTo("input1");
        assertThat(result.get2()).isEqualTo("input2");
        assertThat(result.get3()).isEqualTo("input3");
        assertThat(result.get4()).isEqualTo("input4");
        assertThat(result.get5()).isEqualTo("input5");
        assertThat(result.get6()).isEqualTo("input6");
        assertThat(result.get7()).isEqualTo("input7");
        assertThat(result.get8()).isEqualTo("input8");
    }

    public void assertOutput(Tuple9<String, String, String, String, String, String, String, String, String> result) {
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