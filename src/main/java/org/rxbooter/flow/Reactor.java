package org.rxbooter.flow;

import static org.rxbooter.flow.Tuples.*;

import java.util.function.Supplier;

public interface Reactor {
    <T> T await(Supplier<T> supplier);

//    <T1> Tuple1<T1> awaitAll(Supplier<T1> supplier);
//    <T1, T2, T3, T4, T5, T6, T7, T8, T9> Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>
//    awaitAll(
//            Supplier<T1> supplier1,
//            Supplier<T2> supplier1,
//            Supplier<T3> supplier1,
//            Supplier<T4> supplier1,
//            Supplier<T5> supplier1,
//            Supplier<T6> supplier1,
//            Supplier<T7> supplier1,
//            Supplier<T1> supplier1,
//            Supplier<T1> supplier1,
//            Supplier<T1> supplier1,
//    );
}
