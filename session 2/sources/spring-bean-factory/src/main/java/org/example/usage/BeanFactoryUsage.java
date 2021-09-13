package org.example.usage;

import org.example.bean.Organization;
import org.example.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanFactoryUsage {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Organization organization = context.getBean(Organization.class);

        System.out.println(organization);
    }
}
