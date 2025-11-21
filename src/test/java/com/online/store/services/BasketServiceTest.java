package com.online.store.services;

import com.online.store.customers.BusinessCustomer;
import com.online.store.customers.IndividualCustomer;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class BasketServiceTest {
    private final BasketService basketService = new BasketService();

    @Test
    void should_use_individual_prices_for_individual_client() {
        // Given
        var client = new IndividualCustomer(1L, "Dupont", "Alice");

        // When
        var prices = basketService.getUnitPrices(client);

        // Then
        assertThat(prices.highEndPhoneUnitPrice()).isEqualByComparingTo("1500");
        assertThat(prices.midRangePhoneUnitPrice()).isEqualByComparingTo("800");
        assertThat(prices.laptopUnitPrice()).isEqualByComparingTo("1200");
    }

    @Test
    void should_use_pro_big_turnover_prices_when_turnover_greater_than_10M() {
        // Given
        var client = new BusinessCustomer(
                2L,
                "BigCorp",
                "123456789",
                BigDecimal.valueOf(15_000_000),
                "FR12345678901"
        );

        // When
        var prices = basketService.getUnitPrices(client);

        // Then
        assertThat(prices.highEndPhoneUnitPrice()).isEqualByComparingTo("1000");
        assertThat(prices.midRangePhoneUnitPrice()).isEqualByComparingTo("550");
        assertThat(prices.laptopUnitPrice()).isEqualByComparingTo("900");
    }

    @Test
    void should_use_pro_small_turnover_prices_when_turnover_less_or_equal_10M() {
        // Given
        var client = new BusinessCustomer(
                3L,
                "SmallBiz",
                "987654321",
                BigDecimal.valueOf(3_000_000),
                null
        );

        // When
        var prices = basketService.getUnitPrices(client);

        // Then
        assertThat(prices.highEndPhoneUnitPrice()).isEqualByComparingTo("1150");
        assertThat(prices.midRangePhoneUnitPrice()).isEqualByComparingTo("600");
        assertThat(prices.laptopUnitPrice()).isEqualByComparingTo("1000");
    }

    @Test
    void should_calculate_total_correctly_for_mixed_basket() {
        // Given
        var client = new IndividualCustomer(1L, "Dupont", "Alice");

        // 1 high-end, 2 mid-range, 1 laptop
        int highQty = 1;
        int midQty = 2;
        int laptopQty = 1;

        // When
        var total = basketService.calculateTotal(client, highQty, midQty, laptopQty);

        // Individuel : 1*1500 + 2*800 + 1*1200 = 1500 + 1600 + 1200 = 4300
        // Then
        assertThat(total).isEqualByComparingTo("4300.00");
    }
}