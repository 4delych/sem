package org.example.services.impl;

import lombok.AllArgsConstructor;
import org.example.dto.CategoryForm;
import org.example.model.Category;
import org.example.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl {
    private final CategoryRepository categoryRepository;

    public void createCategory(CategoryForm form) {
        Category category = new Category();
        category.setCategoryName(form.getCategoryName());
        categoryRepository.save(category);
    }
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
