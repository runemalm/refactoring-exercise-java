package com.etraveli.rental.domain.model.movie;

import java.util.List;

import com.etraveli.rental.domain.model.movie.Movie;

public interface MovieRepository {

    public Movie get(String movieId);
}