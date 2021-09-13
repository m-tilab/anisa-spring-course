package org.example.controller;

import org.example.domain.Organization;
import org.example.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @RequestMapping
    public String listOrganizationUsingSQLTag(){
        return "listOrganization1";
    }

    @RequestMapping("/service")
    public String listOrganizationUsingService(Model model){
        var organizations = organizationService.getOrganizations();
        model.addAttribute("organizations", organizations);

        return "listOrganization2";
    }

}
