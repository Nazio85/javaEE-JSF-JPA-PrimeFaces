package pro.khairutdinov.controler;

import pro.khairutdinov.dao.CategoryRepository;
import pro.khairutdinov.dao.MenuRepository;
import pro.khairutdinov.dao.ProductRepository;
import pro.khairutdinov.model.Category;
import pro.khairutdinov.model.Menu;
import pro.khairutdinov.model.Product;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.Collection;
import java.util.Optional;

@ViewScoped
@ManagedBean
public class MainController {
    @Inject
    private ProductRepository productRepository;
    @Inject
    private CategoryRepository categoryRepository;
    @Inject
    private MenuRepository menuRepository;

    public Collection<Product> getProducts() {
        return productRepository.findAll();
    }

    public Collection<Category> geCategory() {
        return categoryRepository.findAll();
    }

    public void deleteProduct(Product product) {
        productRepository.remove(product.getId());
    }

    public void createCategory(String name) {
        categoryRepository.create(Optional.of(new Category(name)));
    }

    public Collection<Menu> loadTopMenu() {
        return menuRepository.findAll();
    }


}

