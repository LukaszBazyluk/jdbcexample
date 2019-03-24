package com.justpz.sda.hibernate6;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class HibernateMain {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = SessionManager.getSessionFactory();
             Session session = sessionFactory.openSession()) {
//            Transaction transaction = session.beginTransaction();
//            Car car1 = new Car();
//            car1.setModel("Mondeo");
//            car1.setName("Ford");
//            session.persist(car1);
//
//
//            Car car = session.find(Car.class,1L);
//            System.out.println(car);
//            System.out.println(car.getClass());
//            car.setName("Tomcio");
//            transaction.commit();
//
//            for (Car queryXX : Hibernate_HQL.queryXX()) {
//                System.out.println(queryXX);
//            }
//
            Transaction transaction = session.beginTransaction();
            Engine engine = new Engine();
            engine.setPower(140);
            session.persist(engine);

            Car car = new Car();
            car.setName("Ford");
            car.setModel("Mondeo");
            car.setEngine(engine);

            session.persist(car);
            transaction.commit();

        } finally {
            SessionManager.getSessionFactory().close();
        }

//        --------------------------------------------------------------------------
//        try (Session session = SessionManager.getSessionFactory().openSession()) {
//            CarReposytory carRepository = new CarReposytory();
//            List<Car> all = carRepository.finaAllFord();
//
//            for (Car car : all) {
//                System.out.println(car);
//            }
//            carRepository.changeMondeoModelToFord("Lambo");
//            SessionManager.getSessionFactory().close();

//    -------------------------------------------------------------------------------

    }
}
