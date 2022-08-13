package com.rajni.ecommers.common.model.request;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class HttpRequest {
    private final String uri;
    private final String body;
}
