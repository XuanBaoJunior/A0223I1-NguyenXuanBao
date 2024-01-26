package com.example.demobaithi.Repository;

import com.example.demobaithi.Model.Category;

import java.util.List;

public interface ICategoryRepository {
    List<Category> findAll();

    Category findIdCategory(int id);

    List<Category> find(int id);
}
