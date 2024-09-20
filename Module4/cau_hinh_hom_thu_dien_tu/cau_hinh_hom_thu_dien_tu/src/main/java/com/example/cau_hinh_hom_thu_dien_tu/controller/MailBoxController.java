package com.example.cau_hinh_hom_thu_dien_tu.controller;


import com.example.cau_hinh_hom_thu_dien_tu.model.MailBox;
import com.example.cau_hinh_hom_thu_dien_tu.service.IMailBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/email")
public class MailBoxController {
    @Autowired
    private IMailBoxService iMailBoxService;

    @GetMapping("")
    public String show(Model model) {
        MailBox mailBox = iMailBoxService.findAll();
        model.addAttribute("mailBox", mailBox);
        return "box";
    }

    @GetMapping("/update")
    public String update(Model model) {
        MailBox mailBox = iMailBoxService.findAll();
        model.addAttribute("mailBox", mailBox);
        model.addAttribute("languages", new String[]{"English", "Vietnamese", "Japanese", "Chinese", "Korea"});
        model.addAttribute("size", new int[]{5, 10, 15, 20, 25});
        return "setting";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute(name = "mailBox") MailBox mailBox) {
        iMailBoxService.save(mailBox);
        return "redirect:/email";
    }
}
