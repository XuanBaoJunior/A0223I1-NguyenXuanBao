package com.example.demo_bai_thi.services;

import com.example.demo_bai_thi.models.ProductType;

import java.util.List;

public interface IProductTypeService {
    ProductType getOneProductType(Long id);

    List<ProductType> getAllProductType();
}
