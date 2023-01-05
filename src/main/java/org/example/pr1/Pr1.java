package org.example.pr1;

import org.example.pr1.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Pr1 {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("from Person where name like 'T%'").getResultList().forEach(System.out::println);
            session.getTransaction().commit();
        }
    }
}
