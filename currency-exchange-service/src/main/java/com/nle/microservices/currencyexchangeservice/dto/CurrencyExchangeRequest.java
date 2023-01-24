package com.nle.microservices.currencyexchangeservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nle.microservices.currencyexchangeservice.model.CurrencyExchange;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyExchangeRequest {
    private Long id;
    @JsonProperty("currencyFrom")
    private String from;
    @JsonProperty("currencyTo")
    private String to;
    private BigDecimal conversionMultiple;

    public CurrencyExchange toEntity() {
        return CurrencyExchange.builder()
                .id(this.id)
                .from(this.from)
                .to(this.to)
                .conversionMultiple(this.conversionMultiple)
                .build();
    }
}
