package com.example.ss2calculator.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/views/")
public class CalculatorController {

    @GetMapping("calculator")
    public  String showCalculatorForm(){
        return "index";
    }
    @PostMapping("calculator")
    public String calculator(@RequestParam("num1") int num1, @RequestParam("num2") int num2, @RequestParam("operator") String operator, Model model){
        double result = 0;
        switch (operator){
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / (double) num2;
                break;
            default:
                model.addAttribute("error", "Invalid operator");
                return "error";
        }
        model.addAttribute("result", result);
        return "result";
    }
}
