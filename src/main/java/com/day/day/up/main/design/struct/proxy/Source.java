package com.day.day.up.main.design.struct.proxy;

public class Source implements Sourceable{
    @Override
    public void method() {
        System.out.println("this is original method");
    }
}
