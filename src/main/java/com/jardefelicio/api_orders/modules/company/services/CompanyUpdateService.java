package com.jardefelicio.api_orders.modules.company.services;

import com.jardefelicio.api_orders.modules.company.dtos.CompanyResponseDTO;
import com.jardefelicio.api_orders.modules.company.dtos.CompanyUpdateDTO;
import com.jardefelicio.api_orders.modules.company.entity.CompanyEntity;
import com.jardefelicio.api_orders.modules.company.repository.CompanyRepository;
import com.jardefelicio.api_orders.shared.exception.ConflictException;
import com.jardefelicio.api_orders.shared.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyUpdateService {
    @Autowired
    private CompanyRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    public CompanyResponseDTO execute(CompanyUpdateDTO data, Long id) {
        CompanyEntity company = this.repository.findById(id).orElseThrow(
                () -> new NotFoundException("company not found")
        );

        if (!(data.getEmail().equals(company.getEmail())))
            this.repository.findByEmail(data.getEmail()).orElseThrow(
                    () -> new ConflictException("There is already a company with the email provided")
            );

        CompanyEntity newCompany = this.modelMapper.map(data, CompanyEntity.class);
        newCompany.setDocument(company.getDocument());

        this.repository.save(newCompany);

        return this.modelMapper.map(newCompany, CompanyResponseDTO.class);
    }
}
