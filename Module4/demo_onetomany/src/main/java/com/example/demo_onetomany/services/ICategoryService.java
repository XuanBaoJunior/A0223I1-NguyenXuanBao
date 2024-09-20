package com.example.demo_onetomany.services;

import com.example.demo_onetomany.models.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
}
