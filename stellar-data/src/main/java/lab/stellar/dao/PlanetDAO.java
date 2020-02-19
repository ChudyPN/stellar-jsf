package lab.stellar.dao;

import lab.stellar.entities.Page;
import lab.stellar.entities.Planet;
import lab.stellar.entities.PlanetarySystem;

import java.util.List;

public interface PlanetDAO {

    List<Planet> getAllPlanets();

    List<Planet> getPlanetsBySystem(PlanetarySystem system);

    List<Planet> getPlanetsBySystemAndName(PlanetarySystem system, String like);

    Page<Planet> getPlanetsPage(PlanetarySystem s, int pageNo, int pageSize);

    Planet getPlanetById(int id);

    Planet addPlanet(Planet p);

}
