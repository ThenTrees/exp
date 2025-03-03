package com.thentrees.orderservice.workflow;

import com.thentrees.orderservice.activities.OrderActivities;
import com.thentrees.orderservice.dtos.request.OrderRequest;
import com.thentrees.orderservice.enums.StatusOrder;
import com.thentrees.orderservice.utils.TracingTime;
import io.temporal.activity.ActivityOptions;
import io.temporal.common.RetryOptions;
import io.temporal.workflow.Workflow;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;

@Slf4j
public class OrderWorkflowImpl implements OrderWorkflow{

    private StatusOrder statusOrder = StatusOrder.PENDING;

    private final RetryOptions retryoptions = RetryOptions.newBuilder()
            .setInitialInterval(Duration.ofSeconds(1))
            .setMaximumInterval(Duration.ofSeconds(20))
            .setBackoffCoefficient(2)
            .setMaximumAttempts(10)
            .build();
    private final OrderActivities activities = Workflow.newActivityStub(
            OrderActivities.class,
            ActivityOptions.newBuilder()
                    .setStartToCloseTimeout(Duration.ofSeconds(10))
                    .setTaskQueue("ORDER_TASK_QUEUE")
                    .setRetryOptions(retryoptions)
                    .build()
            );

    @TracingTime
    @Override
    public void processOrder(OrderRequest request) {


        log.info("Order workflow started.");
        activities.checkInventory(request.getProductId(), request.getQuantity());
        log.info("Inventory checked.");
        Workflow.await(()-> statusOrder.equals(StatusOrder.PROCESSING));
        activities.processPayment(request.getOrderId());
        log.info("Payment processed.");
        Workflow.await(()-> statusOrder.equals(StatusOrder.DELIVERED));
        activities.shipOrder(request.getOrderId());
        log.info("Order shipped.");
        activities.sendNotification(Long.parseLong(String.valueOf(request.getOrderId())), "Your order being delivery for you!");
        log.info("Notification sent.");
        Workflow.await(()-> statusOrder.equals(StatusOrder.COMPLETED));
        log.info("Order workflow completed.");
    }

    @Override
    public void setCancelOrder(String orderId) {
        this.statusOrder = StatusOrder.CANCELLED;
        log.info("Order cancelled: " + orderId);
    }

    @Override
    public void setCompleteOrder(String orderId) {
        this.statusOrder = StatusOrder.COMPLETED;
        log.info("Order completed: " + orderId);
    }

    @Override
    public void setDeliverOrder(String orderId) {
        this.statusOrder = StatusOrder.DELIVERED;
        log.info("Order delivered: " + orderId);
    }

    @Override
    public void setProcessingOrder(String orderId) {
        this.statusOrder = StatusOrder.PROCESSING;
        log.info("Order processed: " + orderId);
    }

    @Override
    public String getOrderStatus() {
        return this.statusOrder.name();
    }
}
