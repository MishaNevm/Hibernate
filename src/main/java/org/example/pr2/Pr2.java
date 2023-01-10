package org.example.pr2;

import org.example.pr2.model.Passport;
import org.example.pr2.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Pr2 {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class).addAnnotatedClass(Passport.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try (sessionFactory) {
            session.beginTransaction();
            session.remove(session.get(Person.class, 1));
            session.getTransaction().commit();
        }
    }
}
