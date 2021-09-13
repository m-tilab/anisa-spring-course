package org.example.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public abstract class StudentSingleton {

    private String firstname;

    @Autowired
    private SchoolPrototype schoolPrototype;

    public SchoolPrototype getSchoolPrototype() {
        return schoolPrototype;
    }

    public void setSchoolPrototype(SchoolPrototype schoolPrototype) {
        this.schoolPrototype = schoolPrototype;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Lookup
    public abstract SchoolPrototype getSchoolAsPrototype();
}
