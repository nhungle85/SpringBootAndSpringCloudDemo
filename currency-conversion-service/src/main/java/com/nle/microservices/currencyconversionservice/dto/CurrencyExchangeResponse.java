package com.nle.microservices.currencyconversionservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyExchangeResponse {
    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
    //read the env from the instance that the request is redirect to
    private String environment;
}
