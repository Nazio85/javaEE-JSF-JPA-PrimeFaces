package pro.khairutdinov.controler;

import pro.khairutdinov.service.MessageService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

@ManagedBean
@ViewScoped
public class AdminPanelController {
    @Inject
    private MessageService messageService;
    private String name;

    public String getMessage(){
       return messageService.getMessage("myFullName");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
