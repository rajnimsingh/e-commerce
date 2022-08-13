package com.rajni.ecommers.common.model.response;

import com.rajni.ecommers.common.model.Error;
import com.rajni.ecommers.common.model.Status;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class NotificationResponse {
    private final String notificationId;
    private final Status notificationStatus;
    private final Error error;
}
