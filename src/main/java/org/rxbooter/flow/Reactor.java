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

import org.rxbooter.flow.Functions.EH;
import org.rxbooter.flow.Functions.TF;
import org.rxbooter.flow.impl.FlowExecutor;
import org.rxbooter.flow.impl.ThreadPool;
import org.rxbooter.flow.impl.ThreadPoolReactor;

import java.util.Optional;
import java.util.function.Supplier;

import static org.rxbooter.flow.Tuples.*;

/**
 * Flow execution reactor.
 */
public interface Reactor {
    /**
     * Schedule asynchronous execution of task provided as a {@link Runnable}.
     *
     * @param runnable
     *         Task to execute
     */
    default Promise<Tuple1<Void>> async(Runnable runnable) {
        return submit(Flow.of(Step.async(TF.from(runnable)), empty1()).applyTo(null));
    }

    /**
     * Schedule asynchronous execution of task provided as a {@link Runnable}.
     * If task will throw any exception, the exception will be passed to provided handler.
     *
     * @param runnable
     *         Task to execute
     * @param handler
     *         Error handler
     */
    default Promise<Tuple1<Void>> async(Runnable runnable, EH<Tuple1<Void>> handler) {
        return submit(Flow.of(Step.async(TF.from(runnable), handler), empty1()).applyTo(null));
    }

    /**
     * Submit task for execution and wait for task completion. If task throws any exception, it will be wrapped into
     * {@link FlowException} and then rethrown by this method as if exception was thrown during direct invocation of the
     * provided {@link Supplier}.
     *
     * @param supplier
     *         Task to execute.
     *
     * @return value returned by supplier
     *
     * @throws FlowWrappedException
     *         if task threw checked (i.e. subclass of @{@link Exception}) exception and original task exception if task
     *         threw unchecked exception (i.e. subclass of @{@link RuntimeException}).
     */
    default <T> T await(Supplier<T> supplier) {
        return submit(supplier).await().get1();
    }

    /**
     * Submit task for execution and wait for task completion. If task throws any exception, it will passed to provided
     * exception handler. By convention, exception handler may return either some other value or null. If some other
     * value is returned, then exception is ignored and result provided by exception handler is returned as result of
     * execution of provided supplier. If {@code null} is returned by exception handler, then error assumed not handled
     * and exception will be rethrown as if exception was thrown by direct invocation of the provided {@link Supplier}.
     *
     * @param supplier
     *         Task to execute.
     *
     * @return value returned by supplier
     *
     * @throws FlowException
     *         if task threw exception
     */
    default <T> T await(Supplier<T> supplier, EH<Tuple1<T>> handler) {
        return submit(Flow.of(Step.await(TF.from(supplier), handler), empty1()).applyTo(null)).await().get1();
    }

    /**
     * Execute provided suppliers as independent tasks and wait successful completion of any of them or failure
     * completion of all of them. Note that failures (exceptions thrown by suppliers) are ignored by this method.
     *
     * @param suppliers
     *         Suppliers to execute
     *
     * @return @{@link Optional} which holds result of execution - non-null value if at least one call was successful or
     *         {@code null} if all of them failed.
     */
    @SuppressWarnings({"unchecked"})
    <T> Optional<T> awaitAny(Supplier<T>... suppliers);

    /**
     * Submit {@link FlowExecutor} to reactor for execution. Submission is performed asynchronously and result if
     * returned immediately. Notification about execution are performed via returned instance of {@link Promise}
     * associated with the {@link FlowExecutor} instance.
     *
     * @param flowExecutor
     *         {@link FlowExecutor} instance which need to be processed.
     *
     * @return Instance of {@link Promise} associated with submitted {@link FlowExecutor}.
     */
    <O extends Tuple, I extends Tuple> Promise<O> submit(FlowExecutor<O, I> flowExecutor);

    /**
     * Submit task provided as {@link Supplier}.
     *
     * @param supplier
     *         The instance of {@link Supplier} to execute
     *
     * @return Instance of {@link Promise} which receives notifications on provided {@link Supplier} instance execution.
     *         If {@link Supplier} is executed successfully then returned {@link Promise} instance will receive value
     *         returned by supplier. If {@link Supplier} throws an exception, then it is rethrown once {@link
     *         Promise#await()} is invoked.
     */
    default <T> Promise<Tuple1<T>> submit(Supplier<T> supplier) {
        return submit(Flow.of(Step.await(TF.from(supplier)), empty1()).applyTo(null));
    }

    /**
     * Await result of execution of provided supplier. Returned instance of {@link Tuple1} holds value returned by
     * {@link Supplier} if execution of provided supplier was successful. If {@link Supplier} throws an exception then
     * exception is rethrown.
     *
     * @param param1
     *         Instance of {@link Supplier} to execute.
     *
     * @return Instance of {@link Tuple1} with value returned by provided supplier.
     */
    default <T1> Tuple1<T1> awaitAll(Supplier<T1> param1) {
        return Tuples.of(await(param1));
    }

    /**
     * Await results of execution of provided suppliers. Returned instance of {@link Tuple2} holds values returned by
     * provided {@link Supplier}'s if execution of them was successful. If any {@link Supplier} throws an exception then
     * exception is rethrown.
     *
     * @param param1
     *         First {@link Supplier} to execute.
     * @param param2
     *         Second {@link Supplier} to execute.
     *
     * @return Instance of {@link Tuple2} with values returned by provided suppliers.
     */
    default <T1, T2> Tuple2<T1, T2> awaitAll(Supplier<T1> param1, Supplier<T2> param2) {
        Promise<Tuple1<T1>> r1 = submit(param1);
        Promise<Tuple1<T2>> r2 = submit(param2);

        return Tuples.of(r1.await().get1(), r2.await().get1());
    }

    /**
     * Await results of execution of provided suppliers. Returned instance of {@link Tuple3} holds values returned by
     * provided {@link Supplier}'s if execution of them was successful. If any {@link Supplier} throws an exception then
     * exception is rethrown.
     *
     * @param param1
     *         First {@link Supplier} to execute.
     * @param param2
     *         Second {@link Supplier} to execute.
     * @param param3
     *         Third {@link Supplier} to execute.
     *
     * @return Instance of {@link Tuple3} with values returned by provided suppliers.
     */
    default <T1, T2, T3> Tuple3<T1, T2, T3> awaitAll(Supplier<T1> param1, Supplier<T2> param2, Supplier<T3> param3) {
        Promise<Tuple1<T1>> r1 = submit(param1);
        Promise<Tuple1<T2>> r2 = submit(param2);
        Promise<Tuple1<T3>> r3 = submit(param3);

        return Tuples.of(r1.await().get1(), r2.await().get1(), r3.await().get1());
    }

    /**
     * Await results of execution of provided suppliers. Returned instance of {@link Tuple4} holds values returned by
     * provided {@link Supplier}'s if execution of them was successful. If any {@link Supplier} throws an exception then
     * exception is rethrown.
     *
     * @param param1
     *         First {@link Supplier} to execute.
     * @param param2
     *         Second {@link Supplier} to execute.
     * @param param3
     *         Third {@link Supplier} to execute.
     * @param param4
     *         Fourth {@link Supplier} to execute.
     *
     * @return Instance of {@link Tuple4} with values returned by provided suppliers.
     */
    default <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4> awaitAll(Supplier<T1> param1, Supplier<T2> param2,
                                                             Supplier<T3> param3, Supplier<T4> param4) {
        Promise<Tuple1<T1>> r1 = submit(param1);
        Promise<Tuple1<T2>> r2 = submit(param2);
        Promise<Tuple1<T3>> r3 = submit(param3);
        Promise<Tuple1<T4>> r4 = submit(param4);

        return Tuples.of(r1.await().get1(), r2.await().get1(), r3.await().get1(), r4.await().get1());
    }

    /**
     * Await results of execution of provided suppliers. Returned instance of {@link Tuple5} holds values returned by
     * provided {@link Supplier}'s if execution of them was successful. If any {@link Supplier} throws an exception then
     * exception is rethrown.
     *
     * @param param1
     *         First {@link Supplier} to execute.
     * @param param2
     *         Second {@link Supplier} to execute.
     * @param param3
     *         Third {@link Supplier} to execute.
     * @param param4
     *         Fourth {@link Supplier} to execute.
     * @param param5
     *         Fifth {@link Supplier} to execute.
     *
     * @return Instance of {@link Tuple5} with values returned by provided suppliers.
     */
    default <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5> awaitAll(Supplier<T1> param1, Supplier<T2> param2,
                                                                     Supplier<T3> param3, Supplier<T4> param4,
                                                                     Supplier<T5> param5) {
        Promise<Tuple1<T1>> r1 = submit(param1);
        Promise<Tuple1<T2>> r2 = submit(param2);
        Promise<Tuple1<T3>> r3 = submit(param3);
        Promise<Tuple1<T4>> r4 = submit(param4);
        Promise<Tuple1<T5>> r5 = submit(param5);

        return Tuples.of(r1.await().get1(), r2.await().get1(), r3.await().get1(), r4.await().get1(), r5.await().get1());
    }

    /**
     * Await results of execution of provided suppliers. Returned instance of {@link Tuple6} holds values returned by
     * provided {@link Supplier}'s if execution of them was successful. If any {@link Supplier} throws an exception then
     * exception is rethrown.
     *
     * @param param1
     *         First {@link Supplier} to execute.
     * @param param2
     *         Second {@link Supplier} to execute.
     * @param param3
     *         Third {@link Supplier} to execute.
     * @param param4
     *         Fourth {@link Supplier} to execute.
     * @param param5
     *         Fifth {@link Supplier} to execute.
     * @param param6
     *         Sixth {@link Supplier} to execute.
     *
     * @return Instance of {@link Tuple6} with values returned by provided suppliers.
     */
    default <T1, T2, T3, T4, T5, T6> Tuple6<T1, T2, T3, T4, T5, T6> awaitAll(Supplier<T1> param1, Supplier<T2> param2,
                                                                             Supplier<T3> param3, Supplier<T4> param4,
                                                                             Supplier<T5> param5, Supplier<T6> param6) {
        Promise<Tuple1<T1>> r1 = submit(param1);
        Promise<Tuple1<T2>> r2 = submit(param2);
        Promise<Tuple1<T3>> r3 = submit(param3);
        Promise<Tuple1<T4>> r4 = submit(param4);
        Promise<Tuple1<T5>> r5 = submit(param5);
        Promise<Tuple1<T6>> r6 = submit(param6);

        return Tuples.of(r1.await().get1(), r2.await().get1(), r3.await().get1(), r4.await().get1(), r5.await().get1(),
                         r6.await().get1());
    }

    /**
     * Await results of execution of provided suppliers. Returned instance of {@link Tuple7} holds values returned by
     * provided {@link Supplier}'s if execution of them was successful. If any {@link Supplier} throws an exception then
     * exception is rethrown.
     *
     * @param param1
     *         First {@link Supplier} to execute.
     * @param param2
     *         Second {@link Supplier} to execute.
     * @param param3
     *         Third {@link Supplier} to execute.
     * @param param4
     *         Fourth {@link Supplier} to execute.
     * @param param5
     *         Fifth {@link Supplier} to execute.
     * @param param6
     *         Sixth {@link Supplier} to execute.
     * @param param7
     *         Seventh {@link Supplier} to execute.
     *
     * @return Instance of {@link Tuple7} with values returned by provided suppliers.
     */
    default <T1, T2, T3, T4, T5, T6, T7> Tuple7<T1, T2, T3, T4, T5, T6, T7> awaitAll(Supplier<T1> param1,
                                                                                     Supplier<T2> param2,
                                                                                     Supplier<T3> param3,
                                                                                     Supplier<T4> param4,
                                                                                     Supplier<T5> param5,
                                                                                     Supplier<T6> param6,
                                                                                     Supplier<T7> param7) {
        Promise<Tuple1<T1>> r1 = submit(param1);
        Promise<Tuple1<T2>> r2 = submit(param2);
        Promise<Tuple1<T3>> r3 = submit(param3);
        Promise<Tuple1<T4>> r4 = submit(param4);
        Promise<Tuple1<T5>> r5 = submit(param5);
        Promise<Tuple1<T6>> r6 = submit(param6);
        Promise<Tuple1<T7>> r7 = submit(param7);

        return Tuples.of(r1.await().get1(), r2.await().get1(), r3.await().get1(), r4.await().get1(), r5.await().get1(),
                         r6.await().get1(), r7.await().get1());
    }

    /**
     * Await results of execution of provided suppliers. Returned instance of {@link Tuple8} holds values returned by
     * provided {@link Supplier}'s if execution of them was successful. If any {@link Supplier} throws an exception then
     * exception is rethrown.
     *
     * @param param1
     *         First {@link Supplier} to execute.
     * @param param2
     *         Second {@link Supplier} to execute.
     * @param param3
     *         Third {@link Supplier} to execute.
     * @param param4
     *         Fourth {@link Supplier} to execute.
     * @param param5
     *         Fifth {@link Supplier} to execute.
     * @param param6
     *         Sixth {@link Supplier} to execute.
     * @param param7
     *         Seventh {@link Supplier} to execute.
     * @param param8
     *         Eighth {@link Supplier} to execute.
     *
     * @return Instance of {@link Tuple8} with values returned by provided suppliers.
     */
    default <T1, T2, T3, T4, T5, T6, T7, T8> Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> awaitAll(Supplier<T1> param1,
                                                                                             Supplier<T2> param2,
                                                                                             Supplier<T3> param3,
                                                                                             Supplier<T4> param4,
                                                                                             Supplier<T5> param5,
                                                                                             Supplier<T6> param6,
                                                                                             Supplier<T7> param7,
                                                                                             Supplier<T8> param8) {
        Promise<Tuple1<T1>> r1 = submit(param1);
        Promise<Tuple1<T2>> r2 = submit(param2);
        Promise<Tuple1<T3>> r3 = submit(param3);
        Promise<Tuple1<T4>> r4 = submit(param4);
        Promise<Tuple1<T5>> r5 = submit(param5);
        Promise<Tuple1<T6>> r6 = submit(param6);
        Promise<Tuple1<T7>> r7 = submit(param7);
        Promise<Tuple1<T8>> r8 = submit(param8);

        return Tuples.of(r1.await().get1(), r2.await().get1(), r3.await().get1(), r4.await().get1(), r5.await().get1(),
                         r6.await().get1(), r7.await().get1(), r8.await().get1());
    }

    /**
     * Await results of execution of provided suppliers. Returned instance of {@link Tuple9} holds values returned by
     * provided {@link Supplier}'s if execution of them was successful. If any {@link Supplier} throws an exception then
     * exception is rethrown.
     *
     * @param param1
     *         First {@link Supplier} to execute.
     * @param param2
     *         Second {@link Supplier} to execute.
     * @param param3
     *         Third {@link Supplier} to execute.
     * @param param4
     *         Fourth {@link Supplier} to execute.
     * @param param5
     *         Fifth {@link Supplier} to execute.
     * @param param6
     *         Sixth {@link Supplier} to execute.
     * @param param7
     *         Seventh {@link Supplier} to execute.
     * @param param8
     *         Eighth {@link Supplier} to execute.
     * @param param9
     *         Ninth {@link Supplier} to execute.
     *
     * @return Instance of {@link Tuple9} with values returned by provided suppliers.
     */
    default <T1, T2, T3, T4, T5, T6, T7, T8, T9> Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> awaitAll(
            Supplier<T1> param1, Supplier<T2> param2, Supplier<T3> param3, Supplier<T4> param4, Supplier<T5> param5,
            Supplier<T6> param6, Supplier<T7> param7, Supplier<T8> param8, Supplier<T9> param9) {
        Promise<Tuple1<T1>> r1 = submit(param1);
        Promise<Tuple1<T2>> r2 = submit(param2);
        Promise<Tuple1<T3>> r3 = submit(param3);
        Promise<Tuple1<T4>> r4 = submit(param4);
        Promise<Tuple1<T5>> r5 = submit(param5);
        Promise<Tuple1<T6>> r6 = submit(param6);
        Promise<Tuple1<T7>> r7 = submit(param7);
        Promise<Tuple1<T8>> r8 = submit(param8);
        Promise<Tuple1<T9>> r9 = submit(param9);

        return Tuples.of(r1.await().get1(), r2.await().get1(), r3.await().get1(), r4.await().get1(), r5.await().get1(),
                         r6.await().get1(), r7.await().get1(), r8.await().get1(), r9.await().get1());
    }

    /**
     * Shutdown reactor instance. Attempt to submit task to reactor which is shutdown will throw an exception.
     */
    void shutdown();

    /**
     * Return default instance of {@link ThreadPoolReactor}.
     *
     * @return default singleton instance of {@link ThreadPoolReactor}.
     */
    static Reactor pooled() {
        return ThreadPoolReactor.defaultReactor();
    }

    /**
     * Create new instance of {@link ThreadPoolReactor} with provided thread pools.
     *
     * @param computingPool
     *         Instance of {@link ThreadPool} used to execute computationally intensive tasks.
     * @param ioPool
     *         Instance of {@link ThreadPool} used to execute long running or blocking tasks.
     *
     * @return created instance of {@link ThreadPoolReactor}
     */
    static Reactor pooled(ThreadPool computingPool, ThreadPool ioPool) {
        return ThreadPoolReactor.with(computingPool, ioPool);
    }
}
