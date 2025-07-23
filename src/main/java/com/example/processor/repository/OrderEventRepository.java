package com.example.processor.repository;

import com.example.processor.model.OrderEvent;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
//create OrderEventRepository implementation for reactive CRUD operations
import org.springframework.stereotype.Repository;

public interface OrderEventRepository extends ReactiveCrudRepository<OrderEvent, Long> {
}

