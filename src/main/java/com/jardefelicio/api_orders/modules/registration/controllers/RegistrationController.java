package com.jardefelicio.api_orders.modules.registration.controllers;

import com.jardefelicio.api_orders.modules.company.dtos.CompanyCreateDTO;
import com.jardefelicio.api_orders.modules.company.dtos.CompanyResponseDTO;
import com.jardefelicio.api_orders.modules.company.services.CompanyCreateService;
import com.jardefelicio.api_orders.modules.customer.dtos.CustomerCreateDTO;
import com.jardefelicio.api_orders.modules.customer.dtos.CustomerResponseDTO;
import com.jardefelicio.api_orders.modules.customer.services.CustomerCreateService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("registration/")
@Tag(name = "registration")
public class RegistrationController {
    @Autowired
    private CustomerCreateService customerCreateService;
    @Autowired
    private CompanyCreateService companyCreateService;

    @PostMapping("customer")
    public ResponseEntity<Object> createCustomer(@RequestBody @Valid CustomerCreateDTO data, UriComponentsBuilder uriBuilder){
        try{
            CustomerResponseDTO result = this.customerCreateService.execute(data);

            URI path = uriBuilder.path("/customer/{id}").buildAndExpand(result.getId()).toUri();

            return ResponseEntity.created(path).body(result);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("company")
    public ResponseEntity<Object> createCompany(@RequestBody @Valid CompanyCreateDTO data, UriComponentsBuilder uriBuilder){
        try{
            CompanyResponseDTO result = this.companyCreateService.execute(data);

            URI path = uriBuilder.path("/company/{id}").buildAndExpand(result.getId()).toUri();

            return ResponseEntity.created(path).body(result);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
