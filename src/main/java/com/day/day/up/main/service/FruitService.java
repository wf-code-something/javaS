package com.day.day.up.main.service;

/**
 * @author admin
 */
public interface FruitService<T> {

    void eat();

    void put(T t);

    T get(long id);

    void del(long id);
}
