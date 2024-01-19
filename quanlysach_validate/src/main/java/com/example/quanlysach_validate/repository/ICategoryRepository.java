package com.example.quanlysach_validate.repository;

import com.example.quanlysach_validate.model.Category;

import java.util.List;

public interface ICategoryRepository {
    List<Category> findAll();

    Category findIdCategory(int id);

    List<Category> find(int id);
}
