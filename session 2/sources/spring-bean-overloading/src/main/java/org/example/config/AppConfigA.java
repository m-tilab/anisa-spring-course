package org.example.config;

import org.example.bean.Organization;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example.bean")

public class AppConfigA {

    @Bean
    public Organization getOrganization() {

        Organization organization = new Organization();
        organization.setTitle("MSI");
        organization.setNumberOfEmployee(1500);

        return organization;

    }
}
