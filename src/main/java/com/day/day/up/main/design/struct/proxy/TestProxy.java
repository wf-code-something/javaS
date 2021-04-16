package com.day.day.up.main.design.struct.proxy;

/**
 * 静态代理
 *
 * @author admin
 */
public class TestProxy {
    public static void main(String[] args) {
        Sourceable proxy = new Proxy(new Source());
        proxy.method();
    }
}
