package com.example.proiectpoo.dao;


import com.example.proiectpoo.Userlog;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.ParameterExpression;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class UserlogDao extends GenericDao<Userlog> {


    private final EntityManagerFactory factory;

    public UserlogDao(EntityManagerFactory factory) {
        super(Userlog.class);
        this.factory = factory;
    }

    @Override
    public EntityManager getEntityManager() {
        try {
            return factory.createEntityManager();
        } catch (Exception ex) {
            System.out.println("The entity manager cannot be created!");
            return null;
        }
    }

    // for login
    public List<Userlog> find(String email) {
        EntityManager em = getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Userlog> q = cb.createQuery(Userlog.class);

        Root<Userlog> c = q.from(Userlog.class);
        ParameterExpression<String> paramName = cb.parameter(String.class);
        q.select(c).where(cb.equal(c.get("email"), paramName));
        TypedQuery<Userlog> query = em.createQuery(q);
        query.setParameter(paramName, email);

        List<Userlog> results = query.getResultList();
        return results;
    }
}
