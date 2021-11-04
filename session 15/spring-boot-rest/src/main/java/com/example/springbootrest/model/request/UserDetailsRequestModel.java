package com.example.springbootrest.model.request;

import lombok.Data;

@Data
public class UserDetailsRequestModel {

    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String email;
}
