package pro.khairutdinov.controler;

import pro.khairutdinov.dao.CategoryRepository;
import pro.khairutdinov.dao.MenuRepository;
import pro.khairutdinov.dao.ProductRepository;
import pro.khairutdinov.model.Category;
import pro.khairutdinov.model.Menu;
import pro.khairutdinov.model.Product;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@ManagedBean(eager = true)//загрузить сразу
@ApplicationScoped
public class MainController {
    @Inject
    private ProductRepository productRepository;
    @Inject
    private CategoryRepository categoryRepository;
    @Inject
    private MenuRepository menuRepository;

    private List<Category> categories;

    @PostConstruct
    private void init(){
        categories = categoryRepository.findAll();
    }

    public Collection<Menu> loadTopMenu() {
        return menuRepository.findAll();
    }

    public void loadProduct(){
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

}

