package com.example.springbootrest.model.request;

import lombok.Data;

@Data
public class UserUpdateRequestModel {

    private String userId;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
}
