package lab.stellar;

import lab.stellar.entities.Planet;
import lab.stellar.service.StellarService;
import lab.stellar.service.impl.StellarServiceImpl;

import java.util.List;

public class StellarServiceStart {

    public static void main(String[] args) {
        System.out.println("Let's explore!");

        StellarService service = new StellarServiceImpl();

        List<Planet> planets = service.getPlanets(service.getSystemById(1));

        planets.forEach(p-> System.out.println(p));

    }
}
