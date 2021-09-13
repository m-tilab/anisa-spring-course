package org.example;

public class ShapeFactoryUsage {

    public static void main(String[] args) {

        ShapeFactory shapeFactory = new ShapeFactory();

        Shape shape = shapeFactory.DrawShape("circle");

        shape.draw();
    }
}
