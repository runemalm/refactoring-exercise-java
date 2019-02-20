package com.etraveli.rental.port.adapter.persistence.mock;

import java.util.HashMap;
import java.util.List;

import com.etraveli.rental.domain.model.movie.Movie;
import com.etraveli.rental.domain.model.movie.MovieRepository;
import com.etraveli.rental.domain.model.movie.MovieType;

public class MockMovieRepository implements MovieRepository {
    
    private HashMap<String, Movie> movies;

    public MockMovieRepository() {
        this.movies = this.createMovies();
    }

    @Override
    public Movie get(String movieId) {
        return this.movies.get(movieId);
    }

    private HashMap<String, Movie> createMovies() {
        /*
         * Create database of movies.
         */
        HashMap<String, Movie> movies = new HashMap();

        movies.put("F001", new Movie("Ran", MovieType.REGULAR));
        movies.put("F002", new Movie("Trois Couleurs: Bleu", MovieType.REGULAR));
        movies.put("F003", new Movie("Cars 2", MovieType.CHILDRENS));
        movies.put("F004", new Movie("Latest Hit Release", MovieType.NEW));

        return movies;
    }
}