package com.rajni.ecommers.common.model.response;

import com.rajni.ecommers.common.model.Error;
import com.rajni.ecommers.common.model.Status;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PaymentResponse {

    private final String paymentId;
    private final Status paymentStatus;
    private final Error error;

}
