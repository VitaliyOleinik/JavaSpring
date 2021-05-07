package com.db;


import com.entites.MaterialValues;
import com.entites.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
@Scope("singleton")
public class MaterialValueDAO {

    @Autowired
    static SessionFactory sessionFactory;

    public static void addMV(MaterialValues value) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(value);
        transaction.commit();
        session.close();

    }

    public static List<MaterialValues> getAllMaterialValues() {

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<MaterialValues> query = builder.createQuery(MaterialValues.class);
        query.from(Person.class);

        List<MaterialValues> value = session.createQuery(query).list();
        return value;

    }

    public static MaterialValues getMaterialValue(Long id) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<MaterialValues> query = builder.createQuery(MaterialValues.class);
        Root<MaterialValues> root = query.from(MaterialValues.class);
        Predicate predicate = builder.equal(root.get("id"), id);
        MaterialValues value = session.createQuery(query.where(predicate)).uniqueResult();

        return value;
    }

    public static void deleteMaterialValue(MaterialValues value) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(value);
        transaction.commit();
        session.close();
    }

    public static void saveMaterialValue(MaterialValues value) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(value);
        transaction.commit();
        session.close();
    }
}
