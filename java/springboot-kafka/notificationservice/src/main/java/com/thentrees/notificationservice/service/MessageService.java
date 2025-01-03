package com.thentrees.notificationservice.service;

import com.thentrees.notificationservice.model.MessageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @KafkaListener(id = "notificationGroup", topics = "notification")
    public void listen(MessageDTO messageDTO){
        log.info("Received: ", messageDTO.getTo());
    }
}
