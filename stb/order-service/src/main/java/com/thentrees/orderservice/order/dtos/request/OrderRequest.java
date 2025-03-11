package com.thentrees.orderservice.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
    private String orderId;
    private int quantity;
}
