package lab.stellar.servlet;

import lab.stellar.entities.PlanetarySystem;
import lab.stellar.service.StellarService;
import lab.stellar.service.impl.StellarServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class SystemsServlet extends HttpServlet {

    private Logger logger = Logger.getLogger(SystemsServlet.class.getName());

    private StellarService service = new StellarServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.info("about to fetch planetary systems");

        List<PlanetarySystem> systems;
        if(req.getParameterMap().containsKey("systemId")) {
            int systemId = Integer.parseInt(req.getParameter("systemId"));
            systems = Arrays.asList(service.getSystemById(systemId));
        } else {
            systems = service.getSystems();
        }

        req.setAttribute("systems", systems);

        req.getRequestDispatcher("/WEB-INF/jsp/systems.jsp").forward(req, resp);

        /*StringBuilder sb = new StringBuilder();

        sb.append("<html><body>"+
                "<table><tr><th>Name</th><th>Star</th></tr>");

        systems.forEach(
                s-> sb.append("<tr><td>").append(s.getName()).append("</td><td>").append(s.getStar()).append("</td></tr>")
        );

        sb.append("</table></body></html>");

        resp.getWriter().write(sb.toString());*/

    }
}
