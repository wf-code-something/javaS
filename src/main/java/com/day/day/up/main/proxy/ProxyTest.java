package com.day.day.up.main.proxy;

/**
 * @author admin
 */
public class ProxyTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        extracted();
    }

    private static void extracted() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        JDKDynamicProxy jdkDynamicProxy = new JDKDynamicProxy();
        Subject subject = (Subject) jdkDynamicProxy.bind(Class.forName("com.day.day.up.main.proxy.RealSubject").newInstance());
        System.out.println(subject.sayHello("wf", 12));

        OtherSubject otherSubject = (OtherSubject) jdkDynamicProxy.bind(new OtherReallySubject());
        System.out.println(otherSubject.otherMethod());
    }
}
