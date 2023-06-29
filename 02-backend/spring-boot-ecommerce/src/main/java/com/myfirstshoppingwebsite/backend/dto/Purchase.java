package com.myfirstshoppingwebsite.backend.dto;

import com.myfirstshoppingwebsite.backend.entity.Address;
import com.myfirstshoppingwebsite.backend.entity.Order;
import com.myfirstshoppingwebsite.backend.entity.OrderItem;
import com.myfirstshoppingwebsite.backend.entity.Customer;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}
