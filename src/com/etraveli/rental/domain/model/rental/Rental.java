package com.etraveli.rental.domain.model.rental;

public class Rental {
    /*
     * The 'Rental' entity.
     */
    private final String movieId;
    private final int days;

    public Rental(String movieId, int days) {
        this.movieId = movieId;
        this.days = days;
    }

    // Getters & Setters

    public String getMovieId() {
        return movieId;
    }

    public int getDays() {
        return days;
    }
}