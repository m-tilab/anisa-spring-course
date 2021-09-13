package org.example.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

@Component
public class Member {

    private String firstname;
    private String lastname;
    private int age;


    //@Autowired
    private MemberType memberType;

    @Override
    public String toString() {
        return "Member{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", memberType=" + memberType +
                '}';
    }

    public MemberType getMemberType() {
        return memberType;
    }

    @Autowired
    @Required
    public void setMemberType(MemberType memberType) {
        this.memberType = memberType;
    }

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

}
