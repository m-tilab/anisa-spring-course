package org.example.config;

import org.example.bean.ConsumerProduct;
import org.example.bean.GenericProduct;
import org.example.bean.IndustrialProduct;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages = {"org.example.bean", "org.example.domain"})
public class AppConfig {

    @Bean
    public GenericProduct getIndustrialProduct() {

        return new IndustrialProduct();
    }

    @Bean
    @Primary
    public GenericProduct getConsumerProduct() {

        return new ConsumerProduct();
    }
}
