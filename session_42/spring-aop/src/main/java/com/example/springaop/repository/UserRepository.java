package com.example.springaop.repository;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    public String retrieveUser() {

        return "user";
    }

}
