package com.example.demobaithi.Service;

import com.example.demobaithi.Model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    Category findIdCategory(int id);

    List<Category> find(int id);
}
