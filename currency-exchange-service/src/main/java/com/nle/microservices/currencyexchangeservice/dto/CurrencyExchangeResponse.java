package com.nle.microservices.currencyexchangeservice.dto;

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
public class CurrencyExchangeResponse {
    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
    //read the env from the instance that the request is redirect to
    private String environment;

    public static CurrencyExchangeResponse fromEntity(CurrencyExchange entity) {
        if (entity == null)
            return CurrencyExchangeResponse.builder().build();
        return CurrencyExchangeResponse.builder()
                .id(entity.getId())
                .from(entity.getFrom())
                .to(entity.getTo())
                .conversionMultiple(entity.getConversionMultiple())
                .build();
    }
}
