package com.justpz.sda.hibernate6;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CarReposytory {
    public List<Car> finaAllFord(){
        try (Session session = SessionManager.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            Query<Car> query = session.createQuery("select c from Car c where c.name like :customName", Car.class);
            query.setParameter("customName", "%Mondeo%");
            List<Car> list = query.list();
            transaction.commit();
            return list;
        }
    }

    public List<Car> findAll(){
        try(Session session = SessionManager.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            Query<Car> query = session.createQuery("select c from Car c", Car.class);
            List<Car> list = query.list();
            transaction.commit();
            return list;
        }
    }

    public int changeMondeoModelToFord(String name){
        try(Session session = SessionManager.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("update Car set name = :name where model = 'Ford'");
            query.setParameter("name" ,name);
            int i = query.executeUpdate();
            transaction.commit();
            return i;
        }
    }
}
