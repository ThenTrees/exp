package com.thentrees.notificationservice.service;

import com.thentrees.notificationservice.model.MessageDTO;

public interface EmailService {
    void sendEmail(MessageDTO messageDTO);
}
