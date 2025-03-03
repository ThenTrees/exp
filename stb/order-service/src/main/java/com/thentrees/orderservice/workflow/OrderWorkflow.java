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

    //

    @SignalMethod
    void setCancelOrder(String orderId);

    @SignalMethod
    void setCompleteOrder(String orderId);

    @SignalMethod
    void setDeliverOrder(String orderId);

    @SignalMethod
    void setProcessingOrder(String orderId);

    @QueryMethod
    String getOrderStatus();
}
