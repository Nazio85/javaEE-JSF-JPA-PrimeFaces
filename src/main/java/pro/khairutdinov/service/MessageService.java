package pro.khairutdinov.service;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.util.ResourceBundle;

@ManagedBean
public class MessageService {

    public String getMessage(String key){
        ResourceBundle resourceBundle = getBundle();
        return resourceBundle.getString(key);
    }

    public ResourceBundle getBundle(){
        return ResourceBundle.getBundle(
                "local.message", //Путь до локал
                FacesContext.getCurrentInstance().getViewRoot().getLocale()); //Current Local

    }
}
