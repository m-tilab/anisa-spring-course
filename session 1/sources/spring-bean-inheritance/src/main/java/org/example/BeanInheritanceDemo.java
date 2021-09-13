package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanInheritanceDemo {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        Parent parent = (Parent)context.getBean("parent");

        Child child = (Child)context.getBean("child");

        //parent.setFirstname("ali");

        child.setLastname("taghizadeh");

        System.out.println(parent);
        System.out.println(child);
    }
}
