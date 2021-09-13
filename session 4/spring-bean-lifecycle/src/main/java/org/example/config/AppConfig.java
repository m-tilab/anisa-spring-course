package org.example.config;

import org.example.bean.Member;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example.bean")
public class AppConfig {

    //@Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public Member getMember () {

        return new Member();
    }
}
