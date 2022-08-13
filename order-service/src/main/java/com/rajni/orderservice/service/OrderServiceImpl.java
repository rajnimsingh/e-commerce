package com.rajni.orderservice.service;

import com.rajni.ecommers.common.model.Message;
import com.rajni.ecommers.common.model.Status;
import com.rajni.ecommers.common.model.User;
import com.rajni.ecommers.common.model.request.NotificationRequest;
import com.rajni.ecommers.common.model.request.PaymentRequest;
import com.rajni.ecommers.common.model.response.ItemResponse;
import com.rajni.ecommers.common.model.response.PaymentResponse;
import com.rajni.ecommers.common.utils.EcommerceServiceConstants;
import com.rajni.orderservice.model.OrderException;
import com.rajni.orderservice.rest.InventoryServiceClient;
import com.rajni.orderservice.rest.NotificationServiceClient;
import com.rajni.orderservice.rest.PaymentServiceClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final InventoryServiceClient inventoryServiceClient;

    private final NotificationServiceClient notificationServiceClient;

    private final PaymentServiceClient paymentServiceClient;

    @Override
    public String placeOrder(User user, int itemID) throws OrderException {
        log.info("OrderService.placeOrder starts for itemID {} by the user {}", itemID, user.getUserId());
        final double price = getItemPrice(itemID);
        final Status status = makePayment(user.getUserId(), price);
        if (status == Status.SUCCESSFUL) {
            sendNotification(user.getEmail(), Message.SUCCESS);
            log.info("OrderService.placeOrder is successful for itemID {} by the user {}", itemID, user.getUserId());
            return UUID.randomUUID().toString();
        }
        sendNotification(user.getEmail(), Message.FAILED);
        log.error("OrderService.placeOrder failed for itemID {} by the user {}", itemID, user.getUserId());
        throw new OrderException(EcommerceServiceConstants.ORDER_FAILED_BODY);
    }

    private double getItemPrice(int itemId) throws OrderException {
        log.info("OrderService.getItemPrice starts for itemID {} ", itemId);
        final ItemResponse itemResponse = inventoryServiceClient.getItem(itemId);
        if (itemResponse.isAvailable()) {
            log.info("OrderService.getItemPrice is successful for itemID {} ", itemId);
            return itemResponse.getItemPrice();
        }
        log.info("OrderService.getItemPrice fails for itemID {} ", itemId);
        throw new OrderException(itemResponse.getError().getMessage());
    }

    private Status makePayment(final String userId, final double price) {
        log.info("OrderService.makePayment starts for price {} by the user {} ", price, userId);
        final PaymentRequest paymentRequest = PaymentRequest.builder().userId(userId).amount(price).build();
        final PaymentResponse paymentResponse = paymentServiceClient.makePayment(paymentRequest);
        log.info("OrderService.makePayment finishes for price {} by the user {} ", price, userId);
        return paymentResponse.getPaymentStatus();
    }

    private void sendNotification(final String recipient, final Message message) {
        log.info("OrderService.sendNotification executing for message {} ", message);
        notificationServiceClient.sendNotification(NotificationRequest.builder()
                .recipient(recipient)
                .subject(message.getSubject())
                .body(message.getBody())
                .build());
    }
}

