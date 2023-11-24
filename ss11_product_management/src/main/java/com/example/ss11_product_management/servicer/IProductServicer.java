package com.example.ss11_product_management.servicer;

import com.example.ss11_product_management.model.Product;

import java.util.List;

public interface IProductServicer {
    List<Product> getAll();

    void addProduct(Product product);
}
