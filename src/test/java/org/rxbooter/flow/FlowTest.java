package org.rxbooter.flow;

import org.junit.Test;
import org.rxbooter.flow.impl.CurrentThreadReactor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.rxbooter.flow.Flows.take;
import static org.rxbooter.flow.Tuples.Tuple1;
import static org.rxbooter.flow.Tuples.of;
import static org.rxbooter.flow.Tuples.with;

//TODO: finish it
public class FlowTest {
    private String field = "";

    @Test
    public void shouldCompileAndRunSimpleFlow() throws Exception {
        Flow<Tuple1<String>, Tuple1<String>> flow = take(String.class)
            .then2((s) -> of(s, s.toLowerCase()))
            .then1((s1, s2) -> with(s1 + " " + s2))
            .thenReturn1();

        String result = flow.applyTo(of("abcABC")).in(CurrentThreadReactor.instance()).await().get();
        assertThat(result).isEqualTo("abcABC abcabc");
    }
}