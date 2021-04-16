package com.day.day.up.main.design.active.watcher;

public interface Subject {

    void add(Observer observer);

    void delete(Observer observer);

    void notifyAllObservers();

    void operation();
}
