package com.jardefelicio.api_orders.modules.customer.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEntity {
    
    @Id
    @GeneratedValue
    private Long id;
    
    private String name;
    private String password;
    private String email;
    private String phone;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
