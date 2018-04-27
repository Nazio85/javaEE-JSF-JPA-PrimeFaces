package pro.khairutdinov.dz.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class Repository {

    @PersistenceContext(unitName = "khairutdinov-persistence-unit")
    protected EntityManager entityManager;
}
