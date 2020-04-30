package ee;

import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/scope")
public class Scope extends HttpServlet {
    @Inject
    MyBean myBean;
    @Inject
    ChangMyBean changMyBean;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        myBean.i = 5;
        changMyBean.changMyBean();
        resp.getWriter().write(myBean.i + "");
        resp.getWriter().write("" + changMyBean.myBean.i);
    }

}
//@RequestScoped
@Dependent
class MyBean {
    int i;
}
class ChangMyBean {
    @Inject
    MyBean myBean;
    public void changMyBean(){
        myBean.i = 1;
    }
}
