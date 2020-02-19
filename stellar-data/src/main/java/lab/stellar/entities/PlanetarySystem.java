package lab.stellar.entities;

import javax.persistence.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.List;

@Entity
public class PlanetarySystem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String star;

    private Date discovery;

    private float distance;

    private URL details;

    @OneToMany(mappedBy = "system")
    private List<Planet> planets;

    public PlanetarySystem(int id, String name, String star, Date discovery, float distance, String url) {
        this.id = id;
        this.name = name;
        this.star = star;
        this.discovery = discovery;
        this.distance = distance;
        try {
            details = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public PlanetarySystem(){}

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

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public List<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(List<Planet> planets) {
        this.planets = planets;
    }

    public Date getDiscovery() {
        return discovery;
    }

    public void setDiscovery(Date discovery) {
        this.discovery = discovery;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public URL getDetails() {
        return details;
    }

    public void setDetails(URL details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "PlanetarySystem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", star='" + star + '\'' +
                ", planets=" + planets +
                '}';
    }
}
