package com.example.processor.service;

import com.example.processor.model.OrderEvent;
import com.example.processor.repository.OrderEventRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class OrderEventProcessor {

    private final OrderEventRepository repository;

    public OrderEventProcessor(OrderEventRepository repository) {
        this.repository = repository;
    }

    public Mono<OrderEvent> process(OrderEvent event) {
        return validate(event)
                .flatMap(this::normalize)
                .flatMap(this::enrich)
                .flatMap(repository::save);
    }

    private Mono<OrderEvent> validate(OrderEvent event) {
        if (event.getCustomerId() == null || event.getProductId() == null) {
            return Mono.error(new IllegalArgumentException("Invalid order event"));
        }
        return Mono.just(event);
    }

    private Mono<OrderEvent> normalize(OrderEvent event) {
        event.setProductId(event.getProductId().trim().toUpperCase());
        return Mono.just(event);
    }

    private Mono<OrderEvent> enrich(OrderEvent event) {
        event.setStatus("PROCESSED");
        return Mono.just(event);
    }
}

