# springboot-resilience4j 
* Resilience4j is a lightweight fault tolerance library inspired by Netflix Hystrix, but designed for funtional programming.
* It uses only Vavr only.

* Resilience4j provide higher order functions:
    1. Circuit Breaker
    2. Rate Limiter
    3. Retry
    4. Bulkhead
    
* The circuit breaker uses a Ring Bit Buffer in the CLOSED state to store the success or failure statues of function calls.
    1. Success function call - 0
    2. Failure function call - 1
  
* For the resilience dashboard we can use prometheus for which we need to download the prometheus from `https://prometheus.io/` and update the yaml file with:
   ```
      - job_name: "spring-resilience4j"
        metrics_path: "/actuator/prometheus"
        scrape_interval: 5s
        static_configs:
        - targets: ["127.0.0.1:8085"]
  ```
* Now we have to go to the command prompt where the prometheus is downloaded and prometheus.exe file lies.
* The run the exe file using command prompt.
* We can see the port number in which it is running. It is running in 9090.
* Then run the application and go to browser and hit:
  > http://localhost:9090/
  
we will see the dashboard for prometheus.
* Now select `go_memstats_heap_alloc_bytes`  from metrics Explorer and hit execute button the click on graph tab we can see the graph.

* We can use `Grafana` also for application monitoring.

* The resilience4j aspects order is the following:
Retry > CircuitBreaker > RateLimiter > Bulkhead