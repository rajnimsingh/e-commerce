package com.rajni.paymentservice.service;

import com.rajni.paymentservice.model.PaymentException;

public interface PaymentService {
    String makePayment(double amount) throws PaymentException;
}
