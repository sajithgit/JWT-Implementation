package com.internal.jwtapi.request;

import lombok.Data;

@Data
public class UserRequest {

    private String userName;
    private String password;
    private String token;
}
