package com.example.ss11_product_management.repository;

import com.example.ss11_product_management.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

}
