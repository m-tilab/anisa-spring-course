package org.example;

import org.example.bean.Student;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

public class ContextUsage {

    public static void main(String[] args) {

        //ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        //Student student = (Student) context.getBean("student");
        //Student student = new Student();

        BeanFactory context = new XmlBeanFactory(new ClassPathResource("spring.xml"));

        Student student = (Student) context.getBean("student");


        student.setFirstname("ali");
        student.setLastname("akbari");

        System.out.println(student);
    }
}
