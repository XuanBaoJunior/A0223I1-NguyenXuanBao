package com.example.ss7_ung_dung_blog.service;

import com.example.ss7_ung_dung_blog.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();

    Category getCategoryById(Long id);

    void saveCategory(Category category);

    void updateCategory(Category category);

    void deleteCategory(Long id);
}
