package com.nle.microservices.currencyexchangeservice.repository;

import com.nle.microservices.currencyexchangeservice.model.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

     CurrencyExchange findByFromAndTo(String from, String to);
}
