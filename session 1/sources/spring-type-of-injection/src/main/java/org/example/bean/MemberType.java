package org.example.bean;

public class MemberType {

    private String title;

    @Override
    public String toString() {
        return "MemberType{" +
                "title='" + title + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
