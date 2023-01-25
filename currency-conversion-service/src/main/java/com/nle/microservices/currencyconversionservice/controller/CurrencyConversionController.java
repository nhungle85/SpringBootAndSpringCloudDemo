package com.nle.microservices.currencyconversionservice.controller;

import com.nle.microservices.currencyconversionservice.Proxy.CurrencyExchangeClient;
import com.nle.microservices.currencyconversionservice.dto.CurrencyExchangeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;

@RestController
@RequestMapping("/currency-conversion")
public class CurrencyConversionController {
    @Autowired
    private CurrencyExchangeClient currencyExchangeClient;

    @GetMapping("/sayHi")
    public String sayHi() {
        return "Hi";
    }

    @GetMapping("/exchange-by-feign/{from}/to/{to}/{amount}")
    public CurrencyExchangeResponse exchangeUsingFeignClient(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal amount) {
        CurrencyExchangeResponse response = currencyExchangeClient.convert(from, to);
        response.setTotalAmount(amount.multiply(response.getConversionMultiple()));

        return response;
    }

    @GetMapping("/exchange/{from}/to/{to}/{amount}")
    public BigDecimal exchange(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal amount) {
        HashMap<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);

        ResponseEntity<CurrencyExchangeResponse> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/{from}/to/{to}", CurrencyExchangeResponse.class, uriVariables);

        return amount.multiply(responseEntity.getBody().getConversionMultiple());
    }
}
