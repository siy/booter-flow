package org.rxbooter.flow;

import org.junit.Test;

public class TypeCheckingExperimentTest {
    @Test
    public void name() throws Exception {
        with(String.class, String.class)
                .apply2((s1) -> Tuple2.of(s1, s1 + " "))
                .apply2((s1, s2) -> Tuple2.of(s2, s1 + " "))
                .apply1((ss1, ss2) -> Tuple1.of(ss1))
                .apply1(Tuple1::of)
                .apply2((ss1) -> Tuple2.of(ss1, ss1))
                .apply2(Tuple2::of)
                .apply2((ss1) -> Tuple2.of(ss1, ss1))
                .apply1(Tuple1::of)
                ;
    }

    public static<I, O> FlowBuilder1<I> with(Class<O> output, Class<I> input) {

        return new FlowBuilder1<>();
    }

    public static class FlowBuilder1<T1> {
        public <R1> FlowBuilder1<R1> apply1(FF11<R1, T1> function) {
            return new FlowBuilder1<>();
        }

        public <R1, R2> FlowBuilder2<R1, R2> apply2(FF21<R1, R2, T1> function) {
            return new FlowBuilder2<>();
        }
    }

    public static class FlowBuilder2<T1, T2> {
        public <R1> FlowBuilder1<R1> apply1(FF11<R1, T1> function) {
            return new FlowBuilder1<>();
        }

        public <R1> FlowBuilder1<R1> apply1(FF12<R1, T1, T2> function) {
            return new FlowBuilder1<>();
        }

        public <R1, R2> FlowBuilder2<R1, R2> apply2(FF21<R1, R2, T1> function) {
            return new FlowBuilder2<>();
        }

        public <R1, R2> FlowBuilder2<R1, R2> apply2(FF22<R1, R2, T1, T2> function) {
            return new FlowBuilder2<>();
        }
    }

    public interface FF11<R1, T1> {
        Tuple1<R1> apply(T1 value1);
    }

    public interface FF12<R1, T1, T2> {
        Tuple1<R1> apply(T1 value1, T2 value2);
    }

    public interface FF21<R1, R2, T1> {
        Tuple2<R1, R2> apply(T1 value1);
    }

    public interface FF22<R1, R2, T1, T2> {
        Tuple2<R1, R2> apply(T1 value1, T2 value2);
    }

    public static class Tuple {
        private final Object[] values;
        protected Tuple(Object ... values) {
            this.values = values;
        }

        public Object get(int i) {
            return values[i];
        }
    }

    public static class Tuple1<T1> extends Tuple {
        public Tuple1(T1 value) {
            super(value);
        }

        public static<T1> Tuple1<T1> of(T1 value) {
            return new Tuple1<>(value);
        }
    }

    public static class Tuple2<T1, T2> extends Tuple {
        public Tuple2(T1 value1, T2 value2) {
            super(value1, value2);
        }

        public static<T1, T2> Tuple2<T1, T2> of(T1 value1, T2 value2) {
            return new Tuple2<>(value1, value2);
        }
    }
}