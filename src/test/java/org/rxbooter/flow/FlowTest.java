package org.rxbooter.flow;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;
import org.rxbooter.flow.Tuples.Tuple2;
import org.rxbooter.flow.Tuples.Tuple3;
import org.rxbooter.flow.impl.ExecutableFlow;
import org.rxbooter.flow.reactor.Promise;
import org.rxbooter.flow.reactor.Reactor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.rxbooter.flow.Flow.take;
import static org.rxbooter.flow.Tuples.Tuple1;
import static org.rxbooter.flow.Tuples.of;

//TODO: finish it
@SuppressWarnings("SpellCheckingInspection")
public class FlowTest {
    @Test
    public void shouldCompileAndRunSimpleFlow() throws Exception {
        Flow<Tuple1<String>, Tuple1<String>> flow = take(new Type<String>(){})
            .mapTo2((s) -> of(s, s.toLowerCase()))
            .mapTo1((s1, s2) -> of(s1 + " " + s2))
            .done();

        String result = flow.applyTo(Tuples.of("abcABC")).in(Reactor.pooled()).await().get1();
        assertThat(result).isEqualTo("abcABC abcabc");
    }

    @Test
    public void name() throws Exception {
        Flow<Tuple1<String>, Tuple2<String, Long>> flow = take(String.class, Long.class)
                .mapTo3((s, i) -> of(s, s.toLowerCase(), i))
                .mapTo1((s1, s2, i) -> of(s1 + " " + i + " " + s2))
                .done();

        ExecutableFlow<Tuple1<String>, Tuple2<String, Long>> excutable =
                flow.applyTo(Tuples.of("absABS", 1L));

//        Promise<Tuple1<String>> result = Reactor.pooled().submit(excutable);
        Promise<Tuple1<String>> result = excutable.in(Reactor.pooled());
    }

    @Test
    public void shouldCompileAndRunComplexFlow() throws Exception {
        Flow<Tuple1<String>, Tuple2<String, Long>> flow = take(String.class, Long.class)
            .mapTo3((s, i) -> of(s, s.toLowerCase(), i))
            .mapTo1((s1, s2, i) -> of(s1 + " " + i + " " + s2))
            .done();

        String result = flow.applyTo(Tuples.of("abcABC", 1L)).in(Reactor.pooled()).await().get1();
        assertThat(result).isEqualTo("abcABC 1 abcabc");
    }

    @Test
    public void shouldBuildFlowFromSupplier() throws Exception {
        AtomicInteger counter = new AtomicInteger(0);

        Flow<Tuple1<Integer>, Tuple1<Void>> flow = Flow.from(counter::incrementAndGet).done();

        Integer value1 = flow.applyTo(null).in(Reactor.pooled()).await().get1();
        Integer value2 = flow.applyTo(null).in(Reactor.pooled()).await().get1();

        assertThat(value1).isEqualTo(1);
        assertThat(value2).isEqualTo(2);
    }

    @Test
    public void shouldCombineFlows() throws Exception {
        Flow<Tuple2<String, Integer>, Tuple3<String, Long, Integer>> flow1 = take(String.class, Long.class, Integer.class)
            .map((s, l, i) -> of(s + "-suffix", l + 42L, i - 15))
            .mapTo2((s, l, i) -> of(s + " " + l, i))
            .done();

        Flow<Tuple1<String>, Tuple2<String, Integer>> flow2 = take(String.class, Integer.class)
            .mapTo5((s, i) -> of(s, i, "prefix-" + s, i + s.length(), s.length()))
            .mapTo1((s1, i1, s2, i2, i3) -> of(String.format("<%s>, <%s>, <%s>, <%s>, <%s>", s1, i1, s2, i2, i3)))
            .done();

        Flow<Tuple1<String>, Tuple3<String, Long, Integer>> flow = Flow.compose(flow1, flow2);

        String result = flow.applyTo(Tuples.of("abcABC", 1L, 33)).in(Reactor.pooled()).await().get1();
        assertThat(result).isEqualTo("<abcABC-suffix 43>, <18>, <prefix-abcABC-suffix 43>, <34>, <16>");
    }
}