package org.example.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.dto.CategoryForm;
import org.example.dto.RecipeForm;
import org.example.model.Category;
import org.example.services.impl.CategoryServiceImpl;
import org.example.services.impl.RecipeServiceImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.UUID;

@Controller
@AllArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {
    private final RecipeServiceImpl recipeService;
    private final CategoryServiceImpl categoryService;


    @GetMapping("/admin")
    public String adminPanel() {
        return "admin";
    }

    @GetMapping("/admin/create-category")
    public String categoryView(Model model) {
        model.addAttribute("categoryForm", new CategoryForm());
        return "create_category";
    }

    @PostMapping("/admin/create-category")
    public String createCategory(@ModelAttribute @Valid CategoryForm form, Model model) {
        categoryService.createCategory(form);
        return "redirect:/admin/create-category";
    }

    @GetMapping("/admin/create-recipe")
    public String recipeView(Model model){
        model.addAttribute("recipeForm", new RecipeForm());
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "create_recipe";
    }
    @PostMapping("/admin/create-recipe")
    public String createRecipe(@ModelAttribute @Valid RecipeForm form){
        recipeService.createRecipe(form);
        return "redirect:/admin/create-recipe";
    }

    @PostMapping("/admin/delete-recipe/{id}")
    public String deleteRecipe(@PathVariable("id") UUID id) {
        recipeService.deleteRecipe(id);
        return "redirect:/recipes";
    }

    @PostMapping("/admin/delete-category/{id}")
    public String deleteCategory(@PathVariable("id") UUID id) {
        categoryService.deleteCategory(id);
        return "redirect:/categories";
    }
}