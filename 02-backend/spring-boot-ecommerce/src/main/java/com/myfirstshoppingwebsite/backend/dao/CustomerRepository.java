package com.myfirstshoppingwebsite.backend.dao;

import com.myfirstshoppingwebsite.backend.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByEmail(String theEmail);

}
