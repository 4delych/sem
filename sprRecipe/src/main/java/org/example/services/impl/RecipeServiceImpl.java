package org.example.services.impl;

import lombok.AllArgsConstructor;
import org.example.dto.RecipeForm;
import org.example.model.Recipe;
import org.example.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RecipeServiceImpl {
    private final RecipeRepository recipeRepository;

    public void createRecipe(RecipeForm form) {
        Recipe recipe = Recipe.builder()
                .name(form.getName())
                .description(form.getDescription())
                .category(form.getCategory())
                .build();
        recipeRepository.save(recipe);
    }

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }
}
