package com.example.springbootdemo.thread;

import com.example.springbootdemo.proxy.ProxyService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class ThreadTest {
    @Resource
    ThreadService threadService;

    @Test
    void doSomething() throws InterruptedException {
        threadService.doSomething();
        Thread.sleep(2000);
        System.out.println(Thread.currentThread() + "   :test   do something");
    }
}
