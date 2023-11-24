package com.example.demo1.service;

import com.example.demo1.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProduct();

    void deleteProduct(int id);

    void updateProduct(Product product);

    void createProduct(Product product);
}
