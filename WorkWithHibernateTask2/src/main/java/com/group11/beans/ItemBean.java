package com.group11.beans;

import com.group11.entities.Items;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class ItemBean {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addItem(Items item){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(item);
        transaction.commit();
        session.close();
    }

    public List<Items> getItems(){

        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Items> query = criteriaBuilder.createQuery(Items.class);
        query.from(Items.class);
        List<Items> items = session.createQuery(query).getResultList();
        return items;

    }

    public List<Items> getItemsByNameAndPrice(String name, int price){
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Items> query = criteriaBuilder.createQuery(Items.class);
        Root<Items> root = query.from(Items.class);
        Predicate predicate1 = criteriaBuilder.equal(root.get("name"), name);
        Predicate predicate2 = criteriaBuilder.equal(root.get("price"), price);
        Predicate total = criteriaBuilder.and(predicate1, predicate2);
        List<Items> items = session.createQuery(query.where(total)).list();

        return items;
    }
    public Items getItem(Long id){

        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Items> query = criteriaBuilder.createQuery(Items.class);
        Root<Items> root = query.from(Items.class);
        Predicate predicate = criteriaBuilder.equal(root.get("id"), id);

        Items item = session.createQuery(query.where(predicate)).getSingleResult();

        return item;

    }

    public void deleteItem(Items item){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(item);
        transaction.commit();
        session.close();
    }

    public void saveItem(Items item){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(item);
        transaction.commit();
        session.close();
    }

}
