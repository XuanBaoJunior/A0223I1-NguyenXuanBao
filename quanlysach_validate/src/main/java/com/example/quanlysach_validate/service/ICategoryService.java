package com.example.quanlysach_validate.service;

import com.example.quanlysach_validate.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    Category findIdCategory(int id);

    List<Category> find(int id);
}
