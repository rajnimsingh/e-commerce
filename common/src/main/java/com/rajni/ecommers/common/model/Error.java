package com.rajni.ecommers.common.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Error {
    private final int code;
    private final String message;
}
