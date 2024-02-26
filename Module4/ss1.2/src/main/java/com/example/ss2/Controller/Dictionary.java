package com.example.ss2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/views")
public class Dictionary {
    private String[] dictionary = {"hello", "world", "spring", "mvc"};

    @GetMapping("/")
    public String showHome() {
        return "home";
    }

    @GetMapping("/lookup")
    public ModelAndView lookupWord(@RequestParam("word") String word) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("result");

        for (String entry : dictionary) {
            if (entry.equalsIgnoreCase(word)) {
                modelAndView.addObject("word", word);
                modelAndView.addObject("meaning", "Nghĩa của từ \"" + word + "\" là ...");
                return modelAndView;
            }
        }

        modelAndView.addObject("word", word);
        modelAndView.addObject("meaning", "Không tìm thấy từ này trong từ điển.");
        return modelAndView;
    }
}
