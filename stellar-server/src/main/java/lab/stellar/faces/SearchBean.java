package lab.stellar.faces;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class SearchBean {

    private String phrase;

    private int systemId;

    @PostConstruct
    public void initSystemId(){
        String systemIdString =
                FacesContext.
                        getCurrentInstance().
                        getExternalContext().
                        getRequestParameterMap().
                        get("systemId");
        if(systemIdString!=null && !systemIdString.trim().isEmpty()){
            this.systemId = Integer.parseInt(systemIdString);
        }
    }

    public boolean isPhrasePresent(){
        return phrase!=null && !phrase.trim().isEmpty();
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public int getSystemId() {
        return systemId;
    }

    public void setSystemId(int systemId) {
        this.systemId = systemId;
    }


}
