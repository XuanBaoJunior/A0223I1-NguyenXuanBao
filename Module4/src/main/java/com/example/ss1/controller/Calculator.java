package com.example.ss1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Calculator {

    @GetMapping("/")
    public String showConverterForm() {
        return "list";
    }

    @GetMapping("/convert")
    public ModelAndView convertUSDToVND(@RequestParam("usdAmount") double usdAmount){
        double exchangeRate = 23000;
        double vndAmount = usdAmount * exchangeRate;
        ModelAndView modelAndView = new ModelAndView("result");
        modelAndView.addObject("usdAmount", usdAmount);
        modelAndView.addObject("vndAmount", vndAmount);
        return modelAndView;
    }
}
