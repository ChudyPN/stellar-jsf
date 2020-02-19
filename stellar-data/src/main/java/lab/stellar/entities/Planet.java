package lab.stellar.entities;

import javax.persistence.*;

@Entity
public class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne
    private PlanetarySystem system;

    public Planet(int id, String name, PlanetarySystem system) {
        this.id = id;
        this.name = name;
        this.system = system;
    }

    public Planet(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlanetarySystem getSystem() {
        return system;
    }

    public void setSystem(PlanetarySystem system) {
        this.system = system;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
