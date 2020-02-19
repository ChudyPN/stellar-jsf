package lab.stellar.dao.impl.inmemory;

import lab.stellar.dao.PlanetDAO;
import lab.stellar.entities.Page;
import lab.stellar.entities.Planet;
import lab.stellar.entities.PlanetarySystem;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;


public class InMemoryPlanetDAO implements PlanetDAO {

    Logger logger = Logger.getLogger(InMemoryPlanetDAO.class.getName());

    @Override
    public List<Planet> getAllPlanets() {
        return InMemory.systems.stream().map(s->s.getPlanets()).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Page<Planet> getPlanetsPage(PlanetarySystem s, int pageNo, int pageSize) {
        List<Planet> planets = getPlanetsBySystem(s);
        return new Page<>(
                planets.subList(
                        (pageNo-1)*pageSize,
                        pageNo*pageSize <= planets.size() ? pageNo*pageSize : planets.size() ),
                planets.size(),
                pageNo,
                pageSize
        );
    }

    @Override
    public List<Planet> getPlanetsBySystem(PlanetarySystem system) {
        logger.info("fetching planets of " + system );

        return InMemory.systems.stream().filter(s->s.equals(system)).findFirst().get().getPlanets();
    }

    @Override
    public List<Planet> getPlanetsBySystemAndName(PlanetarySystem system, String like) {

        logger.info("fetching planets of " + system + " using phrase " + like);
        return InMemory.systems.stream().filter(s->s.equals(system)).findFirst().get().getPlanets().stream().filter(p->p.getName().contains(like)).collect(Collectors.toList());
    }

    @Override
    public Planet getPlanetById(int id) {
        return getAllPlanets().stream().filter(p->p.getId()==id).findFirst().get();
    }

    @Override
    public Planet addPlanet(Planet p) {
        int idMax = getAllPlanets().stream().sorted((p1,p2)->p2.getId()-p1.getId()).findFirst().get().getId();
        p.setId(++idMax);
        InMemory.systems.stream().filter(s->s.getId()==p.getSystem().getId()).findFirst().get().getPlanets().add(p);
        return p;
    }
}
