package com.example.springbootrest.model.request;

import lombok.Data;

@Data
public class UserLoginRequestModel {

    private String username;
    private String password;
}
