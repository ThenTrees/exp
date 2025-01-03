package com.thentrees.accountservice.controller;

import com.thentrees.accountservice.model.AccountDTO;
import com.thentrees.accountservice.model.MessageDTO;
import com.thentrees.accountservice.model.StatisticDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    KafkaTemplate<String, Object> kafkaTemplate; // key:string, value:Object

    @PostMapping("/new")
    public AccountDTO create(@RequestBody AccountDTO accountDTO) {

        StatisticDTO statisticDTO = new StatisticDTO("Account "+accountDTO.getEmail()+" is created", new Date());
        statisticDTO.setStatus(false);

        // send notification
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setTo(accountDTO.getEmail());
        messageDTO.setToName(accountDTO.getName());
        messageDTO.setSubject("Welcome to our service of Thentrees");
        messageDTO.setContent("Thentrees is learning kafka");

        kafkaTemplate.send("notification", messageDTO);
        kafkaTemplate.send("statistic", statisticDTO);
        return accountDTO;
    }

    @GetMapping("/get")
    public String get() {
        return "Hello";
    }
}
