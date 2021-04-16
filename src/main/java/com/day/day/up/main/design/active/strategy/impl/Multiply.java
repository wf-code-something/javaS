package com.day.day.up.main.design.active.strategy.impl;

import com.day.day.up.main.design.active.strategy.ICalculator;

public class Multiply extends AbstractCalculator implements ICalculator {

    @Override
    public int calculator(String exp) {
        int[] arrays = split(exp, "\\*");
        return arrays[0] * arrays[1];
    }
}
