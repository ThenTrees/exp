package com.thentrees.orderservice.enums;


import lombok.Getter;

@Getter
public enum StatusOrder {
    PENDING,
    PROCESSING,
    DELIVERED,
    CANCELLED,
    COMPLETED
}
