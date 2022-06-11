package com.example.proiectpoo.dao;


import com.example.proiectpoo.Ticket;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.ParameterExpression;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class TicketDao extends GenericDao<Ticket> {


    private final EntityManagerFactory factory;

    public TicketDao(EntityManagerFactory factory) {
        super(Ticket.class);
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

    public List<Ticket> find(Integer userId) {
        EntityManager em = getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Ticket> q = cb.createQuery(Ticket.class);

        Root<Ticket> c = q.from(Ticket.class);
        ParameterExpression<Integer> paramName = cb.parameter(Integer.class);
        q.select(c).where(cb.equal(c.get("ticketId"), paramName));
        TypedQuery<Ticket> query = em.createQuery(q);
        query.setParameter(paramName, userId);

        List<Ticket> results = query.getResultList();
        return results;
    }
}
