package com.rajni.orderservice.service;

import com.rajni.ecommers.common.model.User;
import com.rajni.orderservice.model.OrderException;

public interface OrderService {

    String placeOrder(User user, int itemID) throws OrderException;
}
