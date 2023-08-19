package com.myfirstshoppingwebsite.backend.service;

import com.myfirstshoppingwebsite.backend.dto.PaymentInfo;
import com.myfirstshoppingwebsite.backend.dto.Purchase;
import com.myfirstshoppingwebsite.backend.dto.PurchaseResponse;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);

    PaymentIntent createPaymentIntent(PaymentInfo paymentInfo) throws StripeException;
}
