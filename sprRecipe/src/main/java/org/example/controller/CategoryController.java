package org.example.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.dto.CategoryForm;
import org.example.model.Category;
import org.example.model.Recipe;
import org.example.model.User;
import org.example.repository.RecipeRepository;
import org.example.services.impl.CategoryServiceImpl;
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
public class CategoryController {
    private final CategoryServiceImpl categoryService;
    private final UserServiceImpl userService;
    private final RecipeServiceImpl recipeService;

    @GetMapping("/categories")
    public String listCategories(Model model, Principal principal) {
        List<Category> categories = categoryService.getAllCategories();
        User user = userService.getUserByUsername(principal.getName());
        model.addAttribute("user", user);
        model.addAttribute("categories", categories);
        return "categories";
    }

    @GetMapping("/categories/{id}")
    public String recipesByCategory(@PathVariable("id")UUID categoryId, Model model){
        Category category = categoryService.getCategoryById(categoryId);
        List<Recipe> recipes = recipeService.recipesByCategory(category);
        model.addAttribute("recipes", recipes);
        model.addAttribute("category", category);
        return "recipes_by_category";
    }
}
