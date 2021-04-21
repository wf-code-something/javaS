package com.day.day.up.main;

import lombok.SneakyThrows;

public class SimpleTest {

    private String root = getClass().getResource("/").getPath();

    public static void main(String[] args) throws ClassNotFoundException {

        SimpleTest simpleTest = new SimpleTest();
        Class clazz = Class.forName("com.day.day.up.main.service.impl.AppleServiceImpl");
        System.out.println(simpleTest.root);
        clazz.getClass().getName();
        //test(args);
    }

    @SneakyThrows(ArithmeticException.class)
    public static void testTryCatch(int i) {
        System.out.println(5 / i);
    }

    public static void test(int i,String... args) {
        int length = args.length;
        System.out.println(length);

        for (String s : args) {
            System.out.println(s);
        }
        test(args);
    }

    public static void test(String[] args) {
        int length = args.length;
        System.out.println(length);

        for (String s : args) {
            System.out.println(s);
        }

    }
}
