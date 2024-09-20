package com.example.ung_dung_quan_ly_san_pham.controller;

import com.example.ung_dung_quan_ly_san_pham.model.Product;
import com.example.ung_dung_quan_ly_san_pham.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping("")
    public String list(Model model) {
        List<Product> list = iProductService.findAll();
        model.addAttribute("list", list);
        return "list";
    }

    @GetMapping("/create")
    public String ShowCreate(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("product") Product product, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "create";
        }
        List<Product> list = iProductService.findAll();
        product.setId(list.size() + 1);
        iProductService.save(product);
        redirectAttributes.addFlashAttribute("success", "Thêm sản phẩm thành công");
        return "redirect:/product";
    }

    @GetMapping("/{id}/edit")
    public String ShowUpdate(@PathVariable(name = "id") int id, Model model) {
        Product product = iProductService.findById(id);
        model.addAttribute("product", product);
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute(name = "product") Product product, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "update";
        }
        iProductService.update(product);
        redirectAttributes.addFlashAttribute("success", "Cập nhập sản phẩm thành công");
        return "redirect:/product";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable(name = "id") int id, RedirectAttributes redirectAttributes) {
        iProductService.delete(id);
        redirectAttributes.addFlashAttribute("success", "Xóa sản phẩm thành công");
        return "redirect:/product";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable(name = "id") int id, Model model) {
        Product product = iProductService.findById(id);
        model.addAttribute("product", product);
        return "view";
    }

    @PostMapping("/search")
    public String search(@RequestParam(name = "search_txt") String search_txt, Model model) {
        List<Product> list = iProductService.searchByName(search_txt);
        model.addAttribute("list", list);
        return "list";
    }
}
