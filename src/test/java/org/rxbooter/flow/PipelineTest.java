package org.rxbooter.flow;

import org.junit.Test;

import static org.rxbooter.flow.Flow.*;
import static org.rxbooter.flow.Tuples.*;

public class PipelineTest {
    private String field = "";

    @Test
    public void shouldCompileAndRunSimpleFlow() throws Exception {
//        Flow<Tuple1<String>, Tuple1<String>> flow = take(String.class)
//                                                                   .apply2((s) -> of(s, s.toLowerCase()))
//                                                                   .apply1((s1, s2) -> with(s1 + " " + s2))
//                                                                   .build();
//
        //TODO: fix it
        //assertThat(FixedPoolsReactor.waitFor(flow.cursor(of("abcABC"))).get(0)).isEqualTo("abcABC abcabc");
    }
}