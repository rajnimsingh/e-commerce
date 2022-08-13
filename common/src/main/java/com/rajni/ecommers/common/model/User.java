package com.rajni.ecommers.common.model;

import lombok.*;

@Builder
@AllArgsConstructor
@Data
public class User {
    private String userId;
    private String userName;
    private String email;
    private String password;
}
