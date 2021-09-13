package org.example.usage;

import org.example.bean.ConsumerProduct;
import org.example.bean.IndustrialProduct;
import org.example.config.AppConfig;
import org.example.domain.TradeFair;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanAutowiredUsage {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        TradeFair tradeFair = context.getBean(TradeFair.class);

        //tradeFair.setConsumerProduct(new ConsumerProduct());
        //tradeFair.setIndustrialProduct(new IndustrialProduct());

        System.out.println(tradeFair.getQualifiedProductPrice());
    }
}
