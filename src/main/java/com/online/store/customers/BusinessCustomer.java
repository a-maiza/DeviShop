package com.online.store.customers;

import java.math.BigDecimal;
import java.util.Objects;

public record BusinessCustomer(String id, String companyName, String vatNumber, String siren, BigDecimal annualRevenue) implements Customer {
    public BusinessCustomer {
        Objects.requireNonNull(id, "id ne doit pas être null");
        Objects.requireNonNull(companyName, "La raison sociale ne doit pas être null");
        Objects.requireNonNull(siren, "Le SIREN ne doit pas être null");
        Objects.requireNonNull(annualRevenue, "Le chiffre d'affaires ne doit pas être null");
    }
}
