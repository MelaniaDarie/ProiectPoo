package com.example.proiectpoo.dao;

import java.util.List;
import java.util.Optional;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaQuery;


public abstract class GenericDao<T> {

    private Class<T> entityClass;

    public GenericDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public abstract EntityManager getEntityManager();

    public void create(T entity) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } catch (Exception exception) {
            em.getTransaction().rollback();

        } finally {
            em.close();
        }
    }

    public void update(T entity) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        } catch (Exception exception) {
            em.getTransaction().rollback();

        } finally {
            em.close();
        }
    }
    public void remove(T entity, int entityId) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.remove((T) em.find(this.entityClass, entityId));
            em.getTransaction().commit();
        } catch (Exception exception) {
            em.getTransaction().rollback();

        } finally {
            em.close();
        }
    }

    public Optional<T> find(int id){
        EntityManager entityManager = getEntityManager();
        try{
            return Optional.ofNullable((T) entityManager.find(this.entityClass, id));
        }catch(Exception exception){
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }
        return Optional.empty();
    }

    public List<T> findAll() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery<Object> cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(entityClass));
            List<T> returnValues = (List<T>) em.createQuery(cq).getResultList();
            return returnValues;
        } catch (Exception exception) {
            em.getTransaction().rollback();

        } finally {
            em.close();
        }
        return null;
    }

}
