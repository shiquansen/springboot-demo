package com.example.springbootdemo.thread;

import com.example.springbootdemo.proxy.IPointCut;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ReflectiveMethodInvocation;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.lang.Nullable;
import org.springframework.scheduling.annotation.AnnotationAsyncExecutionInterceptor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.function.Supplier;


@Component
public class ThreadAdvisor extends AbstractPointcutAdvisor {

    private Pointcut pointcut = new StaticMethodMatcherPointcut() {
        @Override
        public boolean matches(Method method, Class<?> targetClass) {
            ThreadStart annotation = AnnotationUtils.getAnnotation(method, ThreadStart.class);
            return  annotation != null;
        }
    };

    protected Advice buildAdvice(
            @Nullable Supplier<Executor> executor, @Nullable Supplier<AsyncUncaughtExceptionHandler> exceptionHandler) {

        AnnotationAsyncExecutionInterceptor interceptor = new AnnotationAsyncExecutionInterceptor(null);
        interceptor.configure(executor, exceptionHandler);
        return interceptor;
    }


    private Advice advice = new AnnotationAsyncExecutionInterceptor(new SimpleAsyncTaskExecutor(),new SimpleAsyncUncaughtExceptionHandler()){
        @Override
        public Object invoke(MethodInvocation invocation) throws Throwable {
            return super.invoke(invocation);
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
