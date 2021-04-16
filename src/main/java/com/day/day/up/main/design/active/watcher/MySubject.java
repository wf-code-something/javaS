package com.day.day.up.main.design.active.watcher;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author admin
 */
public class MySubject implements Subject{

    private Vector<Observer> observerList = new Vector<>();

    @Override
    public void add(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void delete(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyAllObservers() {
        Enumeration<Observer> elements = observerList.elements();
        while (elements.hasMoreElements()) {
            elements.nextElement().update();
        }
    }

    @Override
    public void operation() {
        System.out.println("update self");
        notifyAllObservers();
    }
}
