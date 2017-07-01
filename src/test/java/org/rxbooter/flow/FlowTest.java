package org.rxbooter.flow;

import org.junit.Test;
import org.rxbooter.flow.Tuples.Tuple2;
import org.rxbooter.flow.Tuples.Tuple3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.rxbooter.flow.Flows.take;
import static org.rxbooter.flow.Tuples.Tuple1;
import static org.rxbooter.flow.Tuples.of;

//TODO: finish it
public class FlowTest {
    private String field = "";

    @Test
    public void shouldCompileAndRunSimpleFlow() throws Exception {
        Flow<Tuple1<String>, Tuple1<String>> flow = take(new TypeHolder<String>(){})
            .then2((s) -> of(s, s.toLowerCase()))
            .then1((s1, s2) -> of(s1 + " " + s2))
            .done();

        String result = flow.applyTo(Tuples.of("abcABC")).in(Reactor.single()).await().get();
        assertThat(result).isEqualTo("abcABC abcabc");
    }
    
    @Test
    public void shouldCompileAndRunComplexFlow() throws Exception {
        Flow<Tuple1<String>, Tuple2<String, Long>> flow = take(String.class, Long.class)
            .then3((s, i) -> of(s, s.toLowerCase(), i))
            .then1((s1, s2, i) -> of(s1 + " " + i + " " + s2))
            .done();

        String result = flow.applyTo(Tuples.of("abcABC", 1L)).in(Reactor.single()).await().get();
        assertThat(result).isEqualTo("abcABC 1 abcabc");
    }

    @Test
    public void shouldCombineFlows() throws Exception {
        Flow<Tuple2<String, Integer>, Tuple3<String, Long, Integer>> flow1 = take(String.class, Long.class, Integer.class)
            .then3((s, l, i) -> of(s + "-suffix", l + 42L, i - 15))
            .then2((s, l, i) -> of(s + " " + l, i))
            .done();

        Flow<Tuple1<String>, Tuple2<String, Integer>> flow2 = take(String.class, Integer.class)
            .then5((s, i) -> of(s, i, "refix-" + s, i + s.length(), s.length()))
            .then1((s1, i1, s2, i2, i3) -> of(String.format("<%s>, <%s>, <%s>, <%s>, <%s>", s1, i1, s2, i2, i3)))
            .done();

        Flow<Tuple1<String>, Tuple3<String, Long, Integer>> flow = Flow.compose(flow1, flow2);

        String result = flow.applyTo(Tuples.of("abcABC", 1L, 33)).in(Reactor.single()).await().get();
        assertThat(result).isEqualTo("<abcABC-suffix 43>, <18>, <refix-abcABC-suffix 43>, <34>, <16>");
    }
}