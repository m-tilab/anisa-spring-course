package com.example.springbootrest.controller;

import com.example.springbootrest.model.dto.UserDTO;
import com.example.springbootrest.model.request.UserDetailsRequestModel;
import com.example.springbootrest.model.request.UserUpdateRequestModel;
import com.example.springbootrest.model.response.UserDetailsResponseModel;
import com.example.springbootrest.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

        //UserDTO userDTO = UserDTO.builder().build();
        //BeanUtils.copyProperties(userDetailsRequestModel, userDTO);

        ModelMapper modelMapper = new ModelMapper();
        UserDTO userDTO = modelMapper.map(userDetailsRequestModel, UserDTO.class);

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

    @GetMapping
    public Page<UserDetailsResponseModel> getUsers(@RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "10") int limit) {

        var userDetails = new ArrayList<UserDetailsResponseModel>();

        Page<UserDTO> pageUsers = userService.getUsers(page, limit);

        List<UserDTO> userDTOs = pageUsers.getContent();

        userDTOs.stream().forEach(userDTO -> {
            UserDetailsResponseModel responseModel = new UserDetailsResponseModel();

            BeanUtils.copyProperties(userDTO, responseModel);

            userDetails.add(responseModel);
        });

        PageRequest pageRequest = PageRequest.of(page, limit);

        return new PageImpl<>(userDetails,pageRequest, pageUsers.getTotalElements());
    }
}
