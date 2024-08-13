package com.jardefelicio.api_orders.modules.customer.controllers;

import com.jardefelicio.api_orders.modules.customer.dtos.CustomerResponseDTO;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jardefelicio.api_orders.modules.customer.dtos.CustomerUpdateDTO;
import com.jardefelicio.api_orders.modules.customer.services.CustomerFindByIdService;
import com.jardefelicio.api_orders.modules.customer.services.CustomerUpdateService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/customer/")
@SecurityRequirement(name = "bearer-key")
@PreAuthorize("hasRole('CUSTOMER')")
@Tag(name = "customer")
public class CustomerController {
    @Autowired
    private CustomerUpdateService customerUpdate;
    @Autowired
    private CustomerFindByIdService customerFindById;

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody @Valid CustomerUpdateDTO data, HttpServletRequest request) {
        try {
            var customerId = request.getAttribute("id");
            Long customerIdLong = Long.parseLong(customerId.toString());
            var result = customerUpdate.execute(data, customerIdLong);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping()
    public ResponseEntity<Object> findById(HttpServletRequest request) {
        var customerId = request.getAttribute("id");
        Long customerIdLong = Long.parseLong(customerId.toString());
        CustomerResponseDTO result = customerFindById.execute(customerIdLong);
        return ResponseEntity.ok(result);
    }
}
