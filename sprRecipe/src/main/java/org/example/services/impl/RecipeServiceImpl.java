package org.example.services.impl;

import lombok.AllArgsConstructor;
import org.example.dto.RecipeForm;
import org.example.model.Category;
import org.example.model.Recipe;
import org.example.repository.CategoryRepository;
import org.example.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class RecipeServiceImpl {
    private final RecipeRepository recipeRepository;
    private final CategoryRepository categoryRepository;

    public void createRecipe(RecipeForm form) {
        Optional<Category> optionalCategory = categoryRepository.findById(form.getCategoryId());
        if (optionalCategory.isPresent()) {
            Recipe recipe = Recipe.builder()
                    .name(form.getName())
                    .description(form.getDescription())
                    .category(optionalCategory.get())
                    .build();
            recipeRepository.save(recipe);
        } else {
            throw new IllegalArgumentException("Invalid category ID");
        }
    }

    public Recipe getRecipeById(UUID id){
        return recipeRepository.findById(id).orElse(new Recipe());
    }

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }
}
