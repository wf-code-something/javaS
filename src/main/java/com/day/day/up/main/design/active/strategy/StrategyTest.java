package com.day.day.up.main.design.active.strategy;

import com.day.day.up.main.design.active.strategy.impl.Multiply;
import com.day.day.up.main.design.active.strategy.impl.Plus;

public class StrategyTest {
    public static void main(String[] args) {
        String str = "5*3";
        ICalculator calculator = new Multiply();
        int calculator1 = calculator.calculator(str);
        System.out.println(calculator1);
    }
}
