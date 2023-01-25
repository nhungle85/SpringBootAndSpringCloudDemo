package com.nle.microservices.currencyconversionservice.controller;

import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class CircuitBreakerController {

    @GetMapping("/sample-api")
    @Retry(name="sample-api", fallbackMethod = "hardCodedResponse")
    public String sampleApi() {
        log.info("Sample api call receive");

        ResponseEntity<String> response = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-api", String.class);

        return response.getBody();
    }

    public String hardCodedResponse(Exception ex) {
        return "fallback-response";
    }
}
