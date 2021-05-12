package com.db;

import com.entities.Cars;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Component
@Scope("singleton")
public class CarsDAOImpl implements CarsDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addCar(Cars car) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(car);
        transaction.commit();
        session.close();

    }

    @Override
    public List<Cars> getAllCars() {

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Cars> query = builder.createQuery(Cars.class);
        query.from(Cars.class);
        List<Cars> cars = session.createQuery(query).list();
        session.close();
        return cars;

    }
}
