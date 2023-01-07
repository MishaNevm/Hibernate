package org.example.ls4;

import org.example.ls4.model.Director;
import org.example.ls4.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Ls4 {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Director.class).addAnnotatedClass(Movie.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try (sessionFactory) {
            session.beginTransaction();
            Director director = session.get(Director.class, 8);
            session.remove(director);
            director.getMovies().forEach(session::remove);
            session.getTransaction().commit();
        }

    }
}
