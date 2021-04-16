package com.day.day.up.main.design.build.factory.impl;

import com.day.day.up.main.design.build.factory.Shape;

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("this is Rectangle");
    }
}
