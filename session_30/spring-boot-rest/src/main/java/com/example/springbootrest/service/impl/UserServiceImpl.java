package com.example.springbootrest.service.impl;

import com.example.springbootrest.exception.ErrorMessages;
import com.example.springbootrest.exception.UserServiceException;
import com.example.springbootrest.model.dto.UserDTO;
import com.example.springbootrest.model.entity.RoleEntity;
import com.example.springbootrest.model.entity.UserEntity;
import com.example.springbootrest.repository.RoleRepository;
import com.example.springbootrest.repository.UserRepository;
import com.example.springbootrest.service.KafkaProducerConfig;
import com.example.springbootrest.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
    private RoleRepository roleRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private KafkaProducerConfig kafkaProducer;

    @Override
    public UserDTO createCustomerUser(UserDTO userDTO) {

        if (userRepository.findByEmailOrUsername(userDTO.getEmail(), userDTO.getUsername()).isPresent())
            throw new RuntimeException("duplicate username or emailAddress");

        ModelMapper modelMapper = new ModelMapper();

        Optional<RoleEntity> optionalCustomerRole = roleRepository.findByName("CUSTOMER");

        UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);

        if (optionalCustomerRole.isPresent()) {

            userEntity.setRoles(Set.of(optionalCustomerRole.get()));
        }

        userEntity.setUserId(UUID.randomUUID().toString());

        userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));

        userEntity = userRepository.save(userEntity);

        userDTO = modelMapper.map(userEntity, UserDTO.class);

        kafkaProducer.sendMessage("welcome to Spring Boot Rest");

        return userDTO;
    }

    @Override
    public UserDTO createAdminUser(UserDTO userDTO) {

        if (userRepository.findByEmailOrUsername(userDTO.getEmail(), userDTO.getUsername()).isPresent())
            throw new RuntimeException("duplicate username or emailAddress");


        UserEntity userEntity = new UserEntity();

        Optional<RoleEntity> optionalAdminRole = roleRepository.findByName("ADMIN");

        if (optionalAdminRole.isPresent()) {

            userEntity.setRoles(Set.of(optionalAdminRole.get()));
        }

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

        List<GrantedAuthority> authorityList = new ArrayList<>();

        for (RoleEntity role : userEntity.getRoles()) {

            authorityList.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new User(userEntity.getUsername(), userEntity.getEncryptedPassword(), authorityList);
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

    public Optional<UserDTO> findByEmail(String email) {

        Optional<UserDTO> optionalUserDTO;

        UserDTO userDTO = new UserDTO();

        Optional<UserEntity> optionalUserEntity = userRepository.findByEmail(email);

        if (!optionalUserEntity.isPresent())
            throw new UsernameNotFoundException(email);

        BeanUtils.copyProperties(optionalUserEntity.get(), userDTO);

        optionalUserDTO = Optional.of(userDTO);



        return optionalUserDTO;
    }
}
