package com.day.day.up.main.proxy;

/**
 * @author admin
 */
public class SubjectStaticProxy implements Subject {

    private Subject subject;

    public SubjectStaticProxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String sayHello(String name, int age) {
        before();
        String s = subject.sayHello(name, age);
        after();
        return s;
    }

    public void before() {
        System.out.println("before");
    }
    public void after() {
        System.out.println("after");
    }
}
