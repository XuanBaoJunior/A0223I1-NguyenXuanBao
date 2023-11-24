package com.example.baithicategory.Service;

import com.example.baithicategory.Model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    Category findIdCategory(int id);

    List<Category> find(int id);
}
