package com.example.springbootrest.model.response;

import lombok.Data;

@Data
public class UserDetailsResponseModel {

    private String userId;
    private String firstname;
    private String lastname;
    private String username;
    private String email;


}
