package com.rajni.orderservice.model;

public class OrderException extends Exception {
    public OrderException() {
        super();
    }

    public OrderException(String message) {
        super(message);
    }
}
