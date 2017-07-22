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
There are several approaches exists to processing of sequences of incoming events/pieces of data/requests in reactive applications.
All of them are targeted to sequences of identical elements. For example, Java 8 Streams or RxJava are very convenient for such types
of processing. Nevertheless these case do not cover one of the most frequent use cases - processing of incoming requests in various 
servers, especially Web servers. 

The problem is that Web server API's and formats of input/output data
are from technical domain, while application itself along with it's data belong to business domain. The transition between
domains makes such a processing inconvenient to traditional approaches. One of the obstacles for such a use cases is that
request processing often requires more than one intermediate state variables - request is processed to extract parameters,
which are used to retrieve other pieces of data from some kind of storage, then all those pieces of data are 
processed and form final response. At every stage of the processing several variables of different type exists and all 
of them are necessary to process request. Depending on parameters and/or retrieved data processing may take quite different
execution paths. Traditional approaches may use an workaround by using some kind of multivalue container
(such as **Pair<T1, T2>** or **Tuple** or dedicated class). This approach has significant drawback: separate state variables need 
to be accessed through inconvenient and verbose method call syntax, often quite cryptic and lacking freedom of arbitrary
variable naming. 

Beside need to hold several values in reactive application it is quite important to be able to split processing into several 
stages so each stage can be processed synchronously or asynchronously, depending on needs. Traditional approaches enable such 
a processing but they lack granular control over each stage and in general use of this functionality is not convenient and 
even less transparent. 

The **booter-flow** addresses both these problems by providing convenient way to build and execute reactive processing
flows.

First of all assembling of the flow and its execution are clearly separate stages. Flow is assembled and then can be 
processed as many times as necessary with different inputs in different
**Reactor**'s (see below). 

The **booter-flow** explicitly exposes **Reactor** - processor for the **Flow**'s (and much more). The **Reactor** is somewhat similar to 
Java **ExecutorService**. The idea of **Reactor** is inspired by **RxJava Scheduler** concept but with significant improvements.

The main idea behind **Reactor** is to have two thread pools - one dedicated for non-blocking, computationally intensive tasks
while other is dedicated to blocking/slow/asynchronous operations such as I/O. First pool is called computational pool, second - I/O pool. 

Execution of **Flow** uses both pools, switching between them as necessary. Regular non-blocking operations are performed by 
computational thread pool. Once there is a need to perform asynchronous or blocking operation, processing is switched to I/O pool.

Beside execution of **Flow** the **Reactor** provides a number of useful methods which, being combined with power of **Promise**,
makes writing of reactive applications much more convenient.

## Introduction to Flow
Flow is a description of inputs/outputs and processing steps. Each step takes input from previous step of execution (or Flow inputs)
and passes results to next step (or output). Steps can be of different types - synchronous (non-blocking), asynchronous (executed 
concurrently with remaining steps) and blocking.

Flow can be considered a function of Flow inputs that produces outputs, i.e. in general case Flow is
stateless. In order to execute Flow it's necessary to provide initial state (input parameters) and specify Reactor where Flow will 
be executed. Therefore one Flow
can be used to concurrently process different input parameters in same or different Reactors. In order to simplify use of 
**booter-flow** following contract was defined:

### Flow Contract
__Each__ step of the **Flow** with same instance of __state__ (input parameters/intermediate state) is __always__ executed 
by __one__ thread. 

Such a contract avoids need to worry about synchronisation while writing steps.

## Getting Started
### Adding dependency to Maven project
### Creating and Executing Flow
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
------------ waiting conditions, number of notifications, etc.------------------------------

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

Promise allows also to explicitly wait for result availability:
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
and rethrown. Note that _safeAwait_ does not rethrow exception and just returns an empty **Optional** in case 
of exception. If information about exception is necessary it can be retrieved from Promise using _isError_ and _getError_
methods.   

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
The Reactor will execute both tasks asynchronously and once both of them will be ready, result will be returned.

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
to run to the end (either, successful or unsuccessful). Sometimes this behavior can be used (modified version 
of previous example):
~~~
    Optional<Session> result = reactor.awaitAny(() -> distributedSessionCache.get(sessionId),
                                                () -> distributedSessionCache.get(sessionId, sessionDAO.sessionById(sessionId)));
~~~


### Error handling
