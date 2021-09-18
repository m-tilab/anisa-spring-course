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

@Controller
@RequestMapping("/organization")
public class AddOrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @ModelAttribute
    public Organization getOrganization(@RequestParam int organizationId) {
        return organizationService.getOrganization(organizationId);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(@RequestParam(required = false) int organizationId, Model model) {

        return "editOrganization";
    }

    @RequestMapping(value = {"/add", "/update"}, method = RequestMethod.POST)
    public String addOrganization(@ModelAttribute Organization organization, Model model) {

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

        model.addAttribute("organizations", organizationService.getOrganizations());

        return "organizations";
    }
}
