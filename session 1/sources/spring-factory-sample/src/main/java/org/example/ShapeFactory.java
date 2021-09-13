package org.example;

public class ShapeFactory {

    Shape DrawShape(String shapeType) {

        if (shapeType.equals("rectangle"))
            return new Rectangle();
        else if (shapeType.equals("circle"))
            return new Circle();
        else
            return null;

    }
}
