package com.rajni.ecommers.common.model.response;

import com.rajni.ecommers.common.model.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class OrderResponse {
    private final String orderId;
    private final int itemId;
    private final Status orderStatus;
}
