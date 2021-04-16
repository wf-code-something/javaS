package com.day.day.up.main.design.build.factory.impl;

import com.day.day.up.main.design.build.factory.AbstractFactory;

/**
 * @author admin
 */
public class FactoryProducer{

    public static AbstractFactory getFacotry(String name) {
        if (name.equals("Shape")) {
            return new ShapeFactory();
        } else if (name.equals("Color")) {
            return new ColorFactory();
        }
        return null;
    }

}
