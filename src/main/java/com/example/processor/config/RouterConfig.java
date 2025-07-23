package com.example.processor.config;

import com.example.processor.handler.OrderEventHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

@Configuration
public class RouterConfig {

    @Bean
    public RouterFunction<ServerResponse> route(OrderEventHandler handler) {
        return RouterFunctions.route()
                .POST("/order-event", handler::handleOrderEvent)
                .onError(Exception.class, (e, req) -> ServerResponse.badRequest().bodyValue("Error: " + e.getMessage()))
                .build();
    }
}

