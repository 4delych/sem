package org.example.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecipeForm {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotNull
    private UUID categoryId;
    private Set<UUID> ingredientIds;
}