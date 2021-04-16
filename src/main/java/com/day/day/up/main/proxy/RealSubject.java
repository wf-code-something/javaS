package com.day.day.up.main.proxy;

/**
 * @author admin
 */
public class RealSubject implements Subject{
    @Override
    public String sayHello(String name, int age) {
        return name + "，" + age;
    }
}
