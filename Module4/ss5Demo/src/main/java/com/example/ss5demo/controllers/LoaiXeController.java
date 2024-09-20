package com.example.ss5demo.controllers;

import com.example.ss5demo.models.LoaiXe;
import com.example.ss5demo.services.ILoaiXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/loaixe")
public class LoaiXeController {
    private ILoaiXeService loaiXeService;

    @Autowired
    public LoaiXeController(ILoaiXeService loaiXeService) {
        this.loaiXeService = loaiXeService;
    }
    @GetMapping("")
    public String showList(Model model){
        List<LoaiXe> loaiXeList = loaiXeService.findAll();
        model.addAttribute("listLoaiXe", loaiXeList);
        return "list";
    }
    @RequestMapping("/{code}/update")
    public String showUpdate(Model model, @PathVariable(name="code")Integer code){
        List<LoaiXe> loaiXeList = loaiXeService.findOneByID(code);
        model.addAttribute("listLoaiXe", loaiXeList);
        return "list";
    }

}
