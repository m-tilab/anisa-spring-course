package com.example.springbootrest.controller;

import com.example.springbootrest.model.dto.UserDTO;
import com.example.springbootrest.model.request.UserDetailsRequestModel;
import com.example.springbootrest.model.request.UserUpdateRequestModel;
import com.example.springbootrest.model.response.UserDetailsResponseModel;
import com.example.springbootrest.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/user")
@Slf4j
@AllArgsConstructor
public class UserController {


    private UserService userService;

    @GetMapping(value = "/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public UserDetailsResponseModel getUser(@PathVariable String userId) {

        UserDetailsResponseModel userDetailsResponseModel = new UserDetailsResponseModel();

        UserDTO userDTO = userService.getByUserId(userId);

        BeanUtils.copyProperties(userDTO, userDetailsResponseModel);

        return userDetailsResponseModel;
    }

    @PostMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public UserDetailsResponseModel createUser(@RequestBody UserDetailsRequestModel userDetailsRequestModel) {

        UserDetailsResponseModel responseModel = new UserDetailsResponseModel();

        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userDetailsRequestModel, userDTO);

        userDTO = userService.createUser(userDTO);

        BeanUtils.copyProperties(userDTO, responseModel);

        return responseModel;
    }

    @PutMapping
    public ResponseEntity<ResponseStatus> updateUser(@RequestBody UserUpdateRequestModel userUpdateRequestModel) {

        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userUpdateRequestModel, userDTO);

        userService.updateUser(userDTO);


        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    public String deleteUser() {

        return "delUser called";
    }
}
