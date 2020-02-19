package lab.stellar.faces;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@ManagedBean(name="helloBean")
@SessionScoped
public class HelloBean implements Serializable {


    private boolean rendering;

    public HelloBean(){
        System.out.println("hellobean constructor");
    }

    @PostConstruct
    public void init(){
        rendering = FacesContext.
                getCurrentInstance().
                getExternalContext().
                getRequestParameterMap().
                get("name") == null;
    }

    public boolean isRendering(){
        return rendering;
    }

    public String getName(String name){
        /*String name =
        FacesContext.
                getCurrentInstance().
                getExternalContext().
                getRequestParameterMap().
                get("name");*/
        System.out.println("name [" + name + "]");
        return name.toUpperCase();
    }

}
