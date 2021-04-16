package com.day.day.up.main.design.build.factory.test;

import com.day.day.up.main.design.build.factory.AbstractFactory;
import com.day.day.up.main.design.build.factory.Color;
import com.day.day.up.main.design.build.factory.impl.FactoryProducer;

public class TestAbstractFactory {

    public static void main(String[] args) {
        AbstractFactory color = FactoryProducer.getFacotry("Color");
        Color green = color.getColor("Green");
        green.write();
    }
}
