package org.rxbooter.flow;

import org.junit.Test;

import static org.rxbooter.flow.Flow.*;
import static org.rxbooter.flow.Tuples.*;

import static org.assertj.core.api.Assertions.*;

public class PipelineTest {
    private String field = "";

    @Test
    public void shouldCompileAndRunSimpleFlow() throws Exception {
        Pipeline<Tuple1<String>, Tuple1<String>> flow = to(String.class)
                                                                   .apply2((s) -> of(s, s.toLowerCase()))
                                                                   .apply1((s1, s2) -> with(s1 + " " + s2))
                                                                   .asPipeline();
        
        assertThat(Reactor.waitFor(flow.cursor(of("abcABC"))).get(0)).isEqualTo("abcABC abcabc");
    }
}