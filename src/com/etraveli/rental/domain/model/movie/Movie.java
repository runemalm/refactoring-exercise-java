package com.etraveli.rental.domain.model.movie;

public class Movie {
    private final String title;
    private final MovieType type;

    public Movie(String title, MovieType type) {

        this.title = title;
        this.type = type;
    }

    // Getters & Setters

    public String getTitle() {
        return title;
    }

    public MovieType getType() {
        return type;
    }
}