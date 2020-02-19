package lab.stellar.start;

import lab.stellar.dao.SystemDAO;
import lab.stellar.dao.impl.inmemory.InMemorySystemDAO;
import lab.stellar.entities.PlanetarySystem;

import java.util.List;

public class StellarDataStart {

    public static void main(String[] args) {
        System.out.println("StellarDataStart.main");

        SystemDAO systemDAO = new InMemorySystemDAO();
        List<PlanetarySystem> systems = systemDAO.getAllPlanetarySystems();

        systems.forEach( s -> System.out.println(s) );


    }
}
