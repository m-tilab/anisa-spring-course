package org.example.org.example.usage;

import org.example.bean.Member;
import org.example.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanQualifierUsage {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Member member = context.getBean(Member.class);

        System.out.println(member);


    }
}
