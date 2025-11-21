package com.online.store.customers;

import java.math.BigDecimal;
import java.util.Objects;

public record BusinessCustomer(String id, String companyName, String vatNumber, String siren, BigDecimal annualRevenue) implements Customer {
    public BusinessCustomer {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(companyName, "The company name must not be null");
        Objects.requireNonNull(siren, "The SIREN number must not be null");
        Objects.requireNonNull(annualRevenue, "The Revenue must not be zero");
    }
}
