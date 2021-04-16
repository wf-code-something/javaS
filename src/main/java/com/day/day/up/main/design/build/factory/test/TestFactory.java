package com.day.day.up.main.design.build.factory.test;

import com.day.day.up.main.design.build.factory.Shape;
import com.day.day.up.main.design.build.factory.impl.ShapeFactory;

public class TestFactory {

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape circle = shapeFactory.getShape("Circle");
        circle.draw();
    }
}
