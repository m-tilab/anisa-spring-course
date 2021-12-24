package com.example.springbootrest.service.impl;

import com.example.springbootrest.model.dto.UserDTO;
import com.example.springbootrest.model.entity.RoleEntity;
import com.example.springbootrest.model.entity.UserEntity;
import com.example.springbootrest.repository.RoleRepository;
import com.example.springbootrest.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceImplTest {

    public static final String encryptedPassword = "dkgfhdlkjfdhglfd";
    public static final String password = "12345678";

    @Mock
    private UserRepository userRepository;

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private ModelMapper modelMapper;


    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @InjectMocks
    private UserServiceImpl userService;

    UserEntity userEntity;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);

        userEntity = new UserEntity();
        userEntity.setId(1l);
        userEntity.setFirstname("Mehdi");
        userEntity.setLastname("Tilab");
        userEntity.setEncryptedPassword(encryptedPassword);

    }

    @Test
    void testFindByEmail() {

        //fail("not yet implemented");



        when(userRepository.findByEmail(anyString())).thenReturn(Optional.of(userEntity));

        Optional<UserDTO> optionalUserDTO = userService.findByEmail("test@test.com");

        assertTrue(optionalUserDTO.isPresent());

        assertEquals("Mehdi", optionalUserDTO.get().getFirstname());
    }

    @Test
    void testGetInvalidUserProvided_UsernameNotFoundExceptionThrown() {

        when(userRepository.findByEmail(anyString())).thenReturn(Optional.empty());

        assertThrows(UsernameNotFoundException.class, () -> {

            userService.findByEmail("test@test.com");
        });
    }

    @Test
    final void testCreateCustomerUser() {

        RoleEntity customerRoleEntity = new RoleEntity();
        customerRoleEntity.setName("CUSTOMER");

        // when
        when(userRepository.findByEmailOrUsername(anyString(), anyString())).thenReturn(Optional.empty());
        when(bCryptPasswordEncoder.encode(anyString())).thenReturn(encryptedPassword);
        when(userRepository.save(any(UserEntity.class))).thenReturn(userEntity);
        when(roleRepository.findByName("CUSTOMER")).thenReturn(Optional.of(customerRoleEntity));

        // logic

        UserDTO userDTO = new UserDTO();
        userDTO.setFirstname("Mehdi");
        userDTO.setLastname("Tilab");
        userDTO.setPassword(password);

        UserDTO customerUser = userService.createCustomerUser(userDTO);

        // test
        assertNotNull(customerUser);
        assertEquals(userEntity.getFirstname(), customerUser.getFirstname());

        verify(roleRepository, times(1)).findByName("CUSTOMER");
        verify(bCryptPasswordEncoder, times(1)).encode(password);
        verify(modelMapper, times(1)).map(userDTO, UserEntity.class);
    }
}