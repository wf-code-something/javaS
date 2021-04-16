package com.day.day.up.main.design.build.single;

/**
 * 采用加锁方式实现单例模式
 *
 * @author admin
 */
public class Singleton {

    private static Singleton singleton = null;

    private Singleton(){

    }

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (singleton) {
                if (singleton == null) {
                    return new Singleton();
                }
            }
        }
        return singleton;
    }

}
