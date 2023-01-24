package com.nle.microservices.currencyexchangeservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "CURRENCY_EXCHANGE")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurrencyExchange {
    @Id
    @Column(name = "currency_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "currency_from", length = 3, nullable = false)
    private String from;

    @Column(name = "currency_to", length = 3, nullable = false)
    private String to;

    @Column(name = "conversion_multiple")
    private BigDecimal conversionMultiple;

}
