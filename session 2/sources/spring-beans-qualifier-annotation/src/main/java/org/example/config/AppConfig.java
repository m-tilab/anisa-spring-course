package org.example.config;

import org.example.bean.Member;
import org.example.bean.MemberType;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = "org.example.bean")
public class AppConfig {

    @Bean
    public MemberType getMemberType1() {

        System.out.println("getMemberType1 invoked");

        MemberType memberType = new MemberType();
        memberType.setTitle("Teacher");

        return memberType;
    }

    @Bean
    public MemberType getMemberType2() {

        System.out.println("getMemberType2 invoked");

        MemberType memberType = new MemberType();
        memberType.setTitle("Student");

        return memberType;
    }
}
