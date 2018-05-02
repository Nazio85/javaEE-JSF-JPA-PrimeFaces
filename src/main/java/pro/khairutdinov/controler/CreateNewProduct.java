package pro.khairutdinov.controler;

import pro.khairutdinov.dao.CategoryRepository;
import pro.khairutdinov.dao.ProductRepository;
import pro.khairutdinov.model.Category;
import pro.khairutdinov.model.Product;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import java.util.Collection;
import java.util.Random;

@ManagedBean
public class CreateNewProduct {
    @Inject
    private CategoryRepository categoryRepository;
    @Inject
    private ProductRepository productRepository;
    private Category selectCategory;
    private String productName;

    public void createProduct(){
        Random random = new Random();
        productRepository.merge(new Product(productName, random.nextInt(1000)));
    }

    public void clearDialog(){
        productName = "";
    }


    public Collection<Category> loadCategory(){
        return categoryRepository.findAll();
    }

    public Category getSelectCategory() {
        return selectCategory;
    }

    public void setSelectCategory(Category selectCategory) {
        this.selectCategory = selectCategory;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
