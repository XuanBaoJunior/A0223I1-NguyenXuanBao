package com.example.demo1.repository;

import com.example.demo1.model.Product;

import java.util.List;

public interface IProductRepository {
    void createProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(int id);

    List<Product> getAllProduct();
}
