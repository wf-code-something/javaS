package com.day.day.up.main.design.active.watcher;

public class Observer1 implements Observer{
    @Override
    public void update() {
        System.out.println("observer1 has received");
    }
}
