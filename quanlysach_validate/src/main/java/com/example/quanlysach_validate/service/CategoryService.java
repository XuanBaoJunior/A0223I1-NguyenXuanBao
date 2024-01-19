package com.example.quanlysach_validate.service;

import com.example.quanlysach_validate.model.Category;
import com.example.quanlysach_validate.repository.CategoryRepository;
import com.example.quanlysach_validate.repository.ICategoryRepository;

import java.util.List;

public class CategoryService implements ICategoryService{
    private ICategoryRepository iCategoryRepository = new CategoryRepository();
    @Override
    public List<Category> findAll() {
        return iCategoryRepository.findAll();
    }

    @Override
    public Category findIdCategory(int id) {
        return null;
    }

    @Override
    public List<Category> find(int id) {
        return null;
    }
}
