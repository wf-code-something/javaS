package com.day.day.up.main.design.struct.adpater;

/**
 * 对象适配器模式，被适配的可以是当前类以及对应的子类都可以被适配成Target的功能
 * Adapter与Adaptee是组合关系
 *
 * @author admin
 */
public class ObjectAdapter implements Target {

    private SubAdaptee adaptee;

    public ObjectAdapter(SubAdaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void method1() {
        adaptee.method1();
    }

    @Override
    public void method2() {
        System.out.println("this is Adapter");
    }

    public void method3(){
        adaptee.method3();
    }
}
