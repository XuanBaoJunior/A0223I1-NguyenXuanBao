package com.example.demodb.servicer.impl;

import com.example.demodb.model.Product;
import com.example.demodb.repository.IProductRepository;
import com.example.demodb.repository.impl.ProductRepository;
import com.example.demodb.servicer.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    private IProductRepository iProductRepository = new ProductRepository();
    @Override
    public List<Product> getAll() {
        return iProductRepository.findAll();
    }

    @Override
    public void addProduct(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public void deleteById(int id) {
        iProductRepository.deleteById(id);
    }
}
