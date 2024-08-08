package com.jardefelicio.api_orders.modules.order.entity;

import java.math.BigDecimal;

import com.jardefelicio.api_orders.modules.address.entity.AddressEntity;
import com.jardefelicio.api_orders.modules.company.entity.CompanyEntity;
import com.jardefelicio.api_orders.modules.customer.entity.CustomerEntity;
import com.jardefelicio.api_orders.modules.order.enums.OrderStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "orders")
@Data
public class OrderEntity {
    @Id
    @GeneratedValue
    private Long id;

    private OrderStatus status;

    private BigDecimal totalAmount;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private AddressEntity address;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyEntity company;

}
