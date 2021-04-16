package com.day.day.up.main.design.build.factory.impl;

import com.day.day.up.main.design.build.factory.Shape;

public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("this is square");
    }
}
