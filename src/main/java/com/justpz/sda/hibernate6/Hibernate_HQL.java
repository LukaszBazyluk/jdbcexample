package com.justpz.sda.hibernate6;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import java.util.List;

public class Hibernate_HQL {

    public static List<Car> queryXX() {
        try (SessionFactory sessionFactory = SessionManager.getSessionFactory();
             Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            String hqlQuery = "select s from Car s where s.name = :name";
            Query<Car> query = session.createQuery(hqlQuery, Car.class);
            query.setParameter("name","Tomcio");
            List<Car>list = query.list();
            return list;
        }


    }
}

