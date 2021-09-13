package org.example.factory;

import org.example.bean.Organization;

public class OrganizationFactory {

    public Organization getInstance() {

        System.out.println("OrganizationFactory.getInstance invoked");

        return new Organization("Adobe2", "instance slogan2", 1970, 3500);
    }
}
