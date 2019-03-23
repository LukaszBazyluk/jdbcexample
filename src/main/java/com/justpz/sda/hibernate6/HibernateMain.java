package com.justpz.sda.hibernate6;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateMain {
    public static void main(String[] args) {
        SessionFactory sessionFactory = SessionManager.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Car car = new Car();

        car.setModel("dupa");
        car.setName("Fiat");
        session.persist(car);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
