package com.jardefelicio.api_orders.modules.auth.controllers;

import com.jardefelicio.api_orders.modules.auth.dtos.AuthRequestDTO;
import com.jardefelicio.api_orders.modules.auth.services.AuthCompanyService;
import com.jardefelicio.api_orders.modules.auth.services.AuthCustomerService;
import com.jardefelicio.api_orders.shared.exception.RestErrorMessage;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.sasl.AuthenticationException;

@RestController
@RequestMapping("/auth/")
@Tag(name = "auth")
public class AuthController {
    @Autowired
    private AuthCustomerService authCustomerService;
    @Autowired
    private AuthCompanyService authCompanyService;

    @PostMapping("customer")
    public ResponseEntity<Object> authCustomer(@RequestBody @Valid AuthRequestDTO data) {
        try {
            var token = this.authCustomerService.execute(data);
            return ResponseEntity.ok().body(token);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

    @PostMapping("company")
    public ResponseEntity<Object> authCompany(@RequestBody @Valid AuthRequestDTO data) {
        try {
            var token = this.authCompanyService.execute(data);
            return ResponseEntity.ok().body(token);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new RestErrorMessage(HttpStatus.UNAUTHORIZED, e.getMessage(), HttpStatus.UNAUTHORIZED.value()));
        }
    }
}
