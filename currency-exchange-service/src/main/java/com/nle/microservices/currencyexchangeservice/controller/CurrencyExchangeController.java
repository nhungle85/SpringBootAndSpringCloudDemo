package com.nle.microservices.currencyexchangeservice.controller;

import com.nle.microservices.currencyexchangeservice.dto.CurrencyExchangeRequest;
import com.nle.microservices.currencyexchangeservice.dto.CurrencyExchangeResponse;
import com.nle.microservices.currencyexchangeservice.service.CurrencyExchangeService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/currency-exchange")
@Data
@AllArgsConstructor
public class CurrencyExchangeController {

    private CurrencyExchangeService service;
    private Environment environment;

    @GetMapping("/findAll")
    public List<CurrencyExchangeResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/{from}/to/{to}")
    public CurrencyExchangeResponse convert(@PathVariable String from, @PathVariable String to) {
        CurrencyExchangeResponse response = service.findByFromAndTo(from, to);
        response.setEnvironment(environment.getProperty("server.port"));
        return response;
    }

    @PostMapping("/create")
    public CurrencyExchangeResponse addCurrencyExchange(@RequestBody CurrencyExchangeRequest request) {
        return service.save(request);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        service.deleteById(id);
    }

    @PutMapping("/update")
    public CurrencyExchangeResponse update(@RequestBody CurrencyExchangeRequest request) {
        return service.save(request);
    }
}
