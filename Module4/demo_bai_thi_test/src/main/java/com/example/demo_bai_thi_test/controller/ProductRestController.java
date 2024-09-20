package com.example.demo_bai_thi_test.controller;

import com.example.demo_bai_thi_test.model.Product;
import com.example.demo_bai_thi_test.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/product")
public class ProductRestController {
    @Autowired
private IProductService iProductService;

    @GetMapping("/{id}")
    public ResponseEntity<Product> showQuestionFindById(@PathVariable Long id) {
        Product product = iProductService.find(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Product>> showList() {
        List<Product> list = iProductService.findAll();
        if (list == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Product product) {
        if(product == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        iProductService.saveProduct(product);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PatchMapping("/update")
    public ResponseEntity<?> edit(@RequestBody Product product) {
        Product product1 = iProductService.find(product.getIdProduct());
        if(product1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iProductService.saveProduct(product);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Product product = iProductService.find(id);
        if(product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iProductService.deleteProduct(product);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
