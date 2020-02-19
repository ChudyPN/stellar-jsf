package lab.stellar.faces;

import lab.stellar.entities.Page;
import lab.stellar.entities.Planet;
import lab.stellar.entities.PlanetarySystem;
import lab.stellar.service.StellarService;
import lab.stellar.service.impl.StellarServiceImpl;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@ManagedBean
@RequestScoped
public class StellarBean {

    //@ManagedProperty("#{stellarService}")
    @Inject
    private StellarService service;

    @ManagedProperty("#{searchBean}")

    private SearchBean searchBean;



    LazyDataModel<Planet> lazyPlanets;

    @PostConstruct
    public void init(){
        lazyPlanets = new LazyDataModel<Planet>() {
            @Override
            public List<Planet> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {

                Page<Planet> planetsPage = service.getPlanetsPage(
                        service.getSystemById(searchBean.getSystemId()),
                        (first/pageSize)+1,
                        pageSize
                );
                this.setRowCount((int)planetsPage.getTotal());
                return planetsPage.getItems();
            }
        };
    }


    public List<PlanetarySystem> getPlanetarySystems() {
        if (searchBean.isPhrasePresent()) {
            return service.getSystemsByName(searchBean.getPhrase());
        } else {
            return service.getSystems();
        }
    }

    public PlanetarySystem getPlanetarySystem(int systemId) {
        return service.getSystemById(systemId);
    }

    public List<Planet> getPlanets() {

        if (searchBean.isPhrasePresent()) {
            return service.getPlanets(service.getSystemById(searchBean.getSystemId()), searchBean.getPhrase());
        } else {
            return service.getPlanets(service.getSystemById(searchBean.getSystemId()));
        }
    }

    public LazyDataModel<Planet> getLazyPlanets(){

        return lazyPlanets;
    }

    public StellarService getService() {
        return service;
    }

    public void setService(StellarService service) {
        this.service = service;
    }


    public SearchBean getSearchBean() {
        return searchBean;
    }

    public void setSearchBean(SearchBean searchBean) {
        this.searchBean = searchBean;
    }
}
