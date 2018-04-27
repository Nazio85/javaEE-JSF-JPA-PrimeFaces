package pro.khairutdinov.dz.controler;

import pro.khairutdinov.dz.Proxy.Logger;
import pro.khairutdinov.dz.dao.MenuRepository;
import pro.khairutdinov.dz.model.Menu;
import pro.khairutdinov.dz.model.Product;
import pro.khairutdinov.dz.dao.ProductRepository;


import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.interceptor.Interceptor;
import javax.interceptor.Interceptors;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@ViewScoped
@ManagedBean
public class MainController {
    private static int id = 10;
    @Inject
    private ProductRepository productRepository;
    @Inject
    private MenuRepository menuRepository;

    public Collection<Product> getProducts() {
        return productRepository.findAll();
    }

    public void deleteProduct(Product product) {
        productRepository.remove(product.getId());
    }

    public void createProduct(String name, int cost){
        Random random = new Random();
        productRepository.merge(new Product( name, random.nextInt(1000)));
    }

    public Collection<Menu> loadTopMenu(){
        return menuRepository.findAll();
    }
}

