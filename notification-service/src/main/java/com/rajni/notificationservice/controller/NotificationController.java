package com.rajni.notificationservice.controller;

import com.rajni.ecommers.common.model.Error;
import com.rajni.ecommers.common.model.Status;
import com.rajni.ecommers.common.model.request.NotificationRequest;
import com.rajni.ecommers.common.model.response.NotificationResponse;
import com.rajni.notificationservice.model.NotificationException;
import com.rajni.notificationservice.service.NotificationService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
@AllArgsConstructor
public class NotificationController {
    private static final Logger LOG = LoggerFactory.getLogger(NotificationController.class);

    private NotificationService notificationService;

    @PostMapping("/send-notification")
    public NotificationResponse sendNotification(@RequestBody NotificationRequest notificationRequest) {
        try {
            LOG.info("Sending notification to the user, {} with the subject {}", notificationRequest.getRecipient(), notificationRequest.getSubject());
            return NotificationResponse.builder()
                    .notificationId(notificationService.sendNotification(notificationRequest.getRecipient(), notificationRequest.getSubject(), notificationRequest.getBody()))
                    .notificationStatus(Status.SUCCESSFUL)
                    .build();
        } catch (NotificationException e) {
            LOG.error("Sending notification to the user, {} with the subject {} fails", notificationRequest.getRecipient(), notificationRequest.getSubject(), e);
            return NotificationResponse.builder()
                    .notificationStatus(Status.FAILED)
                    .error(Error.builder().message(e.getMessage()).build())
                    .build();
        }
    }
}
