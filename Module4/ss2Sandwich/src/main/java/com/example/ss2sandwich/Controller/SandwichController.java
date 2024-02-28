package com.example.ss2sandwich.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/views/")
public class SandwichController {

    @GetMapping(value = "/sandwich")
    public String showSandwichForm(){
        return "sandwichForm";
    }
    @PostMapping(value = "/sandwich")
    public String processSandwichForm(@RequestParam(value = "condiments", required = false) String[] condiments, Model model){
        model.addAttribute("selectedCondiments", condiments);
        return "sandwichResult";
    }
}
