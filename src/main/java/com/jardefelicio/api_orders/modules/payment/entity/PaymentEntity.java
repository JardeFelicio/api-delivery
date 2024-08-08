package com.jardefelicio.api_orders.modules.payment.entity;

import java.math.BigDecimal;

import com.jardefelicio.api_orders.modules.order.entity.OrderEntity;
import com.jardefelicio.api_orders.modules.payment.enums.PaymentMethod;
import com.jardefelicio.api_orders.modules.payment.enums.PaymentStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "payments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentEntity {
    @Id
    @GeneratedValue
    private Long id;

    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;
    
    private PaymentMethod method;
    private PaymentStatus status;

}
