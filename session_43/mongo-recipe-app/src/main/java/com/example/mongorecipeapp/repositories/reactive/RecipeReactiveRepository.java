package com.example.mongorecipeapp.repositories.reactive;

import com.example.mongorecipeapp.domain.Recipe;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.CrudRepository;


public interface RecipeReactiveRepository extends ReactiveMongoRepository<Recipe, String> {
}
