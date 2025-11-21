package com.online.store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class BasketResponse {
    private BigDecimal highEndPhoneUnitPrice;
    private BigDecimal midRangePhoneUnitPrice;
    private BigDecimal laptopUnitPrice;

    private int highEndPhoneQty;
    private int midRangePhoneQty;
    private int laptopQty;

    private BigDecimal total;
}
