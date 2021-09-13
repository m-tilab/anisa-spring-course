package org.example.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Member //implements InitializingBean, DisposableBean
{

    private String firstname;
    private String lastname;
    private int age;

    public Member() {

        System.out.println("member constuctor invoked");
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //@PostConstruct
    public void initMethod() {

        System.out.println("member init method called");
    }

    //@PreDestroy
    public void destroyMethod() {

        System.out.println("member destroy method called");

    }

    /*@Override
    public void destroy() throws Exception {
        System.out.println("member destroy method called ");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("member init method called via afterPropertiesSet method");
    }*/
}
