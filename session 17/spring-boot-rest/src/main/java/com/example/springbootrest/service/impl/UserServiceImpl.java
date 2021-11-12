package com.example.springbootrest.service.impl;

import com.example.springbootrest.exception.ErrorMessages;
import com.example.springbootrest.exception.UserServiceException;
import com.example.springbootrest.model.dto.UserDTO;
import com.example.springbootrest.model.entity.UserEntity;
import com.example.springbootrest.repository.UserRepository;
import com.example.springbootrest.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

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

    @Override
    public UserDTO getByUsername(String username) {

        UserDTO userDTO = new UserDTO();

        Optional<UserEntity> userEntity = userRepository.findByUsername(username);

        if (userEntity.isEmpty())
            throw new UsernameNotFoundException(username);

        BeanUtils.copyProperties(userEntity.get(), userDTO);

        return userDTO;


    }

    @Override
    public UserDTO getByUserId(String userId) {

        UserDTO userDTO = new UserDTO();

        Optional<UserEntity> userEntity = userRepository.findByUserId(userId);

        if (userEntity.isEmpty())
            throw new RuntimeException("userId " + userId + "not found");

        BeanUtils.copyProperties(userEntity.get(), userDTO);

        return userDTO;

    }

    @Override
    @Transactional
    public void updateUser(UserDTO userDTO) {

        Optional<UserEntity> optionalUserEntity = userRepository.findByUserId(userDTO.getUserId());

        if (optionalUserEntity.isEmpty())
            throw new UserServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());

        Optional<UserEntity> optionalExistUserEntity = userRepository.findByEmail(userDTO.getEmail());

        if (optionalExistUserEntity.isPresent() && !optionalExistUserEntity.get().getUserId().equals(userDTO.getUserId()))
            throw new RuntimeException("duplicate emailAddress");

        UserEntity userEntity = optionalUserEntity.get();

        userEntity.setEmail(userDTO.getEmail());
        userEntity.setFirstname(userDTO.getFirstname());
        userEntity.setLastname(userDTO.getLastname());
        userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));

        userRepository.save(userEntity);
    }

    @Override
    public Page<UserDTO> getUsers(int page, int limit) {

        List<UserDTO> userDTOs = new ArrayList<>();

        PageRequest pageRequest = PageRequest.of(page, limit);

        Page<UserEntity> userEntityPages = userRepository.findAll(pageRequest);
        List<UserEntity> userEntities = userEntityPages.getContent();

        userEntities.forEach(userEntity -> {

            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(userEntity, userDTO);

            userDTOs.add(userDTO);
        });

        return new PageImpl<>(userDTOs, pageRequest, userEntityPages.getTotalElements());
    }
}
