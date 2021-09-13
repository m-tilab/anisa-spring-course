package org.example.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
public class Organization {

    private String title;
    @Value("${slogan}")
    private String slogan;

    private int yearOfFound;
    private int numberOfEmployee;

    public Organization() {}


    public Organization(String title, String slogan, int yearOfFound, int numberOfEmployee) {
        this.title = title;
        this.slogan = slogan;
        this.yearOfFound = yearOfFound;
        this.numberOfEmployee = numberOfEmployee;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan( String slogan) {
        this.slogan = slogan;
    }

    public int getYearOfFound() {
        return yearOfFound;
    }

    @Value("${yearOfFound}")
    public void setYearOfFound(int yearOfFound) {
        this.yearOfFound = yearOfFound;
    }

    public int getNumberOfEmployee() {
        return numberOfEmployee;
    }

    public void setNumberOfEmployee(int numberOfEmployee) {
        this.numberOfEmployee = numberOfEmployee;
    }
    @Override
    public String toString() {
        return "Organization{" +
                "title='" + title + '\'' +
                ", slogan='" + slogan + '\'' +
                ", yearOfFound=" + yearOfFound +
                ", numberOfEmployee=" + numberOfEmployee +
                '}';
    }
}
