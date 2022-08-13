package com.rajni.orderservice.rest;

import com.rajni.ecommers.common.model.request.NotificationRequest;
import com.rajni.ecommers.common.model.response.NotificationResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@AllArgsConstructor
public class NotificationServiceClient {
    private static final String SERVICE_URL = "http://notification-service:8090/notification";
    private final RestTemplate restTemplate;

    public NotificationResponse sendNotification(final NotificationRequest request) {
        return restTemplate.postForObject(SERVICE_URL + "/send-notification", request, NotificationResponse.class);
    }
}
