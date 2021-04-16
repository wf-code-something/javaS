package com.day.day.up.main.design.struct.proxy;

public class Proxy implements Sourceable {

    private Source source;

    public Proxy(Source soure) {
        this.source = soure;
    }

    @Override
    public void method() {
        System.out.println("this is proxy start");
        source.method();
        System.out.println("this is proxy end");
    }
}
