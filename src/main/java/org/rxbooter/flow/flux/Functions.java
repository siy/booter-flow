package org.rxbooter.flow.flux;

// WARNING: Generated file, do not edit, all changes will be lost.

import static org.rxbooter.flow.flux.Step.*;
import static org.rxbooter.flow.flux.Tuples.*;

public interface Functions {
    interface FN10<R1, T1> {
        R1 apply(T1 param1);
    }

    interface FN11<R1, T1> extends FN10<Tuple1<R1>, T1> {
        default TF<Tuple1<R1>, Tuple1<T1>> asStepFunction() {
            return (Tuple1<T1> param) -> apply((T1) param.get(0));
        }
    }

    interface FN12<R1, R2, T1> extends FN10<Tuple2<R1, R2>, T1> {
        default TF<Tuple2<R1, R2>, Tuple1<T1>> asStepFunction() {
            return (Tuple1<T1> param) -> apply((T1) param.get(0));
        }
    }

    interface FN13<R1, R2, R3, T1> extends FN10<Tuple3<R1, R2, R3>, T1> {
        default TF<Tuple3<R1, R2, R3>, Tuple1<T1>> asStepFunction() {
            return (Tuple1<T1> param) -> apply((T1) param.get(0));
        }
    }

    interface FN14<R1, R2, R3, R4, T1> extends FN10<Tuple4<R1, R2, R3, R4>, T1> {
        default TF<Tuple4<R1, R2, R3, R4>, Tuple1<T1>> asStepFunction() {
            return (Tuple1<T1> param) -> apply((T1) param.get(0));
        }
    }

    interface FN15<R1, R2, R3, R4, R5, T1> extends FN10<Tuple5<R1, R2, R3, R4, R5>, T1> {
        default TF<Tuple5<R1, R2, R3, R4, R5>, Tuple1<T1>> asStepFunction() {
            return (Tuple1<T1> param) -> apply((T1) param.get(0));
        }
    }

    interface FN16<R1, R2, R3, R4, R5, R6, T1> extends FN10<Tuple6<R1, R2, R3, R4, R5, R6>, T1> {
        default TF<Tuple6<R1, R2, R3, R4, R5, R6>, Tuple1<T1>> asStepFunction() {
            return (Tuple1<T1> param) -> apply((T1) param.get(0));
        }
    }

    interface FN17<R1, R2, R3, R4, R5, R6, R7, T1> extends FN10<Tuple7<R1, R2, R3, R4, R5, R6, R7>, T1> {
        default TF<Tuple7<R1, R2, R3, R4, R5, R6, R7>, Tuple1<T1>> asStepFunction() {
            return (Tuple1<T1> param) -> apply((T1) param.get(0));
        }
    }

    interface FN18<R1, R2, R3, R4, R5, R6, R7, R8, T1> extends FN10<Tuple8<R1, R2, R3, R4, R5, R6, R7, R8>, T1> {
        default TF<Tuple8<R1, R2, R3, R4, R5, R6, R7, R8>, Tuple1<T1>> asStepFunction() {
            return (Tuple1<T1> param) -> apply((T1) param.get(0));
        }
    }

    interface FN19<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1> extends FN10<Tuple9<R1, R2, R3, R4, R5, R6, R7, R8, R9>, T1> {
        default TF<Tuple9<R1, R2, R3, R4, R5, R6, R7, R8, R9>, Tuple1<T1>> asStepFunction() {
            return (Tuple1<T1> param) -> apply((T1) param.get(0));
        }
    }

    interface FN20<R1, T1, T2> {
        R1 apply(T1 param1, T2 param2);
    }

    interface FN21<R1, T1, T2> extends FN20<Tuple1<R1>, T1, T2> {
        default TF<Tuple1<R1>, Tuple2<T1, T2>> asStepFunction() {
            return (Tuple2<T1, T2> param) -> apply((T1) param.get(0), (T2) param.get(1));
        }
    }

    interface FN22<R1, R2, T1, T2> extends FN20<Tuple2<R1, R2>, T1, T2> {
        default TF<Tuple2<R1, R2>, Tuple2<T1, T2>> asStepFunction() {
            return (Tuple2<T1, T2> param) -> apply((T1) param.get(0), (T2) param.get(1));
        }
    }

    interface FN23<R1, R2, R3, T1, T2> extends FN20<Tuple3<R1, R2, R3>, T1, T2> {
        default TF<Tuple3<R1, R2, R3>, Tuple2<T1, T2>> asStepFunction() {
            return (Tuple2<T1, T2> param) -> apply((T1) param.get(0), (T2) param.get(1));
        }
    }

    interface FN24<R1, R2, R3, R4, T1, T2> extends FN20<Tuple4<R1, R2, R3, R4>, T1, T2> {
        default TF<Tuple4<R1, R2, R3, R4>, Tuple2<T1, T2>> asStepFunction() {
            return (Tuple2<T1, T2> param) -> apply((T1) param.get(0), (T2) param.get(1));
        }
    }

    interface FN25<R1, R2, R3, R4, R5, T1, T2> extends FN20<Tuple5<R1, R2, R3, R4, R5>, T1, T2> {
        default TF<Tuple5<R1, R2, R3, R4, R5>, Tuple2<T1, T2>> asStepFunction() {
            return (Tuple2<T1, T2> param) -> apply((T1) param.get(0), (T2) param.get(1));
        }
    }

    interface FN26<R1, R2, R3, R4, R5, R6, T1, T2> extends FN20<Tuple6<R1, R2, R3, R4, R5, R6>, T1, T2> {
        default TF<Tuple6<R1, R2, R3, R4, R5, R6>, Tuple2<T1, T2>> asStepFunction() {
            return (Tuple2<T1, T2> param) -> apply((T1) param.get(0), (T2) param.get(1));
        }
    }

    interface FN27<R1, R2, R3, R4, R5, R6, R7, T1, T2> extends FN20<Tuple7<R1, R2, R3, R4, R5, R6, R7>, T1, T2> {
        default TF<Tuple7<R1, R2, R3, R4, R5, R6, R7>, Tuple2<T1, T2>> asStepFunction() {
            return (Tuple2<T1, T2> param) -> apply((T1) param.get(0), (T2) param.get(1));
        }
    }

    interface FN28<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2> extends FN20<Tuple8<R1, R2, R3, R4, R5, R6, R7, R8>, T1, T2> {
        default TF<Tuple8<R1, R2, R3, R4, R5, R6, R7, R8>, Tuple2<T1, T2>> asStepFunction() {
            return (Tuple2<T1, T2> param) -> apply((T1) param.get(0), (T2) param.get(1));
        }
    }

    interface FN29<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2> extends FN20<Tuple9<R1, R2, R3, R4, R5, R6, R7, R8, R9>, T1, T2> {
        default TF<Tuple9<R1, R2, R3, R4, R5, R6, R7, R8, R9>, Tuple2<T1, T2>> asStepFunction() {
            return (Tuple2<T1, T2> param) -> apply((T1) param.get(0), (T2) param.get(1));
        }
    }

    interface FN30<R1, T1, T2, T3> {
        R1 apply(T1 param1, T2 param2, T3 param3);
    }

    interface FN31<R1, T1, T2, T3> extends FN30<Tuple1<R1>, T1, T2, T3> {
        default TF<Tuple1<R1>, Tuple3<T1, T2, T3>> asStepFunction() {
            return (Tuple3<T1, T2, T3> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2));
        }
    }

    interface FN32<R1, R2, T1, T2, T3> extends FN30<Tuple2<R1, R2>, T1, T2, T3> {
        default TF<Tuple2<R1, R2>, Tuple3<T1, T2, T3>> asStepFunction() {
            return (Tuple3<T1, T2, T3> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2));
        }
    }

    interface FN33<R1, R2, R3, T1, T2, T3> extends FN30<Tuple3<R1, R2, R3>, T1, T2, T3> {
        default TF<Tuple3<R1, R2, R3>, Tuple3<T1, T2, T3>> asStepFunction() {
            return (Tuple3<T1, T2, T3> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2));
        }
    }

    interface FN34<R1, R2, R3, R4, T1, T2, T3> extends FN30<Tuple4<R1, R2, R3, R4>, T1, T2, T3> {
        default TF<Tuple4<R1, R2, R3, R4>, Tuple3<T1, T2, T3>> asStepFunction() {
            return (Tuple3<T1, T2, T3> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2));
        }
    }

    interface FN35<R1, R2, R3, R4, R5, T1, T2, T3> extends FN30<Tuple5<R1, R2, R3, R4, R5>, T1, T2, T3> {
        default TF<Tuple5<R1, R2, R3, R4, R5>, Tuple3<T1, T2, T3>> asStepFunction() {
            return (Tuple3<T1, T2, T3> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2));
        }
    }

    interface FN36<R1, R2, R3, R4, R5, R6, T1, T2, T3> extends FN30<Tuple6<R1, R2, R3, R4, R5, R6>, T1, T2, T3> {
        default TF<Tuple6<R1, R2, R3, R4, R5, R6>, Tuple3<T1, T2, T3>> asStepFunction() {
            return (Tuple3<T1, T2, T3> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2));
        }
    }

    interface FN37<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3> extends FN30<Tuple7<R1, R2, R3, R4, R5, R6, R7>, T1, T2, T3> {
        default TF<Tuple7<R1, R2, R3, R4, R5, R6, R7>, Tuple3<T1, T2, T3>> asStepFunction() {
            return (Tuple3<T1, T2, T3> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2));
        }
    }

    interface FN38<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3> extends FN30<Tuple8<R1, R2, R3, R4, R5, R6, R7, R8>, T1, T2, T3> {
        default TF<Tuple8<R1, R2, R3, R4, R5, R6, R7, R8>, Tuple3<T1, T2, T3>> asStepFunction() {
            return (Tuple3<T1, T2, T3> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2));
        }
    }

    interface FN39<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3> extends FN30<Tuple9<R1, R2, R3, R4, R5, R6, R7, R8, R9>, T1, T2, T3> {
        default TF<Tuple9<R1, R2, R3, R4, R5, R6, R7, R8, R9>, Tuple3<T1, T2, T3>> asStepFunction() {
            return (Tuple3<T1, T2, T3> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2));
        }
    }

    interface FN40<R1, T1, T2, T3, T4> {
        R1 apply(T1 param1, T2 param2, T3 param3, T4 param4);
    }

    interface FN41<R1, T1, T2, T3, T4> extends FN40<Tuple1<R1>, T1, T2, T3, T4> {
        default TF<Tuple1<R1>, Tuple4<T1, T2, T3, T4>> asStepFunction() {
            return (Tuple4<T1, T2, T3, T4> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3));
        }
    }

    interface FN42<R1, R2, T1, T2, T3, T4> extends FN40<Tuple2<R1, R2>, T1, T2, T3, T4> {
        default TF<Tuple2<R1, R2>, Tuple4<T1, T2, T3, T4>> asStepFunction() {
            return (Tuple4<T1, T2, T3, T4> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3));
        }
    }

    interface FN43<R1, R2, R3, T1, T2, T3, T4> extends FN40<Tuple3<R1, R2, R3>, T1, T2, T3, T4> {
        default TF<Tuple3<R1, R2, R3>, Tuple4<T1, T2, T3, T4>> asStepFunction() {
            return (Tuple4<T1, T2, T3, T4> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3));
        }
    }

    interface FN44<R1, R2, R3, R4, T1, T2, T3, T4> extends FN40<Tuple4<R1, R2, R3, R4>, T1, T2, T3, T4> {
        default TF<Tuple4<R1, R2, R3, R4>, Tuple4<T1, T2, T3, T4>> asStepFunction() {
            return (Tuple4<T1, T2, T3, T4> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3));
        }
    }

    interface FN45<R1, R2, R3, R4, R5, T1, T2, T3, T4> extends FN40<Tuple5<R1, R2, R3, R4, R5>, T1, T2, T3, T4> {
        default TF<Tuple5<R1, R2, R3, R4, R5>, Tuple4<T1, T2, T3, T4>> asStepFunction() {
            return (Tuple4<T1, T2, T3, T4> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3));
        }
    }

    interface FN46<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4> extends FN40<Tuple6<R1, R2, R3, R4, R5, R6>, T1, T2, T3, T4> {
        default TF<Tuple6<R1, R2, R3, R4, R5, R6>, Tuple4<T1, T2, T3, T4>> asStepFunction() {
            return (Tuple4<T1, T2, T3, T4> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3));
        }
    }

    interface FN47<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4> extends FN40<Tuple7<R1, R2, R3, R4, R5, R6, R7>, T1, T2, T3, T4> {
        default TF<Tuple7<R1, R2, R3, R4, R5, R6, R7>, Tuple4<T1, T2, T3, T4>> asStepFunction() {
            return (Tuple4<T1, T2, T3, T4> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3));
        }
    }

    interface FN48<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4> extends FN40<Tuple8<R1, R2, R3, R4, R5, R6, R7, R8>, T1, T2, T3, T4> {
        default TF<Tuple8<R1, R2, R3, R4, R5, R6, R7, R8>, Tuple4<T1, T2, T3, T4>> asStepFunction() {
            return (Tuple4<T1, T2, T3, T4> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3));
        }
    }

    interface FN49<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4> extends FN40<Tuple9<R1, R2, R3, R4, R5, R6, R7, R8, R9>, T1, T2, T3, T4> {
        default TF<Tuple9<R1, R2, R3, R4, R5, R6, R7, R8, R9>, Tuple4<T1, T2, T3, T4>> asStepFunction() {
            return (Tuple4<T1, T2, T3, T4> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3));
        }
    }

    interface FN50<R1, T1, T2, T3, T4, T5> {
        R1 apply(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5);
    }

    interface FN51<R1, T1, T2, T3, T4, T5> extends FN50<Tuple1<R1>, T1, T2, T3, T4, T5> {
        default TF<Tuple1<R1>, Tuple5<T1, T2, T3, T4, T5>> asStepFunction() {
            return (Tuple5<T1, T2, T3, T4, T5> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4));
        }
    }

    interface FN52<R1, R2, T1, T2, T3, T4, T5> extends FN50<Tuple2<R1, R2>, T1, T2, T3, T4, T5> {
        default TF<Tuple2<R1, R2>, Tuple5<T1, T2, T3, T4, T5>> asStepFunction() {
            return (Tuple5<T1, T2, T3, T4, T5> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4));
        }
    }

    interface FN53<R1, R2, R3, T1, T2, T3, T4, T5> extends FN50<Tuple3<R1, R2, R3>, T1, T2, T3, T4, T5> {
        default TF<Tuple3<R1, R2, R3>, Tuple5<T1, T2, T3, T4, T5>> asStepFunction() {
            return (Tuple5<T1, T2, T3, T4, T5> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4));
        }
    }

    interface FN54<R1, R2, R3, R4, T1, T2, T3, T4, T5> extends FN50<Tuple4<R1, R2, R3, R4>, T1, T2, T3, T4, T5> {
        default TF<Tuple4<R1, R2, R3, R4>, Tuple5<T1, T2, T3, T4, T5>> asStepFunction() {
            return (Tuple5<T1, T2, T3, T4, T5> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4));
        }
    }

    interface FN55<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5> extends FN50<Tuple5<R1, R2, R3, R4, R5>, T1, T2, T3, T4, T5> {
        default TF<Tuple5<R1, R2, R3, R4, R5>, Tuple5<T1, T2, T3, T4, T5>> asStepFunction() {
            return (Tuple5<T1, T2, T3, T4, T5> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4));
        }
    }

    interface FN56<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5> extends FN50<Tuple6<R1, R2, R3, R4, R5, R6>, T1, T2, T3, T4, T5> {
        default TF<Tuple6<R1, R2, R3, R4, R5, R6>, Tuple5<T1, T2, T3, T4, T5>> asStepFunction() {
            return (Tuple5<T1, T2, T3, T4, T5> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4));
        }
    }

    interface FN57<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5> extends FN50<Tuple7<R1, R2, R3, R4, R5, R6, R7>, T1, T2, T3, T4, T5> {
        default TF<Tuple7<R1, R2, R3, R4, R5, R6, R7>, Tuple5<T1, T2, T3, T4, T5>> asStepFunction() {
            return (Tuple5<T1, T2, T3, T4, T5> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4));
        }
    }

    interface FN58<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5> extends FN50<Tuple8<R1, R2, R3, R4, R5, R6, R7, R8>, T1, T2, T3, T4, T5> {
        default TF<Tuple8<R1, R2, R3, R4, R5, R6, R7, R8>, Tuple5<T1, T2, T3, T4, T5>> asStepFunction() {
            return (Tuple5<T1, T2, T3, T4, T5> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4));
        }
    }

    interface FN59<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5> extends FN50<Tuple9<R1, R2, R3, R4, R5, R6, R7, R8, R9>, T1, T2, T3, T4, T5> {
        default TF<Tuple9<R1, R2, R3, R4, R5, R6, R7, R8, R9>, Tuple5<T1, T2, T3, T4, T5>> asStepFunction() {
            return (Tuple5<T1, T2, T3, T4, T5> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4));
        }
    }

    interface FN60<R1, T1, T2, T3, T4, T5, T6> {
        R1 apply(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5, T6 param6);
    }

    interface FN61<R1, T1, T2, T3, T4, T5, T6> extends FN60<Tuple1<R1>, T1, T2, T3, T4, T5, T6> {
        default TF<Tuple1<R1>, Tuple6<T1, T2, T3, T4, T5, T6>> asStepFunction() {
            return (Tuple6<T1, T2, T3, T4, T5, T6> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5));
        }
    }

    interface FN62<R1, R2, T1, T2, T3, T4, T5, T6> extends FN60<Tuple2<R1, R2>, T1, T2, T3, T4, T5, T6> {
        default TF<Tuple2<R1, R2>, Tuple6<T1, T2, T3, T4, T5, T6>> asStepFunction() {
            return (Tuple6<T1, T2, T3, T4, T5, T6> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5));
        }
    }

    interface FN63<R1, R2, R3, T1, T2, T3, T4, T5, T6> extends FN60<Tuple3<R1, R2, R3>, T1, T2, T3, T4, T5, T6> {
        default TF<Tuple3<R1, R2, R3>, Tuple6<T1, T2, T3, T4, T5, T6>> asStepFunction() {
            return (Tuple6<T1, T2, T3, T4, T5, T6> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5));
        }
    }

    interface FN64<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6> extends FN60<Tuple4<R1, R2, R3, R4>, T1, T2, T3, T4, T5, T6> {
        default TF<Tuple4<R1, R2, R3, R4>, Tuple6<T1, T2, T3, T4, T5, T6>> asStepFunction() {
            return (Tuple6<T1, T2, T3, T4, T5, T6> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5));
        }
    }

    interface FN65<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6> extends FN60<Tuple5<R1, R2, R3, R4, R5>, T1, T2, T3, T4, T5, T6> {
        default TF<Tuple5<R1, R2, R3, R4, R5>, Tuple6<T1, T2, T3, T4, T5, T6>> asStepFunction() {
            return (Tuple6<T1, T2, T3, T4, T5, T6> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5));
        }
    }

    interface FN66<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6> extends FN60<Tuple6<R1, R2, R3, R4, R5, R6>, T1, T2, T3, T4, T5, T6> {
        default TF<Tuple6<R1, R2, R3, R4, R5, R6>, Tuple6<T1, T2, T3, T4, T5, T6>> asStepFunction() {
            return (Tuple6<T1, T2, T3, T4, T5, T6> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5));
        }
    }

    interface FN67<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6> extends FN60<Tuple7<R1, R2, R3, R4, R5, R6, R7>, T1, T2, T3, T4, T5, T6> {
        default TF<Tuple7<R1, R2, R3, R4, R5, R6, R7>, Tuple6<T1, T2, T3, T4, T5, T6>> asStepFunction() {
            return (Tuple6<T1, T2, T3, T4, T5, T6> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5));
        }
    }

    interface FN68<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5, T6> extends FN60<Tuple8<R1, R2, R3, R4, R5, R6, R7, R8>, T1, T2, T3, T4, T5, T6> {
        default TF<Tuple8<R1, R2, R3, R4, R5, R6, R7, R8>, Tuple6<T1, T2, T3, T4, T5, T6>> asStepFunction() {
            return (Tuple6<T1, T2, T3, T4, T5, T6> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5));
        }
    }

    interface FN69<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5, T6> extends FN60<Tuple9<R1, R2, R3, R4, R5, R6, R7, R8, R9>, T1, T2, T3, T4, T5, T6> {
        default TF<Tuple9<R1, R2, R3, R4, R5, R6, R7, R8, R9>, Tuple6<T1, T2, T3, T4, T5, T6>> asStepFunction() {
            return (Tuple6<T1, T2, T3, T4, T5, T6> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5));
        }
    }

    interface FN70<R1, T1, T2, T3, T4, T5, T6, T7> {
        R1 apply(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5, T6 param6, T7 param7);
    }

    interface FN71<R1, T1, T2, T3, T4, T5, T6, T7> extends FN70<Tuple1<R1>, T1, T2, T3, T4, T5, T6, T7> {
        default TF<Tuple1<R1>, Tuple7<T1, T2, T3, T4, T5, T6, T7>> asStepFunction() {
            return (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6));
        }
    }

    interface FN72<R1, R2, T1, T2, T3, T4, T5, T6, T7> extends FN70<Tuple2<R1, R2>, T1, T2, T3, T4, T5, T6, T7> {
        default TF<Tuple2<R1, R2>, Tuple7<T1, T2, T3, T4, T5, T6, T7>> asStepFunction() {
            return (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6));
        }
    }

    interface FN73<R1, R2, R3, T1, T2, T3, T4, T5, T6, T7> extends FN70<Tuple3<R1, R2, R3>, T1, T2, T3, T4, T5, T6, T7> {
        default TF<Tuple3<R1, R2, R3>, Tuple7<T1, T2, T3, T4, T5, T6, T7>> asStepFunction() {
            return (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6));
        }
    }

    interface FN74<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6, T7> extends FN70<Tuple4<R1, R2, R3, R4>, T1, T2, T3, T4, T5, T6, T7> {
        default TF<Tuple4<R1, R2, R3, R4>, Tuple7<T1, T2, T3, T4, T5, T6, T7>> asStepFunction() {
            return (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6));
        }
    }

    interface FN75<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6, T7> extends FN70<Tuple5<R1, R2, R3, R4, R5>, T1, T2, T3, T4, T5, T6, T7> {
        default TF<Tuple5<R1, R2, R3, R4, R5>, Tuple7<T1, T2, T3, T4, T5, T6, T7>> asStepFunction() {
            return (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6));
        }
    }

    interface FN76<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6, T7> extends FN70<Tuple6<R1, R2, R3, R4, R5, R6>, T1, T2, T3, T4, T5, T6, T7> {
        default TF<Tuple6<R1, R2, R3, R4, R5, R6>, Tuple7<T1, T2, T3, T4, T5, T6, T7>> asStepFunction() {
            return (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6));
        }
    }

    interface FN77<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6, T7> extends FN70<Tuple7<R1, R2, R3, R4, R5, R6, R7>, T1, T2, T3, T4, T5, T6, T7> {
        default TF<Tuple7<R1, R2, R3, R4, R5, R6, R7>, Tuple7<T1, T2, T3, T4, T5, T6, T7>> asStepFunction() {
            return (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6));
        }
    }

    interface FN78<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5, T6, T7> extends FN70<Tuple8<R1, R2, R3, R4, R5, R6, R7, R8>, T1, T2, T3, T4, T5, T6, T7> {
        default TF<Tuple8<R1, R2, R3, R4, R5, R6, R7, R8>, Tuple7<T1, T2, T3, T4, T5, T6, T7>> asStepFunction() {
            return (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6));
        }
    }

    interface FN79<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5, T6, T7> extends FN70<Tuple9<R1, R2, R3, R4, R5, R6, R7, R8, R9>, T1, T2, T3, T4, T5, T6, T7> {
        default TF<Tuple9<R1, R2, R3, R4, R5, R6, R7, R8, R9>, Tuple7<T1, T2, T3, T4, T5, T6, T7>> asStepFunction() {
            return (Tuple7<T1, T2, T3, T4, T5, T6, T7> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6));
        }
    }

    interface FN80<R1, T1, T2, T3, T4, T5, T6, T7, T8> {
        R1 apply(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5, T6 param6, T7 param7, T8 param8);
    }

    interface FN81<R1, T1, T2, T3, T4, T5, T6, T7, T8> extends FN80<Tuple1<R1>, T1, T2, T3, T4, T5, T6, T7, T8> {
        default TF<Tuple1<R1>, Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>> asStepFunction() {
            return (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7));
        }
    }

    interface FN82<R1, R2, T1, T2, T3, T4, T5, T6, T7, T8> extends FN80<Tuple2<R1, R2>, T1, T2, T3, T4, T5, T6, T7, T8> {
        default TF<Tuple2<R1, R2>, Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>> asStepFunction() {
            return (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7));
        }
    }

    interface FN83<R1, R2, R3, T1, T2, T3, T4, T5, T6, T7, T8> extends FN80<Tuple3<R1, R2, R3>, T1, T2, T3, T4, T5, T6, T7, T8> {
        default TF<Tuple3<R1, R2, R3>, Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>> asStepFunction() {
            return (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7));
        }
    }

    interface FN84<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6, T7, T8> extends FN80<Tuple4<R1, R2, R3, R4>, T1, T2, T3, T4, T5, T6, T7, T8> {
        default TF<Tuple4<R1, R2, R3, R4>, Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>> asStepFunction() {
            return (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7));
        }
    }

    interface FN85<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6, T7, T8> extends FN80<Tuple5<R1, R2, R3, R4, R5>, T1, T2, T3, T4, T5, T6, T7, T8> {
        default TF<Tuple5<R1, R2, R3, R4, R5>, Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>> asStepFunction() {
            return (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7));
        }
    }

    interface FN86<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6, T7, T8> extends FN80<Tuple6<R1, R2, R3, R4, R5, R6>, T1, T2, T3, T4, T5, T6, T7, T8> {
        default TF<Tuple6<R1, R2, R3, R4, R5, R6>, Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>> asStepFunction() {
            return (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7));
        }
    }

    interface FN87<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6, T7, T8> extends FN80<Tuple7<R1, R2, R3, R4, R5, R6, R7>, T1, T2, T3, T4, T5, T6, T7, T8> {
        default TF<Tuple7<R1, R2, R3, R4, R5, R6, R7>, Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>> asStepFunction() {
            return (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7));
        }
    }

    interface FN88<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5, T6, T7, T8> extends FN80<Tuple8<R1, R2, R3, R4, R5, R6, R7, R8>, T1, T2, T3, T4, T5, T6, T7, T8> {
        default TF<Tuple8<R1, R2, R3, R4, R5, R6, R7, R8>, Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>> asStepFunction() {
            return (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7));
        }
    }

    interface FN89<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5, T6, T7, T8> extends FN80<Tuple9<R1, R2, R3, R4, R5, R6, R7, R8, R9>, T1, T2, T3, T4, T5, T6, T7, T8> {
        default TF<Tuple9<R1, R2, R3, R4, R5, R6, R7, R8, R9>, Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>> asStepFunction() {
            return (Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7));
        }
    }

    interface FN90<R1, T1, T2, T3, T4, T5, T6, T7, T8, T9> {
        R1 apply(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5, T6 param6, T7 param7, T8 param8, T9 param9);
    }

    interface FN91<R1, T1, T2, T3, T4, T5, T6, T7, T8, T9> extends FN90<Tuple1<R1>, T1, T2, T3, T4, T5, T6, T7, T8, T9> {
        default TF<Tuple1<R1>, Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>> asStepFunction() {
            return (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8));
        }
    }

    interface FN92<R1, R2, T1, T2, T3, T4, T5, T6, T7, T8, T9> extends FN90<Tuple2<R1, R2>, T1, T2, T3, T4, T5, T6, T7, T8, T9> {
        default TF<Tuple2<R1, R2>, Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>> asStepFunction() {
            return (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8));
        }
    }

    interface FN93<R1, R2, R3, T1, T2, T3, T4, T5, T6, T7, T8, T9> extends FN90<Tuple3<R1, R2, R3>, T1, T2, T3, T4, T5, T6, T7, T8, T9> {
        default TF<Tuple3<R1, R2, R3>, Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>> asStepFunction() {
            return (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8));
        }
    }

    interface FN94<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6, T7, T8, T9> extends FN90<Tuple4<R1, R2, R3, R4>, T1, T2, T3, T4, T5, T6, T7, T8, T9> {
        default TF<Tuple4<R1, R2, R3, R4>, Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>> asStepFunction() {
            return (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8));
        }
    }

    interface FN95<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6, T7, T8, T9> extends FN90<Tuple5<R1, R2, R3, R4, R5>, T1, T2, T3, T4, T5, T6, T7, T8, T9> {
        default TF<Tuple5<R1, R2, R3, R4, R5>, Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>> asStepFunction() {
            return (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8));
        }
    }

    interface FN96<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6, T7, T8, T9> extends FN90<Tuple6<R1, R2, R3, R4, R5, R6>, T1, T2, T3, T4, T5, T6, T7, T8, T9> {
        default TF<Tuple6<R1, R2, R3, R4, R5, R6>, Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>> asStepFunction() {
            return (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8));
        }
    }

    interface FN97<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6, T7, T8, T9> extends FN90<Tuple7<R1, R2, R3, R4, R5, R6, R7>, T1, T2, T3, T4, T5, T6, T7, T8, T9> {
        default TF<Tuple7<R1, R2, R3, R4, R5, R6, R7>, Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>> asStepFunction() {
            return (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8));
        }
    }

    interface FN98<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5, T6, T7, T8, T9> extends FN90<Tuple8<R1, R2, R3, R4, R5, R6, R7, R8>, T1, T2, T3, T4, T5, T6, T7, T8, T9> {
        default TF<Tuple8<R1, R2, R3, R4, R5, R6, R7, R8>, Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>> asStepFunction() {
            return (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8));
        }
    }

    interface FN99<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5, T6, T7, T8, T9> extends FN90<Tuple9<R1, R2, R3, R4, R5, R6, R7, R8, R9>, T1, T2, T3, T4, T5, T6, T7, T8, T9> {
        default TF<Tuple9<R1, R2, R3, R4, R5, R6, R7, R8, R9>, Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>> asStepFunction() {
            return (Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> param) -> apply((T1) param.get(0), (T2) param.get(1), (T3) param.get(2), (T4) param.get(3), (T5) param.get(4), (T6) param.get(5), (T7) param.get(6), (T8) param.get(7), (T9) param.get(8));
        }
    }
}
