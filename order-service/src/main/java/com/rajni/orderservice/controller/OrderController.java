package com.rajni.orderservice.controller;

import com.rajni.ecommers.common.model.request.OrderRequest;
import com.rajni.ecommers.common.model.response.OrderResponse;
import com.rajni.ecommers.common.model.Status;
import com.rajni.orderservice.model.OrderException;
import com.rajni.orderservice.service.OrderService;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {

    private static final Logger LOG = LoggerFactory.getLogger(OrderController.class.getName());
    private OrderService orderService;

    private MeterRegistry meterRegistry;

    @PostMapping("/place-order")
    public OrderResponse placeOrder(@RequestBody OrderRequest orderRequest) {
        try {
            meterRegistry.counter("place-order").increment();
            LOG.info("place Order execution starts.");
            LOG.info("Order placed for the item Id, {} by the user {}", orderRequest.getItemId(), orderRequest.getUser().getUserId());
            return OrderResponse.builder()
                    .orderId(orderService.placeOrder(orderRequest.getUser(), orderRequest.getItemId()))
                    .itemId(orderRequest.getItemId())
                    .orderStatus(Status.SUCCESSFUL)
                    .build();
        } catch (OrderException e) {
            LOG.error("place Order execution fails.");
            LOG.error("Exception occurred in placing order for item, {} by the user {}", orderRequest.getItemId(), orderRequest.getUser().getUserId(), e);
            return OrderResponse.builder()
                    .itemId(orderRequest.getItemId())
                    .orderStatus(Status.FAILED)
                    .build();
        }
    }
}
