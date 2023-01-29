package com.nle.microservices.currencyexchangeservice.repository;

import com.nle.microservices.currencyexchangeservice.model.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

     CurrencyExchange findByFromAndTo(String from, String to);
}
