package com.example.mongorecipeapp.repositories;

import com.example.mongorecipeapp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;


public interface RecipeRepository extends CrudRepository<Recipe, String> {
}
