package com.thentrees.orderservice.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
    private Long orderId;
    private String productId;
    private int quantity;
    private String nameCustomer;
    private String cardNumber;
}
