package com.online.store.customers;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;
@Data
@AllArgsConstructor
public final class IndividualCustomer implements Customer {
    private Long id;
    private String lastName;
    private String firstName;
}
