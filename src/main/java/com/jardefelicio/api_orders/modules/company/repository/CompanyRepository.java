package com.jardefelicio.api_orders.modules.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jardefelicio.api_orders.modules.company.entity.CompanyEntity;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {
    Optional<CompanyEntity> findByEmail(String email);
    Optional<CompanyEntity> findByDocument(String document);

}
