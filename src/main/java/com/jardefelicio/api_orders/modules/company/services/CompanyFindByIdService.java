package com.jardefelicio.api_orders.modules.company.services;

import com.jardefelicio.api_orders.modules.company.dtos.CompanyResponseDTO;
import com.jardefelicio.api_orders.modules.company.entity.CompanyEntity;
import com.jardefelicio.api_orders.modules.company.repository.CompanyRepository;
import com.jardefelicio.api_orders.shared.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyFindByIdService {
    @Autowired
    private CompanyRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    public CompanyResponseDTO execute(Long companyId) {
        CompanyEntity company = this.repository.findById(companyId)
                .orElseThrow(() -> new NotFoundException("company not found"));

        return modelMapper.map(company, CompanyResponseDTO.class);
    }
}
