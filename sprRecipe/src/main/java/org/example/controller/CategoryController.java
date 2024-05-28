package org.example.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.dto.CategoryForm;
import org.example.model.Category;
import org.example.services.impl.CategoryServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class CategoryController {
    private final CategoryServiceImpl categoryService;

    @GetMapping("/create-category")
    public String categoryView(Model model) {
        model.addAttribute("categoryForm", new CategoryForm());
        return "create_category";
    }

    @PostMapping("/create-category")
    public String createCategory(@ModelAttribute @Valid CategoryForm form, Model model) {
        categoryService.createCategory(form);
        return "redirect:/categories";
    }

    @GetMapping("/categories")
    public String listCategories(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "categories";
    }
}
