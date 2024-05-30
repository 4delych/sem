package org.example.services.impl;

import lombok.AllArgsConstructor;
import org.example.dto.IngredientForm;
import org.example.model.Ingredient;
import org.example.repository.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class IngredientServiceImpl {
    private final IngredientRepository ingredientRepository;
    public void createIngredient(IngredientForm form){
        Ingredient ingredient = Ingredient.builder()
                .name(form.getName())
                .build();
        ingredientRepository.save(ingredient);
    }

    public Ingredient findById(UUID id){
        return ingredientRepository.findById(id).orElseThrow();
    }

    public void deleteIngredient(UUID id){
        ingredientRepository.deleteById(id);
    }
    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }
}
