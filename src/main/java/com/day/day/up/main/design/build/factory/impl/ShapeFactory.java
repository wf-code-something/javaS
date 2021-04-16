package com.day.day.up.main.design.build.factory.impl;

import com.day.day.up.main.design.build.factory.AbstractFactory;
import com.day.day.up.main.design.build.factory.Color;
import com.day.day.up.main.design.build.factory.Shape;

public class ShapeFactory extends AbstractFactory {

    @Override
    public Shape getShape(String name) {
        if("Circle".equals(name)){
            return new Circle();
        } else if ("Square".equals(name)) {
            return new Square();
        } else if ("Rectangle".equals(name)) {
            return new Rectangle();
        }
        return null;
    }

    @Override
    public Color getColor(String name) {
        return null;
    }
}
