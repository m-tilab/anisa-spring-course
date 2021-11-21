package com.example.springbootrest.service;

import com.example.springbootrest.model.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {


    UserDTO createUser(UserDTO userDTO);

    UserDTO getByUsername(String username);

    UserDTO getByUserId(String userId);

    void updateUser(UserDTO userDTO);

    Page<UserDTO> getUsers(int page, int limit);
}
