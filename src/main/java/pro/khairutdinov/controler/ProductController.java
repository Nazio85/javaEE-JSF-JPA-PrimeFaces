package pro.khairutdinov.controler;

import pro.khairutdinov.dao.ProductRepository;
import pro.khairutdinov.model.Product;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Predicate;

@ManagedBean(eager = true)
@ViewScoped
public class ProductController {
    @Inject
    private ProductRepository productRepository;
    @Inject
    private CategoryController categoryController;

    private List<Product> products;
    private Product product;
    private String productName;

    @PostConstruct
    public void loadAllProducts() {
        products = productRepository.findAll();
    }



    public void createProduct(){
        Random random = new Random();
        productRepository.merge(new Product(productName, random.nextInt(100), categoryController.getCategorySelect()));
    }

    public String deleteProduct(Product product) {
        productRepository.remove(product.getId());
        return null;
    }

    public void deleteProductAndUpdate(Product product){
        deleteProduct(product);
        loadAllProducts();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
