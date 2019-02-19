package com.etraveli.rental;

public class Rental {
    private final String movieId;
    private final int days;

    public Rental(String movieId, int days) {
        this.movieId = movieId;
        this.days = days;
    }

    public String getMovieId() {
        return movieId;
    }

    public int getDays() {
        return days;
    }
}