package com.example.demo_onetomany.services.impl;

import com.example.demo_onetomany.models.Product;
import com.example.demo_onetomany.repositories.IProductRepository;
import com.example.demo_onetomany.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> findAllByName(String name) {
        return null;
    }

    @Override
    public Page<Product> findAllByName(String name, Pageable pageable) {
        return null;
    }

    @Override
    public void deleteById(Integer code) {
        productRepository.deleteById(code);
    }
}
