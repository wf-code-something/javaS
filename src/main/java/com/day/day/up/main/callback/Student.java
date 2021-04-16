package com.day.day.up.main.callback;

public class Student {

    public void b(AnswerCallBack callBack) throws InterruptedException {
        System.out.println("student is answer");
        callBack.tellAnswer(80);
    }
}
