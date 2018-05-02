package pro.khairutdinov.service;

import pro.khairutdinov.dao.ProductRepository;
import pro.khairutdinov.model.Product;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public class Api {
    @Inject
    private ProductRepository productRepository;

    @WebMethod
    public List<Product> getProduct(){
        return productRepository.findAll();
    }

    @WebMethod
    public void createProduct(@WebParam String name, @WebParam int cost){
        productRepository.merge(new Product(name, cost));
    }

    @WebMethod
    public void deleteProduct(@WebParam int id){
        Product product = productRepository.findById(id);
        if (product != null) productRepository.remove(product.getId());
    }
}
