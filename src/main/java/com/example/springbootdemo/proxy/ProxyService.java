package com.example.springbootdemo.proxy;

import org.springframework.stereotype.Component;

@Component
public class ProxyService {

    @IPointCut
    public void doSomething(){
        System.out.println("处理业务逻辑。。。。。。。。。。。。。");
    }
}
