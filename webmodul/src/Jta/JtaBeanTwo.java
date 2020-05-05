package Jta;

import javax.ejb.EJB;
import javax.ejb.Singleton;
//
@Singleton
public class JtaBeanTwo {
    @EJB
    JtaBean jtaBean;
    public void saveStudent(){
        jtaBean.saveStudent();
    }

}
