package com.example.springaop.service;

import com.example.springaop.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getSomething() throws InterruptedException {

        Thread.sleep(5L);

        return userRepository.retrieveUser();
    }
}
