package com.example.demo.dao;

import com.example.demo.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDAO {
    private static Map<Integer, Product> productMap = new HashMap<>();

    static {
        productMap.put(1, new Product(1, "Iphone", 3000, "Mới", "Việt Nam"));
        productMap.put(2, new Product(2, "Samsung", 2000, "Mới", "Việt Nam"));
        productMap.put(3, new Product(3, "Oppo", 1000, "Mới", "Việt Nam"));
    }
    public static List<Product> getListProduct(){
        return new ArrayList<>(productMap.values());
    }

    public static void save(Product product){
        productMap.put(product.getId(), product);
    }
}
