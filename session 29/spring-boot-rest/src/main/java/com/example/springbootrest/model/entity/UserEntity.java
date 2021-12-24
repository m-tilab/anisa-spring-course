package com.example.springbootrest.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "User")
@Data
public class UserEntity {

    @Id
    @GeneratedValue
    private long id;

    @Column(length = 100)
    private String userId;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLE",
            joinColumns = {
                    @JoinColumn(name = "USER_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "ROLE_ID")
            }
    )
    private Set<RoleEntity> roles;

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
