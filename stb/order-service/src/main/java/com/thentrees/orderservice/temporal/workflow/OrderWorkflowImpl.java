package com.thentrees.orderservice.workflow;

import com.thentrees.orderservice.activities.OrderActivity;
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
    private boolean rollbackRequested = false;

    private final OrderActivity orderActivity = Workflow.newActivityStub(
            OrderActivity.class,
            ActivityOptions.newBuilder()
                    .setStartToCloseTimeout(Duration.ofSeconds(10))
                    .setRetryOptions(RetryOptions.newBuilder()
                            .setMaximumAttempts(3)  // Retry tối đa 3 lần
                            .build())
                    .build());

    @Override
    public String processOrder(String orderId) {
        try {
            orderActivity.processPayment(orderId);
            orderActivity.checkInventory(orderId);
            orderActivity.shipOrder(orderId);
            orderActivity.sendNotification(orderId);
            return "Order processed!";
        } catch (Exception e) {
            Workflow.sleep(5000); // Chờ tín hiệu rollback từ bên ngoài
            return "Order failed!";
        }
    }

    @Override
    public void rollbackOrder(String orderId) {
        this.rollbackRequested=true;
        orderActivity.refundPayment(orderId);
        orderActivity.rollbackOrderActivity(orderId);
    }

}
