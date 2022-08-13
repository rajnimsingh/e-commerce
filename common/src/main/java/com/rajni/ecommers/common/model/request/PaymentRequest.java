package com.rajni.ecommers.common.model.request;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PaymentRequest {
    private final String userId;
    private final double amount;
}
