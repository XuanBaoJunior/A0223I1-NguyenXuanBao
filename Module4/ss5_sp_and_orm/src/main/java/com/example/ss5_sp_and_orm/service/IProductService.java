package com.example.ss5_sp_and_orm.service;


import com.example.ss5_sp_and_orm.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(int id);
    void save(Product product);
    void update(Product product);
    void delete(int id);
    List<Product> search(String name);
}
