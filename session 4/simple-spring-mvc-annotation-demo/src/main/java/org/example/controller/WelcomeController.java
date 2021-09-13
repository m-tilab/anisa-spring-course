package org.example.controller;

import org.example.service.GenericWelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class WelcomeController {

    @Autowired
    private GenericWelcomeService welcomeService;

    @RequestMapping("/")
    public String doWelcome(Model model) {

        //WelcomeService welcomeService = new WelcomeService();
        List<String> myWelcomeMessage = welcomeService.getWelcomeMessage("Ahmad Ahmadi");

        model.addAttribute("myWelcomeMessage", myWelcomeMessage);

        return "welcome";
    }
}
