package com.example.springbootdemo.aspect.service.impl;

import com.example.springbootdemo.aspect.Flag;
import com.example.springbootdemo.aspect.service.NeedAspectService;
import org.springframework.stereotype.Component;

@Component
public class NeedAspectServiceImpl implements NeedAspectService {

    @Flag
    @Override
    public void log(String name) {
        System.out.println("这是需要被代理的方法");
    }
}
