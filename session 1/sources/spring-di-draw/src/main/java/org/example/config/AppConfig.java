package org.example.config;

import org.example.Student;
import org.example.beans.DrawShape;
import org.example.beans.Rectangle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "org.example.beans")
@Import(Student.class)
public class AppConfig {

    @Bean
    public DrawShape drawShape() {

        return new DrawShape(new Rectangle());
    }
}
