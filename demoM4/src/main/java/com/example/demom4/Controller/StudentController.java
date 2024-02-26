package com.example.demom4.Controller;

import com.example.demom4.Model.Student;
import com.example.demom4.Service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    //    DI
//    Có 3 cách: Field, constructor, setter
    @Autowired
    private IStudentService studentService;

    @GetMapping("/")
    public String showList(Model model) {
        List<Student> studentList = studentService.findAll();
        model.addAttribute("listStudent", studentList);
        return "/view";
    }

    @GetMapping("/create")
    public String showPageCreate() {
        return "create";
    }

    @PostMapping("/create")
    public void addStudent() {

    }
}
