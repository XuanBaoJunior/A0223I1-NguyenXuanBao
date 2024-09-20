package com.example.ss4_quan_ly_sp.repository;

import com.example.ss4_quan_ly_sp.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private static final List<Product> list = new ArrayList<>();

    static {
        list.add(new Product(1, "Nuoc", 22000, "Con san pham", "Pepsi"));
        list.add(new Product(2, "Keo  ", 21000, "Het san pham", "Gau"));
        list.add(new Product(3, "Sua", 10000, "Con san pham", "TH-TrueMilk"));
    }

    @Override
    public List<Product> findAll() {
        return list;
    }

    @Override
    public void save(Product product) {
        list.add(product);
    }

    @Override
    public Product findById(int id) {
        return list.get(id - 1);
    }

    @Override
    public void update(Product product) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == product.getId()) {
                list.set(i, product);
                break;
            }
        }
    }

    @Override
    public void delete(int id) {
        list.remove(id - 1);
    }

    @Override
    public List<Product> searchByName(String search) {
        List<Product> productList = new ArrayList<>();
        for (Product product : list) {
            if (product.getNameProduct().contains(search)) {
                productList.add(product);
            }
        }
        return productList;
    }
}
