package com.example.repository;

import com.example.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    public List<User> getUsers() {

        var user1 = new User("ali", "ahmadi","test1", "test1");
        var user2 = new User("taghi", "tagizadeh","test2", "test2");
        var user3 = new User("arezoo", "sharafi","test3", "test3");

        return List.of(user1, user2, user3);


    }
}
