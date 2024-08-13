package com.jardefelicio.api_orders.modules.company.services;

import com.jardefelicio.api_orders.modules.company.dtos.CompanyResponseDTO;
import com.jardefelicio.api_orders.modules.company.repository.CompanyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyFindAllService {
    @Autowired
    private CompanyRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    public List<CompanyResponseDTO> execute() {
        return this.repository.findAll().stream()
                .map(company -> this.modelMapper.map(
                        company, CompanyResponseDTO.class))
                .collect(Collectors.toList());
    }
}
