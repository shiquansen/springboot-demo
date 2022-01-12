package com.example.springbootdemo.proxy;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class ProxyTest {
    @Resource
    ProxyService proxyService;

    @Test
    void testProxyService(){
        proxyService.doSomething();
    }
}
