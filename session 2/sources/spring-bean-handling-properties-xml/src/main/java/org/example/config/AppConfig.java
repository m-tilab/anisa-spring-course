package org.example.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;

@Configuration
@ComponentScan(basePackages = "org.example.bean")
@ImportResource("classpath:spring.xml")
public class AppConfig {

    @Bean
    public PropertyPlaceholderConfigurer getPropertyPlaceholderConfigurer()
            throws IOException {
        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        ppc.setLocations(new PathMatchingResourcePatternResolver().getResources("classpath:*.properties"));
        return ppc;
    }

}
