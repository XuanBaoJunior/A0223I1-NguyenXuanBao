package com.example.quan_ly_sach.servicer;

import com.example.quan_ly_sach.model.Product;

import java.util.List;

public interface IProductServicer {
    List<Product> getAllProduct();

    void deleteProduct(int id);

    void updateProduct(Product product);

    void createProduct(Product product);
}
