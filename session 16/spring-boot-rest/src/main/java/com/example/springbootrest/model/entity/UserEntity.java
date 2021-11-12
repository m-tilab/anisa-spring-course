package com.example.springbootrest.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
public class UserEntity {

    @Id
    @GeneratedValue
    private long id;

    @Column(length = 100)
    private String userId;

    @Column(nullable = false, length = 100)
    private String firstname;

    @Column(nullable = false, length = 100)
    private String lastname;

    @Column(nullable = false, length = 100, unique = true)
    private String username;

    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @Column(length = 100)
    private String encryptedPassword;
    private String emailVerificationToken;

    @Column(length = 100, columnDefinition = "boolean default false")
    private Boolean emailVerificationStatus = false;
}
