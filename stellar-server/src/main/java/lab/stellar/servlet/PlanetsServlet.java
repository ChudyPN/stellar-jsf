package lab.stellar.servlet;

import lab.stellar.entities.Page;
import lab.stellar.entities.Planet;
import lab.stellar.service.StellarService;
import lab.stellar.service.impl.StellarServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class PlanetsServlet extends HttpServlet {

    private Logger logger = Logger.getLogger(PlanetsServlet.class.getName());

    private StellarService service = new StellarServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int systemId = Integer.parseInt(req.getParameter("systemId"));

        if(systemId==3){
            throw new IllegalArgumentException("illegal system id");
        }
        logger.info("about to fetch planets of system " + systemId);

        int pageSize = 3;

        int pageNo = 1;
        if(req.getParameterMap().containsKey("pageNo")){
            pageNo = Integer.parseInt(req.getParameter("pageNo"));
        }

        Page<Planet> planetPage = service.getPlanetsPage(
                service.getSystemById(systemId),
                pageNo,
                pageSize
        );

        req.setAttribute("planets", planetPage);

        req.getRequestDispatcher("/WEB-INF/jsp/planets.jsp").forward(req, resp);
    }
}
