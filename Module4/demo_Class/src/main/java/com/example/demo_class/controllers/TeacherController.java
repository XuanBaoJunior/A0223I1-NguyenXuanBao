package com.example.demo_class.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @RequestMapping("")
    public String listTeacher(){
        return "view-staffs";
    }
}
