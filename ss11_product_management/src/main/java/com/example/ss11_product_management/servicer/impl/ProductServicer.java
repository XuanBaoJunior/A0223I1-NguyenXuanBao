package com.example.ss11_product_management.servicer.impl;

import com.example.ss11_product_management.model.Product;
import com.example.ss11_product_management.repository.IProductRepository;
import com.example.ss11_product_management.repository.impl.ProductRepository;
import com.example.ss11_product_management.servicer.IProductServicer;

import java.util.List;

public class ProductServicer implements IProductServicer {
    private IProductRepository iProductRepository = new ProductRepository();
    @Override
    public List<Product> getAll() {
        return iProductRepository.findAll();
    }

    @Override
    public void addProduct(Product product) {
        iProductRepository.save(product);
    }
}
