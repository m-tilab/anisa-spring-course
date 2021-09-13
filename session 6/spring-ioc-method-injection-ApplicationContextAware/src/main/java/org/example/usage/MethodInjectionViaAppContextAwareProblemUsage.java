package org.example.usage;

import org.example.bean.StudentSingleton;
import org.example.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MethodInjectionViaAppContextAwareProblemUsage {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        var studentSingleton1 = context.getBean(StudentSingleton.class);

        var studentSingleton2 = context.getBean(StudentSingleton.class);

        System.out.println(studentSingleton1);
        System.out.println(studentSingleton2);

        System.out.println(studentSingleton1.getSchoolAsPrototype());
        System.out.println(studentSingleton2.getSchoolAsPrototype());
    }
}
