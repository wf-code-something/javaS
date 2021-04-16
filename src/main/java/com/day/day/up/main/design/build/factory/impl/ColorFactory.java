package com.day.day.up.main.design.build.factory.impl;

import com.day.day.up.main.design.build.factory.AbstractFactory;
import com.day.day.up.main.design.build.factory.Color;
import com.day.day.up.main.design.build.factory.Shape;

public class ColorFactory extends AbstractFactory {

    @Override
    public Shape getShape(String name) {
        return null;
    }

    @Override
    public Color getColor(String name) {
        if("Red".equals(name)){
            return new Red();
        } else if ("Green".equals(name)) {
            return new Green();
        } else if ("Yellow".equals(name)) {
            return new Yellow();
        }
        return null;
    }
}
