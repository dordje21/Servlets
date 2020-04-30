package ee;

import javax.decorator.Delegate;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/decorator")
public class DecoratorExample extends HttpServlet {
    @Inject
    Parent parent;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        parent.print();
    }
}
interface Parent{
    void print();
}

class Child implements Parent{
    @Override
    public void print() {
        System.out.println("print");
    }
}
@javax.decorator.Decorator
class Decorator implements Parent{
    @Inject
    @Delegate
    Parent parent;
    @Override
    public void print() {
        System.out.println("befor");
        parent.print();
        System.out.println("after");
    }
}