package pro.khairutdinov.dz.controler;

import pro.khairutdinov.dz.dao.CategoryRepository;
import pro.khairutdinov.dz.dao.MenuRepository;
import pro.khairutdinov.dz.dao.ProductRepository;
import pro.khairutdinov.dz.model.Category;
import pro.khairutdinov.dz.model.Menu;
import pro.khairutdinov.dz.model.Product;

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

