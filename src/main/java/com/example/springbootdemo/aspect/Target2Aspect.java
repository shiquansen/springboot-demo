package com.example.springbootdemo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;


@Aspect
@Component
public class Target2Aspect {

    @Pointcut("execution(* com.example.springbootdemo.aspect.service.Need2AspectService.exec(..))")
    public void pointCut2(){
    }

    @Around("pointCut2()")
    public void exec1(ProceedingJoinPoint pjp) throws Throwable {
        String className=pjp.getTarget().getClass().getSimpleName();
        String methodName=pjp.getSignature().getName();
        Object[] args=pjp.getArgs();

        Class<?> classTarget=pjp.getTarget().getClass();
        Class<?>[] par=((MethodSignature) pjp.getSignature()).getParameterTypes();
        Method objMethod=classTarget.getMethod(methodName, par);
        Annotation[] annotations = objMethod.getAnnotations();

        System.out.println("-----------------annotations: " + Arrays.toString(annotations));
        System.out.println("-----------------arg: " + Arrays.toString(args));
        System.out.println("-----------------className:" + className);
        System.out.println("-----------------methodName:" + methodName);

        pjp.proceed();

    }

}
