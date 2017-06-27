package org.rxbooter.flow.flux;

import static org.rxbooter.flow.flux.Tuples.*;

public interface Functions {
    public interface FN10<R1, T1> {
        R1 apply(T1 param1);
    }

    public interface FN11<R1, T1> extends FN10<Tuple1<R1>, T1> {}
    public interface FN12<R1, R2, T1> extends FN10<Tuple2<R1, R2>, T1> {}
    public interface FN13<R1, R2, R3, T1> extends FN10<Tuple3<R1, R2, R3>, T1> {}
    public interface FN14<R1, R2, R3, R4, T1> extends FN10<Tuple4<R1, R2, R3, R4>, T1> {}
    public interface FN15<R1, R2, R3, R4, R5, T1> extends FN10<Tuple5<R1, R2, R3, R4, R5>, T1> {}
    public interface FN16<R1, R2, R3, R4, R5, R6, T1> extends FN10<Tuple6<R1, R2, R3, R4, R5, R6>, T1> {}
    public interface FN17<R1, R2, R3, R4, R5, R6, R7, T1> extends FN10<Tuple7<R1, R2, R3, R4, R5, R6, R7>, T1> {}
    public interface FN18<R1, R2, R3, R4, R5, R6, R7, R8, T1> extends FN10<Tuple8<R1, R2, R3, R4, R5, R6, R7, R8>, T1> {}
    public interface FN19<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1> extends FN10<Tuple9<R1, R2, R3, R4, R5, R6, R7, R8, R9>, T1> {}

    public interface FN20<R1, T1, T2> {
        R1 apply(T1 param1, T2 param2);
    }

    public interface FN21<R1, T1, T2> extends FN20<Tuple1<R1>, T1, T2> {}
    public interface FN22<R1, R2, T1, T2> extends FN20<Tuple2<R1, R2>, T1, T2> {}
    public interface FN23<R1, R2, R3, T1, T2> extends FN20<Tuple3<R1, R2, R3>, T1, T2> {}
    public interface FN24<R1, R2, R3, R4, T1, T2> extends FN20<Tuple4<R1, R2, R3, R4>, T1, T2> {}
    public interface FN25<R1, R2, R3, R4, R5, T1, T2> extends FN20<Tuple5<R1, R2, R3, R4, R5>, T1, T2> {}
    public interface FN26<R1, R2, R3, R4, R5, R6, T1, T2> extends FN20<Tuple6<R1, R2, R3, R4, R5, R6>, T1, T2> {}
    public interface FN27<R1, R2, R3, R4, R5, R6, R7, T1, T2> extends FN20<Tuple7<R1, R2, R3, R4, R5, R6, R7>, T1, T2> {}
    public interface FN28<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2> extends FN20<Tuple8<R1, R2, R3, R4, R5, R6, R7, R8>, T1, T2> {}
    public interface FN29<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2> extends FN20<Tuple9<R1, R2, R3, R4, R5, R6, R7, R8, R9>, T1, T2> {}

    public interface FN30<R1, T1, T2, T3> {
        R1 apply(T1 param1, T2 param2, T3 param3);
    }

    public interface FN31<R1, T1, T2, T3> extends FN30<Tuple1<R1>, T1, T2, T3> {}
    public interface FN32<R1, R2, T1, T2, T3> extends FN30<Tuple2<R1, R2>, T1, T2, T3> {}
    public interface FN33<R1, R2, R3, T1, T2, T3> extends FN30<Tuple3<R1, R2, R3>, T1, T2, T3> {}
    public interface FN34<R1, R2, R3, R4, T1, T2, T3> extends FN30<Tuple4<R1, R2, R3, R4>, T1, T2, T3> {}
    public interface FN35<R1, R2, R3, R4, R5, T1, T2, T3> extends FN30<Tuple5<R1, R2, R3, R4, R5>, T1, T2, T3> {}
    public interface FN36<R1, R2, R3, R4, R5, R6, T1, T2, T3> extends FN30<Tuple6<R1, R2, R3, R4, R5, R6>, T1, T2, T3> {}
    public interface FN37<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3> extends FN30<Tuple7<R1, R2, R3, R4, R5, R6, R7>, T1, T2, T3> {}
    public interface FN38<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3> extends FN30<Tuple8<R1, R2, R3, R4, R5, R6, R7, R8>, T1, T2, T3> {}
    public interface FN39<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3> extends FN30<Tuple9<R1, R2, R3, R4, R5, R6, R7, R8, R9>, T1, T2, T3> {}

    public interface FN40<R1, T1, T2, T3, T4> {
        R1 apply(T1 param1, T2 param2, T3 param3, T4 param4);
    }

    public interface FN41<R1, T1, T2, T3, T4> extends FN40<Tuple1<R1>, T1, T2, T3, T4> {}
    public interface FN42<R1, R2, T1, T2, T3, T4> extends FN40<Tuple2<R1, R2>, T1, T2, T3, T4> {}
    public interface FN43<R1, R2, R3, T1, T2, T3, T4> extends FN40<Tuple3<R1, R2, R3>, T1, T2, T3, T4> {}
    public interface FN44<R1, R2, R3, R4, T1, T2, T3, T4> extends FN40<Tuple4<R1, R2, R3, R4>, T1, T2, T3, T4> {}
    public interface FN45<R1, R2, R3, R4, R5, T1, T2, T3, T4> extends FN40<Tuple5<R1, R2, R3, R4, R5>, T1, T2, T3, T4> {}
    public interface FN46<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4> extends FN40<Tuple6<R1, R2, R3, R4, R5, R6>, T1, T2, T3, T4> {}
    public interface FN47<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4> extends FN40<Tuple7<R1, R2, R3, R4, R5, R6, R7>, T1, T2, T3, T4> {}
    public interface FN48<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4> extends FN40<Tuple8<R1, R2, R3, R4, R5, R6, R7, R8>, T1, T2, T3, T4> {}
    public interface FN49<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4> extends FN40<Tuple9<R1, R2, R3, R4, R5, R6, R7, R8, R9>, T1, T2, T3, T4> {}

    public interface FN50<R1, T1, T2, T3, T4, T5> {
        R1 apply(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5);
    }

    public interface FN51<R1, T1, T2, T3, T4, T5> extends FN50<Tuple1<R1>, T1, T2, T3, T4, T5> {}
    public interface FN52<R1, R2, T1, T2, T3, T4, T5> extends FN50<Tuple2<R1, R2>, T1, T2, T3, T4, T5> {}
    public interface FN53<R1, R2, R3, T1, T2, T3, T4, T5> extends FN50<Tuple3<R1, R2, R3>, T1, T2, T3, T4, T5> {}
    public interface FN54<R1, R2, R3, R4, T1, T2, T3, T4, T5> extends FN50<Tuple4<R1, R2, R3, R4>, T1, T2, T3, T4, T5> {}
    public interface FN55<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5> extends FN50<Tuple5<R1, R2, R3, R4, R5>, T1, T2, T3, T4, T5> {}
    public interface FN56<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5> extends FN50<Tuple6<R1, R2, R3, R4, R5, R6>, T1, T2, T3, T4, T5> {}
    public interface FN57<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5> extends FN50<Tuple7<R1, R2, R3, R4, R5, R6, R7>, T1, T2, T3, T4, T5> {}
    public interface FN58<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5> extends FN50<Tuple8<R1, R2, R3, R4, R5, R6, R7, R8>, T1, T2, T3, T4, T5> {}
    public interface FN59<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5> extends FN50<Tuple9<R1, R2, R3, R4, R5, R6, R7, R8, R9>, T1, T2, T3, T4, T5> {}

    public interface FN60<R1, T1, T2, T3, T4, T5, T6> {
        R1 apply(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5, T6 param6);
    }

    public interface FN61<R1, T1, T2, T3, T4, T5, T6> extends FN60<Tuple1<R1>, T1, T2, T3, T4, T5, T6> {}
    public interface FN62<R1, R2, T1, T2, T3, T4, T5, T6> extends FN60<Tuple2<R1, R2>, T1, T2, T3, T4, T5, T6> {}
    public interface FN63<R1, R2, R3, T1, T2, T3, T4, T5, T6> extends FN60<Tuple3<R1, R2, R3>, T1, T2, T3, T4, T5, T6> {}
    public interface FN64<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6> extends FN60<Tuple4<R1, R2, R3, R4>, T1, T2, T3, T4, T5, T6> {}
    public interface FN65<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6> extends FN60<Tuple5<R1, R2, R3, R4, R5>, T1, T2, T3, T4, T5, T6> {}
    public interface FN66<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6> extends FN60<Tuple6<R1, R2, R3, R4, R5, R6>, T1, T2, T3, T4, T5, T6> {}
    public interface FN67<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6> extends FN60<Tuple7<R1, R2, R3, R4, R5, R6, R7>, T1, T2, T3, T4, T5, T6> {}
    public interface FN68<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5, T6> extends FN60<Tuple8<R1, R2, R3, R4, R5, R6, R7, R8>, T1, T2, T3, T4, T5, T6> {}
    public interface FN69<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5, T6> extends FN60<Tuple9<R1, R2, R3, R4, R5, R6, R7, R8, R9>, T1, T2, T3, T4, T5, T6> {}

    public interface FN70<R1, T1, T2, T3, T4, T5, T6, T7> {
        R1 apply(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5, T6 param6, T7 param7);
    }

    public interface FN71<R1, T1, T2, T3, T4, T5, T6, T7> extends FN70<Tuple1<R1>, T1, T2, T3, T4, T5, T6, T7> {}
    public interface FN72<R1, R2, T1, T2, T3, T4, T5, T6, T7> extends FN70<Tuple2<R1, R2>, T1, T2, T3, T4, T5, T6, T7> {}
    public interface FN73<R1, R2, R3, T1, T2, T3, T4, T5, T6, T7> extends FN70<Tuple3<R1, R2, R3>, T1, T2, T3, T4, T5, T6, T7> {}
    public interface FN74<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6, T7> extends FN70<Tuple4<R1, R2, R3, R4>, T1, T2, T3, T4, T5, T6, T7> {}
    public interface FN75<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6, T7> extends FN70<Tuple5<R1, R2, R3, R4, R5>, T1, T2, T3, T4, T5, T6, T7> {}
    public interface FN76<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6, T7> extends FN70<Tuple6<R1, R2, R3, R4, R5, R6>, T1, T2, T3, T4, T5, T6, T7> {}
    public interface FN77<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6, T7> extends FN70<Tuple7<R1, R2, R3, R4, R5, R6, R7>, T1, T2, T3, T4, T5, T6, T7> {}
    public interface FN78<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5, T6, T7> extends FN70<Tuple8<R1, R2, R3, R4, R5, R6, R7, R8>, T1, T2, T3, T4, T5, T6, T7> {}
    public interface FN79<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5, T6, T7> extends FN70<Tuple9<R1, R2, R3, R4, R5, R6, R7, R8, R9>, T1, T2, T3, T4, T5, T6, T7> {}

    public interface FN80<R1, T1, T2, T3, T4, T5, T6, T7, T8> {
        R1 apply(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5, T6 param6, T7 param7, T8 param8);
    }

    public interface FN81<R1, T1, T2, T3, T4, T5, T6, T7, T8> extends FN80<Tuple1<R1>, T1, T2, T3, T4, T5, T6, T7, T8> {}
    public interface FN82<R1, R2, T1, T2, T3, T4, T5, T6, T7, T8> extends FN80<Tuple2<R1, R2>, T1, T2, T3, T4, T5, T6, T7, T8> {}
    public interface FN83<R1, R2, R3, T1, T2, T3, T4, T5, T6, T7, T8> extends FN80<Tuple3<R1, R2, R3>, T1, T2, T3, T4, T5, T6, T7, T8> {}
    public interface FN84<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6, T7, T8> extends FN80<Tuple4<R1, R2, R3, R4>, T1, T2, T3, T4, T5, T6, T7, T8> {}
    public interface FN85<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6, T7, T8> extends FN80<Tuple5<R1, R2, R3, R4, R5>, T1, T2, T3, T4, T5, T6, T7, T8> {}
    public interface FN86<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6, T7, T8> extends FN80<Tuple6<R1, R2, R3, R4, R5, R6>, T1, T2, T3, T4, T5, T6, T7, T8> {}
    public interface FN87<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6, T7, T8> extends FN80<Tuple7<R1, R2, R3, R4, R5, R6, R7>, T1, T2, T3, T4, T5, T6, T7, T8> {}
    public interface FN88<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5, T6, T7, T8> extends FN80<Tuple8<R1, R2, R3, R4, R5, R6, R7, R8>, T1, T2, T3, T4, T5, T6, T7, T8> {}
    public interface FN89<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5, T6, T7, T8> extends FN80<Tuple9<R1, R2, R3, R4, R5, R6, R7, R8, R9>, T1, T2, T3, T4, T5, T6, T7, T8> {}

    public interface FN90<R1, T1, T2, T3, T4, T5, T6, T7, T8, T9> {
        R1 apply(T1 param1, T2 param2, T3 param3, T4 param4, T5 param5, T6 param6, T7 param7, T8 param8, T9 param9);
    }

    public interface FN91<R1, T1, T2, T3, T4, T5, T6, T7, T8, T9> extends FN90<Tuple1<R1>, T1, T2, T3, T4, T5, T6, T7, T8, T9> {}
    public interface FN92<R1, R2, T1, T2, T3, T4, T5, T6, T7, T8, T9> extends FN90<Tuple2<R1, R2>, T1, T2, T3, T4, T5, T6, T7, T8, T9> {}
    public interface FN93<R1, R2, R3, T1, T2, T3, T4, T5, T6, T7, T8, T9> extends FN90<Tuple3<R1, R2, R3>, T1, T2, T3, T4, T5, T6, T7, T8, T9> {}
    public interface FN94<R1, R2, R3, R4, T1, T2, T3, T4, T5, T6, T7, T8, T9> extends FN90<Tuple4<R1, R2, R3, R4>, T1, T2, T3, T4, T5, T6, T7, T8, T9> {}
    public interface FN95<R1, R2, R3, R4, R5, T1, T2, T3, T4, T5, T6, T7, T8, T9> extends FN90<Tuple5<R1, R2, R3, R4, R5>, T1, T2, T3, T4, T5, T6, T7, T8, T9> {}
    public interface FN96<R1, R2, R3, R4, R5, R6, T1, T2, T3, T4, T5, T6, T7, T8, T9> extends FN90<Tuple6<R1, R2, R3, R4, R5, R6>, T1, T2, T3, T4, T5, T6, T7, T8, T9> {}
    public interface FN97<R1, R2, R3, R4, R5, R6, R7, T1, T2, T3, T4, T5, T6, T7, T8, T9> extends FN90<Tuple7<R1, R2, R3, R4, R5, R6, R7>, T1, T2, T3, T4, T5, T6, T7, T8, T9> {}
    public interface FN98<R1, R2, R3, R4, R5, R6, R7, R8, T1, T2, T3, T4, T5, T6, T7, T8, T9> extends FN90<Tuple8<R1, R2, R3, R4, R5, R6, R7, R8>, T1, T2, T3, T4, T5, T6, T7, T8, T9> {}
    public interface FN99<R1, R2, R3, R4, R5, R6, R7, R8, R9, T1, T2, T3, T4, T5, T6, T7, T8, T9> extends FN90<Tuple9<R1, R2, R3, R4, R5, R6, R7, R8, R9>, T1, T2, T3, T4, T5, T6, T7, T8, T9> {}
}
