package pro.khairutdinov.dao;

import pro.khairutdinov.model.Category;

import javax.ejb.Stateless;
import java.util.List;
import java.util.Optional;

@Stateless
public class CategoryRepository extends Repository{
    public List<Category> findAll(){
        return entityManager.createQuery("select e from Category e", Category.class).getResultList();
    }

    public void create(Optional<Category> category){
        category.ifPresent(cat -> entityManager.merge(cat));
    }

    public Category findById(long id){
        return entityManager.find(Category.class, id);
    }
}
