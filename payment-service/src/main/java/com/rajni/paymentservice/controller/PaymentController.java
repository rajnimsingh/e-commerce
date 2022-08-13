package com.rajni.paymentservice.controller;

import com.rajni.ecommers.common.model.Error;
import com.rajni.ecommers.common.model.Status;
import com.rajni.ecommers.common.model.request.PaymentRequest;
import com.rajni.ecommers.common.model.response.PaymentResponse;
import com.rajni.paymentservice.model.PaymentException;
import com.rajni.paymentservice.service.PaymentService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/payment")
public class PaymentController {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentController.class);

    private final PaymentService paymentService;

    @PostMapping("/make-payment")
    public PaymentResponse makePayment(@RequestBody final PaymentRequest paymentRequest) {
        try {
            LOG.info("Making payment for the amount, {} by the user {}", paymentRequest.getAmount(), paymentRequest.getUserId());
            return PaymentResponse.builder()
                    .paymentId(paymentService.makePayment(paymentRequest.getAmount()))
                    .paymentStatus(Status.SUCCESSFUL)
                    .build();
        } catch (PaymentException e) {
            LOG.error("Payment fails for the amount, {} by the user, {}", paymentRequest.getAmount(), paymentRequest.getUserId());
            return PaymentResponse.builder()
                    .paymentStatus(Status.SUCCESSFUL)
                    .error(Error.builder().message(e.getMessage()).build())
                    .build();
        }
    }
}
