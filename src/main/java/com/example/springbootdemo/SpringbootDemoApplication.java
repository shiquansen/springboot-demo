package com.example.springbootdemo;

import com.example.springbootdemo.aspect.service.NeedAspectService;
import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootDemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringbootDemoApplication.class, args);
        System.out.println(run.getBean(AnnotationAwareAspectJAutoProxyCreator.class));
        System.out.println(run.getBean(NeedAspectService.class));
    }

}
