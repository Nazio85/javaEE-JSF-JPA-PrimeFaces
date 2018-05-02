package pro.khairutdinov.controler;

import pro.khairutdinov.dao.CategoryRepository;
import pro.khairutdinov.model.Category;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;


@ManagedBean
@FacesConverter("categoryConverter")
public class CategoryConverter implements Converter {
    @Inject
    private CategoryRepository categoryRepository;

    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                return categoryRepository.findById(Integer.parseInt(value));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        }
        else {
            return null;
        }
    }

    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((Category) object).getId());
        }
        else {
            return null;
        }
    }
}
