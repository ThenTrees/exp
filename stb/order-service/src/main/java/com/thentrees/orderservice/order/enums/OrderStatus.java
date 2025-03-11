package com.thentrees.orderservice.order.enums;


import lombok.Getter;

@Getter
public enum StatusOrder {
    PENDING,
    PROCESSING,
    DELIVERED,
    CANCELLED,
    COMPLETED
}
