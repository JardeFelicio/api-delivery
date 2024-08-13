package com.jardefelicio.api_orders.modules.customer.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jardefelicio.api_orders.modules.customer.dtos.CustomerResponseDTO;
import com.jardefelicio.api_orders.modules.customer.repository.CustomerRepository;
import com.jardefelicio.api_orders.shared.exception.NotFoundException;

@Service
public class CustomerFindByIdService {
    @Autowired
    private CustomerRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public CustomerResponseDTO execute(Long id) {
        var result = this.repository.findById(id).orElseThrow(
                () -> new NotFoundException("Customer not found")
        );

        return this.modelMapper.map(result, CustomerResponseDTO.class);

    }
}
