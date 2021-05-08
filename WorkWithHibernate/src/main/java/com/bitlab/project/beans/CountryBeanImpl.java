package com.bitlab.project.beans;

import com.bitlab.project.entities.Cities;
import com.bitlab.project.entities.Countries;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class CountryBeanImpl implements CountryBean {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addCountry(Countries country) {

        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        session.save(country);
        tr.commit();
        session.close();

    }

    public void deleteCountry(Long id) {

    }

    public Countries getCountry(Long id) {

        Countries country = null;

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<Countries> query = builder.createQuery(Countries.class);
        Root<Countries> root = query.from(Countries.class);
        Predicate predicate = builder.equal(root.get("id"), id);
        country = session.createQuery(query.where(predicate)).uniqueResult();
        session.close();

        return country;

    }

    public void saveCountry(Countries country) {

    }

    public List<Countries> getCountries() {
        List<Countries> countries = null;

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<Countries> query = builder.createQuery(Countries.class);
        Root<Countries> root = query.from(Countries.class);
        countries = session.createQuery(query).list();
        session.close();

        return countries;
    }

    public void addCity(Cities city) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(city);
        transaction.commit();
        session.close();
    }

    public List<Cities> getCities(Long id) {

        List<Cities> list = null;

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<Cities> query = builder.createQuery(Cities.class);
        Root<Cities> root = query.from(Cities.class);
        Predicate predicate = builder.equal(root.get("country").get("id"), id);

        list = session.createQuery(query.where(predicate)).list();
        session.close();

        return list;

    }
}
