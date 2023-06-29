package com.myfirstshoppingwebsite.backend.service;

import com.myfirstshoppingwebsite.backend.dto.Purchase;
import com.myfirstshoppingwebsite.backend.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
