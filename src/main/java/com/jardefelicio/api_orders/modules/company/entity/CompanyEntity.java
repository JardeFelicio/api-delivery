package com.jardefelicio.api_orders.modules.company.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "companies")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String document;
    private String email;
    private String password;
    private String phone;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
