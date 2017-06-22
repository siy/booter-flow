package org.rxbooter.flow;

import org.rxbooter.flow.Tuples.Tuple;

public class Processor<O extends Tuple, I extends Tuple> {
    public Processor(Reactor reactor, Pipeline<O, I> pipeline) {
    }
}
