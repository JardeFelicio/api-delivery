package com.jardefelicio.api_orders.modules.company.services;

import com.jardefelicio.api_orders.modules.company.dtos.CompanyResponseDTO;
import com.jardefelicio.api_orders.shared.exception.ConflictException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jardefelicio.api_orders.modules.company.dtos.CompanyCreateDTO;
import com.jardefelicio.api_orders.modules.company.entity.CompanyEntity;
import com.jardefelicio.api_orders.modules.company.repository.CompanyRepository;

@Service
public class CompanyCreateService {
    @Autowired
    private CompanyRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ModelMapper modelMapper;

    public CompanyResponseDTO execute(CompanyCreateDTO data) {
        this.repository.findByDocument(data.getDocument()).ifPresent(
                company -> {
                    throw new ConflictException("There is already a company with the document provided");
                }
        );

        this.repository.findByEmail(data.getEmail()).ifPresent(
                company -> {
                    throw new ConflictException("There is already a company with the email provided");
                }
        );

        var password = passwordEncoder.encode(data.getPassword());
        data.setPassword(password);

        CompanyEntity company = this.modelMapper.map(data, CompanyEntity.class);

        var result = this.repository.save(company);

        return modelMapper.map(result, CompanyResponseDTO.class);
    }
}
