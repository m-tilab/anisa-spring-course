package org.example.bean;

import org.springframework.stereotype.Component;

//@Component
public class MemberType {

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /*@Override
    public String toString() {
        return "MemberType{" +
                "title='" + title + '\'' +
                '}';
    }*/
}
