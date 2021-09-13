package org.example.usage;

import org.example.bean.LazyBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringInitializationUsage {

    public static void main(String[] args) {

        ApplicationContext  context = new ClassPathXmlApplicationContext("spring.xml");

        System.out.println("eager beans initialized");

        LazyBean lazyBean = (LazyBean) context.getBean("lazyBean");


    }
}
