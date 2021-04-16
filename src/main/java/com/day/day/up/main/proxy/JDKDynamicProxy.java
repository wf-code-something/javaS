package com.day.day.up.main.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author admin
 */
public class JDKDynamicProxy implements InvocationHandler {

    private Object object = null;

    public Object bind(Object object) {
        this.object = object;
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), object.getClass().getInterfaces(),this);
    }


    public void before() {
        System.out.println("before");
    }
    public void after() {
        System.out.println("after");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object o = method.invoke(object, args);
        System.out.println("result->"+o);
        after();
        return o;
    }
}
