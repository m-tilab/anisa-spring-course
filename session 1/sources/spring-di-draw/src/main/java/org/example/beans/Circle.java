package org.example.beans;

import org.springframework.stereotype.Component;

@Component
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Circle draw called");
    }
}
