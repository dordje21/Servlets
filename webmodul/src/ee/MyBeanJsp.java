package ee;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Specializes;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/mybeanlink")
public class MyBeanJsp extends HttpServlet {
    @Inject
    MyBeanJ myBeanJ;
    @Inject
    A a;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/MyBeanJsp.jsp");
//        requestDispatcher.forward(req, resp);
        a.print();
    }
}
@RequestScoped
@Named("nameBean")
class MyBeanJ {
    private String s = "my bean jsp";

    public String getS() {
        return s;
    }
    public void setS(String s) {
        this.s = s;
    }
}

interface A {
    void print();
}
class B implements A{
    @Override
    public void print() {
        System.out.println("A");
    }
}
@Specializes
class C extends B{
    @Override
    public void print() {
        System.out.println("B");
    }
}