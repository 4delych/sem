package org.example.services.impl;

import lombok.AllArgsConstructor;
import org.example.dto.CategoryForm;
import org.example.model.Category;
import org.example.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CategoryServiceImpl {
    private final CategoryRepository categoryRepository;

    public void createCategory(CategoryForm form) {
        Category category = new Category();
        category.setCategoryName(form.getCategoryName());
        categoryRepository.save(category);
    }

    public void deleteCategory(UUID id){
        categoryRepository.deleteById(id);
    }

    public Category getCategoryById(UUID id){
        return categoryRepository.findById(id).orElseThrow();
    }
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
