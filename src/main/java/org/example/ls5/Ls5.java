package org.example.ls5;

import org.example.ls5.model.Item;
import org.example.ls5.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Ls5 {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class).addAnnotatedClass(Item.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try (sessionFactory) {
            session.beginTransaction();
            session.remove(session.get(Person.class,2));
            session.getTransaction().commit();
        }
    }
}
