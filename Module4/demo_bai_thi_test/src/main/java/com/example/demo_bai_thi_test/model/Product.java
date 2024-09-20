package com.example.demo_bai_thi_test.model;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;
    @Column(columnDefinition = "text")
    private String nameProduct;
    private String priceProduct;
    @Column(columnDefinition = "text")
    private String statusProduct;

    @ManyToOne
    @JoinColumn(name = "id_type_product", referencedColumnName = "idProductType")
    private ProductType productType;

    public Product() {
    }

    public Product(Long idProduct, String nameProduct, String priceProduct, String statusProduct, ProductType productType) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.statusProduct = statusProduct;
        this.productType = productType;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(String priceProduct) {
        this.priceProduct = priceProduct;
    }

    public String getStatusProduct() {
        return statusProduct;
    }

    public void setStatusProduct(String statusProduct) {
        this.statusProduct = statusProduct;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }
}
