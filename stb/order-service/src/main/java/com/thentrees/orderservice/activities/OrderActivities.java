package com.thentrees.orderservice.activities;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

@ActivityInterface
public interface OrderActivities {

    @ActivityMethod
    void processPayment(String orderId);

    @ActivityMethod
    void checkInventory(String productId, int quantity);

    @ActivityMethod
    void shipOrder(String orderId);

    @ActivityMethod
    void sendNotification(String orderId, String message);
}