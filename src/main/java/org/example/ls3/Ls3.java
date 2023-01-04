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
        try{
            session.beginTransaction();
            Person person = new Person(21, "Test2");
            session.save(person);
            System.out.println(person.getId());
            person = session.get(Person.class, 5);
            person.setName("Test Name3");
            session.getTransaction().commit();
            System.out.println("Hello");
        } finally {
            sessionFactory.close();
        }
    }
}
