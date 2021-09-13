package org.example.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("Rectangle draw called");
    }
}
