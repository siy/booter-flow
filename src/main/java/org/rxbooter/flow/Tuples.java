package org.rxbooter.flow;

/*
 * Copyright (c) 2017 Sergiy Yevtushenko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 */

public final class Tuples {
    private Tuples() {}

    public static<T1> Tuple1<T1> empty1() {
        return new Tuple1<>(null);
    }

    public static<T1, T2> Tuple2<T1, T2> empty2() {
        return new Tuple2<>(null, null);
    }

    public static<T1, T2, T3> Tuple3<T1, T2, T3> empty3() {
        return new Tuple3<>(null, null, null);
    }

    public static<T1, T2, T3, T4> Tuple4<T1, T2, T3, T4> empty4() {
        return new Tuple4<>(null, null, null, null);
    }

    public static<T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5> empty5() {
        return new Tuple5<>(null, null, null, null, null);
    }

    public static<T1, T2, T3, T4, T5, T6> Tuple6<T1, T2, T3, T4, T5, T6> empty6() {
        return new Tuple6<>(null, null, null, null, null, null);
    }

    public static<T1, T2, T3, T4, T5, T6, T7> Tuple7<T1, T2, T3, T4, T5, T6, T7> empty7() {
        return new Tuple7<>(null, null, null, null, null, null, null);
    }

    public static<T1, T2, T3, T4, T5, T6, T7, T8> Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> empty8() {
        return new Tuple8<>(null, null, null, null, null, null, null, null);
    }

    public static<T1, T2, T3, T4, T5, T6, T7, T8, T9> Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> empty9() {
        return new Tuple9<>(null, null, null, null, null, null, null, null, null);
    }

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

    public static<T1, T2, T3, T4, T5, T6, T7, T8> Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> of(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5, T6 param6, T7 param7, T8 param8) {
        return new Tuple8<>(param1, param2, param3, param4, param5, param6, param7, param8);
    }

    public static<T1, T2, T3, T4, T5, T6, T7, T8, T9> Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> of(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5, T6 param6, T7 param7, T8 param8, T9 param9) {
        return new Tuple9<>(param1, param2, param3, param4, param5, param6, param7, param8, param9);
    }

    public static class Tuple {
        private final Object[] values;

        protected Tuple(Object ... values) {
            this.values = values;
        }

        public Object get(int i) {
            return values[i];
        }

        public int size() {
            return values.length;
        }
    }

    public static class Tuple1<T1> extends Tuple {
        public Tuple1(T1 param1) {
            super(param1);
        }

        @SuppressWarnings("unchecked")
        public T1 get1() {
            return (T1) get(0);
        }
    }

    public static class Tuple2<T1, T2> extends Tuple {
        public Tuple2(T1 param1, T2 param2) {
            super(param1, param2);
        }

        @SuppressWarnings("unchecked")
        public T1 get1() {
            return (T1) get(0);
        }

        @SuppressWarnings("unchecked")
        public T2 get2() {
            return (T2) get(1);
        }
    }

    public static class Tuple3<T1, T2, T3> extends Tuple {
        public Tuple3(T1 param1, T2 param2, T3 param3) {
            super(param1, param2, param3);
        }

        @SuppressWarnings("unchecked")
        public T1 get1() {
            return (T1) get(0);
        }

        @SuppressWarnings("unchecked")
        public T2 get2() {
            return (T2) get(1);
        }

        @SuppressWarnings("unchecked")
        public T3 get3() {
            return (T3) get(2);
        }
    }

    public static class Tuple4<T1, T2, T3, T4> extends Tuple {
        public Tuple4(T1 param1, T2 param2, T3 param3, T4 param4) {
            super(param1, param2, param3, param4);
        }

        @SuppressWarnings("unchecked")
        public T1 get1() {
            return (T1) get(0);
        }

        @SuppressWarnings("unchecked")
        public T2 get2() {
            return (T2) get(1);
        }

        @SuppressWarnings("unchecked")
        public T3 get3() {
            return (T3) get(2);
        }

        @SuppressWarnings("unchecked")
        public T4 get4() {
            return (T4) get(3);
        }
    }

    public static class Tuple5<T1, T2, T3, T4, T5> extends Tuple {
        public Tuple5(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5) {
            super(param1, param2, param3, param4, param5);
        }

        @SuppressWarnings("unchecked")
        public T1 get1() {
            return (T1) get(0);
        }

        @SuppressWarnings("unchecked")
        public T2 get2() {
            return (T2) get(1);
        }

        @SuppressWarnings("unchecked")
        public T3 get3() {
            return (T3) get(2);
        }

        @SuppressWarnings("unchecked")
        public T4 get4() {
            return (T4) get(3);
        }

        @SuppressWarnings("unchecked")
        public T5 get5() {
            return (T5) get(4);
        }
    }

    public static class Tuple6<T1, T2, T3, T4, T5, T6> extends Tuple {
        public Tuple6(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5, T6 param6) {
            super(param1, param2, param3, param4, param5, param6);
        }

        @SuppressWarnings("unchecked")
        public T1 get1() {
            return (T1) get(0);
        }

        @SuppressWarnings("unchecked")
        public T2 get2() {
            return (T2) get(1);
        }

        @SuppressWarnings("unchecked")
        public T3 get3() {
            return (T3) get(2);
        }

        @SuppressWarnings("unchecked")
        public T4 get4() {
            return (T4) get(3);
        }

        @SuppressWarnings("unchecked")
        public T5 get5() {
            return (T5) get(4);
        }

        @SuppressWarnings("unchecked")
        public T6 get6() {
            return (T6) get(5);
        }
    }

    public static class Tuple7<T1, T2, T3, T4, T5, T6, T7> extends Tuple {
        public Tuple7(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5, T6 param6, T7 param7) {
            super(param1, param2, param3, param4, param5, param6, param7);
        }

        @SuppressWarnings("unchecked")
        public T1 get1() {
            return (T1) get(0);
        }

        @SuppressWarnings("unchecked")
        public T2 get2() {
            return (T2) get(1);
        }

        @SuppressWarnings("unchecked")
        public T3 get3() {
            return (T3) get(2);
        }

        @SuppressWarnings("unchecked")
        public T4 get4() {
            return (T4) get(3);
        }

        @SuppressWarnings("unchecked")
        public T5 get5() {
            return (T5) get(4);
        }

        @SuppressWarnings("unchecked")
        public T6 get6() {
            return (T6) get(5);
        }

        @SuppressWarnings("unchecked")
        public T7 get7() {
            return (T7) get(6);
        }
    }

    public static class Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> extends Tuple {
        public Tuple8(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5, T6 param6, T7 param7, T8 param8) {
            super(param1, param2, param3, param4, param5, param6, param7, param8);
        }

        @SuppressWarnings("unchecked")
        public T1 get1() {
            return (T1) get(0);
        }

        @SuppressWarnings("unchecked")
        public T2 get2() {
            return (T2) get(1);
        }

        @SuppressWarnings("unchecked")
        public T3 get3() {
            return (T3) get(2);
        }

        @SuppressWarnings("unchecked")
        public T4 get4() {
            return (T4) get(3);
        }

        @SuppressWarnings("unchecked")
        public T5 get5() {
            return (T5) get(4);
        }

        @SuppressWarnings("unchecked")
        public T6 get6() {
            return (T6) get(5);
        }

        @SuppressWarnings("unchecked")
        public T7 get7() {
            return (T7) get(6);
        }

        @SuppressWarnings("unchecked")
        public T8 get8() {
            return (T8) get(7);
        }
    }

    public static class Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> extends Tuple {
        public Tuple9(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5, T6 param6, T7 param7, T8 param8, T9 param9) {
            super(param1, param2, param3, param4, param5, param6, param7, param8, param9);
        }

        @SuppressWarnings("unchecked")
        public T1 get1() {
            return (T1) get(0);
        }

        @SuppressWarnings("unchecked")
        public T2 get2() {
            return (T2) get(1);
        }

        @SuppressWarnings("unchecked")
        public T3 get3() {
            return (T3) get(2);
        }

        @SuppressWarnings("unchecked")
        public T4 get4() {
            return (T4) get(3);
        }

        @SuppressWarnings("unchecked")
        public T5 get5() {
            return (T5) get(4);
        }

        @SuppressWarnings("unchecked")
        public T6 get6() {
            return (T6) get(5);
        }

        @SuppressWarnings("unchecked")
        public T7 get7() {
            return (T7) get(6);
        }

        @SuppressWarnings("unchecked")
        public T8 get8() {
            return (T8) get(7);
        }

        @SuppressWarnings("unchecked")
        public T9 get9() {
            return (T9) get(8);
        }
    }
}
