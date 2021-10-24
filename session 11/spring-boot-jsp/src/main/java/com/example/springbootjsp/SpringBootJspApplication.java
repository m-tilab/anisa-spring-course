package com.example.springbootjsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.example")
@SpringBootApplication
public class SpringBootJspApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJspApplication.class, args);
    }

}
