package com.etraveli.rental;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RecordService {
    /*
     * The Record domain service.
     *
     * Creates Records.
     */

    private HashMap<String, Movie> movies;

    public RecordService() {
        this.movies = this.createMovies();
    }

    public Record createRecord(Customer customer) throws Exception {
        Record record = new Record();

        record.setCustomerName(customer.getName());
        record.setMovieCosts(this.calculateMovieCosts(customer.getRentals()));
        record.setTotal(this.calculateTotal(record.getMovieCosts()));
        record.setFrequentRenterPoints( 
            this.calculateFrequentRenterPoints(
                customer.getRentals()
            )
        );

        return record;
    }

    private List<MovieCost> calculateMovieCosts(List<Rental> rentals) throws Exception {
        List<MovieCost> movieCosts = new ArrayList<MovieCost>();

        for (Rental r : rentals) {
            Movie movie = this.movies.get(r.getMovieId());

            // Calculate cost
            BigDecimal cost = BigDecimal.valueOf(0);

            switch (movie.getType()) {
                case REGULAR:
                    cost = BigDecimal.valueOf(2);
                    if (r.getDays() > 2) {
                        cost = cost.add(BigDecimal.valueOf((r.getDays() - 2) * 1.5));
                    }
                    break;
                case NEW:
                    cost = BigDecimal.valueOf(r.getDays() * 3);
                    break;
                case CHILDRENS:
                    cost = BigDecimal.valueOf(1.5);
                    if (r.getDays() > 3) {
                        cost = cost.add(BigDecimal.valueOf((r.getDays() - 3) * 1.5));
                    }
                    break;
                default:
                    throw new Exception(
                        "Couldn't calculate total, unsupported movie type: " +
                            movie.getType());
            }

            MovieCost movieCost = new MovieCost(movie.getTitle(), cost);
            
            // ..add cost
            movieCosts.add(movieCost);
        }

        return movieCosts;
    }

    private BigDecimal calculateTotal(List<MovieCost> costs) {
        BigDecimal total = BigDecimal.valueOf(0);
        for (MovieCost cost : costs) {
            total = total.add(cost.getCost());
        }
        return total;
    }

    private int calculateFrequentRenterPoints(List<Rental> rentals) {
        int points = 0;

        for (Rental r : rentals) {
            Movie movie = this.movies.get(r.getMovieId());

            // Add one point for rental
            points++;

            // ..and bonus point for a two-day-new-release rental
            if (movie.getType() == MovieType.NEW && r.getDays() > 2) points++;
        }

        return points;
    }

    // Movie data

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
