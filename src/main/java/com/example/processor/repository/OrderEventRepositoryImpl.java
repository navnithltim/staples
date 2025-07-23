package com.example.processor.repository;

import com.example.processor.model.OrderEvent;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

//@Repository
//public class OrderEventRepositoryImpl implements OrderEventRepository {
//
//    private final DatabaseClient databaseClient;
//
//    public OrderEventRepositoryImpl(DatabaseClient databaseClient) {
//        this.databaseClient = databaseClient;
//    }
//
//    @Override
//    public Mono<OrderEvent> save(OrderEvent orderEvent) {
//        return databaseClient.sql("INSERT INTO order_events (order_id, product, quantity, status) VALUES (:orderId, :product, :quantity, :status)")
//                .bind("orderId", orderEvent.getOrderId())
//                .bind("product", orderEvent.getProduct())
//                .bind("quantity", orderEvent.getQuantity())
//                .bind("status", orderEvent.getStatus())
//                .fetch()
//                .rowsUpdated()
//                .map(rows -> orderEvent);
//    }
//}
//
