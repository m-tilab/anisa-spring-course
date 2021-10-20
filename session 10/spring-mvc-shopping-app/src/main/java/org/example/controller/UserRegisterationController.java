package org.example.controller;

import org.example.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserRegisterationController {

    @GetMapping("/register")
    public ModelAndView viewRegisterPage() {

        return new ModelAndView("/user/register", "userDTO", new UserDTO());
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute UserDTO userDTO, BindingResult bindingResult) {

        if (bindingResult.hasErrors())
            return "/user/register";

        return "/home";
    }
}
