package com.example.demo_onetomany.services;

import com.example.demo_onetomany.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    List<Product> findAllByName(String name);

    Page<Product> findAllByName(String name, Pageable pageable);

    void deleteById(Integer code);
}
