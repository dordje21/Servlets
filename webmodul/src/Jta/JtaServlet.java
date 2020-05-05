package Jta;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;
import java.io.IOException;

@WebServlet("/jtaServlet")
public class JtaServlet extends HttpServlet {
//    @EJB
//    JtaBean jtaBean;
    @EJB
    JtaBeanTwo jtaBeanTwo;

//    @PersistenceContext
//    EntityManager entityManager;
//    @Resource
//    UserTransaction userTransaction;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        jtaBeanTwo.saveStudent();
    }
}
