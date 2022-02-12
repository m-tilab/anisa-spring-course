package com.example.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Aspect
@Configuration
public class MethodExecutionAspect {

    Logger logger = LoggerFactory.getLogger(MethodExecutionAspect.class);

    //pointcut
    // What kind of method calls I would intercept
    // execution(* PACKAGE.*.*(..))
    @Before("execution(* com.example.springaop..*.*(..))")
    public void beforeExecution(JoinPoint joinPoint) {

        //advise
        logger.info("check allow execution of service layer");
        logger.info("can execute of service layer - called {}", joinPoint);

    }

    @AfterReturning(value = "execution(* com.example.springaop.service.*.*(..))",
            returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {

        logger.info("{} returned with value {}", joinPoint, result);
    }

    @AfterThrowing(value = "execution(* com.example.springaop.service.*.*(..))",
            throwing = "result")
    public void afterThrowing(JoinPoint joinPoint, Exception result) {

        logger.info("{} throw with value {}", joinPoint, result);
    }

    @After("execution(* com.example.springaop..*.*(..))")
    public void AfterExecution(JoinPoint joinPoint) {

        //advise
        logger.info("after execution of service layer - called {}", joinPoint);

    }

    // both of afterReturning and afterThrowing will be call
    @Around(value = "execution(* com.example.springaop.service.*.*(..))")
    public void AfterExecution(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // Start Time
        // Method Execution
        // End Time

        long startTime = System.currentTimeMillis();

        proceedingJoinPoint.proceed();

        long takenTime = System.currentTimeMillis() - startTime;

        logger.info("time taken by {} is {}", proceedingJoinPoint, takenTime);
    }

    @After("com.example.springaop.aspect.MethodPointcutConfiguration.addServiceLayerExecution()")
    public void AfterServiceExecution(JoinPoint joinPoint) {

        //advise
        logger.info("after execution of user service layer - called {}", joinPoint);

    }
}
