package org.example.repository;

import org.example.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IngredientRepository extends JpaRepository<Ingredient, UUID> {
    List<Ingredient> getIngredientById(UUID id);
    Optional<Ingredient> findById(UUID id);
}