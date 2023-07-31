package com.myfirstshoppingwebsite.backend.controller;

import com.myfirstshoppingwebsite.backend.dto.Purchase;
import com.myfirstshoppingwebsite.backend.dto.PurchaseResponse;
import com.myfirstshoppingwebsite.backend.service.CheckoutService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/checkout")
public class CheckoutController {

    private CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {

        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);

        return purchaseResponse;
    }
}
