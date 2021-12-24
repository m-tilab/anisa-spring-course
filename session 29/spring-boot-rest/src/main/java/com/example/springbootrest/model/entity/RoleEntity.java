package com.example.springbootrest.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "Role")
@Data
public class RoleEntity {

    @Id
    @GeneratedValue
    private long id;

    @Column(unique = true)
    private String name;

    @Column
    private String description;
}
