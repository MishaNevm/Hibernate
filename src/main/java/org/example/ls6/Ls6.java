package org.example.ls6;

import org.example.ls6.model.Passport;
import org.example.ls6.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Ls6 {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class).addAnnotatedClass(Passport.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try (sessionFactory) {
            session.beginTransaction();
            Person person = new Person("Misha", 23);
            person.setPassport(new Passport(12345));
            session.save(person);
            session.getTransaction().commit();
        }
    }
}
