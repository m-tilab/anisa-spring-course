package com.example.springbootrest.repository;

import com.example.springbootrest.model.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmailOrUsername(String email, String username);

    Optional<UserEntity> findByUsername(String username);
}
