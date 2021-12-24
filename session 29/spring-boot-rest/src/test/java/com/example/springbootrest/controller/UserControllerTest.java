package com.example.springbootrest.controller;

import com.example.springbootrest.model.dto.UserDTO;
import com.example.springbootrest.model.response.UserDetailsResponseModel;
import com.example.springbootrest.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @InjectMocks
    UserController userController;

    @Mock
    UserServiceImpl userService;

    UserDTO userDTO;

    public static final String USER_ID = "d90f7d20-6aed-4d82-869c-08e5eaccc3ff";

    @BeforeEach
    void setUp() {

        userDTO = new UserDTO();
        userDTO.setId(1L);
        userDTO.setUserId(USER_ID);
        userDTO.setFirstname("Mehdi");
        userDTO.setLastname("Tilab");
        userDTO.setEmail("Tilab@Tookasoft.com");
        userDTO.setEncryptedPassword("sdfewewrewsdfsd");
    }

    @Test
    void getUser() {

        when(userService.getByUserId(anyString())).thenReturn(userDTO);

        UserDetailsResponseModel restUser = userController.getUser(USER_ID);

        assertNotNull(restUser);
        assertEquals(USER_ID, restUser.getUserId());
        assertEquals(userDTO.getFirstname(), restUser.getFirstname());
    }
}