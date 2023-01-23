package com.nle.microservices.currencyexchangeservice.controller;

import com.nle.microservices.currencyexchangeservice.bean.CurrencyExchangeResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currency-exchange")
@Data
@AllArgsConstructor
public class CurrencyExchangeController {

    private Environment environment;

    @GetMapping("/{from}/to/{to}")
    public CurrencyExchangeResponse convert(@PathVariable String from, @PathVariable String to) {
        return CurrencyExchangeResponse.builder()
                .from(from)
                .to(to)
                .environment(environment.getProperty("local.server.port"))
                .build();
    }
}
