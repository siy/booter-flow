package org.rxbooter.flow;

public final class Tuples {
    private Tuples() {}

    public static<T1> Tuple1<T1> of(T1 param1) {
        return new Tuple1<>(param1);
    }

    public static<T1, T2> Tuple2<T1, T2> of(T1 param1, T2 param2) {
        return new Tuple2<>(param1, param2);
    }

    public static<T1, T2, T3> Tuple3<T1, T2, T3> of(T1 param1, T2 param2, T3 param3) {
        return new Tuple3<>(param1, param2, param3);
    }

    public static<T1, T2, T3, T4> Tuple4<T1, T2, T3, T4> of(T1 param1, T2 param2, T3 param3, T4 param4) {
        return new Tuple4<>(param1, param2, param3, param4);
    }

    public static<T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5> of(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5) {
        return new Tuple5<>(param1, param2, param3, param4, param5);
    }

    public static<T1, T2, T3, T4, T5, T6> Tuple6<T1, T2, T3, T4, T5, T6> of(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5, T6 param6) {
        return new Tuple6<>(param1, param2, param3, param4, param5, param6);
    }

    public static<T1, T2, T3, T4, T5, T6, T7> Tuple7<T1, T2, T3, T4, T5, T6, T7> of(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5, T6 param6, T7 param7) {
        return new Tuple7<>(param1, param2, param3, param4, param5, param6, param7);
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
        public Tuple1(T1 param1) {
            super(param1);
        }
    }

    public static class Tuple2<T1, T2> extends Tuple {
        public Tuple2(T1 param1, T2 param2) {
            super(param1, param2);
        }
    }

    public static class Tuple3<T1, T2, T3> extends Tuple {
        public Tuple3(T1 param1, T2 param2, T3 param3) {
            super(param1, param2, param3);
        }
    }

    public static class Tuple4<T1, T2, T3, T4> extends Tuple {
        public Tuple4(T1 param1, T2 param2, T3 param3, T4 param4) {
            super(param1, param2, param3, param4);
        }
    }

    public static class Tuple5<T1, T2, T3, T4, T5> extends Tuple {
        public Tuple5(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5) {
            super(param1, param2, param3, param4, param5);
        }
    }

    public static class Tuple6<T1, T2, T3, T4, T5, T6> extends Tuple {
        public Tuple6(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5, T6 param6) {
            super(param1, param2, param3, param4, param5, param6);
        }
    }

    public static class Tuple7<T1, T2, T3, T4, T5, T6, T7> extends Tuple {
        public Tuple7(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5, T6 param6, T7 param7) {
            super(param1, param2, param3, param4, param5, param6, param7);
        }
    }
}
