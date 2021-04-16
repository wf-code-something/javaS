package com.day.day.up.main.callback;

import lombok.SneakyThrows;

public class Teacher implements AnswerCallBack{

    private Student student;

    Teacher(Student student) {
        this.student = student;
    }

    public void a(Student student,Teacher teacher) throws InterruptedException {
        student.b(teacher);
    }

    @Override
    public void tellAnswer(int res) {
        System.out.println("the answer is " + res);
    }
}
