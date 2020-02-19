package lab.stellar.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = "You";

        if(req.getParameterMap().containsKey("name")) {
            name = req.getParameter("name");
        }

        resp.getWriter().write("<html><body>Hey " + name + "!</body></html>");
    }
}
