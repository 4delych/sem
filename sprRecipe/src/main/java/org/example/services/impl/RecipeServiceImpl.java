package org.example.services.impl;

import lombok.AllArgsConstructor;
import org.example.dto.RecipeForm;
import org.example.model.Category;
import org.example.model.Ingredient;
import org.example.model.Recipe;
import org.example.repository.CategoryRepository;
import org.example.repository.IngredientRepository;
import org.example.repository.RecipeRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class RecipeServiceImpl {
    private final RecipeRepository recipeRepository;
    private final CategoryRepository categoryRepository;
    private IngredientRepository ingredientRepository;

    public void createRecipe(RecipeForm form) {
        Set<Ingredient> ingredients = new HashSet<>();
        for (UUID ingredientId : form.getIngredientIds()) {
            Ingredient ingredient = ingredientRepository.findById(ingredientId)
                    .orElseThrow(() -> new RuntimeException("Ingredient not found"));
            ingredients.add(ingredient);
        }
        Optional<Category> optionalCategory = categoryRepository.findById(form.getCategoryId());
        if (optionalCategory.isPresent()) {
            Recipe recipe = Recipe.builder()
                    .name(form.getName())
                    .description(form.getDescription())
                    .category(optionalCategory.get())
                    .ingredients(ingredients)
                    .build();
            recipeRepository.save(recipe);
        } else {
            throw new IllegalArgumentException("Invalid category ID");
        }
    }
    public void updateRecipe(UUID id, RecipeForm form) {
        Optional<Recipe> optionalRecipe = recipeRepository.findById(id);
        if (optionalRecipe.isPresent()) {
            Recipe recipe = optionalRecipe.get();
            recipe.setName(form.getName());
            recipe.setDescription(form.getDescription());
            recipeRepository.save(recipe);
        } else {
            throw new IllegalArgumentException("Recipe not found");
        }
    }
    public void deleteRecipe(UUID id){
        recipeRepository.deleteById(id);
    }


    public List<Recipe> findRecipesByIngredientIds(Set<UUID> ingredientIds) {
        return recipeRepository.findDistinctByIngredients_IdIn(ingredientIds);
    }

    public Recipe getRecipeById(UUID id){
        return recipeRepository.findById(id).orElse(new Recipe());
    }

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }
    public List<Recipe> recipesByCategory(Category category){
        return recipeRepository.findByCategory(category);
    }
}
