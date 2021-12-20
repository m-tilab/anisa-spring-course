package com.example.springbootrest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/web/user")
public class UserWebController {

    @GetMapping
    public ModelAndView getUsers() {

        var modelAndView = new ModelAndView();
        modelAndView.setViewName("users");

        return modelAndView;
    }
}
