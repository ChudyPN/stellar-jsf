package lab.stellar.dao.impl.inmemory;

import lab.stellar.entities.Planet;
import lab.stellar.entities.PlanetarySystem;

import java.time.LocalDate;
import java.util.*;

public class InMemory {

    static List<PlanetarySystem> systems = new ArrayList<>();


    static {
        PlanetarySystem s = new PlanetarySystem(
                1,
                "Solar System",
                "Sun",
                java.sql.Date.valueOf(LocalDate.of(857,3,4)),
                3.234f,
                "https://en.wikipedia.org/wiki/Solar_System");
        s.setPlanets(Arrays.asList(
                new Planet(1, "Mercury", s),
                new Planet(2, "Venus", s),
                new Planet(3, "Earth", s),
                new Planet(4, "Mars", s),
                new Planet(5, "Jupiter", s),
                new Planet(6, "Neptun", s),
                new Planet(7, "Saturn", s),
                new Planet(8, "Uranus", s),
                new Planet(9, "Pluto", s)
        ));
        systems.add(s);
        s = new PlanetarySystem(
                2,
                "Kepler-90 System",
                "Kepler-90",
                java.sql.Date.valueOf(LocalDate.of(1987,11,2)),
                12.275123f,
                "https://pl.wikipedia.org/wiki/Kepler-90");
        s.setPlanets(Arrays.asList(
                new Planet(21, "b", s),
                new Planet(22, "c", s),
                new Planet(23, "i", s),
                new Planet(24, "d", s),
                new Planet(25, "e", s),
                new Planet(26, "f", s),
                new Planet(27, "g", s)
        ));
        systems.add(s);
        s = new PlanetarySystem(
                3,
                "Trappist-1 System",
                "Trappist-1",
                java.sql.Date.valueOf(LocalDate.of(2013,7,27)),
                7.62946f,
                "https://pl.wikipedia.org/wiki/TRAPPIST-1");
        s.setPlanets(Arrays.asList(
                new Planet(31, "b", s),
                new Planet(32, "c", s),
                new Planet(33, "d", s),
                new Planet(34, "e", s),
                new Planet(35, "f", s),
                new Planet(36, "g", s),
                new Planet(37, "h", s)
        ));
        systems.add(s);
    }






}
