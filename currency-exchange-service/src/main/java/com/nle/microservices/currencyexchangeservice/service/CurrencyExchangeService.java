package com.nle.microservices.currencyexchangeservice.service;

import com.nle.microservices.currencyexchangeservice.dto.CurrencyExchangeRequest;
import com.nle.microservices.currencyexchangeservice.dto.CurrencyExchangeResponse;
import com.nle.microservices.currencyexchangeservice.model.CurrencyExchange;
import com.nle.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CurrencyExchangeService {
    private CurrencyExchangeRepository repository;

    public CurrencyExchangeResponse findByFromAndTo(String from, String to) {
        CurrencyExchange data = repository.findByFromAndTo(from, to);

        return CurrencyExchangeResponse.fromEntity(data);
    }

    public CurrencyExchangeResponse save(CurrencyExchangeRequest request) {
        var entity = request.toEntity();
        var saved_entity = repository.save(entity);
        return CurrencyExchangeResponse.fromEntity(saved_entity);
    }

    public List<CurrencyExchangeResponse> findAll() {
        return repository.findAll()
                .stream().map(CurrencyExchangeResponse::fromEntity)
                .collect(Collectors.toList());
    }

    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
