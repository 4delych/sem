package org.example.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.example.dto.RecipeForm;
import org.example.model.Category;
import org.example.model.Recipe;
import org.example.services.impl.CategoryServiceImpl;
import org.example.services.impl.RecipeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class RecipeController {
    private final RecipeServiceImpl recipeService;
    private final CategoryServiceImpl categoryService;

    @GetMapping("/create-recipe")
    public String recipeView(Model model){
        model.addAttribute("recipeForm", new RecipeForm());
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "create_recipe";
    }
    @PostMapping("/create_recipe")
    public String createRecipe(@ModelAttribute @Valid RecipeForm form){
        recipeService.createRecipe(form);
        return "redirect:/recipes";
    }

    @GetMapping("/recipes")
    public String listRecipes(Model model){
        List<Recipe> recipes = recipeService.getAllRecipes();
        model.addAttribute("recipes", recipes);
        return "recipes";
    }
}
