package com.example.mongorecipeapp.repositories;

import com.example.mongorecipeapp.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface CategoryRepository extends CrudRepository<Category, String> {

    Optional<Category> findByDescription(String description);
}
