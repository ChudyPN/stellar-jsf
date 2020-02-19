package lab.stellar.dao;

import lab.stellar.entities.PlanetarySystem;

import java.util.List;

public interface SystemDAO {

    List<PlanetarySystem> getAllPlanetarySystems();

    List<PlanetarySystem> getPlanetarySystemsByName(String like);

    PlanetarySystem getPlanetarySystem(int id);

    PlanetarySystem addPlanetarySystem(PlanetarySystem system);

}
