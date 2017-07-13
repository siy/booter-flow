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

import java.util.function.Consumer;
import java.util.function.Supplier;

import static org.rxbooter.flow.Tuples.*;

public interface Functions {

    //----------------------------------- General Purpose functions

    
    interface F<R1, T1> {
        R1 apply(T1 param);

        static F<Tuple1<Void>, Tuple1<Void>> from(Runnable runnable) {
            return (a) -> {runnable.run(); return of(null);};
        }

        static <T> F<Tuple1<T>, Tuple1<Void>> from(Supplier<T> supplier) {
            return (t) -> of(supplier.get());
        }

        static <T> F<Tuple1<Void>, Tuple1<T>> from(Consumer<T> consumer) {
            return (t) -> { consumer.accept(t.get1()); return Tuples.empty1();};
        }
    }

    interface TF<R1, T1> {
        R1 apply(T1 param) throws Throwable;

        static TF<Tuple1<Void>, Tuple1<Void>> from(Runnable runnable) {
            return (a) -> {runnable.run(); return of(null);};
        }

        static <T> TF<Tuple1<T>, Tuple1<Void>> from(Supplier<T> supplier) {
            return (t) -> of(supplier.get());
        }

        static <T> TF<Tuple1<Void>, Tuple1<T>> from(Consumer<T> consumer) {
            return (t) -> { consumer.accept(t.get1()); return Tuples.empty1();};
        }
    }

    interface EH<R1> {
        R1 handle(Throwable err);
    }

    interface CF<T1> {
        boolean test(T1 param);
    }

    interface AF<T1> {
        void accept(T1 param);
    }

    //----------------------------------- Acceptor functions

    interface AF1<T1> {
        void accept(T1 param1);

        default AF<Tuple1<T1>> asAcceptorFunction() {
            return (Tuple1<T1> param) -> accept(param.get1());
        }
    }

    interface AF2<T1, T2> {
        void accept(T1 param1, T2 param2);

        default AF<Tuple2<T1, T2>> asAcceptorFunction() {
            return (Tuple2<T1, T2> param) -> accept(param.get1(), param.get2());
        }
    }

    interface AF3<T1, T2, T3> {
        void accept(T1 param1, T2 param2, T3 param3);

        default AF<Tuple3<T1, T2, T3>> asAcceptorFunction() {
            return (Tuple3<T1, T2, T3> param) -> accept(param.get1(), param.get2(), param.get3());
        }
    }

    interface AF4<T1, T2, T3, T4> {
        void accept(T1 param1, T2 param2, T3 param3, T4 param4);

        default AF<Tuple4<T1, T2, T3, T4>> asAcceptorFunction() {
            return (Tuple4<T1, T2, T3, T4> param) -> accept(param.get1(), param.get2(), param.get3(), param.get4());
        }
    }

    interface AF5<T1, T2, T3, T4, T5> {
        void accept(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5);

        default AF<Tuple5<T1, T2, T3, T4, T5>> asAcceptorFunction() {
            return (Tuple5<T1, T2, T3, T4, T5> param) -> accept(param.get1(), param.get2(), param.get3(), param.get4(), param.get5());
        }
    }

    interface AF6<T1, T2, T3, T4, T5, T6> {
        void accept(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5, T6 param6);

        default AF<Tuple6<T1, T2, T3, T4, T5, T6>> asAcceptorFunction() {
            return (Tuple6<T1, T2, T3, T4, T5, T6> param) -> accept(param.get1(), param.get2(), param.get3(), param.get4(), param.get5(), param.get6());
        }
    }

    interface AF7<T1, T2, T3, T4, T5, T6, T7> {
        void accept(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5, T6 param6, T7 param7);

        default AF<Tuple7<T1, T2, T3, T4, T5, T6, T7>> asAcceptorFunction() {
            return (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> accept(param.get1(), param.get2(), param.get3(), param.get4(), param.get5(), param.get6(), param.get7());
        }
    }

    interface AF8<T1, T2, T3, T4, T5, T6, T7, T8> {
        void accept(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5, T6 param6, T7 param7, T8 param8);

        default AF<Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>> asAcceptorFunction() {
            return (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> accept(param.get1(), param.get2(), param.get3(), param.get4(), param.get5(), param.get6(), param.get7(), param.get8());
        }
    }

    interface AF9<T1, T2, T3, T4, T5, T6, T7, T8, T9> {
        void accept(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5, T6 param6, T7 param7, T8 param8, T9 param9);

        default AF<Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>> asAcceptorFunction() {
            return (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> accept(param.get1(), param.get2(), param.get3(), param.get4(), param.get5(), param.get6(), param.get7(), param.get8(), param.get9());
        }
    }


    //----------------------------------- Condition functions

    interface CF1<T1> {
        boolean test(T1 param1);

        default CF<Tuple1<T1>> asConditionFunction() {
            return (Tuple1<T1> param) -> test(param.get1());
        }
    }

    interface CF2<T1, T2> {
        boolean test(T1 param1, T2 param2);

        default CF<Tuple2<T1, T2>> asConditionFunction() {
            return (Tuple2<T1, T2> param) -> test(param.get1(), param.get2());
        }
    }

    interface CF3<T1, T2, T3> {
        boolean test(T1 param1, T2 param2, T3 param3);

        default CF<Tuple3<T1, T2, T3>> asConditionFunction() {
            return (Tuple3<T1, T2, T3> param) -> test(param.get1(), param.get2(), param.get3());
        }
    }

    interface CF4<T1, T2, T3, T4> {
        boolean test(T1 param1, T2 param2, T3 param3, T4 param4);

        default CF<Tuple4<T1, T2, T3, T4>> asConditionFunction() {
            return (Tuple4<T1, T2, T3, T4> param) -> test(param.get1(), param.get2(), param.get3(), param.get4());
        }
    }

    interface CF5<T1, T2, T3, T4, T5> {
        boolean test(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5);

        default CF<Tuple5<T1, T2, T3, T4, T5>> asConditionFunction() {
            return (Tuple5<T1, T2, T3, T4, T5> param) -> test(param.get1(), param.get2(), param.get3(), param.get4(), param.get5());
        }
    }

    interface CF6<T1, T2, T3, T4, T5, T6> {
        boolean test(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5, T6 param6);

        default CF<Tuple6<T1, T2, T3, T4, T5, T6>> asConditionFunction() {
            return (Tuple6<T1, T2, T3, T4, T5, T6> param) -> test(param.get1(), param.get2(), param.get3(), param.get4(), param.get5(), param.get6());
        }
    }

    interface CF7<T1, T2, T3, T4, T5, T6, T7> {
        boolean test(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5, T6 param6, T7 param7);

        default CF<Tuple7<T1, T2, T3, T4, T5, T6, T7>> asConditionFunction() {
            return (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> test(param.get1(), param.get2(), param.get3(), param.get4(), param.get5(), param.get6(), param.get7());
        }
    }

    interface CF8<T1, T2, T3, T4, T5, T6, T7, T8> {
        boolean test(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5, T6 param6, T7 param7, T8 param8);

        default CF<Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>> asConditionFunction() {
            return (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> test(param.get1(), param.get2(), param.get3(), param.get4(), param.get5(), param.get6(), param.get7(), param.get8());
        }
    }

    interface CF9<T1, T2, T3, T4, T5, T6, T7, T8, T9> {
        boolean test(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5, T6 param6, T7 param7, T8 param8, T9 param9);

        default CF<Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>> asConditionFunction() {
            return (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> test(param.get1(), param.get2(), param.get3(), param.get4(), param.get5(), param.get6(), param.get7(), param.get8(), param.get9());
        }
    }

    //----------------------------------- Map functions

    interface FN10<R1, T1> {
        R1 apply(T1 param1);
    }

    interface FN11<R1, T1> extends FN10<Tuple1<R1>, T1> {
        default TF<Tuple1<R1>, Tuple1<T1>> asStepFunction() {
            return (Tuple1<T1> param) -> apply(param.get1());
        }
    }

    interface FN12<R1, R2, T1> extends FN10<Tuple2<R1, R2>, T1> {
        default TF<Tuple2<R1, R2>, Tuple1<T1>> asStepFunction() {
            return (Tuple1<T1> param) -> apply(param.get1());
        }
    }

    interface FN13<R1, R2, R3, T1> extends FN10<Tuple3<R1, R2, R3>, T1> {
        default TF<Tuple3<R1, R2, R3>, Tuple1<T1>> asStepFunction() {
            return (Tuple1<T1> param) -> apply(param.get1());
        }
    }

    interface FN14<R1, R2, R3, R4, T1> extends FN10<Tuple4<R1, R2, R3, R4>, T1> {
        default TF<Tuple4<R1, R2, R3, R4>, Tuple1<T1>> asStepFunction() {
            return (Tuple1<T1> param) -> apply(param.get1());
        }
    }

    interface FN15<R1, R2, R3, R4, R5, T1> extends FN10<Tuple5<R1, R2, R3, R4, R5>, T1> {
        default TF<Tuple5<R1, R2, R3, R4, R5>, Tuple1<T1>> asStepFunction() {
            return (Tuple1<T1> param) -> apply(param.get1());
        }
    }

    interface FN16<R1, R2, R3, R4, R5, R6, T1> extends FN10<Tuple6<R1, R2, R3, R4, R5, R6>, T1> {
        default TF<Tuple6<R1, R2, R3, R4, R5, R6>, Tuple1<T1>> asStepFunction() {
            return (Tuple1<T1> param) -> apply(param.get1());
        }
    }

    interface FN17<R1, R2, R3, R4, R5, R6, R7, T1> extends FN10<Tuple7<R1, R2, R3, R4, R5, R6, R7>, T1> {
        default TF<Tuple7<R1, R2, R3, R4, R5, R6, R7>, Tuple1<T1>> asStepFunction() {
            return (Tuple1<T1> param) -> apply(param.get1());
        }
    }

    interface FN18<R1, R2, R3, R4, R5, R6, R7, R8, T1> extends FN10<Tuple8<R1, R2, R3, R4, R5, R6, R7, R8>, T1> {
        default TF<Tuple8<R1, R2, R3, R4, R5, R6, R7, R8>, Tuple1<T1>> asStepFunction() {
            return (Tuple1<T1> param) -> apply(param.get1());
        }
    }

    interface FN19<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1> extends FN10<Tuple9<R1, R2, R3, R4, R5, R6, R7, R8, R9>, T1> {
        default TF<Tuple9<R1, R2, R3, R4, R5, R6, R7, R8, R9>, Tuple1<T1>> asStepFunction() {
            return (Tuple1<T1> param) -> apply(param.get1());
        }
    }

    interface FN20<R1, T1, T2> {
        R1 apply(T1 param1, T2 param2);
    }

    interface FN21<R1, T1, T2> extends FN20<Tuple1<R1>, T1, T2> {
        default TF<Tuple1<R1>, Tuple2<T1, T2>> asStepFunction() {
            return (Tuple2<T1, T2> param) -> apply(param.get1(), param.get2());
        }
    }

    interface FN22<R1, R2, T1, T2> extends FN20<Tuple2<R1, R2>, T1, T2> {
        default TF<Tuple2<R1, R2>, Tuple2<T1, T2>> asStepFunction() {
            return (Tuple2<T1, T2> param) -> apply(param.get1(), param.get2());
        }
    }

    interface FN23<R1, R2, R3, T1, T2> extends FN20<Tuple3<R1, R2, R3>, T1, T2> {
        default TF<Tuple3<R1, R2, R3>, Tuple2<T1, T2>> asStepFunction() {
            return (Tuple2<T1, T2> param) -> apply(param.get1(), param.get2());
        }
    }

    interface FN24<R1, R2, R3, R4, T1, T2> extends FN20<Tuple4<R1, R2, R3, R4>, T1, T2> {
        default TF<Tuple4<R1, R2, R3, R4>, Tuple2<T1, T2>> asStepFunction() {
            return (Tuple2<T1, T2> param) -> apply(param.get1(), param.get2());
        }
    }

    interface FN25<R1, R2, R3, R4, R5, T1, T2> extends FN20<Tuple5<R1, R2, R3, R4, R5>, T1, T2> {
        default TF<Tuple5<R1, R2, R3, R4, R5>, Tuple2<T1, T2>> asStepFunction() {
            return (Tuple2<T1, T2> param) -> apply(param.get1(), param.get2());
        }
    }

    interface FN26<R1, R2, R3, R4, R5, R6, T1, T2> extends FN20<Tuple6<R1, R2, R3, R4, R5, R6>, T1, T2> {
        default TF<Tuple6<R1, R2, R3, R4, R5, R6>, Tuple2<T1, T2>> asStepFunction() {
            return (Tuple2<T1, T2> param) -> apply(param.get1(), param.get2());
        }
    }

    interface FN27<R1, R2, R3, R4, R5, R6, R7, T1, T2> extends FN20<Tuple7<R1, R2, R3, R4, R5, R6, R7>, T1, T2> {
        default TF<Tuple7<R1, R2, R3, R4, R5, R6, R7>, Tuple2<T1, T2>> asStepFunction() {
            return (Tuple2<T1, T2> param) -> apply(param.get1(), param.get2());
        }
    }

    interface FN28<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2> extends FN20<Tuple8<R1, R2, R3, R4, R5, R6, R7, R8>, T1, T2> {
        default TF<Tuple8<R1, R2, R3, R4, R5, R6, R7, R8>, Tuple2<T1, T2>> asStepFunction() {
            return (Tuple2<T1, T2> param) -> apply(param.get1(), param.get2());
        }
    }

    interface FN29<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2> extends FN20<Tuple9<R1, R2, R3, R4, R5, R6, R7, R8, R9>, T1, T2> {
        default TF<Tuple9<R1, R2, R3, R4, R5, R6, R7, R8, R9>, Tuple2<T1, T2>> asStepFunction() {
            return (Tuple2<T1, T2> param) -> apply(param.get1(), param.get2());
        }
    }

    interface FN30<R1, T1, T2, T3> {
        R1 apply(T1 param1, T2 param2, T3 param3);
    }

    interface FN31<R1, T1, T2, T3> extends FN30<Tuple1<R1>, T1, T2, T3> {
        default TF<Tuple1<R1>, Tuple3<T1, T2, T3>> asStepFunction() {
            return (Tuple3<T1, T2, T3> param) -> apply(param.get1(), param.get2(), param.get3());
        }
    }

    interface FN32<R1, R2, T1, T2, T3> extends FN30<Tuple2<R1, R2>, T1, T2, T3> {
        default TF<Tuple2<R1, R2>, Tuple3<T1, T2, T3>> asStepFunction() {
            return (Tuple3<T1, T2, T3> param) -> apply(param.get1(), param.get2(), param.get3());
        }
    }

    interface FN33<R1, R2, R3, T1, T2, T3> extends FN30<Tuple3<R1, R2, R3>, T1, T2, T3> {
        default TF<Tuple3<R1, R2, R3>, Tuple3<T1, T2, T3>> asStepFunction() {
            return (Tuple3<T1, T2, T3> param) -> apply(param.get1(), param.get2(), param.get3());
        }
    }

    interface FN34<R1, R2, R3, R4, T1, T2, T3> extends FN30<Tuple4<R1, R2, R3, R4>, T1, T2, T3> {
        default TF<Tuple4<R1, R2, R3, R4>, Tuple3<T1, T2, T3>> asStepFunction() {
            return (Tuple3<T1, T2, T3> param) -> apply(param.get1(), param.get2(), param.get3());
        }
    }

    interface FN35<R1, R2, R3, R4, R5, T1, T2, T3> extends FN30<Tuple5<R1, R2, R3, R4, R5>, T1, T2, T3> {
        default TF<Tuple5<R1, R2, R3, R4, R5>, Tuple3<T1, T2, T3>> asStepFunction() {
            return (Tuple3<T1, T2, T3> param) -> apply(param.get1(), param.get2(), param.get3());
        }
    }

    interface FN36<R1, R2, R3, R4, R5, R6, T1, T2, T3> extends FN30<Tuple6<R1, R2, R3, R4, R5, R6>, T1, T2, T3> {
        default TF<Tuple6<R1, R2, R3, R4, R5, R6>, Tuple3<T1, T2, T3>> asStepFunction() {
            return (Tuple3<T1, T2, T3> param) -> apply(param.get1(), param.get2(), param.get3());
        }
    }

    interface FN37<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3> extends FN30<Tuple7<R1, R2, R3, R4, R5, R6, R7>, T1, T2, T3> {
        default TF<Tuple7<R1, R2, R3, R4, R5, R6, R7>, Tuple3<T1, T2, T3>> asStepFunction() {
            return (Tuple3<T1, T2, T3> param) -> apply(param.get1(), param.get2(), param.get3());
        }
    }

    interface FN38<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3> extends FN30<Tuple8<R1, R2, R3, R4, R5, R6, R7, R8>, T1, T2, T3> {
        default TF<Tuple8<R1, R2, R3, R4, R5, R6, R7, R8>, Tuple3<T1, T2, T3>> asStepFunction() {
            return (Tuple3<T1, T2, T3> param) -> apply(param.get1(), param.get2(), param.get3());
        }
    }

    interface FN39<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3> extends FN30<Tuple9<R1, R2, R3, R4, R5, R6, R7, R8, R9>, T1, T2, T3> {
        default TF<Tuple9<R1, R2, R3, R4, R5, R6, R7, R8, R9>, Tuple3<T1, T2, T3>> asStepFunction() {
            return (Tuple3<T1, T2, T3> param) -> apply(param.get1(), param.get2(), param.get3());
        }
    }

    interface FN40<R1, T1, T2, T3, T4> {
        R1 apply(T1 param1, T2 param2, T3 param3, T4 param4);
    }

    interface FN41<R1, T1, T2, T3, T4> extends FN40<Tuple1<R1>, T1, T2, T3, T4> {
        default TF<Tuple1<R1>, Tuple4<T1, T2, T3, T4>> asStepFunction() {
            return (Tuple4<T1, T2, T3, T4> param) -> apply(param.get1(), param.get2(), param.get3(), param.get4());
        }
    }

    interface FN42<R1, R2, T1, T2, T3, T4> extends FN40<Tuple2<R1, R2>, T1, T2, T3, T4> {
        default TF<Tuple2<R1, R2>, Tuple4<T1, T2, T3, T4>> asStepFunction() {
            return (Tuple4<T1, T2, T3, T4> param) -> apply(param.get1(), param.get2(), param.get3(), param.get4());
        }
    }

    interface FN43<R1, R2, R3, T1, T2, T3, T4> extends FN40<Tuple3<R1, R2, R3>, T1, T2, T3, T4> {
        default TF<Tuple3<R1, R2, R3>, Tuple4<T1, T2, T3, T4>> asStepFunction() {
            return (Tuple4<T1, T2, T3, T4> param) -> apply(param.get1(), param.get2(), param.get3(), param.get4());
        }
    }

    interface FN44<R1, R2, R3, R4, T1, T2, T3, T4> extends FN40<Tuple4<R1, R2, R3, R4>, T1, T2, T3, T4> {
        default TF<Tuple4<R1, R2, R3, R4>, Tuple4<T1, T2, T3, T4>> asStepFunction() {
            return (Tuple4<T1, T2, T3, T4> param) -> apply(param.get1(), param.get2(), param.get3(), param.get4());
        }
    }

    interface FN45<R1, R2, R3, R4, R5, T1, T2, T3, T4> extends FN40<Tuple5<R1, R2, R3, R4, R5>, T1, T2, T3, T4> {
        default TF<Tuple5<R1, R2, R3, R4, R5>, Tuple4<T1, T2, T3, T4>> asStepFunction() {
            return (Tuple4<T1, T2, T3, T4> param) -> apply(param.get1(), param.get2(), param.get3(), param.get4());
        }
    }

    interface FN46<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4> extends FN40<Tuple6<R1, R2, R3, R4, R5, R6>, T1, T2, T3, T4> {
        default TF<Tuple6<R1, R2, R3, R4, R5, R6>, Tuple4<T1, T2, T3, T4>> asStepFunction() {
            return (Tuple4<T1, T2, T3, T4> param) -> apply(param.get1(), param.get2(), param.get3(), param.get4());
        }
    }

    interface FN47<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4> extends FN40<Tuple7<R1, R2, R3, R4, R5, R6, R7>, T1, T2, T3, T4> {
        default TF<Tuple7<R1, R2, R3, R4, R5, R6, R7>, Tuple4<T1, T2, T3, T4>> asStepFunction() {
            return (Tuple4<T1, T2, T3, T4> param) -> apply(param.get1(), param.get2(), param.get3(), param.get4());
        }
    }

    interface FN48<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4> extends FN40<Tuple8<R1, R2, R3, R4, R5, R6, R7, R8>, T1, T2, T3, T4> {
        default TF<Tuple8<R1, R2, R3, R4, R5, R6, R7, R8>, Tuple4<T1, T2, T3, T4>> asStepFunction() {
            return (Tuple4<T1, T2, T3, T4> param) -> apply(param.get1(), param.get2(), param.get3(), param.get4());
        }
    }

    interface FN49<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4> extends FN40<Tuple9<R1, R2, R3, R4, R5, R6, R7, R8, R9>, T1, T2, T3, T4> {
        default TF<Tuple9<R1, R2, R3, R4, R5, R6, R7, R8, R9>, Tuple4<T1, T2, T3, T4>> asStepFunction() {
            return (Tuple4<T1, T2, T3, T4> param) -> apply(param.get1(), param.get2(), param.get3(), param.get4());
        }
    }

    interface FN50<R1, T1, T2, T3, T4, T5> {
        R1 apply(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5);
    }

    interface FN51<R1, T1, T2, T3, T4, T5> extends FN50<Tuple1<R1>, T1, T2, T3, T4, T5> {
        default TF<Tuple1<R1>, Tuple5<T1, T2, T3, T4, T5>> asStepFunction() {
            return (Tuple5<T1, T2, T3, T4, T5> param) -> apply(param.get1(), param.get2(), param.get3(), param.get4(), param.get5());
        }
    }

    interface FN52<R1, R2, T1, T2, T3, T4, T5> extends FN50<Tuple2<R1, R2>, T1, T2, T3, T4, T5> {
        default TF<Tuple2<R1, R2>, Tuple5<T1, T2, T3, T4, T5>> asStepFunction() {
            return (Tuple5<T1, T2, T3, T4, T5> param) -> apply(param.get1(), param.get2(), param.get3(), param.get4(), param.get5());
        }
    }

    interface FN53<R1, R2, R3, T1, T2, T3, T4, T5> extends FN50<Tuple3<R1, R2, R3>, T1, T2, T3, T4, T5> {
        default TF<Tuple3<R1, R2, R3>, Tuple5<T1, T2, T3, T4, T5>> asStepFunction() {
            return (Tuple5<T1, T2, T3, T4, T5> param) -> apply(param.get1(), param.get2(), param.get3(), param.get4(), param.get5());
        }
    }

    interface FN54<R1, R2, R3, R4, T1, T2, T3, T4, T5> extends FN50<Tuple4<R1, R2, R3, R4>, T1, T2, T3, T4, T5> {
        default TF<Tuple4<R1, R2, R3, R4>, Tuple5<T1, T2, T3, T4, T5>> asStepFunction() {
            return (Tuple5<T1, T2, T3, T4, T5> param) -> apply(param.get1(), param.get2(), param.get3(), param.get4(), param.get5());
        }
    }

    interface FN55<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5> extends FN50<Tuple5<R1, R2, R3, R4, R5>, T1, T2, T3, T4, T5> {
        default TF<Tuple5<R1, R2, R3, R4, R5>, Tuple5<T1, T2, T3, T4, T5>> asStepFunction() {
            return (Tuple5<T1, T2, T3, T4, T5> param) -> apply(param.get1(), param.get2(), param.get3(), param.get4(), param.get5());
        }
    }

    interface FN56<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5> extends FN50<Tuple6<R1, R2, R3, R4, R5, R6>, T1, T2, T3, T4, T5> {
        default TF<Tuple6<R1, R2, R3, R4, R5, R6>, Tuple5<T1, T2, T3, T4, T5>> asStepFunction() {
            return (Tuple5<T1, T2, T3, T4, T5> param) -> apply(param.get1(), param.get2(), param.get3(), param.get4(), param.get5());
        }
    }

    interface FN57<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5> extends FN50<Tuple7<R1, R2, R3, R4, R5, R6, R7>, T1, T2, T3, T4, T5> {
        default TF<Tuple7<R1, R2, R3, R4, R5, R6, R7>, Tuple5<T1, T2, T3, T4, T5>> asStepFunction() {
            return (Tuple5<T1, T2, T3, T4, T5> param) -> apply(param.get1(), param.get2(), param.get3(), param.get4(), param.get5());
        }
    }

    interface FN58<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5> extends FN50<Tuple8<R1, R2, R3, R4, R5, R6, R7, R8>, T1, T2, T3, T4, T5> {
        default TF<Tuple8<R1, R2, R3, R4, R5, R6, R7, R8>, Tuple5<T1, T2, T3, T4, T5>> asStepFunction() {
            return (Tuple5<T1, T2, T3, T4, T5> param) -> apply(param.get1(), param.get2(), param.get3(), param.get4(), param.get5());
        }
    }

    interface FN59<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5> extends FN50<Tuple9<R1, R2, R3, R4, R5, R6, R7, R8, R9>, T1, T2, T3, T4, T5> {
        default TF<Tuple9<R1, R2, R3, R4, R5, R6, R7, R8, R9>, Tuple5<T1, T2, T3, T4, T5>> asStepFunction() {
            return (Tuple5<T1, T2, T3, T4, T5> param) -> apply(param.get1(), param.get2(), param.get3(), param.get4(), param.get5());
        }
    }

    interface FN60<R1, T1, T2, T3, T4, T5, T6> {
        R1 apply(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5, T6 param6);
    }

    interface FN61<R1, T1, T2, T3, T4, T5, T6> extends FN60<Tuple1<R1>, T1, T2, T3, T4, T5, T6> {
        default TF<Tuple1<R1>, Tuple6<T1, T2, T3, T4, T5, T6>> asStepFunction() {
            return (Tuple6<T1, T2, T3, T4, T5, T6> param) -> apply(param.get1(), param.get2(), param.get3(), param.get4(), param.get5(), param.get6());
        }
    }

    interface FN62<R1, R2, T1, T2, T3, T4, T5, T6> extends FN60<Tuple2<R1, R2>, T1, T2, T3, T4, T5, T6> {
        default TF<Tuple2<R1, R2>, Tuple6<T1, T2, T3, T4, T5, T6>> asStepFunction() {
            return (Tuple6<T1, T2, T3, T4, T5, T6> param) -> apply(param.get1(), param.get2(), param.get3(), param.get4(), param.get5(), param.get6());
        }
    }

    interface FN63<R1, R2, R3, T1, T2, T3, T4, T5, T6> extends FN60<Tuple3<R1, R2, R3>, T1, T2, T3, T4, T5, T6> {
        default TF<Tuple3<R1, R2, R3>, Tuple6<T1, T2, T3, T4, T5, T6>> asStepFunction() {
            return (Tuple6<T1, T2, T3, T4, T5, T6> param) -> apply(param.get1(), param.get2(), param.get3(), param.get4(), param.get5(), param.get6());
        }
    }

    interface FN64<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6> extends FN60<Tuple4<R1, R2, R3, R4>, T1, T2, T3, T4, T5, T6> {
        default TF<Tuple4<R1, R2, R3, R4>, Tuple6<T1, T2, T3, T4, T5, T6>> asStepFunction() {
            return (Tuple6<T1, T2, T3, T4, T5, T6> param) -> apply(param.get1(), param.get2(), param.get3(), param.get4(), param.get5(), param.get6());
        }
    }

    interface FN65<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6> extends FN60<Tuple5<R1, R2, R3, R4, R5>, T1, T2, T3, T4, T5, T6> {
        default TF<Tuple5<R1, R2, R3, R4, R5>, Tuple6<T1, T2, T3, T4, T5, T6>> asStepFunction() {
            return (Tuple6<T1, T2, T3, T4, T5, T6> param) -> apply(param.get1(), param.get2(), param.get3(), param.get4(), param.get5(), param.get6());
        }
    }

    interface FN66<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6> extends FN60<Tuple6<R1, R2, R3, R4, R5, R6>, T1, T2, T3, T4, T5, T6> {
        default TF<Tuple6<R1, R2, R3, R4, R5, R6>, Tuple6<T1, T2, T3, T4, T5, T6>> asStepFunction() {
            return (Tuple6<T1, T2, T3, T4, T5, T6> param) -> apply(param.get1(), param.get2(), param.get3(), param.get4(), param.get5(), param.get6());
        }
    }

    interface FN67<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6> extends FN60<Tuple7<R1, R2, R3, R4, R5, R6, R7>, T1, T2, T3, T4, T5, T6> {
        default TF<Tuple7<R1, R2, R3, R4, R5, R6, R7>, Tuple6<T1, T2, T3, T4, T5, T6>> asStepFunction() {
            return (Tuple6<T1, T2, T3, T4, T5, T6> param) -> apply(param.get1(), param.get2(), param.get3(), param.get4(), param.get5(), param.get6());
        }
    }

    interface FN68<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5, T6> extends FN60<Tuple8<R1, R2, R3, R4, R5, R6, R7, R8>, T1, T2, T3, T4, T5, T6> {
        default TF<Tuple8<R1, R2, R3, R4, R5, R6, R7, R8>, Tuple6<T1, T2, T3, T4, T5, T6>> asStepFunction() {
            return (Tuple6<T1, T2, T3, T4, T5, T6> param) -> apply(param.get1(), param.get2(), param.get3(), param.get4(), param.get5(), param.get6());
        }
    }

    interface FN69<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5, T6> extends FN60<Tuple9<R1, R2, R3, R4, R5, R6, R7, R8, R9>, T1, T2, T3, T4, T5, T6> {
        default TF<Tuple9<R1, R2, R3, R4, R5, R6, R7, R8, R9>, Tuple6<T1, T2, T3, T4, T5, T6>> asStepFunction() {
            return (Tuple6<T1, T2, T3, T4, T5, T6> param) -> apply(param.get1(), param.get2(), param.get3(), param.get4(), param.get5(), param.get6());
        }
    }

    interface FN70<R1, T1, T2, T3, T4, T5, T6, T7> {
        R1 apply(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5, T6 param6, T7 param7);
    }

    interface FN71<R1, T1, T2, T3, T4, T5, T6, T7> extends FN70<Tuple1<R1>, T1, T2, T3, T4, T5, T6, T7> {
        default TF<Tuple1<R1>, Tuple7<T1, T2, T3, T4, T5, T6, T7>> asStepFunction() {
            return (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> apply(param.get1(), param.get2(), param.get3(), param.get4(), param.get5(), param.get6(), param.get7());
        }
    }

    interface FN72<R1, R2, T1, T2, T3, T4, T5, T6, T7> extends FN70<Tuple2<R1, R2>, T1, T2, T3, T4, T5, T6, T7> {
        default TF<Tuple2<R1, R2>, Tuple7<T1, T2, T3, T4, T5, T6, T7>> asStepFunction() {
            return (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> apply(param.get1(), param.get2(), param.get3(), param.get4(), param.get5(), param.get6(), param.get7());
        }
    }

    interface FN73<R1, R2, R3, T1, T2, T3, T4, T5, T6, T7> extends FN70<Tuple3<R1, R2, R3>, T1, T2, T3, T4, T5, T6, T7> {
        default TF<Tuple3<R1, R2, R3>, Tuple7<T1, T2, T3, T4, T5, T6, T7>> asStepFunction() {
            return (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> apply(param.get1(), param.get2(), param.get3(), param.get4(), param.get5(), param.get6(), param.get7());
        }
    }

    interface FN74<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6, T7> extends FN70<Tuple4<R1, R2, R3, R4>, T1, T2, T3, T4, T5, T6, T7> {
        default TF<Tuple4<R1, R2, R3, R4>, Tuple7<T1, T2, T3, T4, T5, T6, T7>> asStepFunction() {
            return (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> apply(param.get1(), param.get2(), param.get3(), param.get4(), param.get5(), param.get6(), param.get7());
        }
    }

    interface FN75<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6, T7> extends FN70<Tuple5<R1, R2, R3, R4, R5>, T1, T2, T3, T4, T5, T6, T7> {
        default TF<Tuple5<R1, R2, R3, R4, R5>, Tuple7<T1, T2, T3, T4, T5, T6, T7>> asStepFunction() {
            return (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> apply(param.get1(), param.get2(), param.get3(), param.get4(), param.get5(), param.get6(), param.get7());
        }
    }

    interface FN76<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6, T7> extends FN70<Tuple6<R1, R2, R3, R4, R5, R6>, T1, T2, T3, T4, T5, T6, T7> {
        default TF<Tuple6<R1, R2, R3, R4, R5, R6>, Tuple7<T1, T2, T3, T4, T5, T6, T7>> asStepFunction() {
            return (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> apply(param.get1(), param.get2(), param.get3(), param.get4(), param.get5(), param.get6(), param.get7());
        }
    }

    interface FN77<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6, T7> extends FN70<Tuple7<R1, R2, R3, R4, R5, R6, R7>, T1, T2, T3, T4, T5, T6, T7> {
        default TF<Tuple7<R1, R2, R3, R4, R5, R6, R7>, Tuple7<T1, T2, T3, T4, T5, T6, T7>> asStepFunction() {
            return (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> apply(param.get1(), param.get2(), param.get3(), param.get4(), param.get5(), param.get6(), param.get7());
        }
    }

    interface FN78<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5, T6, T7> extends FN70<Tuple8<R1, R2, R3, R4, R5, R6, R7, R8>, T1, T2, T3, T4, T5, T6, T7> {
        default TF<Tuple8<R1, R2, R3, R4, R5, R6, R7, R8>, Tuple7<T1, T2, T3, T4, T5, T6, T7>> asStepFunction() {
            return (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> apply(param.get1(), param.get2(), param.get3(), param.get4(), param.get5(), param.get6(), param.get7());
        }
    }

    interface FN79<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5, T6, T7> extends FN70<Tuple9<R1, R2, R3, R4, R5, R6, R7, R8, R9>, T1, T2, T3, T4, T5, T6, T7> {
        default TF<Tuple9<R1, R2, R3, R4, R5, R6, R7, R8, R9>, Tuple7<T1, T2, T3, T4, T5, T6, T7>> asStepFunction() {
            return (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> apply(param.get1(), param.get2(), param.get3(), param.get4(), param.get5(), param.get6(), param.get7());
        }
    }

    interface FN80<R1, T1, T2, T3, T4, T5, T6, T7, T8> {
        R1 apply(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5, T6 param6, T7 param7, T8 param8);
    }

    interface FN81<R1, T1, T2, T3, T4, T5, T6, T7, T8> extends FN80<Tuple1<R1>, T1, T2, T3, T4, T5, T6, T7, T8> {
        default TF<Tuple1<R1>, Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>> asStepFunction() {
            return (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> apply(param.get1(), param.get2(), param.get3(), param.get4(), param.get5(), param.get6(), param.get7(), param.get8());
        }
    }

    interface FN82<R1, R2, T1, T2, T3, T4, T5, T6, T7, T8> extends FN80<Tuple2<R1, R2>, T1, T2, T3, T4, T5, T6, T7, T8> {
        default TF<Tuple2<R1, R2>, Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>> asStepFunction() {
            return (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> apply(param.get1(), param.get2(), param.get3(), param.get4(), param.get5(), param.get6(), param.get7(), param.get8());
        }
    }

    interface FN83<R1, R2, R3, T1, T2, T3, T4, T5, T6, T7, T8> extends FN80<Tuple3<R1, R2, R3>, T1, T2, T3, T4, T5, T6, T7, T8> {
        default TF<Tuple3<R1, R2, R3>, Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>> asStepFunction() {
            return (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> apply(param.get1(), param.get2(), param.get3(), param.get4(), param.get5(), param.get6(), param.get7(), param.get8());
        }
    }

    interface FN84<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6, T7, T8> extends FN80<Tuple4<R1, R2, R3, R4>, T1, T2, T3, T4, T5, T6, T7, T8> {
        default TF<Tuple4<R1, R2, R3, R4>, Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>> asStepFunction() {
            return (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> apply(param.get1(), param.get2(), param.get3(), param.get4(), param.get5(), param.get6(), param.get7(), param.get8());
        }
    }

    interface FN85<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6, T7, T8> extends FN80<Tuple5<R1, R2, R3, R4, R5>, T1, T2, T3, T4, T5, T6, T7, T8> {
        default TF<Tuple5<R1, R2, R3, R4, R5>, Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>> asStepFunction() {
            return (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> apply(param.get1(), param.get2(), param.get3(), param.get4(), param.get5(), param.get6(), param.get7(), param.get8());
        }
    }

    interface FN86<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6, T7, T8> extends FN80<Tuple6<R1, R2, R3, R4, R5, R6>, T1, T2, T3, T4, T5, T6, T7, T8> {
        default TF<Tuple6<R1, R2, R3, R4, R5, R6>, Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>> asStepFunction() {
            return (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> apply(param.get1(), param.get2(), param.get3(), param.get4(), param.get5(), param.get6(), param.get7(), param.get8());
        }
    }

    interface FN87<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6, T7, T8> extends FN80<Tuple7<R1, R2, R3, R4, R5, R6, R7>, T1, T2, T3, T4, T5, T6, T7, T8> {
        default TF<Tuple7<R1, R2, R3, R4, R5, R6, R7>, Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>> asStepFunction() {
            return (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> apply(param.get1(), param.get2(), param.get3(), param.get4(), param.get5(), param.get6(), param.get7(), param.get8());
        }
    }

    interface FN88<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5, T6, T7, T8> extends FN80<Tuple8<R1, R2, R3, R4, R5, R6, R7, R8>, T1, T2, T3, T4, T5, T6, T7, T8> {
        default TF<Tuple8<R1, R2, R3, R4, R5, R6, R7, R8>, Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>> asStepFunction() {
            return (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> apply(param.get1(), param.get2(), param.get3(), param.get4(), param.get5(), param.get6(), param.get7(), param.get8());
        }
    }

    interface FN89<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5, T6, T7, T8> extends FN80<Tuple9<R1, R2, R3, R4, R5, R6, R7, R8, R9>, T1, T2, T3, T4, T5, T6, T7, T8> {
        default TF<Tuple9<R1, R2, R3, R4, R5, R6, R7, R8, R9>, Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>> asStepFunction() {
            return (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> apply(param.get1(), param.get2(), param.get3(), param.get4(), param.get5(), param.get6(), param.get7(), param.get8());
        }
    }

    interface FN90<R1, T1, T2, T3, T4, T5, T6, T7, T8, T9> {
        R1 apply(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5, T6 param6, T7 param7, T8 param8, T9 param9);
    }

    interface FN91<R1, T1, T2, T3, T4, T5, T6, T7, T8, T9> extends FN90<Tuple1<R1>, T1, T2, T3, T4, T5, T6, T7, T8, T9> {
        default TF<Tuple1<R1>, Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>> asStepFunction() {
            return (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> apply(param.get1(), param.get2(), param.get3(), param.get4(), param.get5(), param.get6(), param.get7(), param.get8(), param.get9());
        }
    }

    interface FN92<R1, R2, T1, T2, T3, T4, T5, T6, T7, T8, T9> extends FN90<Tuple2<R1, R2>, T1, T2, T3, T4, T5, T6, T7, T8, T9> {
        default TF<Tuple2<R1, R2>, Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>> asStepFunction() {
            return (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> apply(param.get1(), param.get2(), param.get3(), param.get4(), param.get5(), param.get6(), param.get7(), param.get8(), param.get9());
        }
    }

    interface FN93<R1, R2, R3, T1, T2, T3, T4, T5, T6, T7, T8, T9> extends FN90<Tuple3<R1, R2, R3>, T1, T2, T3, T4, T5, T6, T7, T8, T9> {
        default TF<Tuple3<R1, R2, R3>, Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>> asStepFunction() {
            return (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> apply(param.get1(), param.get2(), param.get3(), param.get4(), param.get5(), param.get6(), param.get7(), param.get8(), param.get9());
        }
    }

    interface FN94<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6, T7, T8, T9> extends FN90<Tuple4<R1, R2, R3, R4>, T1, T2, T3, T4, T5, T6, T7, T8, T9> {
        default TF<Tuple4<R1, R2, R3, R4>, Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>> asStepFunction() {
            return (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> apply(param.get1(), param.get2(), param.get3(), param.get4(), param.get5(), param.get6(), param.get7(), param.get8(), param.get9());
        }
    }

    interface FN95<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6, T7, T8, T9> extends FN90<Tuple5<R1, R2, R3, R4, R5>, T1, T2, T3, T4, T5, T6, T7, T8, T9> {
        default TF<Tuple5<R1, R2, R3, R4, R5>, Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>> asStepFunction() {
            return (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> apply(param.get1(), param.get2(), param.get3(), param.get4(), param.get5(), param.get6(), param.get7(), param.get8(), param.get9());
        }
    }

    interface FN96<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6, T7, T8, T9> extends FN90<Tuple6<R1, R2, R3, R4, R5, R6>, T1, T2, T3, T4, T5, T6, T7, T8, T9> {
        default TF<Tuple6<R1, R2, R3, R4, R5, R6>, Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>> asStepFunction() {
            return (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> apply(param.get1(), param.get2(), param.get3(), param.get4(), param.get5(), param.get6(), param.get7(), param.get8(), param.get9());
        }
    }

    interface FN97<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6, T7, T8, T9> extends FN90<Tuple7<R1, R2, R3, R4, R5, R6, R7>, T1, T2, T3, T4, T5, T6, T7, T8, T9> {
        default TF<Tuple7<R1, R2, R3, R4, R5, R6, R7>, Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>> asStepFunction() {
            return (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> apply(param.get1(), param.get2(), param.get3(), param.get4(), param.get5(), param.get6(), param.get7(), param.get8(), param.get9());
        }
    }

    interface FN98<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5, T6, T7, T8, T9> extends FN90<Tuple8<R1, R2, R3, R4, R5, R6, R7, R8>, T1, T2, T3, T4, T5, T6, T7, T8, T9> {
        default TF<Tuple8<R1, R2, R3, R4, R5, R6, R7, R8>, Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>> asStepFunction() {
            return (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> apply(param.get1(), param.get2(), param.get3(), param.get4(), param.get5(), param.get6(), param.get7(), param.get8(), param.get9());
        }
    }

    interface FN99<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5, T6, T7, T8, T9> extends FN90<Tuple9<R1, R2, R3, R4, R5, R6, R7, R8, R9>, T1, T2, T3, T4, T5, T6, T7, T8, T9> {
        default TF<Tuple9<R1, R2, R3, R4, R5, R6, R7, R8, R9>, Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>> asStepFunction() {
            return (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> apply(param.get1(), param.get2(), param.get3(), param.get4(), param.get5(), param.get6(), param.get7(), param.get8(), param.get9());
        }
    }
}
