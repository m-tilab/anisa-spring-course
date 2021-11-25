package com.example.springbootrest.service;

import com.example.springbootrest.model.dto.RoleDTO;
import com.example.springbootrest.model.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface RoleService {


    RoleDTO createRole(RoleDTO roleDTO);


}
