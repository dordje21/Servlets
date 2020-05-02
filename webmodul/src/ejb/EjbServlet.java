package ejb;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ejbservlet")
public class EjbServlet extends HttpServlet {
    @EJB
    EjbInterface ejbInterface;
    @EJB
    EjbBean ejbBean;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write(ejbBean.say());
        resp.getWriter().write(ejbBean.getName());
        resp.getWriter().write(ejbBean.getFullName());

        resp.getWriter().write(ejbInterface.getName());

    }
}
