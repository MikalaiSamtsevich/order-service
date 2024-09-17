package com.example.orderservice.model;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

public record OrderPlacedEvent(Long id, Long customerId, ZonedDateTime orderDate, BigDecimal totalAmount) {
}

