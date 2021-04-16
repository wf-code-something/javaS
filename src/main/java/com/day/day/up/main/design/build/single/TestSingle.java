package com.day.day.up.main.design.build.single;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;

/**
 * @author admin
 */
@Component
public class TestSingle implements Runnable{

    @Autowired
    private Executor executor;

    public void testThread() {
        for (int i = 0; i < 2; i++) {
            executor.execute(new TestSingle());
        }
    }

    @Override
    public void run() {

        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        //比较地址
        System.out.println(instance == instance1);
    }
}
