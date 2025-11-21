package com.online.store.customers;

import java.util.Objects;

public record IndividualCustomer(String id, String firstName, String lastName) implements Customer {
    public IndividualCustomer {
        Objects.requireNonNull(id, "id ne doit pas être null");
        Objects.requireNonNull(firstName, "Le prénom ne doit pas être null");
        Objects.requireNonNull(lastName, "Le nom ne doit pas être null");
    }
}
