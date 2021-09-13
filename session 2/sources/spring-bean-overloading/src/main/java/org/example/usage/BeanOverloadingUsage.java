package org.example.usage;

import org.example.bean.Organization;
import org.example.config.AppConfigA;
import org.example.config.AppConfigB;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanOverloadingUsage {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfigA.class, AppConfigB.class);

        Organization organization = context.getBean(Organization.class);

        System.out.println(organization);
    }
}
