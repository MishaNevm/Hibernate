package org.example.pr3;

import org.example.pr3.model.Actor;
import org.example.pr3.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;


public class Pr3 {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Actor.class).addAnnotatedClass(Movie.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try (sessionFactory) {
            session.beginTransaction();
            Movie movie = session.get(Movie.class, 1);
            Actor actor = session.get(Actor.class, 1);
            actor.getMovies().add(movie);
            movie.getActors().add(actor);
            session.getTransaction().commit();
        }
    }
}
