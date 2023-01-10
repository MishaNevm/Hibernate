package org.example.ls7;

import org.example.ls7.model.Actor;
import org.example.ls7.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;


public class Ls7 {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Actor.class).addAnnotatedClass(Movie.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try (sessionFactory) {
            session.beginTransaction();

            session.get(Actor.class, 3)
                    .setMovies(new ArrayList<>(List.of(session.get(Movie.class, 1))));

            session.getTransaction().commit();
        }
    }
}
