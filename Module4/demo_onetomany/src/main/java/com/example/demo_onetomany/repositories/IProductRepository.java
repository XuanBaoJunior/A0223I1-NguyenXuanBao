package com.example.demo_onetomany.repositories;

import com.example.demo_onetomany.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Integer> {
}
