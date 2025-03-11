package com.thentrees.orderservice.controller;

import com.thentrees.orderservice.service.ExampleLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
public class LogExample {

    @Autowired
    private ExampleLogService exampleLogService;

    @GetMapping("/around")
    public void aroundMethod() {
        exampleLogService.AroundMethodTest();
    }

    @GetMapping("/throw")
    public void throwException(){
        exampleLogService.afterThrowing();
    }

}
