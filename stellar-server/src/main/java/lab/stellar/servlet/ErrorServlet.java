package lab.stellar.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ErrorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String message = (String)req.getAttribute(RequestDispatcher.ERROR_MESSAGE);

        req.setAttribute("error_message", message);

        req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req,resp);

    }
}
