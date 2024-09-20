package com.example.demo_onetomany.services.impl;

import com.example.demo_onetomany.models.Category;
import com.example.demo_onetomany.repositories.ICategoryRepository;
import com.example.demo_onetomany.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatogoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
