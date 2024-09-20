package com.example.demo_bai_thi_test.service;

import com.example.demo_bai_thi_test.model.Product;
import com.example.demo_bai_thi_test.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository iProductRepository;


    @Override
    public Page<Product> findAll(Pageable pageable) {
        return iProductRepository.findAll(pageable);
    }

    @Override
    public void saveProduct(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public void deleteProduct(Product product) {
        iProductRepository.delete(product);
    }

    @Override
    public Product find(Long idProduct) {
        return iProductRepository.findById(idProduct).orElse(null);
    }

    @Override
    public void updateProduct(Product idProduct) {
        iProductRepository.save(idProduct);
    }

    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }

//    @Override
//    public Page<Product> searchProduct(Pageable pageable, String nameProduct, Double priceProduc, Long idCategory) {
//        return iProductRepository.findAll(pageable);
//    }
}
