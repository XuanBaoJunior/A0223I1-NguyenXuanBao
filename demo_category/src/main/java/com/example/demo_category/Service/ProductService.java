package com.example.demo_category.Service;

import com.example.demo_category.Model.Product;
import com.example.demo_category.Repository.IProductRepository;
import com.example.demo_category.Repository.ProductRepository;

import java.util.List;

public class ProductService implements IProductService{
    private IProductRepository iProductRepository = new ProductRepository();
    @Override
    public List<Product> display() {
        return iProductRepository.display();
    }

    @Override
    public void create(Product product) {
        iProductRepository.create(product);
    }

    @Override
    public Product edit(int id) {
        return iProductRepository.edit(id);
    }

    @Override
    public void update(Product product) {
        iProductRepository.update(product);
    }

    @Override
    public void delete(int id) {
        iProductRepository.delete(id);
    }

    @Override
    public List<Product> searchName(String name) {
        return iProductRepository.searchName(name);
    }
}
