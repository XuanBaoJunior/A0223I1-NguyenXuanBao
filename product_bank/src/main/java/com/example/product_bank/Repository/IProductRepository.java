package com.example.product_bank.Repository;

import com.example.product_bank.Model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> display();

    void create(Product product);

    Product edit(int id);

    void update(Product product);

    void delete(int id);

    List<Product> searchName(String name);
}
