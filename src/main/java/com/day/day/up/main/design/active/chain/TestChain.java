package com.day.day.up.main.design.active.chain;

public class TestChain {
    public static void main(String[] args) {
        MyHandler myHandler = new MyHandler("myhandle");
        MyHandler myHandler1 = new MyHandler("myhandle1");
        MyHandler myHandler2 = new MyHandler("myhandle2");
        myHandler.setHandler(myHandler1);
        myHandler1.setHandler(myHandler2);
        myHandler.operator();
    }
}

