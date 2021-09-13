package org.example.usage;

import org.example.bean.Member;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanLifecycleXML {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        Member member = (Member) context.getBean("member");

        System.out.println("after init Member Bean");

        context.close();

    }
}
