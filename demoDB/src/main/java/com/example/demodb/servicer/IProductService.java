package com.example.demodb.servicer;

import com.example.demodb.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();

    void addProduct(Product product);

    void deleteById(int id);
}
