package org.rxbooter.flow;

import static org.rxbooter.flow.Tuples.*;

public interface Functions {
    interface FN11<R1, T1> {
        Tuple1<R1> apply(T1 param1);
    }

    interface FN12<R1, T1, T2> {
        Tuple1<R1> apply(T1 param1, T2 param2);
    }

    interface FN13<R1, T1, T2, T3> {
        Tuple1<R1> apply(T1 param1, T2 param2, T3 param3);
    }

    interface FN14<R1, T1, T2, T3, T4> {
        Tuple1<R1> apply(T1 param1, T2 param2, T3 param3, T4 param4);
    }

    interface FN15<R1, T1, T2, T3, T4, T5> {
        Tuple1<R1> apply(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5);
    }

    interface FN16<R1, T1, T2, T3, T4, T5, T6> {
        Tuple1<R1> apply(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5, T6 param6);
    }

    interface FN17<R1, T1, T2, T3, T4, T5, T6, T7> {
        Tuple1<R1> apply(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5, T6 param6, T7 param7);
    }

    interface FN21<R1, R2, T1> {
        Tuple2<R1, R2> apply(T1 param1);
    }

    interface FN22<R1, R2, T1, T2> {
        Tuple2<R1, R2> apply(T1 param1, T2 param2);
    }

    interface FN23<R1, R2, T1, T2, T3> {
        Tuple2<R1, R2> apply(T1 param1, T2 param2, T3 param3);
    }

    interface FN24<R1, R2, T1, T2, T3, T4> {
        Tuple2<R1, R2> apply(T1 param1, T2 param2, T3 param3, T4 param4);
    }

    interface FN25<R1, R2, T1, T2, T3, T4, T5> {
        Tuple2<R1, R2> apply(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5);
    }

    interface FN26<R1, R2, T1, T2, T3, T4, T5, T6> {
        Tuple2<R1, R2> apply(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5, T6 param6);
    }

    interface FN27<R1, R2, T1, T2, T3, T4, T5, T6, T7> {
        Tuple2<R1, R2> apply(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5, T6 param6, T7 param7);
    }

    interface FN31<R1, R2, R3, T1> {
        Tuple3<R1, R2, R3> apply(T1 param1);
    }

    interface FN32<R1, R2, R3, T1, T2> {
        Tuple3<R1, R2, R3> apply(T1 param1, T2 param2);
    }

    interface FN33<R1, R2, R3, T1, T2, T3> {
        Tuple3<R1, R2, R3> apply(T1 param1, T2 param2, T3 param3);
    }

    interface FN34<R1, R2, R3, T1, T2, T3, T4> {
        Tuple3<R1, R2, R3> apply(T1 param1, T2 param2, T3 param3, T4 param4);
    }

    interface FN35<R1, R2, R3, T1, T2, T3, T4, T5> {
        Tuple3<R1, R2, R3> apply(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5);
    }

    interface FN36<R1, R2, R3, T1, T2, T3, T4, T5, T6> {
        Tuple3<R1, R2, R3> apply(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5, T6 param6);
    }

    interface FN37<R1, R2, R3, T1, T2, T3, T4, T5, T6, T7> {
        Tuple3<R1, R2, R3> apply(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5, T6 param6, T7 param7);
    }

    interface FN41<R1, R2, R3, R4, T1> {
        Tuple4<R1, R2, R3, R4> apply(T1 param1);
    }

    interface FN42<R1, R2, R3, R4, T1, T2> {
        Tuple4<R1, R2, R3, R4> apply(T1 param1, T2 param2);
    }

    interface FN43<R1, R2, R3, R4, T1, T2, T3> {
        Tuple4<R1, R2, R3, R4> apply(T1 param1, T2 param2, T3 param3);
    }

    interface FN44<R1, R2, R3, R4, T1, T2, T3, T4> {
        Tuple4<R1, R2, R3, R4> apply(T1 param1, T2 param2, T3 param3, T4 param4);
    }

    interface FN45<R1, R2, R3, R4, T1, T2, T3, T4, T5> {
        Tuple4<R1, R2, R3, R4> apply(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5);
    }

    interface FN46<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6> {
        Tuple4<R1, R2, R3, R4> apply(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5, T6 param6);
    }

    interface FN47<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6, T7> {
        Tuple4<R1, R2, R3, R4> apply(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5, T6 param6, T7 param7);
    }

    interface FN51<R1, R2, R3, R4, R5, T1> {
        Tuple5<R1, R2, R3, R4, R5> apply(T1 param1);
    }

    interface FN52<R1, R2, R3, R4, R5, T1, T2> {
        Tuple5<R1, R2, R3, R4, R5> apply(T1 param1, T2 param2);
    }

    interface FN53<R1, R2, R3, R4, R5, T1, T2, T3> {
        Tuple5<R1, R2, R3, R4, R5> apply(T1 param1, T2 param2, T3 param3);
    }

    interface FN54<R1, R2, R3, R4, R5, T1, T2, T3, T4> {
        Tuple5<R1, R2, R3, R4, R5> apply(T1 param1, T2 param2, T3 param3, T4 param4);
    }

    interface FN55<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5> {
        Tuple5<R1, R2, R3, R4, R5> apply(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5);
    }

    interface FN56<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6> {
        Tuple5<R1, R2, R3, R4, R5> apply(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5, T6 param6);
    }

    interface FN57<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6, T7> {
        Tuple5<R1, R2, R3, R4, R5> apply(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5, T6 param6, T7 param7);
    }

    interface FN61<R1, R2, R3, R4, R5, R6, T1> {
        Tuple6<R1, R2, R3, R4, R5, R6> apply(T1 param1);
    }

    interface FN62<R1, R2, R3, R4, R5, R6, T1, T2> {
        Tuple6<R1, R2, R3, R4, R5, R6> apply(T1 param1, T2 param2);
    }

    interface FN63<R1, R2, R3, R4, R5, R6, T1, T2, T3> {
        Tuple6<R1, R2, R3, R4, R5, R6> apply(T1 param1, T2 param2, T3 param3);
    }

    interface FN64<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4> {
        Tuple6<R1, R2, R3, R4, R5, R6> apply(T1 param1, T2 param2, T3 param3, T4 param4);
    }

    interface FN65<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5> {
        Tuple6<R1, R2, R3, R4, R5, R6> apply(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5);
    }

    interface FN66<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6> {
        Tuple6<R1, R2, R3, R4, R5, R6> apply(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5, T6 param6);
    }

    interface FN67<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6, T7> {
        Tuple6<R1, R2, R3, R4, R5, R6> apply(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5, T6 param6, T7 param7);
    }

    interface FN71<R1, R2, R3, R4, R5, R6, R7, T1> {
        Tuple7<R1, R2, R3, R4, R5, R6, R7> apply(T1 param1);
    }

    interface FN72<R1, R2, R3, R4, R5, R6, R7, T1, T2> {
        Tuple7<R1, R2, R3, R4, R5, R6, R7> apply(T1 param1, T2 param2);
    }

    interface FN73<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3> {
        Tuple7<R1, R2, R3, R4, R5, R6, R7> apply(T1 param1, T2 param2, T3 param3);
    }

    interface FN74<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4> {
        Tuple7<R1, R2, R3, R4, R5, R6, R7> apply(T1 param1, T2 param2, T3 param3, T4 param4);
    }

    interface FN75<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5> {
        Tuple7<R1, R2, R3, R4, R5, R6, R7> apply(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5);
    }

    interface FN76<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6> {
        Tuple7<R1, R2, R3, R4, R5, R6, R7> apply(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5, T6 param6);
    }

    interface FN77<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6, T7> {
        Tuple7<R1, R2, R3, R4, R5, R6, R7> apply(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5, T6 param6, T7 param7);
    }
}
