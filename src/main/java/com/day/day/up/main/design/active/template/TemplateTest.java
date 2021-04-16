package com.day.day.up.main.design.active.template;

public class TemplateTest {

    public static void main(String[] args) {
        String str = "4*5";
        AbstractCalculator a = new Multiply();
        int calculate = a.calculate(str, "\\*");
        System.out.println("result is " + calculate);
    }
}
