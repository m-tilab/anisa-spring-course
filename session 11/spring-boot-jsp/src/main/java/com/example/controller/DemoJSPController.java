package com.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class DemoJSPController {

    @GetMapping("welcome")
    public String welcome(Model model) {

        log.info("welcome method called");

        model.addAttribute("message", "Spring Course");
        
        return "welcome";
    }
}
