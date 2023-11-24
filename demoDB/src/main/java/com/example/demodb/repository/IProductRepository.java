package com.example.demodb.repository;

import com.example.demodb.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    void save(Product product);

    void deleteById(int id);
}
