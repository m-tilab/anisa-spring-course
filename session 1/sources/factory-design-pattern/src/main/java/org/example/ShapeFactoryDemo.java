package org.example;

public class ShapeFactoryDemo {

    public static void main(String[] args) {

        Shape shape = ShapeFactory.drawShape("circle");

        shape.draw();
    }
}
