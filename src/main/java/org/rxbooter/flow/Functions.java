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

    interface FN21<R1, R2, T1> {
        Tuple2<R1, R2> apply(T1 param1);
    }

    interface FN22<R1, R2, T1, T2> {
        Tuple2<R1, R2> apply(T1 param1, T2 param2);
    }

    interface FN23<R1, R2, T1, T2, T3> {
        Tuple2<R1, R2> apply(T1 param1, T2 param2, T3 param3);
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
}
