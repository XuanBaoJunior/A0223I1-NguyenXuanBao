package com.example.quanlysach_validate.service;

import com.example.quanlysach_validate.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> display();

    void create (Product product);

    Product edit(int id);

    void update(Product product);

    void delete(int id);

    List<Product> searchName(String name);
}
