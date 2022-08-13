package com.rajni.paymentservice.service;

import com.rajni.ecommers.common.utils.EcommerceServiceConstants;
import com.rajni.paymentservice.model.PaymentException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String makePayment(double amount) throws PaymentException {
        log.info("PaymentService starts for the amount, {}", amount);
        if(amount <= 700) {
            return UUID.randomUUID().toString();
        }
        log.error("Payment failed, as this amount {} is not acceptable", amount);
        throw new PaymentException(EcommerceServiceConstants.PAYMENT_EXCEPTION);
    }
}
