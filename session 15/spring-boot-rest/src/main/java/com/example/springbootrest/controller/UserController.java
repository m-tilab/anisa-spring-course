package com.example.springbootrest.controller;

import com.example.springbootrest.model.dto.UserDTO;
import com.example.springbootrest.model.request.UserDetailsRequestModel;
import com.example.springbootrest.model.response.UserDetailsResponseModel;
import com.example.springbootrest.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Slf4j
@AllArgsConstructor
public class UserController {


    private UserService userService;

    @GetMapping
    public String getUser() {

        return "getUser called";
    }

    @PostMapping
    public UserDetailsResponseModel createUser(@RequestBody UserDetailsRequestModel userDetailsRequestModel) {

        UserDetailsResponseModel responseModel = new UserDetailsResponseModel();

        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userDetailsRequestModel, userDTO);

        userDTO = userService.createUser(userDTO);

        BeanUtils.copyProperties(userDTO, responseModel);

        return responseModel;
    }

    @PutMapping
    public String updateUser() {

        return "updateUser Called";
    }

    @DeleteMapping
    public String deleteUser() {

        return "delUser called";
    }
}
