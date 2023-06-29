package com.myfirstshoppingwebsite.backend.service;

import com.myfirstshoppingwebsite.backend.dao.CustomerRepository;
import com.myfirstshoppingwebsite.backend.dto.Purchase;
import com.myfirstshoppingwebsite.backend.dto.PurchaseResponse;
import com.myfirstshoppingwebsite.backend.entity.Customer;
import com.myfirstshoppingwebsite.backend.entity.Order;
import com.myfirstshoppingwebsite.backend.entity.OrderItem;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CustomerRepository customerRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        // retrieve the order info from dto
        Order order = purchase.getOrder();

        // generate tracking number
        String orderTrackNumber = generateOrderTrackNumber();
        order.setOrderTrackingNumber(orderTrackNumber);

        // populate order with orderItems
        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item));

        // populate order with billingAddress and shippingAddress
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());

        // populate customer with order
        Customer customer = purchase.getCustomer();
        customer.add(order);

        // save to the database
        customerRepository.save(customer);

        // return a response
        return new PurchaseResponse(orderTrackNumber);
    }

    private String generateOrderTrackNumber() {

        // generate a random UUID number (UUID version-4)
        // for details see: https://en.wikipedia.org/woki/Universally_unique_identifier
        //
        return UUID.randomUUID().toString();
    }
}
