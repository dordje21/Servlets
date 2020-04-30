package ee;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.interceptor.*;
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

@WebServlet("/livecyclebean")
public class LiveCycleBean extends HttpServlet {
    @Inject
    LiveCycle liveCycle;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            liveCycle.doJob();
        liveCycle.doJob2();
    }
}

@InterceptorBinding
@Retention(RUNTIME)
@Target({FIELD, TYPE, METHOD})
@interface One {}

@One
@javax.interceptor.Interceptor
class Interceptor{
//    @AroundConstruct
//    private void aroundConstruct(InvocationContext context) throws Exception{
//        System.out.println(" before construct ");
//        context.proceed();
//    }
//    @PostConstruct
//    private void postConstruct(InvocationContext context) throws Exception{
//        System.out.println("post construct");
//        context.proceed();
//    }
    @AroundInvoke
    private Object aroundMethods(InvocationContext context) throws Exception{
        System.out.println("befor method");
        return context.proceed();
    }
    @PreDestroy
    private void preDestroy(){
        System.out.println("pre destroy");
    }
}
@One
//@Interceptors(Interceptor.class)
@RequestScoped
class LiveCycle {
    public LiveCycle(){
        System.out.println("constructor");
    }
//    @Interceptors(Interceptor.class)
    public void doJob(){
        System.out.println("do job");
    }
    @ExcludeClassInterceptors
    public void doJob2(){
        System.out.println("do job2");
    }
}


