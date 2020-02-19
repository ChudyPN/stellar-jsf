package lab.stellar.service;

import lab.stellar.entities.Page;
import lab.stellar.entities.Planet;
import lab.stellar.entities.PlanetarySystem;

import java.util.List;

public interface StellarService {

    List<PlanetarySystem> getSystems();

    List<PlanetarySystem> getSystemsByName(String like);

    PlanetarySystem getSystemById(int id);

    List<Planet> getPlanets(PlanetarySystem s);

    public List<Planet> getPlanets(PlanetarySystem system, String like);

    Page<Planet> getPlanetsPage(PlanetarySystem s, int pageNo, int pageSize);

    Planet getPlanetById(int id);

    Planet addPlanet(Planet p, PlanetarySystem s);

    PlanetarySystem addPlanetarySystem(PlanetarySystem s);

}
