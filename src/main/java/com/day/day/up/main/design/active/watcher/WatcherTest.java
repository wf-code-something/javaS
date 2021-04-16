package com.day.day.up.main.design.active.watcher;

public class WatcherTest {

    public static void main(String[] args) {
        Observer1 o1 = new Observer1();
        Observer2 o2 = new Observer2();
        MySubject mySubject = new MySubject();
        mySubject.add(o1);
        mySubject.add(o2);
        mySubject.operation();
        System.out.println("-------");
        mySubject.delete(o2);
        mySubject.operation();

    }
}
