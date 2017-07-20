# booter-flow
###Small and fast reactive data processing pipeline builder/executor

#Motivation
There are several approaches exists to processing of sequences of incoming events/pieces of data/requests in reactive applications.
All of them are targeted to sequences of identical elements. For example, Java 8 Streams or RxJava are very convenient for such types
of processing. Nevertheless these case do not cover one of the most frequent use cases - processing of incoming requests in various 
servers, especially Web servers. The problem is that Web server API's and formats of input/output data
are from technical domain, while application itself along with it's data belong to business domain. The transition between
domains makes such a processing inconvenient to traditional approaches. One of the obstacles for such a use cases is that
request processing often requires more than one intermediate state variables - request is processed to extract parameters,
which are used to retrieve other pieces of data from some kind of storage, then all those pieces of data are 
processed and form final response. At every stage of the processing several variables of different type exists and all 
of them are necessary to process request. Depending on parameters and/or retrieved data processing may take quite different
execution paths. Traditional approaches may use an workaround by using some kind of multivalue contaioner
(such as **Pair<T1, T2>** or **Tuple** or dedicated class). This approach has significant drawback: separate state variables need 
to be accesses through inconvenient and verbose method call syntax, often quite cryptic and lacking freedom of arbitrary
variable naming. 

Beside need to hold several values in reactive application it is quite important to be able to split processing into several 
stages so each stage can be processed synchronously or asynchronously, depending on needs. Traditional approaches enable such 
a processing but they lack granular control over each stage and in general use of this functionality is not convenient and 
even less transparent. 

The **booter-flow** addresses both these problems by providing convenient way to build and execute reactive processing
flows.

#General Overview
The **booter-flow** approach is quite different from traditional. 

First of all assembling of the flow and its execution are clearly separate stages. Flow is assembled and then can be processed several times with different inputs in different
**Reactor**'s (see below). 

The **booter-flow** explicitly exposes **Reactor** - processor for the flows. The **Reactor** is somewhat similar to 
Java **ExecutorService**. The idea of **Reactor** is inspired by **RxJava Scheduler** but with significant improvements.
The main idea behind **Reactor** is to have two thread pools - one dedicated for non-blocking, computationally intensive tasks
while other is dedicated to blocking/slow/independent (asynchronous) operations such as I/O. -----------------------  
