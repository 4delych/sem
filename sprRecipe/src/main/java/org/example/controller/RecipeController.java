package org.example.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.dto.RecipeForm;
import org.example.model.Category;
import org.example.model.Recipe;
import org.example.model.User;
import org.example.services.impl.CategoryServiceImpl;
import org.example.services.impl.FavoriteServiceImpl;
import org.example.services.impl.RecipeServiceImpl;
import org.example.services.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

@Controller
@AllArgsConstructor
public class RecipeController {
    private final RecipeServiceImpl recipeService;
    private final UserServiceImpl userService;

    private final FavoriteServiceImpl favoriteService;

    @GetMapping("/recipes")
    public String listRecipes(Model model, Principal principal){
        List<Recipe> recipes = recipeService.getAllRecipes();
        User user = userService.getUserByUsername(principal.getName());
        model.addAttribute("user", user);
        model.addAttribute("recipes", recipes);
        return "recipes";
    }

    @GetMapping("/recipe/{id}")
    public String showRecipe(@PathVariable("id") UUID id, Model model) {
        Recipe recipe = recipeService.getRecipeById(id);
        model.addAttribute("recipe", recipe);
        return "recipe_details";
    }

    @PostMapping("/recipe/{id}/favorite")
    public String addToFavorites(@PathVariable("id") UUID recipeId, Principal principal) {
        User user = userService.getUserByUsername(principal.getName());
        Recipe recipe = recipeService.getRecipeById(recipeId);
        favoriteService.addToFavorites(user, recipe);
        return "redirect:/recipe/" + recipeId;
    }
}
