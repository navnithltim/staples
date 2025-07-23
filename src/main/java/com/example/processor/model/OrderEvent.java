package com.example.processor.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
//create getters and setters for the fields
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Table("orders")
public class OrderEvent {
    @Id
    private Long id;
    private String orderId;
    private String product;
    private int quantity;
    private String status;
}

