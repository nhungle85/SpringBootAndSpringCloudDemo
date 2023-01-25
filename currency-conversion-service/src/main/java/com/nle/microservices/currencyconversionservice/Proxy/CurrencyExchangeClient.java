package com.nle.microservices.currencyconversionservice.Proxy;

import com.nle.microservices.currencyconversionservice.dto.CurrencyExchangeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "currency-service", url="localhost:8000") if not register to naming service
@FeignClient(name = "currency-exchange")
public interface CurrencyExchangeClient {

    @GetMapping("/currency-exchange/{from}/to/{to}")
    public CurrencyExchangeResponse convert(@PathVariable String from, @PathVariable String to);
}
