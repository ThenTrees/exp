package com.thentrees.orderservice.service;

import com.thentrees.orderservice.utils.TracingTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ExampleLogService {

    @TracingTime
    public void AroundMethodTest() {
        log.info("Around method is running");
    }

    public void afterThrowing(){
        log.info(".... throw exception ....");
        throw new RuntimeException("Exception");
    }

}
