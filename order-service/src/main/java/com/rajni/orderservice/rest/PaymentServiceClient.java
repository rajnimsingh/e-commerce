package com.rajni.orderservice.rest;

import com.rajni.ecommers.common.model.request.PaymentRequest;
import com.rajni.ecommers.common.model.response.PaymentResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@AllArgsConstructor
public class PaymentServiceClient {
    private static final String SERVICE_URL = "http://payment-service:8060/payment";

    private final RestTemplate restTemplate;

    public PaymentResponse makePayment(PaymentRequest paymentRequest) {
        return restTemplate.postForObject(SERVICE_URL+"/make-payment", paymentRequest, PaymentResponse.class);
    }
}
