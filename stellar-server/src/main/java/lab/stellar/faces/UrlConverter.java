package lab.stellar.faces;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

@FacesConverter("urlConverter")
public class UrlConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {

        try {
            URL url = new URL(s);
            return url;
        } catch (MalformedURLException e) {

            ResourceBundle bundle =
                    ResourceBundle.getBundle(
                            facesContext.getApplication().getMessageBundle(),
                            facesContext.getViewRoot().getLocale()
                    );

            FacesMessage m =
                    new FacesMessage(
                            "URL conversion error for value " + s,
                                bundle.getString("error.convert.url")
                            );
            throw new ConverterException(m, e);
        }
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        URL url = (URL) o;
        return url.toString();
    }
}
