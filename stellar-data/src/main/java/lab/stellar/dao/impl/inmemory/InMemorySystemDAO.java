package lab.stellar.dao.impl.inmemory;

import lab.stellar.dao.SystemDAO;
import lab.stellar.entities.PlanetarySystem;

import java.util.List;
import java.util.stream.Collectors;

public class InMemorySystemDAO implements SystemDAO {

    @Override
    public List<PlanetarySystem> getAllPlanetarySystems() {
        return InMemory.systems;
    }

    @Override
    public List<PlanetarySystem> getPlanetarySystemsByName(String like) {
        return InMemory.systems.stream().filter(s->s.getName().contains(like)).collect(Collectors.toList());
    }

    @Override
    public PlanetarySystem getPlanetarySystem(int id) {
        return InMemory.systems.stream().filter(s->s.getId()==id).findFirst().get();
    }

    @Override
    public PlanetarySystem addPlanetarySystem(PlanetarySystem system) {
        int idMax = InMemory.systems.stream().sorted((s1,s2)->s2.getId()-s1.getId()).findFirst().get().getId();

        system.setId(++idMax);
        InMemory.systems.add(system);
        return system;
    }
}