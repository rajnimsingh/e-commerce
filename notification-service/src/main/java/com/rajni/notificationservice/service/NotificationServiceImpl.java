package com.rajni.notificationservice.service;

import com.rajni.ecommers.common.utils.EcommerceServiceConstants;
import com.rajni.notificationservice.model.NotificationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class NotificationServiceImpl implements NotificationService {
    @Override
    public String sendNotification(String recipient, String subject, String body) throws NotificationException {
        log.info("Sending notification from Notification Service to the recipient {}, with subject {}", recipient, subject);
        if(recipient != null && recipient.length() <= 15 ) {
            return UUID.randomUUID().toString();
        }
        log.error("Sending notification from Notification Service to the recipient {}, with subject {} is failed due to invalid details.", recipient, subject);
        throw new NotificationException(EcommerceServiceConstants.INVALID_RECIPIENT);
    }
}
