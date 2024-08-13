package com.jardefelicio.api_orders.modules.customer.services;

import com.jardefelicio.api_orders.modules.customer.entity.CustomerEntity;
import com.jardefelicio.api_orders.modules.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerFindByEmailService {
    @Autowired
    private CustomerRepository repository;

    public Optional<CustomerEntity> execute(String email){
        return this.repository.findByEmail(email);
    }
}
