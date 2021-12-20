package com.example.springbootrest.model.response;

import com.example.springbootrest.model.dto.RoleDTO;
import com.example.springbootrest.model.entity.RoleEntity;
import lombok.Data;

import java.util.List;

@Data
public class UserDetailsResponseModel {

    private String userId;
    private String firstname;
    private String lastname;
    private String username;
    private String email;

    private List<RoleDTO> roles;


}
