package com.example.springbootrest.model.request;

import lombok.Data;

import java.util.List;

@Data
public class UserDetailsRequestModel {

    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String email;
    private List<AddressRequestModel> addresses;
}
