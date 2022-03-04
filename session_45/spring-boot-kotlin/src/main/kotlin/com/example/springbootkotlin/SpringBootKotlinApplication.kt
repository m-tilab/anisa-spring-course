package com.example.springbootkotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootKotlinApplication

fun main(args: Array<String>) {
    runApplication<SpringBootKotlinApplication>(*args)
}


