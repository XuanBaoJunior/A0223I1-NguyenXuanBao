package com.example.baithicategory.Service;

import com.example.baithicategory.Model.Category;
import com.example.baithicategory.Repository.CategoryRepository;
import com.example.baithicategory.Repository.ICategoryRepository;

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
