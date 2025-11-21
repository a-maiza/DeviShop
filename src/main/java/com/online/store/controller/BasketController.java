package com.online.store.controller;

import com.online.store.customers.BusinessCustomer;
import com.online.store.customers.Customer;
import com.online.store.customers.IndividualCustomer;
import com.online.store.dto.BasketRequest;
import com.online.store.dto.BasketResponse;
import com.online.store.enums.ClientType;
import com.online.store.services.BasketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/basket")
public class BasketController {

    private final BasketService basketService;

    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    @PostMapping("/compute")
    public ResponseEntity<BasketResponse> computeBasket(@RequestBody BasketRequest request) {

        Customer client = mapToClient(request);

        BasketService.Prices prices = basketService.getUnitPrices(client);

        BigDecimal total = basketService.calculateTotal(
                client,
                request.getHighEndPhoneQty(),
                request.getMidRangePhoneQty(),
                request.getLaptopQty()
        );

        BasketResponse response = new BasketResponse(
                prices.highEndPhoneUnitPrice(),
                prices.midRangePhoneUnitPrice(),
                prices.laptopUnitPrice(),
                request.getHighEndPhoneQty(),
                request.getMidRangePhoneQty(),
                request.getLaptopQty(),
                total
        );

        return ResponseEntity.ok(response);
    }

    private Customer mapToClient(BasketRequest r) {

        if (r.getClientType() == ClientType.INDIVIDUAL) {
            return new IndividualCustomer(
                    r.getClientId(),
                    r.getLastName(),
                    r.getFirstName()
            );
        }

        return new BusinessCustomer(
                r.getClientId(),
                r.getCompanyName(),
                r.getSiren(),
                r.getAnnualTurnover(),
                r.getIntraVatNumber()
        );
    }
}
