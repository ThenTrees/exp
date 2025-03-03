package com.thentrees.orderservice.activities;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

@ActivityInterface
public interface OrderActivities {

    @ActivityMethod
    void processPayment(Long orderId);

    @ActivityMethod
    void checkInventory(String productId, int quantity);

    @ActivityMethod
    void shipOrder(Long orderId);

    @ActivityMethod
    void sendNotification(Long orderId, String message);
}