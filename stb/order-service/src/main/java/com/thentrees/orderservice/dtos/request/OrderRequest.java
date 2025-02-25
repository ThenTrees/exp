package com.thentrees.orderservice.dtos.request;

import com.thentrees.orderservice.enums.StatusOrder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
    private String orderId;
    private String productId;
    private int quantity;
}
