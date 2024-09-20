package com.example.ung_dung_quan_ly_san_pham.repository;

import com.example.ung_dung_quan_ly_san_pham.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private static final List<Product> list = new ArrayList<>();

    static {
        list.add(new Product(1, "Bánh", 22000, "Còn sản phẩm", "Orion"));
        list.add(new Product(2, "Kẹo  ", 21000, "Hết sản phẩm", "Candy"));
        list.add(new Product(3, "Sữa", 10000, "Còn sản phẩm", "TH-TrueMilk"));
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
