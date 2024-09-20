package com.example.ss4_quan_ly_sp.service;


import com.example.ss4_quan_ly_sp.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void update(Product product);

    void delete(int id);

    List<Product> searchByName(String search);
}
