package com.example.demo_category.Service;

import com.example.demo_category.Model.Category;
import com.example.demo_category.Repository.CategoryRepository;
import com.example.demo_category.Repository.ICategoryRepository;

import java.util.List;

public class CategoryService implements ICategoryService {
private ICategoryRepository iCategoryRepository = new CategoryRepository();
    @Override
    public List<Category> findAll() {
        return iCategoryRepository.findAll();
    }

    @Override
    public Category findIdCategory(int id) {
        return iCategoryRepository.findIdCategory(id);
    }

    @Override
    public List<Category> find(int id) {
        return iCategoryRepository.find(id);
    }
}
