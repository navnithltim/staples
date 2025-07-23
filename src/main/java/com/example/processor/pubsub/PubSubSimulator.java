package com.example.processor.pubsub;

import com.example.processor.model.OrderEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class PubSubSimulator {

    @Autowired
    private WebClient.Builder webClientBuilder;

    public void simulateOrderEvent(OrderEvent event) {
        webClientBuilder.build()
                .post()
                .uri("http://localhost:8080/order-event")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(event)
                .retrieve()
                .bodyToMono(String.class)
                .subscribe();
    }
}

