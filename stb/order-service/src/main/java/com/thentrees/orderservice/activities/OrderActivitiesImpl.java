package com.thentrees.orderservice.activities;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderActivitiesImpl implements OrderActivities {

    @Override
    public void processPayment(String orderId) {
        // Gọi Payment Service
        log.info("Processing payment for order: " + orderId);
    }

    @Override
    public void checkInventory(String productId, int quantity) {
        // Gọi Inventory Service
        log.info("Checking inventory for product: " + productId);
    }

    @Override
    public void shipOrder(String orderId) {
        // Gọi Shipping Service
        log.info("Shipping order: " + orderId);
    }

    @Override
    public void sendNotification(String orderId, String message) {
        // Gửi email
        log.info("Sending notification: " + message);
    }
}