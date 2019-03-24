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
//            Car car = new Car();
//            car.setId(1L);
//            car.setModel("A4");
//            car.setName("Audi");
//            Engine engine = new Engine();
//            engine.setId(1L);
//            engine.setPower(350);
//            car.setEngine(engine);
//            session.merge(car);
//            session.find(Engine.class, 1L);
            Car car = session.find(Car.class, 1L);
            System.out.println(car);
            System.out.println(car.getEngine());
           Transaction transaction = session.beginTransaction();
//            Engine engine = new Engine();
//            engine.setPower(140);
//            session.persist(engine);
//
//            Car car2 = new Car();
//            car2.setName("Ford");
//            car2.setModel("Mondeo");
//            car2.setEngine(engine);




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
