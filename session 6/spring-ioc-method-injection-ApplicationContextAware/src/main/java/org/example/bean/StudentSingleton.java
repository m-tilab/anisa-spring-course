package org.example.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class StudentSingleton implements ApplicationContextAware {

    private ApplicationContext context;

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

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public SchoolPrototype getSchoolAsPrototype() {

        return context.getBean(SchoolPrototype.class);
    }
}
