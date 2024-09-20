package com.example.ss7demo.controllers;

import com.example.ss7demo.models.LoaiXe;
import com.example.ss7demo.services.ILoaiXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @PostMapping("/delete")
    public String delete(@RequestParam Integer code){
        loaiXeService.deleteById(code);
        return "redirect:/loaixe";
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        LoaiXe loaiXe = new LoaiXe();
        loaiXe.setId_loai_xe(3);
        model.addAttribute("loaiXe", loaiXe);
        return "create";
    }

    @PostMapping("/create")
    public String addStudent(@ModelAttribute("student") LoaiXe loaiXe, BindingResult bindingResult,
                             RedirectAttributes redirect) {
        if(bindingResult.hasErrors()) {
            return "create";
        }
        loaiXeService.save(loaiXe);
        redirect.addFlashAttribute("message", "Thêm mới thành công");
//       Redirect chuyển về trang list
        return "redirect:/loaixe";
    }
//    @RequestMapping("/{code}/update")
//    public String showUpdate(Model model, @PathVariable(name="code")Integer code){
//        List<LoaiXe> loaiXeList = loaiXeService.findOneByID(code);
//        model.addAttribute("listLoaiXe", loaiXeList);
//        return "list";
//    }

}
