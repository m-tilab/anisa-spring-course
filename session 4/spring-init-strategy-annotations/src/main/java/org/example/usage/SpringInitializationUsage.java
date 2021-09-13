package org.example.usage;

import org.example.bean.LazyBean;
import org.example.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringInitializationUsage {

    public static void main(String[] args) {

        ApplicationContext  context = new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("eager beans initialized");

        LazyBean lazyBean = context.getBean(LazyBean.class);


    }
}
