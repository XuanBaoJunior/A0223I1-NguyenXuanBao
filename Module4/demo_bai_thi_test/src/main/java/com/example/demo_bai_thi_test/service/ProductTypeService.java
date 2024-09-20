package com.example.demo_bai_thi_test.service;

import com.example.demo_bai_thi_test.model.ProductType;
import com.example.demo_bai_thi_test.repository.IProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Service
public class ProductTypeService implements IProductTypeService {
    @Autowired
    private IProductTypeRepository iProductTypeRepository;

    @Override
    public List<ProductType> listProductType() {
        return iProductTypeRepository.findAll();
    }
}
