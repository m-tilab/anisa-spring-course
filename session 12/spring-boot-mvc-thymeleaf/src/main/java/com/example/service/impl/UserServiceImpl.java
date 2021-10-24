package com.example.service.impl;

import com.example.domain.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers() {

        return userRepository.getUsers();
    }
}
