package org.rxbooter.flow;

import static org.rxbooter.flow.Tuples.*;

public interface Functions {
    public interface FN11<R1, T1> {
        Tuple1<R1> apply(T1 param1);
    }

    public interface FN12<R1, R2, T1> {
        Tuple2<R1, R2> apply(T1 param1);
    }

    public interface FN13<R1, R2, R3, T1> {
        Tuple3<R1, R2, R3> apply(T1 param1);
    }

    public interface FN14<R1, R2, R3, R4, T1> {
        Tuple4<R1, R2, R3, R4> apply(T1 param1);
    }

    public interface FN15<R1, R2, R3, R4, R5, T1> {
        Tuple5<R1, R2, R3, R4, R5> apply(T1 param1);
    }

    public interface FN21<R1, T1, T2> {
        Tuple1<R1> apply(T1 param1, T2 param2);
    }

    public interface FN22<R1, R2, T1, T2> {
        Tuple2<R1, R2> apply(T1 param1, T2 param2);
    }

    public interface FN23<R1, R2, R3, T1, T2> {
        Tuple3<R1, R2, R3> apply(T1 param1, T2 param2);
    }

    public interface FN24<R1, R2, R3, R4, T1, T2> {
        Tuple4<R1, R2, R3, R4> apply(T1 param1, T2 param2);
    }

    public interface FN25<R1, R2, R3, R4, R5, T1, T2> {
        Tuple5<R1, R2, R3, R4, R5> apply(T1 param1, T2 param2);
    }

    public interface FN31<R1, T1, T2, T3> {
        Tuple1<R1> apply(T1 param1, T2 param2, T3 param3);
    }

    public interface FN32<R1, R2, T1, T2, T3> {
        Tuple2<R1, R2> apply(T1 param1, T2 param2, T3 param3);
    }

    public interface FN33<R1, R2, R3, T1, T2, T3> {
        Tuple3<R1, R2, R3> apply(T1 param1, T2 param2, T3 param3);
    }

    public interface FN34<R1, R2, R3, R4, T1, T2, T3> {
        Tuple4<R1, R2, R3, R4> apply(T1 param1, T2 param2, T3 param3);
    }

    public interface FN35<R1, R2, R3, R4, R5, T1, T2, T3> {
        Tuple5<R1, R2, R3, R4, R5> apply(T1 param1, T2 param2, T3 param3);
    }

    public interface FN41<R1, T1, T2, T3, T4> {
        Tuple1<R1> apply(T1 param1, T2 param2, T3 param3, T4 param4);
    }

    public interface FN42<R1, R2, T1, T2, T3, T4> {
        Tuple2<R1, R2> apply(T1 param1, T2 param2, T3 param3, T4 param4);
    }

    public interface FN43<R1, R2, R3, T1, T2, T3, T4> {
        Tuple3<R1, R2, R3> apply(T1 param1, T2 param2, T3 param3, T4 param4);
    }

    public interface FN44<R1, R2, R3, R4, T1, T2, T3, T4> {
        Tuple4<R1, R2, R3, R4> apply(T1 param1, T2 param2, T3 param3, T4 param4);
    }

    public interface FN45<R1, R2, R3, R4, R5, T1, T2, T3, T4> {
        Tuple5<R1, R2, R3, R4, R5> apply(T1 param1, T2 param2, T3 param3, T4 param4);
    }

    public interface FN51<R1, T1, T2, T3, T4, T5> {
        Tuple1<R1> apply(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5);
    }

    public interface FN52<R1, R2, T1, T2, T3, T4, T5> {
        Tuple2<R1, R2> apply(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5);
    }

    public interface FN53<R1, R2, R3, T1, T2, T3, T4, T5> {
        Tuple3<R1, R2, R3> apply(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5);
    }

    public interface FN54<R1, R2, R3, R4, T1, T2, T3, T4, T5> {
        Tuple4<R1, R2, R3, R4> apply(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5);
    }

    public interface FN55<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5> {
        Tuple5<R1, R2, R3, R4, R5> apply(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5);
    }
}
