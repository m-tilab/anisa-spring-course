package org.example.config;

import org.example.bean.Member;
import org.example.bean.MemberType;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example.bean")
public class AppConfig {

    /*@Bean
    @Qualifier
    public MemberType getMemberType1() {

        System.out.println("getMemberType1 invoked");

        return new MemberType();
    }

    @Bean
    public MemberType getMemberType2() {

        System.out.println("getMemberType2 invoked");

        return new MemberType();
    }*/
}
