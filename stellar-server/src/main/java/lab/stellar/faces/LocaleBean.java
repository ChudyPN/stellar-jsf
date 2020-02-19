package lab.stellar.faces;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

@ManagedBean
@SessionScoped
public class LocaleBean {

    Logger logger = Logger.getLogger(LocaleBean.class.getName());

    private String selectedLocale =
            FacesContext.
                    getCurrentInstance().
                    getViewRoot().
                    getLocale()
            .getLanguage();


    public String getSelectedLocale() {
        return selectedLocale;
    }

    public void setSelectedLocale(String selectedLocale) {
        FacesContext.
                getCurrentInstance().
                getViewRoot().
                setLocale( new Locale(selectedLocale) );
        this.selectedLocale = selectedLocale;
    }

    public void changeLocaleEvent(ValueChangeEvent e){
        logger.info("about to change locale to " + e.getNewValue());
        changeLocale(e.getNewValue().toString());
    }

    public void changeLocale(String code){

        logger.info("changing locale to [" + code + "]");
        /*FacesContext.
                getCurrentInstance().
                getViewRoot().
                setLocale( new Locale(code) );*/
    }

    public List<Locale> getSupportedLocales(){
        Iterator<Locale> itr =
                FacesContext.
                        getCurrentInstance().
                        getApplication().
                        getSupportedLocales();
        List<Locale> locales = new ArrayList<>();
        itr.forEachRemaining(l->locales.add(l));

        locales.add(FacesContext.
                getCurrentInstance().
                getApplication().
                getDefaultLocale()
        );

        return locales;
    }
}
