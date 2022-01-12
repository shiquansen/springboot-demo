package com.example.springbootdemo.aspect.service;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


public interface NeedAspectService{
    void log(String name);
}
