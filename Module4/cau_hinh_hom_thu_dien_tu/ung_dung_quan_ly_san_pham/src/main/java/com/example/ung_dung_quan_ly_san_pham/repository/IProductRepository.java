package com.example.ung_dung_quan_ly_san_pham.repository;

import com.example.ung_dung_quan_ly_san_pham.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void update(Product product);

    void delete(int id);

    List<Product> searchByName(String search);
}
