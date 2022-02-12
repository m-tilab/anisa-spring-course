package com.example.springaop.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class MethodPointcutConfiguration {

    @Pointcut("execution(* com.example.springaop.service.UserService.*(..))")
    public void addServiceLayerExecution() {}
}
