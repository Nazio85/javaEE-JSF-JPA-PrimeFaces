package pro.khairutdinov.controler;

import pro.khairutdinov.dao.CategoryRepository;
import pro.khairutdinov.dao.ProductRepository;
import pro.khairutdinov.model.Category;
import pro.khairutdinov.model.Product;
import pro.khairutdinov.service.MessageService;

import javax.annotation.PostConstruct;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@ManagedBean
@SessionScoped
public class TestController{
    @Inject
    private MessageService messageService;
    @Inject
    private CategoryRepository categoryRepository;
    @Inject
    private ProductRepository productRepository;


    private Category categorySelect;
    private Map<String, Category> categoryMap;

    private String name;
    private String searchCategoryId;
    private List<Product> products;

    public TestController() {
        categoryMap = new HashMap<>();
    }

    public void sortList() {
        Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        int categoryId = Integer.parseInt(map.get("category_id"));

        System.out.println( categoryId+ "<--------------------------------------------");
        List<Product> tmp = new ArrayList<>();


        products = productRepository.findByCategoryId(categoryId);
//        products = products.stream().filter(product -> product.getCategory().getId() == categoryId).collect(Collectors.toList());
    }

    @PostConstruct
    public void init() {
        List<Category> all = categoryRepository.findAll();
        for (Category category : all) {
            categoryMap.put(category.getName(), category);
        }
        products = productRepository.findAll();
    }

    public String getMessage() {
        return messageService.getMessage("myFullName");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String enterToName() {
        return "index";
    }

    public String getSearchCategoryId() {
        return searchCategoryId;
    }

    public void setSearchCategoryId(String searchCategoryId) {
        this.searchCategoryId = searchCategoryId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
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
