package org.example.ls8;

import org.example.ls8.model.Item;
import org.example.ls8.model.Person;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Ls8 {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Item.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Item item;
        try  {
            session.beginTransaction();
            item = session.get(Item.class, 1);
            Hibernate.initialize(item.getOwner());
            session.getTransaction().commit();
            System.out.println(item.getOwner());
        } finally {
            sessionFactory.close();
        }
    }
}
