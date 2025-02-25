package com.thentrees.orderservice.configuration;

import com.thentrees.orderservice.activities.OrderActivities;
import com.thentrees.orderservice.activities.OrderActivitiesImpl;
import com.thentrees.orderservice.workflow.OrderWorkflow;
import com.thentrees.orderservice.workflow.OrderWorkflowImpl;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowClientOptions;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfiguration {

    @Bean
    public WorkflowClient workflowClient() {
        return WorkflowClient.newInstance(
                WorkflowServiceStubs.newLocalServiceStubs(),
                WorkflowClientOptions.newBuilder()
                        .build()
        );
    }

    @Bean
    public WorkerFactory workerFactory(WorkflowClient workflowClient) {
        return WorkerFactory.newInstance(workflowClient);
    }

    @Bean
    public Worker orderWorker(WorkerFactory factory) {
        Worker worker = factory.newWorker("ORDER_TASK_QUEUE");
        worker.registerWorkflowImplementationTypes(OrderWorkflowImpl.class);
        worker.registerActivitiesImplementations(new OrderActivitiesImpl());
        factory.start();
        return worker;
    }
}
