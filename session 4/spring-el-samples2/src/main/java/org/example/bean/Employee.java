package org.example.bean;

import org.springframework.stereotype.Component;

@Component
public class Employee {


    private int age;

    private String firstname;

    private Organization organization;

    private boolean retired;

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isRetired() {
        return retired;
    }

    public void setRetired(boolean retired) {
        this.retired = retired;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "age=" + age +
                ", retired=" + retired +
                ", firstname='" + firstname + '\'' +
                ", organization=" + organization +
                '}';
    }

}
