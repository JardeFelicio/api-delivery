package com.jardefelicio.api_orders.modules.company.services;

import com.jardefelicio.api_orders.modules.company.entity.CompanyEntity;
import com.jardefelicio.api_orders.modules.company.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyFindByEmailService {
    @Autowired
    private CompanyRepository repository;
    public Optional<CompanyEntity> execute(String email){
        return this.repository.findByEmail(email);
    }
}
