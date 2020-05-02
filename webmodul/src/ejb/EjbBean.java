package ejb;

import javax.annotation.PostConstruct;
import javax.ejb.*;

//@Stateful
//@Stateless
@Singleton
//@Local(EjbInterface.class)
@LocalBean
@Startup
@DependsOn("SecondBean")
public class EjbBean implements EjbInterface{
    public String say(){
        return "hello ejb";
    }
    public String getName(){
        return "Name";
    }
    public String getFullName(){
        return "FullName";
    }
    @PostConstruct
    void postConstruct(){
        System.out.println("first bean");
    }
}
