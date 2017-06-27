package org.rxbooter.flow;

import org.junit.Test;

import static org.junit.Assert.*;

public class FluxTest {
    @Test
    public void name() throws Exception {
        Flux.take(String.class)
            .apply2((s) -> Tuples.of(s, s.length()))
            .apply3((s, l) -> Tuples.of(s, s.toLowerCase(), l));
    }
}