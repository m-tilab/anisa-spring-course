package com.example.springbootmvcdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example")
public class SpringBootMvcDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMvcDemoApplication.class, args);
    }

}
