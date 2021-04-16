package com.day.day.up.main.design.struct.adpater;

/**
 * 类适配器模式 Adapter与Adaptee 是继承关系，则表示这是类适配器模式
 *
 * @author admin
 */
public class Adapter extends Adaptee implements Target{

    @Override
    public void method2() {
        System.out.println("this is Adapter");
    }
}
