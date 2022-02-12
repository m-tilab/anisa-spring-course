package com.example.currencyexchangeservice.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@Slf4j
public class CircuitBreakerController {

    @GetMapping("/sample-api")
    @Bulkhead(name = "default")
    public String sampleApi() throws InterruptedException {

        log.info("sampleAPI called");

        Thread.sleep(5000);

        //ResponseEntity<String> stringResponseEntity = new RestTemplate().getForEntity("http://localhost:8080/dummy-url", String.class);

        return "sample response";
    }

    public String hardcodedResponse(Exception ex) {

        return "fallback-response";
    }
}
