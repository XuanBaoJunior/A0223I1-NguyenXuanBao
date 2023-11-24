package com.example.demo_category.Repository;

import com.example.demo_category.Model.Category;

import java.util.List;

public interface ICategoryRepository {
    List<Category> findAll();

    Category findIdCategory(int id);

    List<Category> find(int id);
}
