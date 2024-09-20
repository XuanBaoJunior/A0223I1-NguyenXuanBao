package com.example.demo_bai_test.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/staffs")
public class StaffController {
    @RequestMapping("")
    public String listStaff(){
        return "view-staffs";
    }
}
