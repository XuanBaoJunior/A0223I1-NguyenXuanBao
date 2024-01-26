package com.example.demobaithi.Service;

import com.example.demobaithi.Model.Category;
import com.example.demobaithi.Repository.CategoryRepository;
import com.example.demobaithi.Repository.ICategoryRepository;

import java.util.List;

public class CategoryService implements ICategoryService{
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
