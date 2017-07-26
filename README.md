# booter-flow
Small and fast reactive data processing pipeline builder/executor

## Overview
The **booter-flow** is a tiny framework for building high performance reactive service processing pipelines. It's small 
(less than 200K), has no external dependencies and beside flow building/processing provides a number of convenient 
utilities for writing reactive applications.   

## License
This library is released under terms and conditions of Apache License, Version 2.0.
Copy of license is included in the sources or can be obtained at 
[Apache Software Foundation Site](http://www.apache.org/licenses/LICENSE-2.0). 

## Motivation and General Overview
Traditional approaches to processing sequences of elements (or events) like Java8 Streams or RxJava have no clear separation
between building processing pipeline and its execution. Also, built pipeline is inherently coupled to the source of 
elements, so it's impossible to reuse built pipeline. Pipelines created with these approaches have sensible assembling and
execution overheads.

The **booter-flow** takes different approach: building of processing pipeline and execution of pipeline are separate stages.
Built pipeline can be reused as many times as necessary with different data. Also, built pipeline has minimal execution overhead
and, obviously, zero assembling overhead. It also possible to build partial pipelines
and then assemble full pipelines as combination of partial pipelines. Finally, **booter-flow** incorporates convenient
asynchronous execution framework which significantly simplifies implementation of common processing patterns.   

## Framework Structure
The **booter-flow** consists of two core parts: Flow + builders and Reactor + Promise.

## Introduction to Flow
Flow is a processing pipeline with strictly typed inputs/outputs and processing steps. Each step takes input from 
previous step of execution (or Flow inputs) and passes results to next step (or output). Steps can be of different 
types - synchronous (non-blocking), asynchronous (executed concurrently with remaining steps) and blocking.

Flow can be considered a function of Flow inputs that produces outputs, i.e. in general case Flow is
stateless. In order to execute Flow it's necessary to provide initial state (input parameters) and specify Reactor where 
Flow will be executed. Therefore one Flow can be used to concurrently process different input parameters in same or 
different Reactors. In order to simplify use of **booter-flow** following contract was defined:

#### Flow Contract
**Each step of the Flow with same instance of state (input parameters/intermediate state) always executed 
by only one thread.** 

Such a contract avoids need to worry about synchronisation while writing flow steps.

## Getting Started
### Adding dependency to Maven project
(NOTE: library is not yet included into public Maven repos)
~~~
    <dependency>
        <groupId>org.rx-booter</groupId>
        <artifactId>flow</artifactId>
        <version>1.0-SNAPSHOT</version>
    </dependency>
~~~

### Tuples
The **booter-flow** framework heavily uses **Tuples**, i.e. vectors of variables where each variable has it's own type.
Since Java does not allow variable length of type variable list, **booter-flow** provides nine implementations of Tuple - **Tuple1** through **Tuple9**
which can hold from 1 to 9 variables respectively. Tuples provide methods to access each variable independently with strict
type checking.

### Short introduction to Reactor and Promise
The **booter-flow** uses concepts of **Reactor** and **Promise**. The **Reactor** is an extension of Java **ExecutorService**
concept. In other words, it's an specialised version of **ExecutorService** for execution of Flow. Internally **Reactor**
consists of two thread pools, one of which is relatively small and is used to execute short non-blocking steps of Flow.
 

### Creating and executing Flow

Flows are created using one of the **take** static Flow methods, for example:

~~~
    Flow<Tuple1<String>, Tuple2<Request, Response>> flow1 = Flow.take(Request.class, Response.class)
                     .map((req, resp) -> Tuples.of(validate(req), resp)) 
                     .mapTo3((req, resp) -> Tuples.of(extractToken(req), req, resp)) 
                     .mapTo1((token, req, resp) -> processRequest(token, req, resp))
                     .done();
~~~

Lets review this code step by step.
 - Created Flow accepts tuple with two parameters - **Request** and **Response** and ** and returns tuple with **String**.
 - Flow adds first step lambda and maps tuple content to lambda parameters and lambda returns tuple with **two** results
 - Flow adds second step lambda, maps tuple to lambda parameters and lambda returns tuple with **three** results
 - Flow adds third step lambda, maps tuple lambda parameters and lambda returns tuple with **single** result  
 - Flow finishes building flow and from type of last build stage derives type of the lambda output 

Created flow has no state and can be executed with any **Reactor**. In order to execute flow it's necessary to bind 
input parameter values to flow and submit it for execution into **Reactor**. Lets see how this can be done. First of all
it's necessary to bind input parameter values to Flow and create **ExecutableFlow**:

~~~
    ExecutableFlow<Tuple1<String>, Tuple2<Request, Response>> excutable =
                    flow.applyTo(Tuples.of(request, response));
~~~

Created executable flow can be submitted to **Reactor** directly:

~~~
    Promise<Tuple1<String>> promise = Reactor.pooled().submit(excutable);
~~~

Another alternative is to use **ExecutableFlow**'s _in()_ method:

~~~
    Promise<Tuple1<String>> result = excutable.in(Reactor.pooled());
~~~

Basically both ways are identical except that second approach is more suitable for fluent syntax:

~~~
    Promise<Tuple1<String>> result = flow.applyTo(Tuples.of(request, response)).in(Reactor.pooled());
~~~

Once flow is submitted to **Reactor** 

Creation of Flows starts from one of static factory methods of **Flow** class. There are several such methods, but 
all of them can be separated in two groups. First group of method takes classes as a parameters. These classes describe
types of the **Flow** input parameters. Second group uses **Type** interface for same purposes. The first group is less
verbose and little bit more convenient, but lacks ability to describe complex generic input types. Second group is more
verbose but enables describing of arbitrary input parameter types. 

Some examples:


Same code with **Type**:

~~~
    Flow<Tuple1<String>, Tuple2<Request, Response>> flow1 = Flow.take(new Type<Request>() {}, new Type<Response>() {})
                     .mapTo1((req, resp) -> processRequest(req, resp))
                     .done();
~~~



### Utility methods of Reactor and Promise

#### Promise
Reactor and Promise are designed to work together, nevertheless, Promise might be useful 
by it's own, as a general purpose result of some (possibly asynchronous) operation. From this point
of view it's very similar to Java **CompletableFuture** although much simpler and lightweight.
First of all, just like **CompletableFuture** Promise can be set explicitly:
~~~
    Promise<String> promise = Promise.empty();
    ...(probably in another thread)...
    promise.notify("Some string");
~~~
Similar method exists to notify Promise about error:
~~~
    Promise<String> promise = Promise.empty();
    ...(probably in another thread)...
    try {
        promise.notify(service.retrieveData());
    } catch (ServiceException e) {
        promise.notifyError(e);
    }
~~~
Once _notify_ or _notifyError_ is called, Promise considered _ready_, i.e. such that holds value or error value. 
Both of these calls will set value only once (i.e. subsequent calls to same _notify_ will not change value and
subsequent calls to _notifyError_ will not change error value), but value and error value are independent on 
each other. It means that when, for example, _notifyError_ is called and error value is set, one may call _notify_
and set the value.

Sometimes it is necessary to wait for more than one notification (see implementation of **Reactor.awaitAny()** 
for example). For this purpose **Promise** can be created using **waitingFor** static factory method. Such a promise 
will wait for at least one value notification or for specified number of error value notifications:
~~~
    Promise<String> promise = Promise.waitingFor(3);
~~~
If it's necessary to wait while notifications will come, then one of **await** or **safeAwait** methods can be used.
First method will wait until notification will appear and then either returns value (if there was a value notification) 
or throws an exception (if there was error value notification). Second method never throws an exception, instead it 
returns empty **Optional** in case of error value notification.

There is more reactive approach for dealing with value and error value notifications. Promise supports installation of
listeners which will be invoked upon receiving appropriate notification. For value notifications _then_ method is used
to install listener:
~~~
    Promise<String> promise = Promise.empty();
    promise.then(s -> request.write(s));
~~~
If value is available by the moment when _then_ method is invoked, then listener will be called immediately. If value 
is not available, then listener will be invoked upon receiving notification. Note that in these cases listener will be 
invoked in context of different threads. Although listener will never be invoked concurrently in different threads,
the distinction between these cases should be kept in mind. 

Behavior of _onError_ method is identical to _then_ except it deals with error notifications. 

#### Reactor
Reactor provides convenient API for blocking and non-blocking execution of some 
concurrent tasks. Lets take a look at following method:
~~~
    Promise<T> submit(Supplier<T> supplier);
~~~
This method starts execution of provided supplier as asynchronous task which runs concurrently with current thread. 
Returned **Promise** can be used to retrieve value when result will be available or perform some steps
upon receiving of computation result. For example:
~~~
    Promise<String> promise = Reactor.pooled().submit(() -> externalService.retieveData())
        .then((s) -> response.write(s));
~~~
Note that in this case we're dealing with asynchronous operation, so invocation of method _then_ may 
happen either before or after Promise actually receives it's value. The Promise transparently handles both 
these situations and lambda passed to _then_ method will be always executed with received value. 

As mentioned above, Promise allows also to explicitly wait for result availability:
~~~
    Optional<String> value = Reactor.pooled().submit(() -> externalService.retieveData())
        .safeAwait();
~~~

Sometimes it is convenient to handle asynchronous execution just like a method call. For these cases _await_ metod
might be handy:
~~~
    String value = Reactor.pooled().submit(() -> externalService.retieveData()).await();
~~~
In this use case invocation will behave exactly like method call - when value will be available it will be returned. 
If call to external service will throw exception it will be wrapped into **FlowWrappedException** if necessary
and rethrown.

Since use case mentioned above is quite widespread, there is a shorter version of the same call:
~~~
    String value = Reactor.pooled().await(() -> externalService.retieveData());
~~~

In some cases it is necessary to retrieve data from several sources at once. **booter-flow** provides 
convenient methods for retrieving multiple (1-9) results. For example, for 2 results:
~~~
    Tuple2<Session, User> result = reactor.awaitAll(() -> sessionDAO.fromToken(token),
                                                    () -> userDAO.byToken(token));
~~~
The Reactor will execute both tasks asynchronously and once all of them will be ready, result will be returned.

Sometimes waiting for all results is not necessary. Instead we need to get result as soon as possible but it 
can be obtained from different sources with different reliability and speed. For this use case Reactor provides
convenient method _awaitAny_:
~~~
    Optional<Session> result = reactor.awaitAny(() -> distributedSessionCache.get(sessionId),
                                                () -> sessionDAO.sessionById(sessionId));
~~~
This method executes all provided lambdas concurrently and first one which return valid result will be 
returned to caller. If all lambdas will throw an exception then empty _Optional_ will be returned. Note that 
even when result is returned execution of remaining lambdas will not be terminated and they will be allowed 
to run to the end (either, successful or unsuccessful). Sometimes this behavior is not desirable and 
it is necessary to invoke provided suppliers one by one until value will be returned. Handy _awaitFirst_
method provides simple solution for this case:
~~~
    Optional<Session> result = reactor.awaitFirst(() -> distributedSessionCache.get(sessionId),
                                                  () -> distributedSessionCache.get(sessionId, sessionDAO.sessionById(sessionId)));
~~~

### Error handling
