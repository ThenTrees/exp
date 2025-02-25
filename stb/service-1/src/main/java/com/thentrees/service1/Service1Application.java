package com.thentrees.service1;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RefreshScope
@RestController
@Slf4j
public class Service1Application {

    @Value("${message}") // nam o file cau hinh tren repo github
    private String message;

    @Value("${API_KEY}") // nam o file cau hinh tren vault
    private String apiKey;

    @PostConstruct
    public void init() {
        log.info("API_KEY: " + apiKey);
    }

    public static void main(String[] args) {
        SpringApplication.run(Service1Application.class, args);
    }

    @GetMapping("/message")
    public String getMessage() {
        return message;
    }
}
