package org.example.usage;

import org.example.bean.Member;
import org.example.bean.MemberType;
import org.example.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanScopeUsage {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // member is singleton

        Member member = context.getBean(Member.class);

        System.out.println(member);

        Member member2 = context.getBean(Member.class);

        System.out.println(member2);

        // memberType is prototype

        MemberType memberType = context.getBean(MemberType.class);

        System.out.println(memberType);

        MemberType memberType2 = context.getBean(MemberType.class);

        System.out.println(memberType2);


    }
}
