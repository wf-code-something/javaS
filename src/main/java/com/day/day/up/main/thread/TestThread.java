package com.day.day.up.main.thread;

/**
 * @author admin
 */
public class TestThread {

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 5; i++) {
            Thread t1 = new Thread(new MyRunnable(i));
            t1.start();
            System.out.println(t1.getName());
        }
        System.out.println("this is main running");
    }

    private static class MyRunnable implements Runnable {

        private final int size;

        public MyRunnable(int size) {
            this.size = size;
        }

        @Override
        public void run() {
            System.out.println("this is thread running " + size);
        }
    }


}
