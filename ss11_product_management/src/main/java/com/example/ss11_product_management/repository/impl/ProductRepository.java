package com.example.ss11_product_management.repository.impl;

import com.example.ss11_product_management.model.Product;
import com.example.ss11_product_management.repository.IProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static List<Product> products = new ArrayList();

    static {
        products.add(new Product(1,"Dien thoai", 2000, "new", "vn/a"));
        products.add(new Product(2,"Laptop", 3000, "new", "ll/a"));
        products.add(new Product(3,"Tai nghe", 200, "new", "vn/a"));
        products.add(new Product(4,"PC", 3500, "new", "vn/a"));
        products.add(new Product(5,"Tan nhiet", 90, "new", "vn/a"));
    }
    @Override
    public List<Product> findAll() {
        return products;
    }


    public static void save(Product product) {
        products.add(product.getId(), product);
    }
}
