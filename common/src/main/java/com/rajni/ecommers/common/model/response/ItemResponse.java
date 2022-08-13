package com.rajni.ecommers.common.model.response;

import com.rajni.ecommers.common.model.Error;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ItemResponse {
    private final boolean available;
    private final double itemPrice;
    private final Error error;
}
