package com.rajni.notificationservice.service;

import com.rajni.notificationservice.model.NotificationException;

public interface NotificationService {
    String sendNotification(String recipient, String subject, String body) throws NotificationException;
}
