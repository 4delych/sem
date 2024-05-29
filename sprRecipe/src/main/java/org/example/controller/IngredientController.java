package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.model.Ingredient;
import org.example.services.impl.IngredientServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class IngredientController {
    private final IngredientServiceImpl ingredientService;

    @GetMapping("/admin/ingredients")
    public String listIngredients(Model model) {
        List<Ingredient> ingredients = ingredientService.getAllIngredients();
        model.addAttribute("ingredients", ingredients);
        return "ingredients";
    }
}
