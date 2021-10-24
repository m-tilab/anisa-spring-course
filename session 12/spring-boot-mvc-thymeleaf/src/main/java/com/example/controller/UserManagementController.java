package com.example.controller;

import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserManagementController {

    private final UserService userService;

    public UserManagementController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ModelAndView browseUsers() {

        var modelAndView = new ModelAndView();

        modelAndView.setViewName("users");
        modelAndView.addObject("users", userService.getUsers());
        modelAndView.addObject("pageTitle", "user-management");

        return modelAndView;
    }
}
