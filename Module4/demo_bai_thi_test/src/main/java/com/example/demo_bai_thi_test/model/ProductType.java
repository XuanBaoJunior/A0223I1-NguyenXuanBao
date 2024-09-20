package com.example.demo_bai_thi_test.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProductType;
    private String nameProductType;
    @OneToMany(mappedBy = "productType",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Product> products;

    public ProductType() {
    }

    public ProductType(Long idProductType, String nameProductType, List<Product> products) {
        this.idProductType = idProductType;
        this.nameProductType = nameProductType;
        this.products = products;
    }

    public Long getIdProductType() {
        return idProductType;
    }

    public void setIdProductType(Long idProductType) {
        this.idProductType = idProductType;
    }

    public String getNameProductType() {
        return nameProductType;
    }

    public void setNameProductType(String nameProductType) {
        this.nameProductType = nameProductType;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
