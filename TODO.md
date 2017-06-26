### Main features
 - Flow.combine(Flow, Flow) with type safety
 - Flow.run(I input) -> O output (where I/O - Tuple) - single threaded 
 - Second argument (error handler) for all apply/asyncApply/awaitApply

### Additional features
 - Reactor to interface
 - Reactor awaitAny(Supplier ... Supplier)
 - Reactor awaitAll(Supplier ... Supplier)
 - Reactor async(Flow)
 - Reactor async(Runnable)
 - Reactor.defaultReactor()
 - Reactor.current();
 - Reactor scheduled(Flow, CronTab);