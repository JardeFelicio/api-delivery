package com.jardefelicio.api_orders.modules.auth.services;

import com.jardefelicio.api_orders.modules.auth.dtos.AuthRequestDTO;
import com.jardefelicio.api_orders.modules.auth.dtos.AuthResponseDTO;
import com.jardefelicio.api_orders.modules.customer.services.CustomerFindByEmailService;
import com.jardefelicio.api_orders.shared.config.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.security.sasl.AuthenticationException;
import java.util.Arrays;

@Service
public class AuthCustomerService {
    @Autowired
    private CustomerFindByEmailService customerFindByEmail;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenService tokenService;

    public AuthResponseDTO execute(AuthRequestDTO data) throws AuthenticationException {
        var customer = this.customerFindByEmail.execute(data.getEmail()).orElseThrow(
                () -> new UsernameNotFoundException("Username or password incorrect"));

        var passwordMatches = this.passwordEncoder
                .matches(data.getPassword(), customer.getPassword());

        if (!passwordMatches) {
            throw new AuthenticationException();
        }

        var roles = Arrays.asList("CUSTOMER");

        return tokenService.generateToken(customer.getId().toString(), roles);
    }
}
