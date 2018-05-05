package pro.khairutdinov.controler;

import pro.khairutdinov.dao.CategoryRepository;
import pro.khairutdinov.model.Category;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.inject.Inject;
import java.util.*;

@ManagedBean
@SessionScoped
public class CategoryController {
    @Inject
    private CategoryRepository categoryRepository;

    private Category categorySelect;
    private Map<String, Category> categoryMap = new HashMap<>();

    @PostConstruct
    public void init() {
        List<Category> all = categoryRepository.findAll();
        for (Category category : all) {
            if (categorySelect == null) categorySelect = category;
            categoryMap.put(category.getName(), category);
        }
    }


    public Category getCategorySelect() {
        return categorySelect;
    }

    public void setCategorySelect(Category categorySelect) {
        this.categorySelect = categorySelect;
    }

    public Map<String, Category> getCategoryMap() {
        return categoryMap;
    }

    public void setCategoryMap(Map<String, Category> categoryMap) {
        this.categoryMap = categoryMap;
    }
}
