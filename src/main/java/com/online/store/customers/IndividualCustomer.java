package com.online.store.customers;

import java.util.Objects;

public record IndividualCustomer(String id, String firstName, String lastName) implements Customer {
    public IndividualCustomer {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(firstName, "The first name must not be null");
        Objects.requireNonNull(lastName, "The name must not be null");
    }
}
