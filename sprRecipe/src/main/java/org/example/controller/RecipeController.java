package org.example.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.dto.RecipeForm;
import org.example.model.Category;
import org.example.model.Ingredient;
import org.example.model.Recipe;
import org.example.model.User;
import org.example.services.impl.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Controller
@AllArgsConstructor
public class RecipeController {
    private final RecipeServiceImpl recipeService;
    private final UserServiceImpl userService;
    private final CategoryServiceImpl categoryService;
    private final IngredientServiceImpl ingredientService;
    private final FavoriteServiceImpl favoriteService;

    @GetMapping("/recipes")
    public String listRecipes(Model model, @RequestParam(value = "ingredientIds", required = false) Set<UUID> ingredientIds, Principal principal) {
        User user = userService.getUserByUsername(principal.getName());
        List<Recipe> recipes;
        if (ingredientIds != null && !ingredientIds.isEmpty()) {
            recipes = recipeService.findRecipesByIngredientIds(ingredientIds);
        } else {
            recipes = recipeService.getAllRecipes();
        }
        List<Ingredient> ingredients = ingredientService.getAllIngredients();
        model.addAttribute("recipes", recipes);
        model.addAttribute("ingredients", ingredients);
        if (ingredientIds != null) { // Проверяем, не является ли ingredientIds null перед добавлением в модель
            model.addAttribute("selectedIngredients", ingredientIds);
        }
        model.addAttribute("user", user);
        return "recipes";
    }


    @GetMapping("/recipe/{id}")
    public String showRecipe(@PathVariable("id") UUID id, Model model, Principal principal) {
        Recipe recipe = recipeService.getRecipeById(id);
        User user = userService.getUserByUsername(principal.getName());
        model.addAttribute("recipe", recipe);
        model.addAttribute("user", user);
        return "recipe_details";
    }

    @PostMapping("/recipe/{id}/favorite")
    public String addToFavorites(@PathVariable("id") UUID recipeId, Principal principal) {
        User user = userService.getUserByUsername(principal.getName());
        Recipe recipe = recipeService.getRecipeById(recipeId);
        favoriteService.addToFavorites(user, recipe);
        return "redirect:/recipe/" + recipeId;
    }

    @GetMapping("/admin/recipe/{id}/edit")
    public String editRecipeForm(@PathVariable("id") UUID id, Model model) {
        Recipe recipe = recipeService.getRecipeById(id);
        List<Category> categories = categoryService.getAllCategories();
        List<Ingredient> ingredients = ingredientService.getAllIngredients();
        model.addAttribute("recipe", recipe);
        model.addAttribute("categories", categories);
        model.addAttribute("ingredients", ingredients);
        return "edit_recipe";
    }

    @PostMapping("/admin/recipe/{id}/edit")
    public String editRecipe(@PathVariable("id") UUID id, @ModelAttribute @Valid RecipeForm form) {
        recipeService.updateRecipe(id, form);
        return "redirect:/recipes";
    }
    @GetMapping("/random-recipe")
    public String getRandomRecipeView() {
        return "random_recipe";
    }
    @PostMapping("/random-recipe")
    public String getRandomRecipe(Model model) {
        String recipe = recipeService.getRandomRecipe();
        model.addAttribute("recipe", recipe);
        return "random_recipe";
    }
}