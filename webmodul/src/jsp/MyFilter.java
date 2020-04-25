package jsp;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/MyNewFilter")
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(filterConfig.getFilterName());
        System.out.println(filterConfig.getInitParameter("name"));
        System.out.println("init filter ");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.getWriter().write("before");
        System.out.println(servletRequest.getRemoteHost());
        if(true){
            filterChain.doFilter(servletRequest, servletResponse);
        }
        servletResponse.getWriter().write("after");
    }

    @Override
    public void destroy() {
        System.out.println("destroy filter ");
    }
}
