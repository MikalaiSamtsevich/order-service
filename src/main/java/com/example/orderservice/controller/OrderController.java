package com.example.orderservice.controller;

import com.example.orderservice.model.Order;
import com.example.orderservice.model.OrderPlacedEvent;
import com.example.orderservice.repo.OrderRepo;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Slf4j
@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepo orderRepo;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @SneakyThrows
    @GetMapping("/{id}/{sleep}")
    public Order getOrder(@PathVariable Long id, @PathVariable Long sleep) {
        log.error("HALLOO");
        log.debug("HALLOO");
        log.info("HALLOO");
        Thread.sleep(1000 * sleep);
        return orderRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid id: %d".formatted(id)));
    }

    @PostMapping
    public void placeOrder(){
        OrderPlacedEvent event = new OrderPlacedEvent(1L, 1L, ZonedDateTime.now(), BigDecimal.TEN);
        kafkaTemplate.send("public.order.orders.v1", event);
    }
}
