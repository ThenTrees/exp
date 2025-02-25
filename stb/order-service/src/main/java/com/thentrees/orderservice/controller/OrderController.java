package com.thentrees.orderservice.controller;

import com.thentrees.orderservice.dtos.request.OrderRequest;
import com.thentrees.orderservice.workflow.OrderWorkflow;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final WorkflowClient workflowClient;

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody OrderRequest request) {
        // Tạo Workflow stub
        OrderWorkflow workflow = workflowClient.newWorkflowStub(
                OrderWorkflow.class,
                WorkflowOptions.newBuilder()
                        .setTaskQueue("ORDER_TASK_QUEUE")
                        .setWorkflowId("ORDER")
                        .build()
        );
        // Chạy workflow bất đồng bộ
        WorkflowClient.start(workflow::processOrder, request);
        return ResponseEntity.ok("Create order, wait for processing");
    }

    @PostMapping("/confirm-order")
    public ResponseEntity<String> orderComplete(@RequestParam("orderId") String orderId) {
        // Tạo Workflow stub
        OrderWorkflow workflow = workflowClient.newWorkflowStub(
                OrderWorkflow.class,"ORDER"
        );
        // Chạy workflow bất đồng bộ
        workflow.completeOrder(orderId);
        return ResponseEntity.ok("Order is being completed.");
    }

    @PostMapping("/cancel-order")
    public ResponseEntity<String> orderCancel(@RequestParam("orderId") String orderId) {
        // Tạo Workflow stub
        OrderWorkflow workflow = workflowClient.newWorkflowStub(
                OrderWorkflow.class,"ORDER"
        );
        // Chạy workflow bất đồng bộ
        workflow.cancelOrder(orderId);
        return ResponseEntity.ok("Order is being cancelled");
    }

    @PostMapping("/deliver-order")
    public ResponseEntity<String> orderDeliver(@RequestParam("orderId") String orderId) {
        // Tạo Workflow stub
        OrderWorkflow workflow = workflowClient.newWorkflowStub(
                OrderWorkflow.class,"ORDER"
        );
        // Chạy workflow bất đồng bộ
        workflow.deliverOrder(orderId);
        return ResponseEntity.ok("Order delivery is being processed");
    }

    @PostMapping("/process-order")
    public ResponseEntity<String> orderProcessing(@RequestParam("orderId") String orderId) {
        // Tạo Workflow stub
        OrderWorkflow workflow = workflowClient.newWorkflowStub(
                OrderWorkflow.class,"ORDER"
        );
        // Chạy workflow bất đồng bộ
        workflow.processingOrder(orderId);
        return ResponseEntity.ok("Order is being processed, wait for delivery");
    }


}
