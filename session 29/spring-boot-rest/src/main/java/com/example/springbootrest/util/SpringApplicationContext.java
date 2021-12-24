package com.example.springbootrest.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringApplicationContext implements ApplicationContextAware {

    private static ApplicationContext CONTEXT;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        CONTEXT = applicationContext;
    }

    public static Object getBean(String beanName) {

        return CONTEXT.getBean(beanName);
    }
}
