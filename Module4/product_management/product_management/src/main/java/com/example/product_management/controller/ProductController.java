package com.example.product_management.controller;

import com.example.product_management.model.Product;
import com.example.product_management.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping("")
    public String showList(Model model) {
        List<Product> list = iProductService.findAll();
        model.addAttribute("list", list);
        return "product/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("productNew", new Product());
        return "product/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("productNew") Product product, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "product/create";
        }
        iProductService.save(product);
        redirectAttributes.addFlashAttribute("messages", "You have successfully created a new product ");
        return "redirect:/products";
    }

    @GetMapping("/{id}/update")
    public String showUpdate(@PathVariable(name = "id") int id, Model model) {
        Product product = iProductService.findById(id);
        model.addAttribute("product", product);
        return "product/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute(name = "product") Product product, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "product/update";
        }
        iProductService.update(product);
        redirectAttributes.addFlashAttribute("messages", "You have successfully updated a product ");
        return "redirect:/products";
    }

    @GetMapping("/{id}/delete")
    private String delete(@PathVariable(name = "id") int id, RedirectAttributes redirectAttributes) {
        iProductService.delete(id);
        redirectAttributes.addFlashAttribute("messages", "You have successfully deleted a product ");
        return "redirect:/products";
    }

    @PostMapping("search")
    public String search(@RequestParam(name = "nameSearch") String nameSearch, Model model) {
        List<Product> list = iProductService.search(nameSearch);
        model.addAttribute("list", list);
        return "product/list";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable(name = "id") int id, Model model) {
        Product product = iProductService.findById(id);
        model.addAttribute("productV", product);
        return "product/view";
    }

}
