package org.example.usage;

import org.example.Student;
import org.example.beans.DrawShape;
import org.example.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DrawingUsage {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        DrawShape drawShape = (DrawShape) context.getBean("drawShape");

        //context.getBean(Student.class);

        drawShape.draw();

    }
}
