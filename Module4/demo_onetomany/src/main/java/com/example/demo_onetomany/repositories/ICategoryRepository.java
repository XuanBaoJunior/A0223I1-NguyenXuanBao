package com.example.demo_onetomany.repositories;

import com.example.demo_onetomany.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
}
