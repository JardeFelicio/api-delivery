package com.jardefelicio.api_orders.modules.auth.services;

import com.jardefelicio.api_orders.modules.auth.dtos.AuthRequestDTO;
import com.jardefelicio.api_orders.modules.auth.dtos.AuthResponseDTO;
import com.jardefelicio.api_orders.modules.company.services.CompanyFindByEmailService;
import com.jardefelicio.api_orders.shared.config.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.security.sasl.AuthenticationException;
import java.util.List;

@Service
public class AuthCompanyService {
    @Autowired
    private CompanyFindByEmailService companyFindByEmail;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private TokenService tokenService;

    public AuthResponseDTO execute(AuthRequestDTO data) throws AuthenticationException {
        var company = this.companyFindByEmail.execute(data.getEmail()).orElseThrow(
                () -> new UsernameNotFoundException("Username or password incorrect"));

        var passwordMatches = this.passwordEncoder
                .matches(data.getPassword(), company.getPassword());

        if (!passwordMatches) {
            throw new AuthenticationException("Username or password incorrect");
        }

        var roles = List.of("COMPANY");

        return tokenService.generateToken(company.getId().toString(), roles);
    }
}
