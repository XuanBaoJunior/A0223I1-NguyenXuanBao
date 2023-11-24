package com.example.demo_category.Service;

import com.example.demo_category.Model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    Category findIdCategory(int id);

    List<Category> find(int id);
}
