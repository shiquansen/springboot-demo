package com.example.springbootdemo.thread;

import org.springframework.stereotype.Component;

@Component
public class ThreadService {

    @ThreadStart
    public void doSomething() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println(Thread.currentThread() + "   :do something");
    }
}
