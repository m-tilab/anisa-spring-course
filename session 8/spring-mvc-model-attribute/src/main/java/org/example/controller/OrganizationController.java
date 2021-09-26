package org.example.controller;

import org.example.domain.Organization;
import org.example.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/organization")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @RequestMapping(value = "/editOrganization", method = RequestMethod.GET)
    @ModelAttribute
    public Organization getOrganization(@RequestParam(required = false, defaultValue = "0") int organizationId) {

        if (organizationId > 0 && organizationService.getOrganization(organizationId) != null) {
            return organizationService.getOrganization(organizationId);

        } else {

            return new Organization();
        }
    }

    @RequestMapping(value = {"/add", "/update"}, method = RequestMethod.POST)
    public ModelAndView addOrganization(@ModelAttribute Organization organization, Model model) {

        //var modelAndView = new ModelAndView("organizations");


        //var modelAndView = new ModelAndView();

        int organizationId = organization.getOrganizationId();

        if (organizationId > 0 && organizationService.getOrganization(organizationId) != null) {

            organizationService.updateOrganization(organizationId, organization.getCompanyName(),
                    organization.getYearOfIncorporation(),
                    organization.getPostalCode(),
                    organization.getEmployeeCount(), organization.getSlogan());

        } else {

            organizationService.addOrganization(organization.getCompanyName(),
                    organization.getYearOfIncorporation(),
                    organization.getPostalCode(),
                    organization.getEmployeeCount(), organization.getSlogan());

        }

        //modelAndView.addObject("organizations", organizationService.getOrganizations());

        //modelAndView.setViewName("organizations");

        var modelAndView = new ModelAndView("organization/organizations",
                "organizations", organizationService.getOrganizations());

        return modelAndView;
    }

    @RequestMapping("/organizations")
    public void organizations(Model model) {

        organizationService.printOrganizations();

        model.addAttribute("organizations", organizationService.getOrganizations());
    }

    @ModelAttribute
    public void modelAttributeTest1(Model model) {

        model.addAttribute("data1", "modelAttributeTest1 called");
    }

    @ModelAttribute(name = "data2")
    public String modelAttributeTest2() {

        return "modelAttributeTest2 Called";
    }
}
