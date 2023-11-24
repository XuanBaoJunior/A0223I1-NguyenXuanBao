package com.example.baithicategory.Repository;


import com.example.baithicategory.Model.Category;

import java.util.List;

public interface ICategoryRepository {
    List<Category> findAll();

    Category findIdCategory(int id);

    List<Category> find(int id);
}
