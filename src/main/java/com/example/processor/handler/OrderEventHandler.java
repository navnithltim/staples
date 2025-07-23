package com.example.processor.handler;

import com.example.processor.model.OrderEvent;
import com.example.processor.service.OrderEventProcessor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class OrderEventHandler {

    private final OrderEventProcessor processor;

    public OrderEventHandler(OrderEventProcessor processor) {
        this.processor = processor;
    }

    public Mono<ServerResponse> handleOrderEvent(ServerRequest request) {
        return request.bodyToMono(OrderEvent.class)
                .flatMap(processor::process)
                .flatMap(saved -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(saved));
    }
}

