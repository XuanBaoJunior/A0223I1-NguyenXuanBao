package com.example.demo_bai_thi.repositories;

import com.example.demo_bai_thi.models.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductTypeRepository extends JpaRepository<ProductType, Long> {
}
