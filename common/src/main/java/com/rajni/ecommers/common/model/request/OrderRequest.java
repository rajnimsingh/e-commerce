package com.rajni.ecommers.common.model.request;

import com.rajni.ecommers.common.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class OrderRequest {
    private User user;
    private int itemId;
}
