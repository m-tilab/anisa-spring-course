package org.example.beans;

import org.springframework.stereotype.Component;
@Component
public class DrawShape {

    private Shape shape;

    public DrawShape(Shape shape) {
        this.shape = shape;
    }

    public void draw() {

        shape.draw();
    }
}
