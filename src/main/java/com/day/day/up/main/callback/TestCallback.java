package com.day.day.up.main.callback;

public class TestCallback {
    public static void main(String[] args) throws InterruptedException {
        Student tom = new Student();
        Teacher lee = new Teacher(tom);
        lee.a(tom, lee);
    }
}
