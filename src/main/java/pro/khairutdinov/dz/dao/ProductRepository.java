package pro.khairutdinov.dz.dao;

import pro.khairutdinov.dz.model.Product;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class ProductRepository extends Repository {
    public void remove(int productId) {
        if (productId > 0){
            Product product = findById(productId);
            entityManager.remove(product);
        }

    }

    public void merge(Product product){
        if (product != null)
            entityManager.merge(product);
    }

    public List<Product> findAll(){
        return entityManager.createQuery("SELECT e FROM Product e", Product.class).getResultList();
    }

    public Product findById(int id){
        return entityManager.find(Product.class, id);
    }


}
