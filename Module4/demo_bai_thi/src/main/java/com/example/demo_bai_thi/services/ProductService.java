package com.example.demo_bai_thi.services;

import com.example.demo_bai_thi.models.Product;
import com.example.demo_bai_thi.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
    public Product getOneProduct(Long idProduct) {
        return iProductRepository.findAll().stream()
                .filter(product -> product.getIdProduct() == idProduct)
                .findFirst().orElse(null);
    }

    @Override
    public Page<Product> searchProduct(Pageable pageable, String nameProduct, Double priceProduc, Long idCategory) {
        return iProductRepository.findByTitleAndCategory(pageable,nameProduct,priceProduc,idCategory);
    }
}
