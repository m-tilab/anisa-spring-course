package org.example.config;

import org.example.bean.EagerBean;
import org.example.bean.LazyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example.bean")
public class AppConfig {

    @Bean
    public EagerBean getEager() {

        return new EagerBean();
    }

    /*
    @Bean
    public LazyBean getLazy() {

        return new LazyBean();
    }*/
}
