package com.example.springbootdemo.thread.test;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Test test = new Test();
        Runnable runnable = test::doSomething;
        new Thread(runnable).start();
        Thread.sleep(2000);
        System.out.println("当前线程ID:" + Thread.currentThread());
    }



}

class Test{
    void doSomething(){
        System.out.println("do something");
        System.out.println("当前线程ID:" + Thread.currentThread());
    }

}
