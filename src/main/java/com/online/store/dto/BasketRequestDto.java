package com.online.store.dto;

import com.online.store.enums.ClientType;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class BasketRequestDto {
    private ClientType clientType;

    private Long clientId;

    private String lastName;
    private String firstName;

    private String companyName;
    private String siren;
    private String intraVatNumber;
    private BigDecimal annualTurnover;

    private int highEndPhoneQty;
    private int midRangePhoneQty;
    private int laptopQty;
}
