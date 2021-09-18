package org.example.controller;

import org.example.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/organization")
public class AddOrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(@RequestParam(required = false) int orgId, Model model) {

        if (orgId > 0 && organizationService.getOrganization(orgId) != null) {

            model.addAttribute("organization", organizationService.getOrganization(orgId));
        }

        return "editOrganization";
    }

    @RequestMapping(value = {"/add", "/update"}, method = RequestMethod.POST)
    public String addOrganization(@RequestParam int orgId, @RequestParam("companyName") String companyName,
                                  @RequestParam(value = "yearOfIncorporation", defaultValue = "1") int yearOfIncorporation,
                                  @RequestParam int postalCode,
                                  @RequestParam(value = "employeeCount", defaultValue = "1") int employeeCount,
                                  @RequestParam String slogan, Model model) {

        if (orgId > 0 && organizationService.getOrganization(orgId) != null) {

            organizationService.updateOrganization(orgId, companyName, yearOfIncorporation, postalCode,
                    employeeCount, slogan);

        } else {

            organizationService.addOrganization(companyName, yearOfIncorporation, postalCode,
                    employeeCount, slogan);

        }

        model.addAttribute("organizations", organizationService.getOrganizations());

        return "organizations";
    }
}
