package lab.stellar.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;

public class AccessFilter implements Filter {

    int opening = 10;

    int closing = 16;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        opening = Integer.parseInt(filterConfig.getInitParameter("opening"));
        closing = Integer.parseInt(filterConfig.getInitParameter("closing"));

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        int currentHour = LocalTime.now().getHour();

        if(currentHour>=opening && currentHour<closing){
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            ((HttpServletResponse)servletResponse).sendRedirect("https://images.unsplash.com/photo-1520531971933-0ad2edaea16e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=750&q=80");
        }
    }

    @Override
    public void destroy() {

    }
}
