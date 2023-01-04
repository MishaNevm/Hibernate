package org.example;

import org.example.ls1.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Ls1 {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Person person1 = new Person(21,"Anya");
        Person person2 = new Person(2,"Asya");
        try{
            session.beginTransaction();
            session.save(person1);
            session.save(person2);
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
