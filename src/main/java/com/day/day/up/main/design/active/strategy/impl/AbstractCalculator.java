package com.day.day.up.main.design.active.strategy.impl;

public class AbstractCalculator {

    public int[] split(String exp, String splitStr) {
        String[] strings = exp.split(splitStr);
        int[] results = new int[2];
        results[0] = Integer.parseInt(strings[0]);
        results[1] = Integer.parseInt(strings[1]);
        return results;
    }
}
