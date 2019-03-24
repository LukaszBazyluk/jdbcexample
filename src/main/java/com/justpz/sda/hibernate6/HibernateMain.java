package com.justpz.sda.hibernate6;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
//            Car car = session.find(Car.class, 1L);
//            System.out.println(car);
//            System.out.println(car.getEngine());
            Transaction transaction = session.beginTransaction();
//            Engine engine = new Engine();
//            engine.setPower(140);
//            session.persist(engine);
//
//            Car car2 = new Car();
//            car2.setName("Ford");
//            car2.setModel("Mondeo");
//            car2.setEngine(engine);

            Car car = new Car();
            car.setName("Porshe");
            car.setModel("911");

            Set<Person> owner = new HashSet<>();
            Person  person1 = new Person();
            person1.setName("Łukasz");
            person1.setSurname("Bazyluk");
//            person1.setMainCar(car);

            Person person2 = new Person();
            person2.setName("XYZ");
            person2.setSurname("AAA");
//            person2.setMainCar(car);



//            session.persist(car);

            Set<Address> addresses = new HashSet<>();
            Address address = new Address();
            address.setCity("Białystok");
            address.setStreet("Błotna");

                    Address address1 = new Address();
            address1.setCity("NY");
            address1.setStreet("III");


            person1.addAddress(address);
            person2.addAddress(address1);

            car.addOwner(person1);
            car.addOwner(person2);

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
