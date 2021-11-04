package com.example.springbootrest.service.impl;

import com.example.springbootrest.model.dto.UserDTO;
import com.example.springbootrest.model.entity.UserEntity;
import com.example.springbootrest.repository.UserRepository;
import com.example.springbootrest.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Properties;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDTO createUser(UserDTO userDTO) {

        if (userRepository.findByEmailOrUsername(userDTO.getEmail(), userDTO.getUsername()).isPresent())
            throw new RuntimeException("duplicate username or emailAddress");

        UserEntity userEntity = new UserEntity();

        BeanUtils.copyProperties(userDTO, userEntity);

        userEntity.setUserId(UUID.randomUUID().toString());

        userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));

        userEntity = userRepository.save(userEntity);

        BeanUtils.copyProperties(userEntity, userDTO);

        return userDTO;
    }

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {

        Optional<UserEntity> optionalUserEntity = userRepository.findByEmailOrUsername(usernameOrEmail, usernameOrEmail);

        if (optionalUserEntity.isEmpty())
            throw new UsernameNotFoundException(usernameOrEmail);

        UserEntity userEntity = optionalUserEntity.get();

        return new User(userEntity.getUsername(), userEntity.getEncryptedPassword(), new ArrayList<>());
    }
}
