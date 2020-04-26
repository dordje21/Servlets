package ee;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.enterprise.inject.spi.configurator.InjectionPointConfigurator;
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
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@WebServlet("/diExample")
public class DependencyInjectionExample extends HttpServlet {
    @Inject
//    @StudentAnotation
//    Student student;
    Person person;

    @Inject
//    @WorkerAnotation
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
    @Inject
    String s;
    @Inject
    @S2
    String S2;
    @Inject
    int i;
    @Inject
    Car car;
    @Inject
    Logger logger;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println(student.getName());
        System.out.println(person.getName());
        resp.getWriter().write(person.getName());
        System.out.println(worker.getName());
        resp.getWriter().write(worker.getName());
        System.out.println(s + i + car.name);
        resp.getWriter().write(s + " " + i + car.name + S2);
        logger.log(Level.ALL, "message");
    }
}

//@Qualifier
//@Retention(RUNTIME)
//@Target({FIELD, TYPE, METHOD})
//@interface StudentAnotation{}
//
//@Qualifier
//@Retention(RUNTIME)
//@Target({FIELD, TYPE, METHOD})
//@interface WorkerAnotation{}

interface Person{
    String getName();
}
//@StudentAnotation
@Alternative
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
//@WorkerAnotation
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
@Qualifier
@Retention(RUNTIME)
@Target({FIELD, TYPE, METHOD})
@interface S2{}

class Producer{
    @Produces
    String s = " string ";
    @Produces
    @S2
    String s2 = " string2 ";
    @Produces
    int i = 15;
    @Produces
    Car getCar(){
        return new Car("Mers");
    }
    public void clean(@Disposes Car car){
        car.clean();
    }
}

class Car{
    String name;

    public Car(String name) {
        this.name = name;
    }

    public void clean(){
        System.out.println(" car clean ");
    }
}

class MyLogger{
    @Produces
    public Logger getLogger(InjectionPoint injectionPoint){
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }
}