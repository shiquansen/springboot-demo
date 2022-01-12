package com.example.springbootdemo.proxy;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


@Component
public class Iadvisor extends AbstractPointcutAdvisor {

    private Pointcut pointcut = new StaticMethodMatcherPointcut() {
        @Override
        public boolean matches(Method method, Class<?> targetClass) {
            IPointCut annotation = AnnotationUtils.getAnnotation(method, IPointCut.class);
            return  annotation != null;
        }
    };

    private Advice advice = new MethodInterceptor(){

        @Override
        public Object invoke(MethodInvocation invocation) throws Throwable {
            try{
                before();
                Object proceed = invocation.proceed();
                after();
                return proceed;
            }catch (Exception e){
                afterThrow();
            }finally {
                afterReturn();
            }
            return null;
        }

        private void afterReturn() {
            System.out.println("最终处理。。。。。。。。。");
        }

        private void afterThrow() {
            System.out.println("异常处理。。。。。。。。。");
        }

        private void after() {
            System.out.println("后置处理。。。。。。。。。");
        }

        private void before() {
            System.out.println("前置处理。。。。。。。。");
        }

    };



    @Override
    public Pointcut getPointcut() {
        return pointcut;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }
}
