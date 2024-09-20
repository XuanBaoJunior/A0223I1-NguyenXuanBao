package com.example.demo_bai_thi_test.dto;

import com.example.demo_bai_thi_test.model.ProductType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ProductDto implements Validator {
    private String nameProduct;
    private String priceProduct;
    private String statusProduct;
    private ProductType productType;

    public ProductDto() {
    }

    public ProductDto(String nameProduct, String priceProduct, String statusProduct, ProductType productType) {
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.statusProduct = statusProduct;
        this.productType = productType;
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProductDto productDto = (ProductDto) target;
        if (productDto.getNameProduct().isEmpty()) {
            errors.rejectValue("nameProduct", null, "Không được để trống");
        } else if (productDto.getNameProduct().length() < 5 || productDto.getNameProduct().length() > 100) {
            errors.rejectValue("nameProduct", null, "Tên sản phẩm phải từ 5 đến 100 ký tự");
        }
        if (productDto.getPriceProduct() == null || productDto.getPriceProduct().trim().isEmpty()) {
            errors.rejectValue("priceProduct", null, "Giá không được để trống");
        } else {
            try {
                double price = Double.parseDouble(productDto.getPriceProduct());
                if (price <= 0) {
                    errors.rejectValue("priceProduct", null, "Giá phải lớn hơn 0");
                }
            } catch (NumberFormatException e) {
                errors.rejectValue("priceProduct", null, "Giá không hợp lệ");
            }
        }

        if (productDto.getStatusProduct().isEmpty()) {
            errors.rejectValue("statusProduct", null, "Status không được để trống");
        } else if (productDto.getStatusProduct().length() < 5 || productDto.getNameProduct().length() > 100) {
            errors.rejectValue("statusProduct", null, "Status phải từ 5 đến 100 ký tự");
        }

    }
}
