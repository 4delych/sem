package org.example.repository;

import org.example.model.Category;
import org.example.model.Ingredient;
import org.example.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface RecipeRepository extends JpaRepository<Recipe, UUID> {
    List<Recipe> findByCategory(Category category);
    List<Recipe> findDistinctByIngredients_IdIn(Set<UUID> ingredientIds);
}
