package ejb;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

@Singleton
public class SecondBean {
    @PostConstruct
    void postConstruct(){
        System.out.println("second Bean");
    }
}
