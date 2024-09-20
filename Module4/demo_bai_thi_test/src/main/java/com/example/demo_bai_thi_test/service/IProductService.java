package com.example.demo_bai_thi_test.service;

import com.example.demo_bai_thi_test.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    Page<Product> findAll(Pageable pageable);

    void saveProduct(Product product);

    void deleteProduct(Product product);

    Product find(Long idProduct);

    void updateProduct(Product idProduct);

    List<Product> findAll();
}
