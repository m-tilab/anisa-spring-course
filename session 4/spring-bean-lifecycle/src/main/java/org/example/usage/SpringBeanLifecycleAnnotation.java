package org.example.usage;

import org.example.bean.Member;
import org.example.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanLifecycleAnnotation {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Member member = (Member) context.getBean(Member.class);

        System.out.println("after init Member Bean");

        context.close();

    }
}
