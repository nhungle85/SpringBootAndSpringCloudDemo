package com.nle.microservices.currencyconversionservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currency-conversion")
public class CurrencyConversionController {
    @GetMapping("/sayHi")
    public String sayHi() {
        return "Hi";
    }
}
