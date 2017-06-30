package org.rxbooter.flow;

import java.util.function.Supplier;

import org.rxbooter.flow.impl.CurrentThreadReactor;
import org.rxbooter.flow.impl.ThreadPoolReactor;
import org.rxbooter.flow.impl.FlowExecutor;
import org.rxbooter.flow.Step.EH;
import org.rxbooter.flow.impl.Promise;
import org.rxbooter.flow.impl.SingleThreadReactor;
import org.rxbooter.flow.impl.ThreadPool;

import static org.rxbooter.flow.Tuples.*;

public interface Reactor {
    void shutdown();

    <O extends Tuple, I extends Tuple> O await(FlowExecutor<O, I> flowExecutor);
    <O extends Tuple, I extends Tuple> void async(FlowExecutor<O, I> flowExecutor);

    void async(Runnable runnable);
    <T> T await(Supplier<T> supplier);

    void async(Runnable runnable, EH<Tuple1<Void>> handler);

    <T> T await(Supplier<T> function, EH<Tuple1<T>> handler);

    <T> T awaitAny(Supplier<T>... suppliers);

    <O extends Tuple, I extends Tuple> Promise<O> submit(FlowExecutor<O, I> flowExecutor);

    static Reactor single() {
        return new SingleThreadReactor();
    }

    static Reactor thisThread() {
        return CurrentThreadReactor.instance();
    }

    static Reactor pooled() {
        return ThreadPoolReactor.defaultReactor();
    }

    static Reactor pooled(ThreadPool computingPool, ThreadPool ioPool) {
        return ThreadPoolReactor.with(computingPool, ioPool);
    }

    default <T1> Tuple1<T1> awaitAll(Supplier<T1> param1) {
        return Tuples.of(await(param1));
    }

    default <T1, T2> Tuple2<T1, T2> awaitAll(Supplier<T1> param1, Supplier<T2> param2) {
        return Tuples.of(await(param1), await(param2));
    }

    default <T1, T2, T3> Tuple3<T1, T2, T3> awaitAll(Supplier<T1> param1, Supplier<T2> param2, Supplier<T3> param3) {
        return Tuples.of(await(param1), await(param2), await(param3));
    }

    default <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4> awaitAll(Supplier<T1> param1, Supplier<T2> param2, Supplier<T3> param3, Supplier<T4> param4) {
        return Tuples.of(await(param1), await(param2), await(param3), await(param4));
    }

    default <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5> awaitAll(Supplier<T1> param1, Supplier<T2> param2, Supplier<T3> param3, Supplier<T4> param4, Supplier<T5> param5) {
        return Tuples.of(await(param1), await(param2), await(param3), await(param4), await(param5));
    }

    default <T1, T2, T3, T4, T5, T6> Tuple6<T1, T2, T3, T4, T5, T6> awaitAll(Supplier<T1> param1, Supplier<T2> param2, Supplier<T3> param3, Supplier<T4> param4, Supplier<T5> param5, Supplier<T6> param6) {
        return Tuples.of(await(param1), await(param2), await(param3), await(param4), await(param5), await(param6));
    }

    default <T1, T2, T3, T4, T5, T6, T7> Tuple7<T1, T2, T3, T4, T5, T6, T7> awaitAll(Supplier<T1> param1, Supplier<T2> param2, Supplier<T3> param3, Supplier<T4> param4, Supplier<T5> param5, Supplier<T6> param6, Supplier<T7> param7) {
        return Tuples.of(await(param1), await(param2), await(param3), await(param4), await(param5), await(param6), await(param7));
    }

    default <T1, T2, T3, T4, T5, T6, T7, T8> Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> awaitAll(Supplier<T1> param1, Supplier<T2> param2, Supplier<T3> param3, Supplier<T4> param4, Supplier<T5> param5, Supplier<T6> param6, Supplier<T7> param7, Supplier<T8> param8) {
        return Tuples.of(await(param1), await(param2), await(param3), await(param4), await(param5), await(param6), await(param7), await(param8));
    }

    default <T1, T2, T3, T4, T5, T6, T7, T8, T9> Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> awaitAll(Supplier<T1> param1, Supplier<T2> param2, Supplier<T3> param3, Supplier<T4> param4, Supplier<T5> param5, Supplier<T6> param6, Supplier<T7> param7, Supplier<T8> param8, Supplier<T9> param9) {
        return Tuples.of(await(param1), await(param2), await(param3), await(param4), await(param5), await(param6), await(param7), await(param8), await(param9));
    }
}
