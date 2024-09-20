package com.example.demo_bai_thi_test.repository;

import com.example.demo_bai_thi_test.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductTypeRepository extends JpaRepository<ProductType, Long> {
}
