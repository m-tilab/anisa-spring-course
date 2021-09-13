import bean.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScopeUsage {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Student student = context.getBean(Student.class);
        student.setFirstname("Mehdi");

        System.out.println(student);

        Student student2 = context.getBean(Student.class);

        System.out.println(student2);

    }
}
