package com.example.springbootrest.service.impl;

import com.example.springbootrest.model.dto.UserDTO;
import com.example.springbootrest.model.entity.UserEntity;
import com.example.springbootrest.repository.UserRepository;
import com.example.springbootrest.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Properties;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public UserDTO createUser(UserDTO userDTO) {

        UserEntity userEntity = new UserEntity();

        BeanUtils.copyProperties(userDTO, userEntity);

        userEntity.setUserId(UUID.randomUUID().toString());

        //@TODO set encryptedPsssword
        //userEntity.

        userEntity = userRepository.save(userEntity);

        BeanUtils.copyProperties(userEntity, userDTO);

        return userDTO;
    }
}
