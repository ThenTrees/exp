package com.thentrees.orderservice.controller;

import com.thentrees.orderservice.dtos.request.OrderRequest;
import com.thentrees.orderservice.entities.Order;
import com.thentrees.orderservice.repository.OrderRepository;
import com.thentrees.orderservice.utils.VaultEncryptConverter;
import com.thentrees.orderservice.workflow.OrderWorkflow;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final WorkflowClient workflowClient;
    private final OrderRepository orderRepository;
    private final VaultEncryptConverter vaultTransit;

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
        workflow.setCompleteOrder(orderId);
        return ResponseEntity.ok("Order is being completed.");
    }

    @PostMapping("/cancel-order")
    public ResponseEntity<String> orderCancel(@RequestParam("orderId") String orderId) {
        // Tạo Workflow stub
        OrderWorkflow workflow = workflowClient.newWorkflowStub(
                OrderWorkflow.class,"ORDER"
        );
        // Chạy workflow bất đồng bộ
        workflow.setCancelOrder(orderId);
        return ResponseEntity.ok("Order is being cancelled");
    }

    @PostMapping("/deliver-order")
    public ResponseEntity<String> orderDeliver(@RequestParam("orderId") String orderId) {
        // Tạo Workflow stub
        OrderWorkflow workflow = workflowClient.newWorkflowStub(
                OrderWorkflow.class,"ORDER"
        );
        // Chạy workflow bất đồng bộ
        workflow.setDeliverOrder(orderId);
        return ResponseEntity.ok("Order delivery is being processed");
    }

    @PostMapping("/process-order")
    public ResponseEntity<String> orderProcessing(@RequestParam("orderId") String orderId) {
        // Tạo Workflow stub
        OrderWorkflow workflow = workflowClient.newWorkflowStub(
                OrderWorkflow.class,"ORDER"
        );
        // Chạy workflow bất đồng bộ
        workflow.setProcessingOrder(orderId);
        return ResponseEntity.ok("Order is being processed, wait for delivery");
    }

    @PostMapping("/insert-order")
    public ResponseEntity<String> insertOrder(@RequestBody OrderRequest request) {

        log.info("Card number controller: " + request.getCardNumber());

        Order order = Order.builder()
                .cardNumber(request.getCardNumber())
                .nameCustomer(request.getNameCustomer())
                .productId(request.getProductId())
                .quantity(request.getQuantity())
                .build();

        orderRepository.save(order);
        return ResponseEntity.ok("Order is being inserted");
    }

    @GetMapping
    public ResponseEntity<List<Order>> getOrder() {
        return ResponseEntity.ok(orderRepository.findAll());
    }


}
