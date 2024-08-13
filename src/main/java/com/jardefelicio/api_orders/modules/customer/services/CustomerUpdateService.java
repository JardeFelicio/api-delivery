package com.jardefelicio.api_orders.modules.customer.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jardefelicio.api_orders.modules.customer.dtos.CustomerResponseDTO;
import com.jardefelicio.api_orders.modules.customer.dtos.CustomerUpdateDTO;
import com.jardefelicio.api_orders.modules.customer.entity.CustomerEntity;
import com.jardefelicio.api_orders.modules.customer.repository.CustomerRepository;
import com.jardefelicio.api_orders.shared.exception.ConflictException;
import com.jardefelicio.api_orders.shared.exception.NotFoundException;

@Service
public class CustomerUpdateService {
    @Autowired
    private CustomerRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    public CustomerResponseDTO execute(CustomerUpdateDTO data, Long id) {
        var customerExists = repository.findById(id).orElseThrow(
                () -> new NotFoundException("The customer is not registered")
        );

        if (!customerExists.getEmail().equals(data.getEmail())) {
            this.repository.findByEmail(data.getEmail()).ifPresent((customer) -> {
                throw new ConflictException("There is already a registration with this email");
            });
        }

        if (!customerExists.getEmail().equals(data.getEmail())) {
            this.repository.findByPhone(data.getPhone()).ifPresent((customer) -> {
                throw new ConflictException("There is already a registration with this phone");
            });
        }

        CustomerEntity customer = this.modelMapper.map(data, CustomerEntity.class);

        var result = repository.save(customer);

        return this.modelMapper.map(result, CustomerResponseDTO.class);
    }
}
