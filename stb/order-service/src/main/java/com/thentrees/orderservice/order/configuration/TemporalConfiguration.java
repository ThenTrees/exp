package com.thentrees.orderservice.configuration;

import com.thentrees.orderservice.temporal.activities.impl.InventoryActivityImpl;
import com.thentrees.orderservice.temporal.workflow.OrderWorkflowImpl;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowClientOptions;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;
import org.apache.camel.ProducerTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TemporalConfiguration {
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
    public Worker orderWorker(WorkerFactory workerFactory, ProducerTemplate template) {
        Worker worker = workerFactory.newWorker("ORDER_TASK_QUEUE");
        worker.registerWorkflowImplementationTypes(OrderWorkflowImpl.class);
        worker.registerActivitiesImplementations(
                new InventoryActivityImpl(template)
        );
        workerFactory.start();
        return worker;
    }
}
