package com.online.store.customers;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public final class BusinessCustomer implements Customer {
    private Long id;
    private String companyName;
    private String siren;
    private BigDecimal annualTurnover;
    private String intraVatNumber; // optionnel
}
