package com.day.day.up.main.design.active.template;

public abstract class AbstractCalculator {

    public final int calculate(String exp, String opt) {
        int array[] = split(exp, opt);
        return calculate(array[0], array[1]);
    }

    public abstract int calculate(int a, int b);

    public int[] split(String exp, String opt) {
        String[] strings = exp.split(opt);
        int[] results = new int[2];
        results[0] = Integer.parseInt(strings[0]);
        results[1] = Integer.parseInt(strings[1]);
        return results;
    }
}
