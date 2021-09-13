package org.example.demo;

import org.example.anotherbean.AnotherElseStudent;
import org.example.anotherbean.AnotherStudent;
import org.example.bean.Student;
import org.example.bean.Teacher;
import org.example.config.AnotherAppConfig;
import org.example.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StudentContextDemo {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class, AnotherAppConfig.class);

        Student student = context.getBean(Student.class);


        student.setFirstname("ali");
        student.setLastname("akbari");

        System.out.println(student);

        Teacher teacher = (Teacher) context.getBean("teacher");
        teacher.setFirstname("taghi");
        teacher.setLastname("alizadeh");

        System.out.println(teacher);

        AnotherStudent anotherStudent = (AnotherStudent) context.getBean("anotherStudent");
        anotherStudent.setFirstname("hoda");
        anotherStudent.setLastname("saberi");

        System.out.println(anotherStudent);

        AnotherElseStudent anotherElseStudent = context.getBean(AnotherElseStudent.class);
        anotherElseStudent.setFirstname("hoda2");
        anotherElseStudent.setLastname("saberi2");

        System.out.println(anotherElseStudent);


    }
}
