package com.example.demo_bai_thi.services;

import com.example.demo_bai_thi.models.ProductType;
import com.example.demo_bai_thi.repositories.IProductRepository;
import com.example.demo_bai_thi.repositories.IProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Service
public class ProductTypeService implements IProductTypeService{
    @Autowired
    private IProductTypeRepository iProductTypeRepository;
    @Override
    public ProductType getOneProductType(Long idProductType) {
        return iProductTypeRepository.findAll().stream()
                .filter(productType -> productType.getIdProductType() == idProductType)
                .findFirst().orElse(null);
    }
    @ModelAttribute("")
    @Override
    public List<ProductType> getAllProductType() {
        return iProductTypeRepository.findAll();
    }
}
