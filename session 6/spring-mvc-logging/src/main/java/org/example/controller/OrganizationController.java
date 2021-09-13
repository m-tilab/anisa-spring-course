package org.example.controller;

import org.example.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @RequestMapping("/organizations")
    public String organizations(Model model) {

        organizationService.printOrganizations();

        model.addAttribute("organizations", organizationService.getOrganizations());

        return "organizations";
    }
}
