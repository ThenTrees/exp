package com.thentrees.orderservice.workflow;

import com.thentrees.orderservice.dtos.request.OrderRequest;
import io.temporal.workflow.QueryMethod;
import io.temporal.workflow.SignalMethod;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface OrderWorkflow {

    @WorkflowMethod
    String processOrder(String orderId);

    @SignalMethod
    void rollbackOrder(String orderId);

}
