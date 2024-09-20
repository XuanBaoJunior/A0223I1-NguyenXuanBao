package com.example.demo_bai_thi_test.controller;

import com.example.demo_bai_thi_test.dto.ProductDto;
import com.example.demo_bai_thi_test.model.Product;
import com.example.demo_bai_thi_test.service.IProductService;
import com.example.demo_bai_thi_test.service.IProductTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService iProductService;
    @Autowired
    private IProductTypeService iProductTypeService;

    @GetMapping("")
    public String showProduct(Model model, @PageableDefault(page = 0, size = 5) Pageable pageable) {
        Page<Product> products = iProductService.findAll(pageable);
        model.addAttribute("products", products);
        return "list";
    }

    @GetMapping("/create")
    public String showCreateProduct (Model model){
        model.addAttribute("productDto", new ProductDto());
        model.addAttribute("productType", iProductTypeService.listProductType());
        return "create";
    }

    @PostMapping("/create")
    public String createProduct(@Valid @ModelAttribute ProductDto productDto,
                                BindingResult bindingResult, Model model,
                                RedirectAttributes redirectAttributes){
        new ProductDto().validate(productDto, bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("productDto", productDto);
            model.addAttribute("productType", iProductTypeService.listProductType());
            return "create";
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        product.setPriceProduct(String.valueOf(productDto.getPriceProduct()));
        product.setStatusProduct(String.valueOf(productDto.getStatusProduct()));
        iProductService.saveProduct(product);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công");
        return "redirect:/product";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long idProduct, RedirectAttributes redirectAttributes){
        Product product = iProductService.find(idProduct);
        iProductService.deleteProduct(product);
        redirectAttributes.addFlashAttribute("mess", "Xóa thành công");
        return "redirect:/product";
    }
}
