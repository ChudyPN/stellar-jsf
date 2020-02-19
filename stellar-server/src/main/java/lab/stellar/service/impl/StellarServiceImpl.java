package lab.stellar.service.impl;

import lab.stellar.dao.PlanetDAO;
import lab.stellar.dao.SystemDAO;
import lab.stellar.entities.Page;
import lab.stellar.entities.Planet;
import lab.stellar.entities.PlanetarySystem;
import lab.stellar.service.StellarService;


import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.logging.Logger;

/*@ManagedBean(name="stellarService")
@ApplicationScoped*/

public class StellarServiceImpl implements StellarService {


    Logger logger = Logger.getLogger(StellarServiceImpl.class.getName());

    //@ManagedProperty("#{systemDao}")
    @Inject
    private SystemDAO systemDAO;

    //@ManagedProperty("#{planetDao}")
    @Inject
    private PlanetDAO planetDAO;

    @Override
    public List<PlanetarySystem> getSystems() {
        logger.info("fetching all planetary systems");
        List<PlanetarySystem> systems = systemDAO.getAllPlanetarySystems();
        logger.info("found: " + systems.size());
        return systems;
    }

    @Override
    public List<PlanetarySystem> getSystemsByName(String like) {
        logger.info("fetching planetary systems like " + like);
        List<PlanetarySystem> systems =  systemDAO.getPlanetarySystemsByName(like);
        logger.info("found: " + systems.size());
        return systems;
    }

    @Override
    public PlanetarySystem getSystemById(int id) {
        logger.info("fetching planetary system by id " + id);

        PlanetarySystem system = systemDAO.getPlanetarySystem(id);
        logger.info("found: " + system);
        return  system;
    }

    @Override
    public List<Planet> getPlanets(PlanetarySystem s) {
        logger.info("fetching  planets by system " + s);

        List<Planet> planets = planetDAO.getPlanetsBySystem(s);
        logger.info("found:" + planets.size());
        return planets;
    }

    @Override
    public List<Planet> getPlanets(PlanetarySystem system, String like) {
        return planetDAO.getPlanetsBySystemAndName(system,like);
    }

    @Override
    public Page<Planet> getPlanetsPage(PlanetarySystem s, int pageNo, int pageSize) {
        return planetDAO.getPlanetsPage(s, pageNo, pageSize);
    }

    @Override
    public Planet getPlanetById(int id) {
        return planetDAO.getPlanetById(id);
    }

    @Override
    public Planet addPlanet(Planet p, PlanetarySystem s) {
        p.setSystem(s);
        return planetDAO.addPlanet(p);
    }

    @Override
    public PlanetarySystem addPlanetarySystem(PlanetarySystem s) {
        return systemDAO.addPlanetarySystem(s);
    }


    public void setPlanetDAO(PlanetDAO planetDAO) {
        this.planetDAO = planetDAO;
    }

    public void setSystemDAO(SystemDAO systemDAO) {
        this.systemDAO = systemDAO;
    }
}
