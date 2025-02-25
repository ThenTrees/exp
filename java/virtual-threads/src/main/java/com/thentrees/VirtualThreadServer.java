package com.thentrees;

import java.util.concurrent.Executors;

public class VirtualThreadServer {
    public static void main(String[] args) {
        var executor = Executors.newVirtualThreadPerTaskExecutor(); // Sử dụng Virtual Threads

        for (int i = 0; i < 100; i++) {
            int clientId = i;
            executor.submit(() -> {
                System.out.println("Handling client " + clientId + " on " + Thread.currentThread().getName());
                simulateRequestProcessing();
            });
        }

        executor.shutdown();
    }
    private static void simulateRequestProcessing() {
        try {
            Thread.sleep(1000); // Mô phỏng xử lý I/O
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
