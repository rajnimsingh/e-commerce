package com.rajni.ecommers.common.model.response;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Builder
@Getter
public class HttpResponse {
    private final String body;
    private final HttpStatus httpStatus;
}
