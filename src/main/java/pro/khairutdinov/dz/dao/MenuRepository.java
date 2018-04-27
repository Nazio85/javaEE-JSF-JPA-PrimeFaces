package pro.khairutdinov.dz.dao;

import pro.khairutdinov.dz.model.Menu;


import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class MenuRepository extends Repository {
    public List<Menu> findAll(){
        return entityManager.createQuery("SELECT e FROM Menu e", Menu.class).getResultList();
    }
}
