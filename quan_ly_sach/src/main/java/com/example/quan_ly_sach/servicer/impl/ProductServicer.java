package com.example.quan_ly_sach.servicer.impl;

import com.example.quan_ly_sach.model.Product;
import com.example.quan_ly_sach.repository.IProductRepository;
import com.example.quan_ly_sach.repository.impl.ProductRepository;
import com.example.quan_ly_sach.servicer.IProductServicer;

import java.util.List;

public class ProductServicer implements IProductServicer {
    IProductRepository iProductRepository = new ProductRepository();
    @Override
    public List<Product> getAllProduct() {
        return iProductRepository.getAllProduct();
    }

    @Override
    public void deleteProduct(int id) {
        iProductRepository.deleteProduct(id);
    }

    @Override
    public void updateProduct(Product product) {
        iProductRepository.updateProduct(product);
    }

    @Override
    public void createProduct(Product product) {
        iProductRepository.createProduct(product);
    }
}
