package com.online.store.services;

import com.online.store.customers.BusinessCustomer;
import com.online.store.customers.Customer;
import com.online.store.customers.IndividualCustomer;
import lombok.Builder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class BasketService {
    private static final BigDecimal TEN_MILLION = BigDecimal.valueOf(10_000_000L);
    public BigDecimal calculateTotal(
            Customer customer,
            int highEndPhoneQty,
            int midRangePhoneQty,
            int laptopQty) {
        Prices prices = getUnitPrices(customer);

        BigDecimal total = BigDecimal.ZERO;
        total = total.add(prices.highEndPhoneUnitPrice().multiply(BigDecimal.valueOf(highEndPhoneQty)));
        total = total.add(prices.midRangePhoneUnitPrice().multiply(BigDecimal.valueOf(midRangePhoneQty)));
        total = total.add(prices.laptopUnitPrice().multiply(BigDecimal.valueOf(laptopQty)));

        return total.setScale(2, RoundingMode.HALF_UP);
    }

    public Prices getUnitPrices(Customer client) {
        if (client instanceof IndividualCustomer) {
            return Prices.builder()
                    .highEndPhoneUnitPrice(BigDecimal.valueOf(1500))
                    .midRangePhoneUnitPrice(BigDecimal.valueOf(800))
                    .laptopUnitPrice(BigDecimal.valueOf(1200))
                    .build();
        }

        if (client instanceof BusinessCustomer pro) {
            if (pro.getAnnualTurnover().compareTo(TEN_MILLION) > 0) {
                return Prices.builder()
                        .highEndPhoneUnitPrice(BigDecimal.valueOf(1000))
                        .midRangePhoneUnitPrice(BigDecimal.valueOf(550))
                        .laptopUnitPrice(BigDecimal.valueOf(900))
                        .build();
            } else {
                return Prices.builder()
                        .highEndPhoneUnitPrice(BigDecimal.valueOf(1150))
                        .midRangePhoneUnitPrice(BigDecimal.valueOf(600))
                        .laptopUnitPrice(BigDecimal.valueOf(1000))
                        .build();
            }
        }

        throw new IllegalArgumentException("Unsupported client type");
    }

    @Builder
    public record Prices(BigDecimal highEndPhoneUnitPrice, BigDecimal midRangePhoneUnitPrice, BigDecimal laptopUnitPrice) {

    }
}
