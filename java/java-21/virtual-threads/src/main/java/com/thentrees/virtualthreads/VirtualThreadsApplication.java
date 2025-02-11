package com.thentrees.virtualthreads;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VirtualThreadsApplication {

    public static void main(String[] args) {
        Runnable task = () -> {
            System.out.println(Thread.currentThread().getName() + " is running");
        };

        for (int i = 0; i < 10; i++) {
            Thread thread = Thread.ofVirtual().start(task); // Tạo Virtual Thread
        }
    }

}
