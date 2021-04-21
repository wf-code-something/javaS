package com.day.day.up.main.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib 和jdkProxy示例代码
 *
 * @author admin
 */
public class ProxyTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        extractedJdkProxy();
        extractedCglibProxy();
    }

    private static void extractedJdkProxy() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        JDKDynamicProxy jdkDynamicProxy = new JDKDynamicProxy();
        Subject subject = (Subject) jdkDynamicProxy.bind(Class.forName("com.day.day.up.main.proxy.RealSubject").newInstance());
        System.out.println(subject.sayHello("wf", 12));

        OtherSubject otherSubject = (OtherSubject) jdkDynamicProxy.bind(new OtherReallySubject());
        System.out.println(otherSubject.otherMethod());
    }

    private static void extractedCglibProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CglibClass.class);
        enhancer.setCallback(new MethodInterceptorImpl());
        CglibClass o = (CglibClass) enhancer.create();
        o.testCglibMethod();
        System.out.println(o);
    }

    private static class MethodInterceptorImpl implements MethodInterceptor {

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("before" + method);
            Object invoke = methodProxy.invokeSuper(o, objects);
            System.out.println("after" + method);
            return invoke;
        }
    }

}
