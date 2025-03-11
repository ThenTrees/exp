package com.thentrees.orderservice.controller;

import com.thentrees.orderservice.dtos.request.OrderRequest;
import com.thentrees.orderservice.entities.Order;
import com.thentrees.orderservice.repository.OrderRepository;
import com.thentrees.orderservice.utils.VaultEncryptConverter;
import com.thentrees.orderservice.temporal.workflow.OrderWorkflow;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
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
    private final RabbitTemplate rabbitTemplate;

//    @PostMapping("/create")
//    public String createOrder(@RequestParam String orderId) {
//        WorkflowOptions options = WorkflowOptions.newBuilder()
//                .setWorkflowId(orderId) // Đảm bảo mỗi order có ID duy nhất
//                .setTaskQueue("ORDER_TASK_QUEUE") // Trùng với queue của worker
//                .build();
//
//        OrderWorkflow workflow = workflowClient.newWorkflowStub(OrderWorkflow.class, options);
//
//        WorkflowClient.start(workflow::processOrder, orderId);
//
//        return "Order processing started for " + orderId;
//    }


    @PostMapping("/new")
    public String createOrder(@RequestBody OrderRequest request) {
        // Khởi chạy workflow Temporal
        OrderWorkflow workflow = workflowClient.newWorkflowStub(
                OrderWorkflow.class,
                WorkflowOptions.newBuilder().setTaskQueue("ORDER_TASK_QUEUE")
                        .setWorkflowId(request.getOrderId())
                        .build()
        );
        String result = workflow.processOrder(request);

        // Gửi order vào RabbitMQ
//        rabbitTemplate.convertAndSend("order.queue", orderId);
        return result;
    }
}
