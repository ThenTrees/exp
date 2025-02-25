package com.thentrees.orderservice.workflow;

import com.thentrees.orderservice.dtos.request.OrderRequest;
import io.temporal.workflow.QueryMethod;
import io.temporal.workflow.SignalMethod;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface OrderWorkflow {

    @WorkflowMethod
    void processOrder(OrderRequest request);

    @SignalMethod
    void cancelOrder(String orderId);

    @SignalMethod
    void completeOrder(String orderId);

    @SignalMethod
    void deliverOrder(String orderId);

    @SignalMethod
    void processingOrder(String orderId);

    @QueryMethod
    String getOrderStatus();
}
