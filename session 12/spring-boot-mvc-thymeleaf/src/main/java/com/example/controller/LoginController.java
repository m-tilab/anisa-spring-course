package com.example.controller;

import com.example.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class LoginController {

    /*@GetMapping("/login/{name}")
    public String loginPage(@PathVariable String name, @RequestParam String random) {

        System.out.println(name);

        System.out.println(random);

        return "login";
    }*/

    @GetMapping("/login")
    public ModelAndView loginPage(ModelAndView modelAndView) {

        log.info("loginPage method called");

        User user = new User();
        user.setUsername("my username");
        user.setPassword("my password");

        modelAndView.addObject("user", user);
        modelAndView.setViewName("login");

        return modelAndView;
    }

    @PostMapping("/login")
    public String doLogin(@ModelAttribute User user, Model model) {

        System.out.println(user.getUsername());
        System.out.println(user.getPassword());

        if (!user.getPassword().equals("123")) {

            model.addAttribute("error", "incorrect password");
            System.out.println("!user.getPassword().equals(123)");
        }

        return "login";
        // return "redirect:/login";
    }


}
