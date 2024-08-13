package com.jardefelicio.api_orders.modules.customer.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jardefelicio.api_orders.modules.customer.dtos.CustomerCreateDTO;
import com.jardefelicio.api_orders.modules.customer.dtos.CustomerResponseDTO;
import com.jardefelicio.api_orders.modules.customer.entity.CustomerEntity;
import com.jardefelicio.api_orders.modules.customer.repository.CustomerRepository;
import com.jardefelicio.api_orders.shared.exception.ConflictException;

@Service
public class CustomerCreateService {
    @Autowired
    private CustomerRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    public CustomerResponseDTO execute(CustomerCreateDTO data) {

        this.repository.findByEmail(data.getEmail()).ifPresent((customer) -> {
            throw new ConflictException("There is already a registration with this email");
        });

        this.repository.findByPhone(data.getPhone()).ifPresent((customer) -> {
            throw new ConflictException("There is already a registration with this phone");
        });

        var password = passwordEncoder.encode(data.getPassword());
        data.setPassword(password);

        CustomerEntity customer = this.modelMapper.map(data, CustomerEntity.class);

        var result = repository.save(customer);

        return this.modelMapper.map(result, CustomerResponseDTO.class);
    }
}
