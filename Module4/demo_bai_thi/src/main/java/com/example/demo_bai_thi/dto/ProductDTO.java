package com.example.demo_bai_thi.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ProductDTO implements Validator {
    @NotNull(message = "Tên Sp không được để trống")
    @Size(min = 5, max = 50)
    private String nameProduct;

    @Min(value = 100000,message = "Gía Không Nhỏ Hơn 100.000")
    private Double priceProduct;

    private String statusProduct;

    private Long productType;

    public ProductDTO(String nameProduct, Double priceProduct, String statusProduct, Long productType) {
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.statusProduct = statusProduct;
        this.productType = productType;
    }

    public ProductDTO() {
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(Double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public String getStatusProduct() {
        return statusProduct;
    }

    public void setStatusProduct(String statusProduct) {
        this.statusProduct = statusProduct;
    }

    public Long getProductType() {
        return productType;
    }

    public void setProductType(Long productType) {
        this.productType = productType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }


    @Override
    public void validate(Object target, Errors errors) {

    }
}
