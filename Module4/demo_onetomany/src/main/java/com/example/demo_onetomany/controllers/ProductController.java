package com.example.demo_onetomany.controllers;

import com.example.demo_onetomany.models.Product;
import com.example.demo_onetomany.services.ICategoryService;
import com.example.demo_onetomany.services.IProductService;
import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String showList(Model model, @RequestParam(value = "nameSearch", defaultValue = "") String name, @RequestParam(value = "page", defaultValue = "0") int page) {
        if (page < 0) {
            page = 0;
        }
        Page<Product> productList = productService.findAllByName(name, PageRequest.of(page, 2));
        if (productList.isEmpty()) {

        }
        model.addAttribute("listProduct", productList);
        model.addAttribute("nameSearch", name);
        return "list";
    }
}
