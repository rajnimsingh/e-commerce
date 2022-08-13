package com.rajni.ecommers.common.model.request;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class NotificationRequest {
    private final String recipient;
    private final String subject;
    private final String body;
}
