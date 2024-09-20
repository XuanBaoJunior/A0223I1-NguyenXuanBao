package com.example.demo_bai_thi.repositories;

import com.example.demo_bai_thi.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

public interface IProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findAll(Pageable pageable);

    @Transactional
    @Query("select p from Product p join p.productType pt where p.nameProduct like %:nameProduct% " +
            "and p.priceProduct = :priceProduc and pt.idProductType = :idCategory ")
    Page<Product> findByTitleAndCategory(Pageable pageable, @Param("nameProduct")
    String nameProduct, @Param("priceProduc") Double priceProduc, @Param("idCategory") Long idCategory);
}
