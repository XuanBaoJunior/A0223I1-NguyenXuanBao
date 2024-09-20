package com.example.demo_bai_thi.services;

import com.example.demo_bai_thi.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> findAll(Pageable pageable);

    void saveProduct(Product product);

    void deleteProduct(Product product);

    Product getOneProduct(Long idProduct);

    Page<Product> searchProduct(Pageable pageable,String nameProduct,Double priceProduc,Long idCategory);

}
