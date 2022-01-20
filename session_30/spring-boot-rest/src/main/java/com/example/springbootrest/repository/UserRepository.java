package com.example.springbootrest.repository;

import com.example.springbootrest.model.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.security.access.prepost.PostAuthorize;

import java.util.Optional;

public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmailOrUsername(String email, String username);

    Optional<UserEntity> findByUsername(String username);

    Optional<UserEntity> findByEmail(String email);

    //@PostAuthorize("hasPermission(returnObject.get(), 'READ')")
    Optional<UserEntity> findByUserId(String userId);
}
