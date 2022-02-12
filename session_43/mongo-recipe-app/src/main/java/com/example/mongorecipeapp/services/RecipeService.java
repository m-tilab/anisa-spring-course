package com.example.mongorecipeapp.services;

import com.example.mongorecipeapp.commands.RecipeCommand;
import com.example.mongorecipeapp.domain.Recipe;

import java.util.Set;

/**
 * Created by jt on 6/13/17.
 */
public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(String id);

    RecipeCommand findCommandById(String id);

    RecipeCommand saveRecipeCommand(RecipeCommand command);

    void deleteById(String idToDelete);
}
