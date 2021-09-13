package org.example.bean;

import org.springframework.stereotype.Component;

@Component
public class Teacher {

    private String firstname;
    private String lastname;

    @Override
    public String toString() {
        return "Teacher {" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
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
}
