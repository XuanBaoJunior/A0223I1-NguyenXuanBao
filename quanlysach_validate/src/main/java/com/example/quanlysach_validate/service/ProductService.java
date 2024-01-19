package com.example.quanlysach_validate.service;

import com.example.quanlysach_validate.model.Product;
import com.example.quanlysach_validate.repository.IProductRepository;
import com.example.quanlysach_validate.repository.ProductRepository;

import java.util.List;

public class ProductService implements IProductService{
    private IProductRepository iProductRepository = new ProductRepository();
    @Override
    public List<Product> display() {
        return iProductRepository.display();
    }

    @Override
    public void create(Product product) {

    }

    @Override
    public Product edit(int id) {
        return null;
    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Product> searchName(String name) {
        return null;
    }
}
