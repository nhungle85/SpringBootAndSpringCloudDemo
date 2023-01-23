package com.nle.microservices.currencyexchangeservice.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CurrencyExchangeResponse {
    private int id;
    private String from;
    private String to;
    private Float conversionMultiple;

}
