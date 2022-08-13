package com.rajni.ecommers.common.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import static com.rajni.ecommers.common.utils.EcommerceServiceConstants.*;

@Getter
@AllArgsConstructor
public enum Message {

    SUCCESS(ORDER_SUCCESS_SUBJECT, ORDER_SUCCESS_BODY), FAILED(ORDER_FAILED_SUBJECT, ORDER_FAILED_BODY);

    private final String subject;
    private final String body;

}
