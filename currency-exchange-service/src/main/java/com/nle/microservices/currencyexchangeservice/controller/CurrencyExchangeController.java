package com.nle.microservices.currencyexchangeservice.controller;

import com.nle.microservices.currencyexchangeservice.bean.CurrencyExchangeResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currency-exchange")
public class CurrencyExchangeController {

    @GetMapping("/{from}/to/{to}")
    public CurrencyExchangeResponse convert(@PathVariable String from, @PathVariable String to) {
        return CurrencyExchangeResponse.builder()
                .from(from)
                .to(to)
                .build();
    }
}
