package ee;

import javax.inject.Inject;
import javax.inject.Qualifier;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@WebServlet("/diExample")
public class DependencyInjectionExample extends HttpServlet {
    @Inject
    @StudentAnotation
//    Student student;
    Person person;

    @Inject
    @WorkerAnotation
//    Student student;
    Person worker;

//    @Inject
//    public DependencyInjectionExample(Student student){
//        this.student = student;
//    }

//    @Inject
//    public void setStudent(Student student) {
//        this.student = student;
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println(student.getName());
        System.out.println(person.getName());
        resp.getWriter().write(person.getName());
        System.out.println(worker.getName());
        resp.getWriter().write(worker.getName());
    }
}

@Qualifier
@Retention(RUNTIME)
@Target({FIELD, TYPE, METHOD})
@interface StudentAnotation{}

@Qualifier
@Retention(RUNTIME)
@Target({FIELD, TYPE, METHOD})
@interface WorkerAnotation{}

interface Person{
    String getName();
}
@StudentAnotation
class Student implements Person {
    public String getName() {
        name="student";
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

}
@WorkerAnotation
class Worker implements Person {
    public String getName() {
        name="worker";
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

}