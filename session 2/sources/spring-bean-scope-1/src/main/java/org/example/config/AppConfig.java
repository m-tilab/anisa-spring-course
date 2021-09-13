package org.example.config;

import org.example.bean.Member;
import org.example.bean.MemberType;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

import java.util.Random;

@Configuration
@ComponentScan(basePackages = "org.example.bean")
public class AppConfig {

    @Bean
    //@Scope("singleton")
    public Member getMember() {

        Member member = new Member();
        member.setLastname("Ahmadi");
        member.setAge(new Random().nextInt(100));

        return member;
    }

    @Bean
    @Scope("prototype")
    public MemberType getMemberType() {

        MemberType memberType = new MemberType();
        memberType.setTitle(String.valueOf(new Random().nextInt(10)));

        return memberType;
    }
}
