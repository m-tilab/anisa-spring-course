package org.example.controller;

import org.example.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrganizationController extends AbstractController {

    @Autowired
    private OrganizationService organizationService;

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        ModelAndView modelAndView = new ModelAndView("organizations");

        modelAndView.addObject("organizations", organizationService.getOrganizations());

        return modelAndView;
    }

    /*@RequestMapping("/organizations")
    public String organizations(Model model) {

        model.addAttribute("organizations", organizationService.getOrganizations());

        return "organizations";
    }*/
}
