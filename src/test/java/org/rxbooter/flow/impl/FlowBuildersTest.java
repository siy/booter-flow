package org.rxbooter.flow.impl;

import org.junit.Test;
import org.rxbooter.flow.Flow;
import org.rxbooter.flow.Reactor;
import org.rxbooter.flow.Tuples;
import org.rxbooter.flow.Tuples.Tuple1;

import static org.assertj.core.api.Assertions.assertThat;

//TODO: do we need it?
public class FlowBuildersTest {
    @Test
    public void shouldBuildSimpleFlow() throws Exception {
        Flow<Tuple1<String>, Tuple1<String>> flow = Flow.take(String.class)
                                                        .mapTo2((s) -> Tuples.of(s, s.length()))
                                                        .map((s, l) -> Tuples.of(s.toLowerCase(), l * 2))
                                                        .mapTo1((s, l) -> Tuples.of(s + " - " + l))
                                                        .done();
        String result = flow.applyTo(Tuples.of("AbCdEf")).in(Reactor.pooled()).await().get();
        assertThat(result).isEqualTo("abcdef - 12");
    }
}