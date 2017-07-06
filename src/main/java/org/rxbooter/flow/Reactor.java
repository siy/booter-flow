package org.rxbooter.flow;

import org.rxbooter.flow.Step.EH;
import org.rxbooter.flow.impl.*;

import java.util.Optional;
import java.util.function.Supplier;

import static org.rxbooter.flow.Tuples.*;

/**
 * Flow execution reactor.
 */
public interface Reactor {
    /**
     * Shutdown reactor instance.
     */
    void shutdown();

    /**
     * Schedule asynchronous execution of task provided as a {@link Runnable}.
     *
     * @param runnable
     *          Task to execute
     */
    default void async(Runnable runnable) {
        submit(Flow.async(Step.from(runnable)).applyTo(null));
    }

    /**
     * Schedule asynchronous execution of task provided as a {@link Runnable}.
     * If task will throw any exception, it will be passed to provided handler.
     *
     * @param runnable
     *          Task to execute
     * @param handler
     *          Error handler
     */
    default void async(Runnable runnable, EH<Tuple1<Void>> handler) {
        submit(Flow.async(Step.from(runnable), handler).applyTo(null));
    }

    /**
     * Submit task for execution and wait for task completion.
     * If task throws any exception, it will be wrapped into {@link FlowException} and then rethrown by this method
     * as if exception was thrown during direct invocation of the provided {@link Supplier}.
     *
     * @param supplier
     *          Task to execute.
     * @return value returned by supplier
     * @throws FlowWrappedException if task threw checked (i.e. subclass of @{@link Exception}) exception and original
     * task exception if task threw unchecked exception (i.e. subclass of @{@link RuntimeException}).
     */
    default <T> T await(Supplier<T> supplier) {
        return submit(Flow.await(Step.from(supplier)).applyTo(null)).await().get();
    }

    /**
     * Submit task for execution and wait for task completion.
     * If task throws any exception, it will passed to provided exception handler.
     * By convention, exception handler may return either some other value or null. If some other value is returned,
     * then exception is ignored and result provided by exception handler is returned as result of execution of provided
     * supplier. If {@code null} is returned by exception handler, then error assumed not handled and exception will
     * be rethrown as if exception was thrown by direct invocation of the provided {@link Supplier}.
     *
     * @param supplier
     *          Task to execute.
     * @return value returned by supplier
     * @throws FlowException if task threw exception
     */
    default <T> T await(Supplier<T> supplier, EH<Tuple1<T>> handler) {
        return submit(Flow.await(Step.from(supplier), handler).applyTo(null)).await().get();
    }

    /**
     * Execute provided suppliers as independent tasks and wait successful completion of any of them or failure
     * completion of all of them.
     * Note that failures (exceptions thrown by suppliers) are ignored by this method.
     *
     * @param suppliers
     *          Suppliers to execute
     * @return @{@link Optional} which holds result of execution - non-null value if at least one call was successful or
     * {@code null} if all of them failed.
     */
    <T> Optional<T> awaitAny(Supplier<T>... suppliers);

    <O extends Tuple, I extends Tuple> Promise<O> submit(FlowExecutor<O, I> flowExecutor);

    static Reactor single() {
        return new SingleThreadReactor();
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
