package com.example.springbootrest.service;

import com.example.springbootrest.model.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {


    UserDTO createUser(UserDTO userDTO);

    UserDTO getByUsername(String username);
}
