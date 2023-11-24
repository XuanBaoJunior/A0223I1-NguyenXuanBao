package com.example.quan_ly_sach.repository;

import com.example.quan_ly_sach.model.Product;

import java.util.List;

public interface IProductRepository {
    void createProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(int id);

    List<Product> getAllProduct();
}
