package com.example.springbootrest.controller;

import com.example.springbootrest.model.dto.RoleDTO;
import com.example.springbootrest.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
@AllArgsConstructor
public class RoleController {

    private RoleService roleService;

    @PostMapping("/add")
    public RoleDTO createNewRole(@RequestBody RoleDTO roleDTO) {

        return roleService.createRole(roleDTO);
    }
}
