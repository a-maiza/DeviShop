package com.online.store.customers;

public sealed interface Customer permits BusinessCustomer, IndividualCustomer{
    Long getId();
}
