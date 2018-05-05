package pro.khairutdinov.validation;

import pro.khairutdinov.service.MessageService;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import java.util.ResourceBundle;

@FacesValidator("validatorName")
public class ValidatorName implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        if (o.toString().length() < 4){
            ResourceBundle resourceBundle = ResourceBundle.getBundle("local.message", FacesContext.getCurrentInstance().getViewRoot().getLocale());
            FacesMessage facesMessage = new FacesMessage(resourceBundle.getString("requiredIsSmall"));
            facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(facesMessage);
        }
    }
}
