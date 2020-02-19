package lab.stellar.faces.dto;

import lab.stellar.entities.PlanetarySystem;
import lab.stellar.service.StellarService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import java.net.URL;
import java.util.Date;

@ManagedBean
@ViewScoped
public class PlanetarySystemForm {

    private String name;

    private String star;

    private float distance;

    private Date discovery;

    private URL details;

    private boolean next;

    private boolean display = false;


    @ManagedProperty("#{stellarService}")
    StellarService service;

    public String add(){

        PlanetarySystem s = new PlanetarySystem();
        s.setName(name);
        s.setStar(star);
        s.setDistance(distance);
        s.setDiscovery(discovery);
        s.setDetails(details);

        service.addPlanetarySystem(s);

        return next ? "adding" : "listing";
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

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public Date getDiscovery() {
        return discovery;
    }

    public void setDiscovery(Date discovery) {
        this.discovery = discovery;
    }

    public StellarService getService() {
        return service;
    }

    public void setService(StellarService service) {
        this.service = service;
    }

    public URL getDetails() {
        return details;
    }

    public void setDetails(URL details) {
        this.details = details;
    }

    public boolean isNext() {
        return next;
    }

    public void setNext(boolean next) {
        this.next = next;
    }

    public boolean isDisplay() {
        System.out.println("get display: " + display);
        return display;
    }

    public void setDisplay(boolean display) {
        System.out.println("set display: " + display ) ;
        this.display = display;
    }
}
