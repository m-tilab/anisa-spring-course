package org.example.config;

import org.example.anotherbean.AnotherElseStudent;
import org.example.anotherbean.AnotherStudent;
import org.example.bean.Teacher;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = {"org.example.bean"})
//@ComponentScan(basePackages = "org.example.anotherbean")
@ImportResource("spring.xml")
//@Import({AnotherStudent.class, AnotherElseStudent.class})
public class AppConfig {

    @Bean(name = "teacher")
    Teacher getTeacher() {

        return new Teacher();
    }
}
