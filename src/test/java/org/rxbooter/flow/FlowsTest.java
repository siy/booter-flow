package org.rxbooter.flow;

import org.junit.Test;

import static org.junit.Assert.*;

import static org.rxbooter.flow.Flows.*;
import static org.rxbooter.flow.Tuples.*;

public class FlowsTest {
    private String field = "";

    @Test
    public void shouldCompileAndRunSimpleFlow() throws Exception {
        ExecutableFlow<Tuple1<String>, Tuple1<String>> flow = Flows.with(String.class)
                                                                   .then2((s) -> of(s, s.toLowerCase()))
                                                                   .then1((s1, s2) -> of(s1 + " " + s2))
                                                                   .build();
        Reactor reactor = new Reactor();
        Tuple1<String> result = reactor.await(flow.cursor(of("abcABC")));
        System.out.println(">>" + result.get(0) + "<<");
    }
}