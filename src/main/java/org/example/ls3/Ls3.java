package org.example.ls3;

import org.example.ls3.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Ls3 {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            session.createQuery("delete from Person where age>10").executeUpdate();
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
