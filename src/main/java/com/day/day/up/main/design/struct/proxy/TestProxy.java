package com.day.day.up.main.design.struct.proxy;

/**
 * ้ๆไปฃ็
 *
 * @author admin
 */
public class TestProxy {
    public static void main(String[] args) {
        Sourceable proxy = new Proxy(new Source());
        proxy.method();
    }
}
